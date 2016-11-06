/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Stock;
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
public class daoStock {
    public boolean insStock(int kilos, int precio, int idProd, int rutUsu){   
        boolean asd = true;
        try{
        Connection conexion = Conexion.getConexion();
        String query="insert into stock values (stock_seq.nextval,?,?,?,?)";
        PreparedStatement insert = 
        conexion.prepareStatement(query);
        insert.setInt(1, kilos);
        insert.setInt(2, precio);
        insert.setInt(3, idProd);
        insert.setInt(4, rutUsu);
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
    public boolean updStock(int kilos, int precio, int idStock){   
        boolean asd = true;
        try{
        Connection conexion = Conexion.getConexion();
        String query="update stock set st_kilos = ?, st_precio = ? where st_id = ?";
        PreparedStatement insert = 
        conexion.prepareStatement(query);
        insert.setInt(1, kilos);
        insert.setInt(2, precio);
        insert.setInt(3, idStock);
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
    
    public boolean delStock(int idStock){   
        boolean asd = true;
        try{
        Connection conexion = Conexion.getConexion();
        String query="delete from stock where st_id = ?";
        PreparedStatement insert = 
        conexion.prepareStatement(query);
        insert.setInt(1, idStock);
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

    public ArrayList<Stock> getStockByUsu(int rut) {
        ArrayList<Stock> lista= new ArrayList<>();
        Stock dto;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "select a.st_id, a.st_kilos, a.st_precio, a.producto_pr_id, a.bodega_bod_id from stock a, bodega b "+
                    " where a.bodega_bod_id = b.bod_id and b.usuario_us_rut = ?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, rut);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                dto = new Stock();
                dto.setId(rs.getInt("st_id"));
                dto.setKilos(rs.getInt("st_kilos"));
                dto.setPrecio(rs.getInt("st_precio"));
                dto.setPr_id(rs.getInt("producto_pr_id"));
                dto.setBod_id(rs.getInt("bodega_bod_id"));
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
