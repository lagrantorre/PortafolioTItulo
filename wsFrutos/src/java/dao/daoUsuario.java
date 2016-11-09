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
                dto.setPass((rs.getString("us_pass")));
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
                dto.setPass(rs.getString("us_pass"));
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
                dto.setPass(rs.getString("us_pass"));
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
    
    public boolean updUsuario(int rut,char dv,String nombre, String email, String geoData, String geoTipo, String pass, String img, boolean vigente, int tipo)
    {
        boolean asd = true;
            try{
            Connection conexion = Conexion.getConexion();
            String query="update usuario set US_NOMBRE = ?, US_EMAIL = ?,US_GEO_DATA = ?,US_GEO_TIPO = ?,US_PASS = ?, US_IMG = ? , US_VIGENTE = ?, TIPO_USUARIO_TIP_ID = ? where us_rut = ?";
            PreparedStatement update = 
            conexion.prepareStatement(query);
            update.setInt(9, rut);
            update.setString(1, nombre);
            update.setString(2, email);
            update.setString(3, geoData);
            update.setString(4, geoTipo);
            update.setString(5, pass);
            update.setString(6, img);
            update.setBoolean(7, vigente);
            update.setInt(8, tipo);
            update.execute();
            update.close();
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
    }
    public boolean updPass(int rut, String pass)
    {
        boolean asd = true;
            try{
            Connection conexion = Conexion.getConexion();
            String query="update usuario set US_PASS = ? where us_rut = ?";
            PreparedStatement update = 
            conexion.prepareStatement(query);
            update.setString(1, pass);
            update.setInt(2, rut);
            update.execute();
            update.close();
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
    }
    public boolean insUsuario(int rut,char dv,String nombre, String email, String geoData, String geoTipo, String pass, String img, boolean vigente, int tipo)
    {
        boolean asd = true;
            try{
            Connection conexion = Conexion.getConexion();
            String query="insert into usuario values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement update = 
            conexion.prepareStatement(query);
            update.setInt(1, rut);
            update.setString(2, String.valueOf(dv));
            update.setString(3, nombre);
            update.setString(4, email);
            update.setString(5, geoData);
            update.setString(6, geoTipo);
            update.setString(7, pass);
            update.setString(8, img);
            update.setBoolean(9, vigente);
            update.setInt(10, tipo);
            update.execute();
            update.close();
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
    }
    
    public boolean delUsuario(int rut)
    {
        boolean asd = true;
        try{
            Connection conexion = Conexion.getConexion();
            String query="delete from usuario where us_rut = ?";
            PreparedStatement update = 
            conexion.prepareStatement(query);
            update.setInt(1, rut);
            update.execute();
            update.close();
            conexion.close();
        }catch(SQLException s){
                System.out.println("Problema SQL al eliminar "+
                        s.getMessage());
                asd = false;
            }catch(Exception e){
                System.out.println("Problemas al eliminar "+
                        e.getMessage());
                asd = false;
            }return asd;
    }
    
    public ArrayList<Usuario> getUsuarioByTipoProd(int tipoProd)
    {
        ArrayList<Usuario> lista= new ArrayList<>();
        Usuario dto;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select distinct d.US_RUT ," +
            "d.US_DV ," +
            "d.US_NOMBRE , " +
            "d.US_EMAIL  ," +
            "d.US_GEO_DATA,  " +
            "d.US_GEO_TIPO , " +
            "d.US_PASS  ," +
            "d.US_IMG  ," +
            "d.US_VIGENTE,  " +
            "d.TIPO_USUARIO_TIP_ID " +
            "from producto a, stock b , bodega c, usuario d " +
            "where " +
            "a.pr_id = b.producto_pr_id and " +
            "b.bodega_bod_id = c.bod_id and " +
            "c.usuario_us_rut = d.us_rut and " +
            "a.tipo_prod_tip_id = ?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, tipoProd);
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
                dto.setPass((rs.getString("us_pass")));
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
}
