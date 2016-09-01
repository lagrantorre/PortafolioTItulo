/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import dto.TipoUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sql.Conexion;

/**
 *
 * @author Robert
 */
public class daoTipoUsuario {
    public TipoUsuario listarTipoUsuario(int tipoUsuario)
    {
        TipoUsuario dto = new TipoUsuario();
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select * from tipo_usuario where tip_id = ?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, tipoUsuario);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                dto = new TipoUsuario();
                dto.setId(rs.getInt("tip_id"));
                dto.setNombre(rs.getString("tip_nombre"));
            }
            conexion.close();
        }catch(SQLException w){
            System.out.println("Error SQL al buscar "+w.getMessage());
        }catch(Exception z){
            System.out.println("Error al buscar "+z.getMessage());
        }
        return dto;
    }//fin metodo LISTAR todos los tipos
}
