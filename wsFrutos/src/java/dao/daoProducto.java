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
    
    public ArrayList<Producto> listarProducto()
    {
        ArrayList<Producto> lista= new ArrayList<>();
        Producto dto;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select * from producto";
            PreparedStatement buscar=conexion.prepareStatement(query);
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
    }//
    
    public Producto getProdById(int id)
    {
        Producto dto = new Producto();
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select * from producto where pr_id = ?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                dto = new Producto();
                dto.setId(rs.getInt("pr_id"));
                dto.setNombre(rs.getString("pr_nombre"));
                dto.setTipo(rs.getInt("tipo_prod_tip_id"));
            }
            conexion.close();
        }catch(SQLException w){
            System.out.println("Error SQL al buscar "+w.getMessage());
        }catch(Exception z){
            System.out.println("Error al buscar "+z.getMessage());
        }
        return dto;
    }//
    
    public boolean updProd(int id, String nombre, int tipo)
    {
        boolean asd = true;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "update producto set pr_nombre = ?, tipo_prod_tip_id =?  where pr_id = ?";
            PreparedStatement upd=conexion.prepareStatement(query);
            upd.setString(1, nombre);
            upd.setInt(2, tipo);
            upd.setInt(3, id);
            upd.execute();
            upd.close();
            conexion.close();
            
        }catch(SQLException w){
            System.out.println("Error SQL al buscar "+w.getMessage());
            asd=false;
        }catch(Exception z){
            System.out.println("Error al buscar "+z.getMessage());
            asd = false;
        }
        return asd;
    }//
    
    public boolean delProd(int id)
    {
        boolean asd = true;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "delete from producto where pr_id = ?";
            PreparedStatement upd=conexion.prepareStatement(query);
            upd.setInt(1, id);
            upd.execute();
            upd.close();
            conexion.close();
            
        }catch(SQLException w){
            System.out.println("Error SQL al buscar "+w.getMessage());
            asd=false;
        }catch(Exception z){
            System.out.println("Error al buscar "+z.getMessage());
            asd = false;
        }
        return asd;
    }//
    
    public boolean insProd(int id, String nombre, int tipo)
    {
        boolean asd = true;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "insert into producto values (?,?,?);";
            PreparedStatement upd=conexion.prepareStatement(query);
            upd.setInt(1, id);
            upd.setString(2, nombre);
            upd.setInt(3, tipo);
            upd.execute();
            upd.close();
            conexion.close();
            
        }catch(SQLException w){
            System.out.println("Error SQL al buscar "+w.getMessage());
            asd=false;
        }catch(Exception z){
            System.out.println("Error al buscar "+z.getMessage());
            asd = false;
        }
        return asd;
    }//
    
    public ArrayList<Producto> getProdByUsu(int rut)
    {
        ArrayList<Producto> lista= new ArrayList<>();
        Producto dto;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select a.pr_id, " +
            "a.pr_nombre," +
            "a.tipo_prod_tip_id" +
            "from producto a, stock b , bodega c, usuario d" +
            "where" +
            "a.pr_id = b.producto_pr_id and" +
            "b.bodega_bod_id = c.bod_id and" +
            "c.usuario_us_rut = d.us_rut and" +
            "d.us_rut = ?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, rut);
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
