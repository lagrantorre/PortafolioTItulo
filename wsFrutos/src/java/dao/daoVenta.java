/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


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
public class daoVenta {
    public ArrayList<Venta> ListarVentasByVendedor(int rut)
    {
        ArrayList<Venta> lista= new ArrayList<>();
        Venta dto;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select * from venta where usuario_rut_vende = ?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, rut);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                dto = new Venta();
                dto.setId(rs.getInt("vn_id"));
                dto.setTotal(rs.getInt("vn_total"));
                dto.setRutVende(rs.getInt("usuario_rut_vende"));
                dto.setRutCompra(rs.getInt("usuario_rut_compra"));
                dto.setEstado(rs.getInt("estado"));
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
    
    public ArrayList<Venta> ListarVentasByComprador(int rut)
    {
        ArrayList<Venta> lista= new ArrayList<>();
        Venta dto;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select * from venta where usuario_rut_compra = ?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, rut);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                dto = new Venta();
                dto.setId(rs.getInt("vn_id"));
                dto.setTotal(rs.getInt("vn_total"));
                dto.setRutVende(rs.getInt("usuario_rut_vende"));
                dto.setRutCompra(rs.getInt("usuario_rut_compra"));
                dto.setEstado(rs.getInt("vn_estado"));
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
    
    public boolean insVenta(int total, int rutVende, int rutCompra, int estado){   
        boolean asd = true;
        try{
        Connection conexion = Conexion.getConexion();
        String query="insert into venta values (venta_seq.nextval,?,?,?,?)";
        PreparedStatement insert = 
        conexion.prepareStatement(query);
        insert.setInt(1, total);
        insert.setInt(2, rutVende);
        insert.setInt(3, rutCompra);
        insert.setInt(4, estado);
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
    
    public boolean updVenta(int id, int total, int rutVende, int rutCompra, int estado){   
        boolean asd = true;
        try{
        Connection conexion = Conexion.getConexion();
        String query="update venta set vn_total = ?, usuario_rut_vende = ?, usuario_rut_compra = ?, vn_estado = ? where vn_id = ?";
        PreparedStatement insert = 
        conexion.prepareStatement(query);
        insert.setInt(1, total);
        insert.setInt(2, rutVende);
        insert.setInt(3, rutCompra);
        insert.setInt(4, estado);
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
    
    public boolean delVenta(int id){   
        boolean asd = true;
        try{
        Connection conexion = Conexion.getConexion();
        String query="delete from venta where vn_id = ?";
        PreparedStatement insert = 
        conexion.prepareStatement(query);
        insert.setInt(1, id);
        insert.execute();
        insert.close();
        conexion.close();
        }catch(SQLException s){
            System.out.println("Problema SQL al eliminar"+
                    s.getMessage());
            asd = false;
        }catch(Exception e){
            System.out.println("Problemas al eliminar"+
                    e.getMessage());
            asd = false;
        }return asd;
    }//
    
     public Venta getVentaById(int id)
    {
        Venta dto = new Venta();
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select * from venta where vn_id = ?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                dto = new Venta();
                dto.setId(rs.getInt("vn_id"));
                dto.setTotal(rs.getInt("vn_total"));
                dto.setRutVende(rs.getInt("usuario_rut_vende"));
                dto.setRutCompra(rs.getInt("usuario_rut_compra"));
                dto.setEstado(rs.getInt("vn_estado"));
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


