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
public class Venta {
    private int id;
    private int total; 
    private int rutVende;
    private int rutCompra;
    private int estado;

    public Venta() {
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", total=" + total + ", rutVende=" + rutVende + ", rutCompra=" + rutCompra + ", estado=" + estado + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRutVende() {
        return rutVende;
    }

    public void setRutVende(int rutVende) {
        this.rutVende = rutVende;
    }

    public int getRutCompra() {
        return rutCompra;
    }

    public void setRutCompra(int rutCompra) {
        this.rutCompra = rutCompra;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
}
