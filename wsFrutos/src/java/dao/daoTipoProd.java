/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.TipoProd;
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
public class daoTipoProd {
    /**
    *Retorna todos los tipos de productos existentes
    *
    *@return: ArrayList con los TipoProd que existen en el sistema
    */
    public ArrayList<TipoProd> listarTipoProd()
    {
        ArrayList<TipoProd> lista= new ArrayList<>();
        TipoProd dto;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select * from tipo_prod";
            PreparedStatement buscar=conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                dto = new TipoProd();
                dto.setId(rs.getInt("tip_id"));
                dto.setNombre(rs.getString("tip_nombre"));
                lista.add(dto);
            }
            conexion.close();
        }catch(SQLException w){
            System.out.println("Error SQL al buscar "+w.getMessage());
        }catch(Exception z){
            System.out.println("Error al buscar "+z.getMessage());
        }
        return lista;
    }//fin metodo LISTAR todos los tipos
    
}
