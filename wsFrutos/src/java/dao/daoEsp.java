/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.StockName;
import dto.Usuario;
import dto.UsuarioProd;
import dto.Venta;
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
public class daoEsp {
    public UsuarioProd listar(int rut)
    {
        StockName dto;
        UsuarioProd asd = new UsuarioProd();
        Usuario usu = new daoUsuario().getUsuarioByRut(rut);
        asd.setRut(rut);
        asd.setNombre(usu.getNombre());
        asd.setGeoData(usu.getGeoData());
        
        ArrayList<StockName> lista= new ArrayList<>();
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select b.st_id, "+
            "b.st_kilos, "+
            "b.st_precio, "+
            "a.pr_id,  "+
            "c.bod_id, "+
            "a.pr_nombre, "+
            "t.tip_id, "+
            "t.tip_nombre  "+
            "from tipo_prod t, producto a, stock b , bodega c, usuario d  "+
            "where  "+
            "t.TIP_ID = a.TIPO_PROD_TIP_ID and "+
            "a.pr_id = b.producto_pr_id and  "+
            "b.bodega_bod_id = c.bod_id and  "+
            "c.usuario_us_rut = d.us_rut and  "+
            "d.us_rut = ?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, rut);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                dto = new StockName();
                dto.setId(rs.getInt("st_id"));
                dto.setKilos(rs.getInt("st_kilos"));
                dto.setPrecios(rs.getInt("st_precio"));
                dto.setPrId(rs.getInt("pr_id"));
                dto.setBodId(rs.getInt("bod_id"));
                dto.setNomProd(rs.getString("pr_nombre"));
                dto.setTipoId(rs.getInt("tip_id"));
                dto.setNomTipo(rs.getString("tip_nombre"));
                lista.add(dto);
            }
            conexion.close();
        }catch(SQLException w){
            System.out.println("Error SQL al buscar "+w.getMessage());
        }catch(Exception z){
            System.out.println("Error al buscar "+z.getMessage());
        }
        asd.setStock(lista);
        return asd;
    }
}
