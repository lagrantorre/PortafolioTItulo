/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;

/**
 *
 * @author Robert
 */
public class UsuarioProd {
    private int rut;
    private String nombre; 
    private String geoData;
    private ArrayList<StockName> stock;

    public UsuarioProd() {
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGeoData() {
        return geoData;
    }

    public void setGeoData(String geoData) {
        this.geoData = geoData;
    }

    public ArrayList<StockName> getStock() {
        return stock;
    }

    public void setStock(ArrayList<StockName> stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "UsuarioProd{" + "rut=" + rut + ", nombre=" + nombre + ", geoData=" + geoData + ", stock=" + stock + '}';
    }
    
}

