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
    
    public TipoProd getTipoProdById(int id)
    {
        TipoProd dto = new TipoProd();
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select * from tipo_prod where tip_id = ?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                dto = new TipoProd();
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
    
    public boolean updTipoProd	(String nombre, int id)
    {   
        boolean asd = true;
        try{
        Connection conexion = Conexion.getConexion();
        String query="update tipo_prod set tip_nombre = ? where tip_id = ?;";
        PreparedStatement update = 
        conexion.prepareStatement(query);
        update.setString(1, nombre);
        update.setInt(2, id);
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
    }//
    
    public boolean insTipoProd(String nombre)
    {   
        boolean asd = true;
        try{
        Connection conexion = Conexion.getConexion();
        String query="insert into tipo_prod values ((select max (tip_id) +1 from tipo_prod), ?);";
        PreparedStatement insert = 
        conexion.prepareStatement(query);
        insert.setString(1, nombre);
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
    
    public boolean delTipoProd(int id)
    {   
        boolean asd = true;
        try{
        Connection conexion = Conexion.getConexion();
        String query="delete from tipo_prod where tip_id = ?;";
        PreparedStatement insert = 
        conexion.prepareStatement(query);
        insert.setInt(1, id);
        insert.execute();
        insert.close();
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
    }//
}
