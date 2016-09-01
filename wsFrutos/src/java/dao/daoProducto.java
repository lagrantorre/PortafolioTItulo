/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Producto;
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
public class daoProducto {
    public ArrayList<Producto> listarProdByTipo(int tipoProd)
    {
        ArrayList<Producto> lista= new ArrayList<>();
        Producto dto;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select * from producto where tipo_prod_tip_id = ?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, tipoProd);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                dto = new Producto();
                dto.setId(rs.getInt("pr_id"));
                dto.setNombre(rs.getString("pr_nombre"));
                dto.setTipo(rs.getInt("tipo_prod_tip_id"));
                lista.add(dto);
            }
            conexion.close();
        }catch(SQLException w){
            System.out.println("Error SQL al buscar "+w.getMessage());
        }catch(Exception z){
            System.out.println("Error al buscar "+z.getMessage());
        }
        return lista;
    }//fin metodo LISTAR por tipo
}
