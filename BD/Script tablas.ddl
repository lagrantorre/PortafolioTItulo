-- Generado por Oracle SQL Developer Data Modeler 4.1.3.901
--   en:        2016-08-30 08:09:36 CLT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g


connect system
exec dbms_xdb.sethttpport(9090)


DROP TABLE bodega CASCADE CONSTRAINTS ;

DROP TABLE detalle_venta CASCADE CONSTRAINTS ;

DROP TABLE producto CASCADE CONSTRAINTS ;

DROP TABLE stock CASCADE CONSTRAINTS ;

DROP TABLE tipo_prod CASCADE CONSTRAINTS ;

DROP TABLE tipo_usuario CASCADE CONSTRAINTS ;

DROP TABLE usuario CASCADE CONSTRAINTS ;

DROP TABLE venta CASCADE CONSTRAINTS ;

CREATE TABLE bodega
  (
    bod_id         INTEGER NOT NULL ,
    bod_nombre     VARCHAR2 (50) ,
    bod_direccion  VARCHAR2 (30) ,
    bod_geo_data   VARCHAR2 (255) ,
    bod_geo_tipo   VARCHAR2 (255) ,
    " bod_vigente" CHAR (1) ,
    usuario_us_rut INTEGER NOT NULL
  ) ;
ALTER TABLE bodega ADD CONSTRAINT bodega_PK PRIMARY KEY ( bod_id ) ;


CREATE TABLE detalle_venta
  (
    dt_id       INTEGER NOT NULL ,
    dt_cantidad INTEGER NOT NULL ,
    dt_total    INTEGER NOT NULL ,
    stock_st_id INTEGER NOT NULL ,
    venta_vn_id INTEGER NOT NULL
  ) ;
ALTER TABLE detalle_venta ADD CONSTRAINT detalle_venta_PK PRIMARY KEY ( dt_id ) ;


CREATE TABLE producto
  (
    pr_id            INTEGER NOT NULL ,
    pr_nombre        VARCHAR2 (40) NOT NULL ,
    tipo_prod_tip_id INTEGER NOT NULL
  ) ;
ALTER TABLE producto ADD CONSTRAINT producto_PK PRIMARY KEY ( pr_id ) ;


CREATE TABLE stock
  (
    st_id          INTEGER NOT NULL ,
    st_kilos       INTEGER NOT NULL ,
    st_precio      INTEGER NOT NULL ,
    producto_pr_id INTEGER NOT NULL ,
    bodega_bod_id  INTEGER NOT NULL
  ) ;
ALTER TABLE stock ADD CONSTRAINT stock_PK PRIMARY KEY ( st_id ) ;


CREATE TABLE tipo_prod
  (
    tip_id     INTEGER NOT NULL ,
    tip_nombre VARCHAR2 (30) NOT NULL
  ) ;
ALTER TABLE tipo_prod ADD CONSTRAINT tipo_prod_PK PRIMARY KEY ( tip_id ) ;


CREATE TABLE tipo_usuario
  (
    tip_id     INTEGER NOT NULL ,
    tip_nombre VARCHAR2 (30) NOT NULL
  ) ;
ALTER TABLE tipo_usuario ADD CONSTRAINT tipo_usuario_PK PRIMARY KEY ( tip_id ) ;


CREATE TABLE usuario
  (
    us_rut              INTEGER NOT NULL ,
    us_dv               CHAR (1 CHAR) NOT NULL ,
    us_nombre           VARCHAR2 (50) NOT NULL ,
    us_email            VARCHAR2 (50) NOT NULL ,
    us_geo_data         VARCHAR2 (255) ,
    us_geo_tipo         VARCHAR2 (255) ,
    us_pass             VARCHAR2 (255) NOT NULL ,
    us_img              VARCHAR2 (255) ,
    us_vigente          CHAR (1) NOT NULL ,
    tipo_usuario_tip_id INTEGER NOT NULL
  ) ;
ALTER TABLE usuario ADD CONSTRAINT usuario_PK PRIMARY KEY ( us_rut ) ;


CREATE TABLE venta
  (
    vn_id              INTEGER NOT NULL ,
    vn_total           INTEGER NOT NULL ,
    usuario_rut_vende  INTEGER NOT NULL ,
    usuario_rut_compra INTEGER NOT NULL
  ) ;
ALTER TABLE venta ADD CONSTRAINT venta_PK PRIMARY KEY ( vn_id ) ;


ALTER TABLE bodega ADD CONSTRAINT bodega_usuario_FK FOREIGN KEY ( usuario_us_rut ) REFERENCES usuario ( us_rut ) ;

ALTER TABLE detalle_venta ADD CONSTRAINT detalle_venta_stock_FK FOREIGN KEY ( stock_st_id ) REFERENCES stock ( st_id ) ;

ALTER TABLE detalle_venta ADD CONSTRAINT detalle_venta_venta_FK FOREIGN KEY ( venta_vn_id ) REFERENCES venta ( vn_id ) ;

ALTER TABLE producto ADD CONSTRAINT producto_tipo_prod_FK FOREIGN KEY ( tipo_prod_tip_id ) REFERENCES tipo_prod ( tip_id ) ;

ALTER TABLE stock ADD CONSTRAINT stock_bodega_FK FOREIGN KEY ( bodega_bod_id ) REFERENCES bodega ( bod_id ) ;

ALTER TABLE stock ADD CONSTRAINT stock_producto_FK FOREIGN KEY ( producto_pr_id ) REFERENCES producto ( pr_id ) ;

ALTER TABLE usuario ADD CONSTRAINT usuario_tipo_usuario_FK FOREIGN KEY ( tipo_usuario_tip_id ) REFERENCES tipo_usuario ( tip_id ) ;

ALTER TABLE venta ADD CONSTRAINT venta_usuario_FK FOREIGN KEY ( usuario_rut_vende ) REFERENCES usuario ( us_rut ) ;

ALTER TABLE venta ADD CONSTRAINT venta_usuario_FKv1 FOREIGN KEY ( usuario_rut_compra ) REFERENCES usuario ( us_rut ) ;


-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             8
-- CREATE INDEX                             0
-- ALTER TABLE                             17
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
