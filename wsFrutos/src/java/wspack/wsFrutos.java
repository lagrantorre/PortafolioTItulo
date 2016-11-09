/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wspack;

import com.google.gson.Gson;
import dao.daoDetalle;
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
@WebService(serviceName = "wsFrutos")
public class wsFrutos {
    /**
     * Web service operation
     * @param rut
     * @param pass
     * @return 
     */
    @WebMethod(operationName = "Login")
    public String login(@WebParam(name = "Rut") int rut, @WebParam(name = "Password") String pass) {
        Gson gson;
        Usuario dto = new daoLogin().validar(rut, (pass));
        if (!dto.isVigente()){
            return "";
        }else{
            gson = new Gson();
            return gson.toJson(dto);
        }
    }

    
    @WebMethod(operationName = "getTipoProd")
    public String getTipoProd() {
        Gson gson = new Gson();
        ArrayList<TipoProd> lista = new daoTipoProd().listarTipoProd();
        return gson.toJson(lista);
    }
    @WebMethod(operationName = "getTipoProdById")
    public String getTipoProdById(@WebParam(name = "idTipoProducto")int idTipoProd) {
        Gson gson = new Gson();
        String asd = new daoTipoProd().getTipoProdById(idTipoProd).toString();
        return gson.toJson(asd);
    }
    @WebMethod(operationName = "updTipoProd")
    public boolean updTipoProd(@WebParam(name = "nombre")String nombre, @WebParam(name = "idTipoProducto")int idTipoProd) {
       return new daoTipoProd().updTipoProd(nombre, idTipoProd);
    }
    @WebMethod(operationName = "insTipoProd")
    public boolean insTipoProd(@WebParam(name = "nombre")String nombre) {
        return new daoTipoProd().insTipoProd(nombre);
    }
    @WebMethod(operationName = "delTipoProd")
    public boolean delTipoProd(@WebParam(name = "id")int id) {
        return new daoTipoProd().delTipoProd(id);
    }
    
    @WebMethod(operationName = "getProdByTipo")
    public String getProdByTipo(@WebParam(name = "tipoProducto")int tipoProd) {
        Gson gson = new Gson();
        ArrayList<Producto> lista = new daoProducto().listarProdByTipo(tipoProd);
        return gson.toJson(lista);
    }
    @WebMethod(operationName = "getProdByUsu")
    public String getProdByUsu(@WebParam(name = "rut")int rut) {
        Gson gson = new Gson();
        ArrayList<Producto> lista = new daoProducto().getProdByUsu(rut);
        return gson.toJson(lista);
    }
    @WebMethod(operationName = "listarProducto")
    public String getProdByRut() {
        Gson gson = new Gson();
        ArrayList<Producto> lista = new daoProducto().listarProducto();
        return gson.toJson(lista);
    }
    @WebMethod(operationName = "getProdById")
    public String getProdByRut(@WebParam(name = "id")int id) {
        Gson gson = new Gson();
        Producto asd = new daoProducto().getProdById(id);
        return gson.toJson(asd);
    }
    @WebMethod(operationName = "updProd")
    public boolean updProd(@WebParam(name = "id")  int id, @WebParam(name = "nombre") String nombre,@WebParam(name = "tipo")  int tipo) {
       return new daoProducto().updProd(id, nombre, tipo);
    }
    @WebMethod(operationName = "insProd")
    public boolean insProd(@WebParam(name = "nombre") String nombre, @WebParam(name = "tipo")  int tipo) {
       return new daoProducto().insProd(nombre, tipo);
    }
    @WebMethod(operationName = "delProd")
    public boolean delProd(@WebParam(name = "id")int id) {
        return new daoProducto().delProd(id);
    }
    
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getUsuarios")
    public String getUsuarios() {
        Gson gson = new Gson();
        ArrayList<Usuario> lista = new daoUsuario().listarUsuario();
        return gson.toJson(lista);
    }
    
    /**
     * Web service operation
     * @param tipoUsuario
     * @return 
     */
    @WebMethod(operationName = "getUsuariosByTipo")
    public String getUsuariosByTipo(@WebParam(name = "tipoUsuario")int tipoUsuario) {
        Gson gson = new Gson();
        ArrayList<Usuario> lista = new daoUsuario().ListarUsuario(tipoUsuario);
        return gson.toJson(lista);
    }
    @WebMethod(operationName = "getUsuariosByTipoProd")
    public String getUsuariosByTipoProd(@WebParam(name = "tipoProducto")int tipoProd) {
        Gson gson = new Gson();
        ArrayList<Usuario> lista = new daoUsuario().getUsuarioByTipoProd(tipoProd);
        return gson.toJson(lista);
    }
    @WebMethod(operationName = "getUsuarioByRut")
    public String getUsuarioByRut(@WebParam(name = "rut")int rut) {
        Gson gson = new Gson();
        Usuario asd = new daoUsuario().getUsuarioByRut(rut);
        return gson.toJson(asd);
    }
    @WebMethod(operationName = "updUsuario")
    public boolean updUsuario(@WebParam(name = "rut") int rut,@WebParam(name = "dv") char dv,@WebParam(name = "nombre") String nombre, @WebParam(name = "email") String email, @WebParam(name = "getoData") String geoData, @WebParam(name = "geoTipo") String geoTipo, @WebParam(name = "pass") String pass, @WebParam(name = "img") String img,@WebParam(name = "bool")  boolean vigente,@WebParam(name = "tipo")  int tipo) {
       return new daoUsuario().updUsuario(rut, dv, nombre, email, geoData, geoTipo, pass, img, vigente, tipo);
    }

    @WebMethod(operationName = "insUsuario")
    public boolean insUsuario(@WebParam(name = "rut") int rut,@WebParam(name = "dv") String dv,@WebParam(name = "nombre") String nombre, @WebParam(name = "email") String email, @WebParam(name = "getoData") String geoData, @WebParam(name = "geoTipo") String geoTipo, @WebParam(name = "pass") String pass, @WebParam(name = "img") String img,@WebParam(name = "bool")  boolean vigente,@WebParam(name = "tipo")  int tipo) {
       return new daoUsuario().insUsuario(rut, dv.charAt(0), nombre, email, geoData, geoTipo, pass, img, vigente, tipo);
    }
    @WebMethod(operationName = "getStockByUsu")
    public String getStockByUsu(@WebParam(name = "Rut vendedor") int rut) {
        Gson gson = new Gson();
        ArrayList<Stock> lista = new daoStock().getStockByUsu(rut);
        return gson.toJson(lista);
    }
    @WebMethod(operationName = "insStock")
    public boolean insStock(@WebParam(name = "Kilos") int kilos, @WebParam(name = "Precio")  int precio, @WebParam(name = "idProducto")  int idProd, @WebParam(name = "RutUsu")  int rutUsu) {
       return new daoStock().insStock(kilos, precio,idProd,rutUsu);
    }
    @WebMethod(operationName = "updStock")
    public boolean updStock(@WebParam(name = "Kilos") int kilos, @WebParam(name = "Precio")  int precio, @WebParam(name = "idStock")  int idStock) {
       return new daoStock().updStock(kilos, precio,idStock);
    }
    @WebMethod(operationName = "delStock")
    public boolean delStock(@WebParam(name = "idStock")  int idStock) {
       return new daoStock().delStock(idStock);
    }
    @WebMethod(operationName = "delUsuario")
    public boolean delUsuario(@WebParam(name = "rut")int rut) {
        return new daoUsuario().delUsuario(rut);
    }
    
    
    /**
     * Web service operation
     * @param tipoUsuario
     * @return 
     */
    @WebMethod(operationName = "getTipoUsuarioByTipo")
    public String getTipoUsuarioByTipo(@WebParam(name = "tipoUsuario")int tipoUsuario) {
        Gson gson = new Gson();
        TipoUsuario lista = new daoTipoUsuario().listarTipoUsuario(tipoUsuario);
        return gson.toJson(lista);
    }
    
    /**
     * Web service operation
     * @param rut
     * @return 
     */
    @WebMethod(operationName = "RecuperarContrasena")
    public boolean RecuperarContrasena(@WebParam(name = "Rut") int rut) {
        boolean recupera = new Mail().recuperarMail(rut);
        return recupera;
    }
    
    
    
    @WebMethod(operationName = "ListarTipoUsuario")
    public String ListarTipoUsuario() {
        Gson gson = new Gson();
        ArrayList<TipoUsuario> lista = new daoTipoUsuario().listarTipoUsuario();
        return gson.toJson(lista);
    }
    
    /**
     * Web service operation
     * @param rut
     * @return 
     */
    @WebMethod(operationName = "ListarVentasByVendedor")
    public String ListarVentasByVendedor(@WebParam(name = "Rut") int rut) {
        Gson gson = new Gson();
        ArrayList<Venta> lista = new daoVenta().ListarVentasByVendedor(rut);
        return gson.toJson(lista);
    }
    
    @WebMethod(operationName = "ListarVentasByComprador")
    public String ListarVentasByComprador(@WebParam(name = "Rut") int rut) {
        Gson gson = new Gson();
        ArrayList<Venta> lista = new daoVenta().ListarVentasByComprador(rut);
        return gson.toJson(lista);
    }
    @WebMethod(operationName = "getVentaById")
    public String getVentaById(@WebParam(name = "id") int id) {
        Gson gson = new Gson();
        Venta asd = new daoVenta().getVentaById(id);
        return gson.toJson(asd);
    }
    
    @WebMethod(operationName = "insVenta")
    public boolean insVenta(@WebParam(name = "Total")int total, @WebParam(name = "rutVende")int rutVende, @WebParam(name = "rutCompra")int rutCompra, @WebParam(name = "Estado")int estado) {
        return new daoVenta().insVenta(total, rutVende, rutCompra, estado);
    }
    @WebMethod(operationName = "updVenta")
    public boolean updVenta(@WebParam(name = "Id")int id, @WebParam(name = "Total")int total, @WebParam(name = "rutVende")int rutVende, @WebParam(name = "rutCompra")int rutCompra, @WebParam(name = "Estado")int estado) {
        return new daoVenta().updVenta(id, total, rutVende, rutCompra, estado);
    }
    
    @WebMethod(operationName = "delVenta")
    public boolean delVenta(@WebParam(name = "Id")int id) {
        return new daoVenta().delVenta(id);
    }
    
    @WebMethod(operationName = "ListarDetalleByIdVenta")
    public String ListarDetalleByIdVenta(@WebParam(name = "Id Venta") int id) {
        Gson gson = new Gson();
        ArrayList<Detalle> lista = new daoDetalle().ListarDetalleByIdVenta(id);
        return gson.toJson(lista);
    }
    
    @WebMethod(operationName = "getDetalleById")
    public String getDetalleById(@WebParam(name = "Id detalle") int id) {
        Gson gson = new Gson();
        Detalle asd = new daoDetalle().getDetalleById(id);
        return gson.toJson(asd);
    }
    
    @WebMethod(operationName = "insDetalle")
    public boolean insDetalle(@WebParam(name = "Cantidad")int cantidad, @WebParam(name = "Total")int total, @WebParam(name = "Id Stock")int stockId, @WebParam(name = "Id Venta")int ventaId) {
        return new daoDetalle().insDetalle(cantidad, total, stockId, ventaId);
    }
    
    @WebMethod(operationName = "updDetalle")
    public boolean updDetalle(@WebParam(name = "id")int id, @WebParam(name = "Cantidad")int cantidad, @WebParam(name = "Total")int total, @WebParam(name = "Id Stock")int stockId, @WebParam(name = "Id Venta")int ventaId) {
        return new daoDetalle().updDetalle(id,cantidad, total, stockId, ventaId);
    }
    
    @WebMethod(operationName = "delDetalle")
    public boolean delDetalle(@WebParam(name = "id")int id) {
        return new daoDetalle().delDetalle(id);
    }
}
