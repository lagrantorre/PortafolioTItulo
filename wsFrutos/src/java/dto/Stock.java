/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Robert
 */
public class Stock {
    private int id;
    private int kilos; 
    private int precio;
    private int pr_id;
    private int bod_id;

    public Stock() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKilos() {
        return kilos;
    }

    public void setKilos(int kilos) {
        this.kilos = kilos;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPr_id() {
        return pr_id;
    }

    public void setPr_id(int pr_id) {
        this.pr_id = pr_id;
    }

    public int getBod_id() {
        return bod_id;
    }

    public void setBod_id(int bod_id) {
        this.bod_id = bod_id;
    }

    @Override
    public String toString() {
        return "Stock{" + "id=" + id + ", kilos=" + kilos + ", precio=" + precio + ", pr_id=" + pr_id + ", bod_id=" + bod_id + '}';
    }
    
}
