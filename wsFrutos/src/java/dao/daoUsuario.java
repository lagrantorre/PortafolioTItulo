/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import util.Cript;
import dto.Usuario;
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
public class daoUsuario {
    public ArrayList<Usuario> listarUsuario()
    {
        ArrayList<Usuario> lista= new ArrayList<>();
        Usuario dto;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select * from usuario";
            PreparedStatement buscar=conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                dto = new Usuario();
                dto.setRut(rs.getInt("us_rut"));
                dto.setDv(rs.getString("us_dv").charAt(0));
                dto.setNombre(rs.getString("us_nombre"));
                dto.setEmail(rs.getString("us_email"));
                dto.setGeoData(rs.getString("us_geo_data"));
                dto.setGeoTipo(rs.getString("us_geo_tipo"));
                dto.setVigente(rs.getBoolean("us_vigente"));
                dto.setPass(Cript.desencriptar(rs.getString("us_pass")));
                dto.setImg(rs.getString("us_img"));
                dto.setTipo(rs.getInt("tipo_usuario_tip_id"));
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
    
    
    public ArrayList<Usuario> ListarUsuario(int tipoUsuario)
    {
        ArrayList<Usuario> lista= new ArrayList<>();
        Usuario dto;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select * from usuario where tipo_usuario_tip_id = ?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, tipoUsuario);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                dto = new Usuario();
                dto.setRut(rs.getInt("us_rut"));
                dto.setDv(rs.getString("us_dv").charAt(0));
                dto.setNombre(rs.getString("us_nombre"));
                dto.setEmail(rs.getString("us_email"));
                dto.setGeoData(rs.getString("us_geo_data"));
                dto.setGeoTipo(rs.getString("us_geo_tipo"));
                dto.setVigente(rs.getBoolean("us_vigente"));
                dto.setPass(Cript.desencriptar(rs.getString("us_pass")));
                dto.setImg(rs.getString("us_img"));
                dto.setTipo(rs.getInt("tipo_usuario_tip_id"));
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
    
    public Usuario getUsuarioByRut(int rut)
    {
        Usuario dto = new Usuario();
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select * from usuario where us_rut = ?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, rut);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                dto = new Usuario();
                dto.setRut(rs.getInt("us_rut"));
                dto.setDv(rs.getString("us_dv").charAt(0));
                dto.setNombre(rs.getString("us_nombre"));
                dto.setEmail(rs.getString("us_email"));
                dto.setGeoData(rs.getString("us_geo_data"));
                dto.setGeoTipo(rs.getString("us_geo_tipo"));
                dto.setVigente(rs.getBoolean("us_vigente"));
                dto.setPass(Cript.desencriptar(rs.getString("us_pass")));
                dto.setImg(rs.getString("us_img"));
                dto.setTipo(rs.getInt("tipo_usuario_tip_id"));
            }
            conexion.close();
        }catch(SQLException w){
            System.out.println("Error SQL al buscar "+w.getMessage());
        }catch(Exception z){
            System.out.println("Error al buscar "+z.getMessage());
        }
        return dto;
    }
}
