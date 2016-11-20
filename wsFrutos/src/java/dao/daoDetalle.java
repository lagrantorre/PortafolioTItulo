/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Detalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.Conexion;

/**
 *
 * @author Robert
 */
public class daoDetalle {
    public ArrayList<Detalle> ListarDetalleByIdVenta(int idVenta)
    {
        ArrayList<Detalle> lista= new ArrayList<>();
        Detalle dto;
        try{
            Connection conexion = Conexion.getConexion();
           // String query = "select * from detalle_venta where venta_vn_id = ?";
            
             String query = "select det.dt_id, det.dt_cantidad, det.dt_total, det.stock_st_id, det.venta_vn_id, st.producto_pr_id, pr.PR_NOMBRE  from detalle_venta det " +
                    "JOIN stock st ON det.stock_st_id = st.st_id " +
                    "JOIN producto pr ON st.producto_pr_id = pr.PR_ID " +
                    "where venta_vn_id = ?";
            
            
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, idVenta);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                dto = new Detalle();
                dto.setId(rs.getInt("dt_id"));
                dto.setCantidad(rs.getInt("dt_cantidad"));
                dto.setTotal(rs.getInt("dt_total"));
                dto.setStockId(rs.getInt("stock_st_id"));
                dto.setVentaId(rs.getInt("venta_vn_id"));
                dto.setProdId(rs.getInt("producto_pr_id"));
                dto.setProdNombre(rs.getString("pr_nombre"));
                lista.add(dto);
            }
            conexion.close();
        }catch(SQLException w){
            System.out.println("Error SQL al buscar "+w.getMessage());
        }catch(Exception z){
            System.out.println("Error al buscar "+z.getMessage());
        }
        return lista;
    }
    
    public Detalle getDetalleById(int idDetalle)
    {
        Detalle dto = new Detalle();
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select * from detalle where dt_id = ?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, idDetalle);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                dto.setId(rs.getInt("dt_id"));
                dto.setCantidad(rs.getInt("dt_cantidad"));
                dto.setTotal(rs.getInt("dt_total"));
                dto.setStockId(rs.getInt("stock_st_id"));
                dto.setVentaId(rs.getInt("venta_vn_id"));
            }
            conexion.close();
        }catch(SQLException w){
            System.out.println("Error SQL al buscar "+w.getMessage());
        }catch(Exception z){
            System.out.println("Error al buscar "+z.getMessage());
        }
        return dto;
    }
    public boolean insDetalle(int cantidad, int total, int stockId, int ventaId){   
        boolean asd = true;
        try{
        Connection conexion = Conexion.getConexion();
        String query="insert into detalle_venta values (detvta_seq.nextval,?,?,?,?)";
        PreparedStatement insert = 
        conexion.prepareStatement(query);
        insert.setInt(1, cantidad);
        insert.setInt(2, total);
        insert.setInt(3, stockId);
        insert.setInt(4, ventaId);
        insert.execute();
        insert.close();
        conexion.close();
        }catch(SQLException s){
            System.out.println("Problema SQL al insertar "+
                    s.getMessage());
            asd = false;
        }catch(Exception e){
            System.out.println("Problemas al insertar "+
                    e.getMessage());
            asd = false;
        }return asd;
    }//
    
    public boolean updDetalle(int id, int cantidad, int total, int stockId, int ventaId){   
        boolean asd = true;
        try{
        Connection conexion = Conexion.getConexion();
        String query="update detalle_venta set dt_id = ?, dt_cantidad = ?, dt_total = ?, stock_st_id = ?, venta_vn_id = ? where dt_id = ?";
        PreparedStatement insert = 
        conexion.prepareStatement(query);
        insert.setInt(1, cantidad);
        insert.setInt(2, total);
        insert.setInt(3, stockId);
        insert.setInt(4, ventaId);
        insert.setInt(5, id);
        insert.execute();
        insert.close();
        conexion.close();
        }catch(SQLException s){
            System.out.println("Problema SQL al actualizar "+
                    s.getMessage());
            asd = false;
        }catch(Exception e){
            System.out.println("Problemas al actualizar "+
                    e.getMessage());
            asd = false;
        }return asd;
    }//
    
    public boolean delDetalle(int id){   
        boolean asd = true;
        try{
        Connection conexion = Conexion.getConexion();
        String query="delete from detalle_venta where dt_id = ?";
        PreparedStatement insert = 
        conexion.prepareStatement(query);
        insert.setInt(1, id);
        insert.execute();
        insert.close();
        conexion.close();
        }catch(SQLException s){
            System.out.println("Problema SQL al borrar "+
                    s.getMessage());
            asd = false;
        }catch(Exception e){
            System.out.println("Problemas al borrar "+
                    e.getMessage());
            asd = false;
        }return asd;
    }//
}
