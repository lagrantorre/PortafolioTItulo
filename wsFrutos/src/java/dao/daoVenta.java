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
