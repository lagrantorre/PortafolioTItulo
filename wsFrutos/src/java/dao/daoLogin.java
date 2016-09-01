/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sql.Conexion;

/**
 *
 * @author NoteHP
 */
public class daoLogin {
    
    /**Valida login retornando objeto usuario en formato  con datos si es correcto 
     * o vacío en caso contrario
     * @param rut el rut sin el digito verificador
     * @param pass password sin codificar 
     * @return objeto Usuario con todos sus datos o vacío en caso que las credenciales sean erroneas
     **/
    public Usuario validar(int rut, String pass)
    {
        Usuario dto = new Usuario();
        try{
        Connection conexion = Conexion.getConexion();
        String query="select * from usuario where us_rut = ? and us_pass = ?";       
        PreparedStatement consulta = conexion.prepareStatement(query);
        consulta.setInt(1, rut);
        consulta.setString(2, pass);
        ResultSet rs = consulta.executeQuery();
        if(rs.next()){
            dto.setRut(rut);
            dto.setDv(rs.getString("us_dv").charAt(0));
            dto.setNombre(rs.getString("us_nombre"));
            dto.setEmail(rs.getString("us_email"));
            dto.setGeoData(rs.getString("us_geo_data"));
            dto.setGeoTipo(rs.getString("us_geo_tipo"));
            dto.setVigente(rs.getBoolean("us_vigente"));
            dto.setImg(rs.getString("us_img"));
            dto.setTipo(rs.getInt("tipo_usuario_tip_id"));
        }
        conexion.close();
        }catch(SQLException s){
            System.out.println("Problema SQL al ingresar "+
                    s.getMessage());
        }catch(Exception e){
            System.out.println("Problemas al ingresar "+
                    e.getMessage());
        }
        return dto;
    }
}
