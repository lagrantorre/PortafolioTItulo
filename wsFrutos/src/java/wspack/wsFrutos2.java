/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wspack;

import com.google.gson.Gson;
import dao.daoDetalle;
import dao.daoEsp;
import dao.daoLogin;
import dao.daoProducto;
import dao.daoStock;
import dao.daoTipoProd;
import dao.daoTipoUsuario;
import dao.daoUsuario;
import dao.daoVenta;
import dto.Detalle;
import util.Cript;
import dto.Producto;
import dto.Stock;
import dto.TipoProd;
import dto.TipoUsuario;
import dto.Usuario;
import dto.UsuarioProd;
import dto.Venta;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import util.Mail;

/**
 *
 * @author Robert
 */
@WebService(serviceName = "wsFrutos2")
public class wsFrutos2 {
/**
     * Borrar venta
     * 
     * @param id id de la venta a borrar
     * @return true o false
     */
    @WebMethod(operationName = "delVenta")
    public boolean delVenta(@WebParam(name = "Id")int id) {
        return new daoVenta().delVenta(id);
    }
    
    /**
     * Traer detalles por id de venta
     *
     * @param id id de venta a buscar
     * @return Json con Array de detalles
     */
    @WebMethod(operationName = "ListarDetalleByIdVenta")
    public String ListarDetalleByIdVenta(@WebParam(name = "IdVenta") int id) {
        Gson gson = new Gson();
        ArrayList<Detalle> lista = new daoDetalle().ListarDetalleByIdVenta(id);
        return gson.toJson(lista);
    }
    
    /**
     * Traer detalle por id
     *
     * @param id id del detalle
     * @return Json con detalle
     */
    @WebMethod(operationName = "getDetalleById")
    public String getDetalleById(@WebParam(name = "IdDetalle") int id) {
        Gson gson = new Gson();
        Detalle asd = new daoDetalle().getDetalleById(id);
        return gson.toJson(asd);
    }
    
    /**
     * insertar nuevo detalle
     *
     * @param cantidad nuevo dato
     * @param total nuevo dato
     * @param stockId id del stock asociado
     * @param ventaId id de la venta asociada
     * @return true o false
     */
    @WebMethod(operationName = "insDetalle")
    public boolean insDetalle(@WebParam(name = "Cantidad")int cantidad, @WebParam(name = "Total")int total, @WebParam(name = "IdStock")int stockId, @WebParam(name = "IdVenta")int ventaId) {
        return new daoDetalle().insDetalle(cantidad, total, stockId, ventaId);
    }
    
    /**
     * Actualizar detalle 
     *
     * @param id id del detalle a actualizar
     * @param cantidad nuevo dato
     * @param total nuevo dato
     * @param stockId nuevo dato
     * @param ventaId nuevo dato
     * @return true o false
     */
    @WebMethod(operationName = "updDetalle")
    public boolean updDetalle(@WebParam(name = "id")int id, @WebParam(name = "Cantidad")int cantidad, @WebParam(name = "Total")int total, @WebParam(name = "IdStock")int stockId, @WebParam(name = "IdVenta")int ventaId) {
        return new daoDetalle().updDetalle(id,cantidad, total, stockId, ventaId);
    }
    
    /**
     * Borrar detalle 
     *
     * @param id del detalle a borrar
     * @return true o false
     */
    @WebMethod(operationName = "delDetalle")
    public boolean delDetalle(@WebParam(name = "id")int id) {
        return new daoDetalle().delDetalle(id);
    }
    
    /**
     * Traer datos de producto y vendedor / objetos especiales:
     * UsuarioProd:
     * private int rut;
     * private String nombre; 
     * private String geoData;
     * private ArrayList<StockName> stock;
     * 
     * StockName:
     * private int id;
     * private int kilos;
     * private int precios;
     * private int prId;
     * private int bodId;
     * private String nomProd;
     * private int tipoId;
     * private String nomTipo;
     * 
     * @param rut Rut del vendedor
     * @return Json con objeto UsuarioProd
     */
    @WebMethod(operationName = "getProductoUsuario")
    public String getProductoUsuario(@WebParam(name = "Rutproductor") int rut) {
        Gson gson = new Gson();
        UsuarioProd asd = new daoEsp().listar(rut);
        return gson.toJson(asd);
    }
    
    
    /**
     * Traer stock por usuario
     * 
     * @param rut rut del vendedor
     * @return Json con array de stock
     */
    @WebMethod(operationName = "getStockById")
    public String getStockById(@WebParam(name = "IdStock") int id) {
        Gson gson = new Gson();
        ArrayList<Stock> lista = new daoStock().getStockById(id);
        return gson.toJson(lista);
    }    
    
    @WebMethod(operationName = "getStock")
    public String getStock() {
        Gson gson = new Gson();
        ArrayList<Stock> lista = new daoStock().getStock();
        return gson.toJson(lista);
    }
}

    