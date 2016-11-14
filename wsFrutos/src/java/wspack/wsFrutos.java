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
@WebService(serviceName = "wsFrutos")
public class wsFrutos {
/**
     * Login
     * 
     * @param rut rut del usuario
     * @param pass password del usuario
     * @return Json con los datos del usuario (password encriptada)
     */
    @WebMethod(operationName = "Login")
    public String login(@WebParam(name = "Rut") int rut, @WebParam(name = "Password") String pass) {
        Gson gson;
        String pw = new Cript().encriptaEnMD5(pass);
        Usuario dto = new daoLogin().validar(rut, (pw));
        if (!dto.isVigente()){
            return "";
        }else{
            gson = new Gson();
            return gson.toJson(dto);
        }
    }

    /**
     * Traer tipos de productos
     * 
     * @return Json con Array de los tipos de productos que hay en la bdd
     */
    @WebMethod(operationName = "getTipoProd")
    public String getTipoProd() {
        Gson gson = new Gson();
        ArrayList<TipoProd> lista = new daoTipoProd().listarTipoProd();
        return gson.toJson(lista);
    }

    /**
     * Traer tipo de producto por id
     * 
     * @param idTipoProd el id del tipo de producto a buscar
     * @return Json el tipo de producto buscado
     */
    @WebMethod(operationName = "getTipoProdById")
    public String getTipoProdById(@WebParam(name = "idTipoProducto")int idTipoProd) {
        Gson gson = new Gson();
        String asd = new daoTipoProd().getTipoProdById(idTipoProd).toString();
        return gson.toJson(asd);
    }

    /**
     * Actualizar datos de tipo producto
     * 
     * @param nombre Nuevo nombre del tipo producto
     * @param idTipoProd id del producto
     * @return true o false
     */
    @WebMethod(operationName = "updTipoProd")
    public boolean updTipoProd(@WebParam(name = "nombre")String nombre, @WebParam(name = "idTipoProducto")int idTipoProd) {
       return new daoTipoProd().updTipoProd(nombre, idTipoProd);
    }

    /**
     *insertar tipo producto
     * 
     * @param nombre nombre del tipo de producto a insertar
     * @return true o false
     */
    @WebMethod(operationName = "insTipoProd")
    public boolean insTipoProd(@WebParam(name = "nombre")String nombre) {
        return new daoTipoProd().insTipoProd(nombre);
    }

    /**
     * borrar tipo producto
     * 
     * @param id id del tipo producto a borrar
     * @return true o false
     */
    @WebMethod(operationName = "delTipoProd")
    public boolean delTipoProd(@WebParam(name = "id")int id) {
        return new daoTipoProd().delTipoProd(id);
    }
    
    /**
     * traer productos por tipo 
     * 
     * @param tipoProd tipo de producto a consultar
     * @return Json con Array de productos
     */
    @WebMethod(operationName = "getProdByTipo")
    public String getProdByTipo(@WebParam(name = "tipoProducto")int tipoProd) {
        Gson gson = new Gson();
        ArrayList<Producto> lista = new daoProducto().listarProdByTipo(tipoProd);
        return gson.toJson(lista);
    }

    /**
     * Traer productos por usuario
     * 
     * @param rut rut del productor asociado 
     * @return Json con Array de productos 
     */
    @WebMethod(operationName = "getProdByUsu")
    public String getProdByUsu(@WebParam(name = "rut")int rut) {
        Gson gson = new Gson();
        ArrayList<Producto> lista = new daoProducto().getProdByUsu(rut);
        return gson.toJson(lista);
    }

    /**
     * Traer todos los productos de la BD
     * 
     * @return Array de productos
     */
    @WebMethod(operationName = "listarProducto")
    public String getProdByRut() {
        Gson gson = new Gson();
        ArrayList<Producto> lista = new daoProducto().listarProducto();
        return gson.toJson(lista);
    }

    /**
     * Traer producto por id
     * 
     * @param id id del producto a consultar
     * @return Json con producto
     */
    @WebMethod(operationName = "getProdById")
    public String getProdByRut(@WebParam(name = "id")int id) {
        Gson gson = new Gson();
        Producto asd = new daoProducto().getProdById(id);
        return gson.toJson(asd);
    }

    /**
     * Actualizar producto
     * 
     * @param id id del producto a actualizar
     * @param nombre nuevo nombre del producto
     * @param tipo nuevo tipo del producto
     * @return true o false
     */
    @WebMethod(operationName = "updProd")
    public boolean updProd(@WebParam(name = "id")  int id, @WebParam(name = "nombre") String nombre,@WebParam(name = "tipo")  int tipo) {
       return new daoProducto().updProd(id, nombre, tipo);
    }

    /**
     * insertar producto
     * 
     * @param nombre nombre del producto
     * @param tipo tipo del producto
     * @return true o false
     */
    @WebMethod(operationName = "insProd")
    public boolean insProd(@WebParam(name = "nombre") String nombre, @WebParam(name = "tipo")  int tipo) {
       return new daoProducto().insProd(nombre, tipo);
    }

    /**
     * Eliminar producto
     * 
     * @param id id del producto a eliminar
     * @return true o false
     */
    @WebMethod(operationName = "delProd")
    public boolean delProd(@WebParam(name = "id")int id) {
        return new daoProducto().delProd(id);
    }
    
    /**
     * Traer usuarios
     * @return Json con Array con usuarios disponibles en BD
     */
    @WebMethod(operationName = "getUsuarios")
    public String getUsuarios() {
        Gson gson = new Gson();
        ArrayList<Usuario> lista = new daoUsuario().listarUsuario();
        return gson.toJson(lista);
    }
    
    /**
     * Traer usuarios por tipo de usuario
     * 
     * @param tipoUsuario tipo de usuario a consultar
     * @return Json con array de usuarios
     */
    @WebMethod(operationName = "getUsuariosByTipo")
    public String getUsuariosByTipo(@WebParam(name = "tipoUsuario")int tipoUsuario) {
        Gson gson = new Gson();
        ArrayList<Usuario> lista = new daoUsuario().ListarUsuario(tipoUsuario);
        return gson.toJson(lista);
    }

    /**
     * Traer usuarios por tipo de producto disponible
     * 
     * @param tipoProd tipo de producto por el cual se filtra
     * @return Json con array de usuarios 
     */
    @WebMethod(operationName = "getUsuariosByTipoProd")
    public String getUsuariosByTipoProd(@WebParam(name = "tipoProducto")int tipoProd) {
        Gson gson = new Gson();
        ArrayList<Usuario> lista = new daoUsuario().getUsuarioByTipoProd(tipoProd);
        return gson.toJson(lista);
    }

    /**
     * Traer usuario por rut
     * 
     * @param rut rut del usuario a buscar (sin dv)
     * @return Json con el usuario
     */
    @WebMethod(operationName = "getUsuarioByRut")
    public String getUsuarioByRut(@WebParam(name = "rut")int rut) {
        Gson gson = new Gson();
        Usuario asd = new daoUsuario().getUsuarioByRut(rut);
        return gson.toJson(asd);
    }

	/**
	 * Actualizar usuario
	 * 
	 * @param rut rut del usuario a actualizar 
	 * @param dv dv a actualizar (no debiese actualizarse, de ser posible mantenerlo y dejarlo bloqueado)
	 * @param nombre nuevo dato
	 * @param email nuevo dato
	 * @param geoData nuevo dato
	 * @param geoTipo nuevo dato
	 * @param pass nuevo dato
	 * @param img nuevo dato
	 * @param vigente nuevo dato
	 * @param tipo nuevo dato
	 * @return true o false
	 */
	@WebMethod(operationName = "updUsuario")
	public boolean updUsuario(@WebParam(name = "rut") int rut,@WebParam(name = "dv") char dv,@WebParam(name = "nombre") String nombre, @WebParam(name = "email") String email, @WebParam(name = "getoData") String geoData, @WebParam(name = "geoTipo") String geoTipo, @WebParam(name = "pass") String pass, @WebParam(name = "img") String img,@WebParam(name = "bool")  boolean vigente,@WebParam(name = "tipo")  int tipo) {
	   String pw = new Cript().encriptaEnMD5(pass);
	   return new daoUsuario().updUsuario(rut, dv, nombre, email, geoData, geoTipo, pw, img, vigente, tipo);
	}

    /**
     * Insertar Usuario
     * 
     * @param rut nuevo dato
     * @param dv nuevo dato
     * @param nombre nuevo dato
     * @param email nuevo dato
     * @param geoData nuevo dato
     * @param geoTipo nuevo dato
     * @param pass nuevo dato
     * @param img nuevo dato
     * @param vigente nuevo dato
     * @param tipo nuevo dato
     * @return true o false
     */
    @WebMethod(operationName = "insUsuario")
    public boolean insUsuario(@WebParam(name = "rut") int rut,@WebParam(name = "dv") String dv,@WebParam(name = "nombre") String nombre, @WebParam(name = "email") String email, @WebParam(name = "getoData") String geoData, @WebParam(name = "geoTipo") String geoTipo, @WebParam(name = "pass") String pass, @WebParam(name = "img") String img,@WebParam(name = "bool")  boolean vigente,@WebParam(name = "tipo")  int tipo) {
        String pw = new Cript().encriptaEnMD5(pass);
        return new daoUsuario().insUsuario(rut, dv.charAt(0), nombre, email, geoData, geoTipo, pw, img, vigente, tipo);
    }

    /**
     * Traer stock por usuario
     * 
     * @param rut rut del vendedor
     * @return Json con array de stock
     */
    @WebMethod(operationName = "getStockByUsu")
    public String getStockByUsu(@WebParam(name = "RutVendedor") int rut) {
        Gson gson = new Gson();
        ArrayList<Stock> lista = new daoStock().getStockByUsu(rut);
        return gson.toJson(lista);
    }

    /**
     * insertar Stock
     *
     * @param kilos nuevo dato 
     * @param precio nuevo dato 
     * @param idProd id del producto
     * @param rutUsu rut del vendedor 
     * @return true o false
     */
    @WebMethod(operationName = "insStock")
    public boolean insStock(@WebParam(name = "Kilos") int kilos, @WebParam(name = "Precio")  int precio, @WebParam(name = "idProducto")  int idProd, @WebParam(name = "RutUsu")  int rutUsu) {
       return new daoStock().insStock(kilos, precio,idProd,rutUsu);
    }

    /**
     * Actualizar Stock
     *
     * @param kilos nuevo dato 
     * @param precio nuevo dato 
     * @param idStock id del stock a actualizar
     * @return true o false
     */
    @WebMethod(operationName = "updStock")
    public boolean updStock(@WebParam(name = "Kilos") int kilos, @WebParam(name = "Precio")  int precio, @WebParam(name = "idStock")  int idStock) {
       return new daoStock().updStock(kilos, precio,idStock);
    }

    /**
     * Borrar stock
     * 
     * @param idStock id del stock a borrar
     * @return ture o false
     */
    @WebMethod(operationName = "delStock")
    public boolean delStock(@WebParam(name = "idStock")  int idStock) {
       return new daoStock().delStock(idStock);
    }

    /**
     * Borrar usuario
     * 
     * @param rut rut del usuario a borrar
     * @return true o false
     */
    @WebMethod(operationName = "delUsuario")
    public boolean delUsuario(@WebParam(name = "rut")int rut) {
        return new daoUsuario().delUsuario(rut);
    }
    
    
    /**
     * Traer tipo de usuario por id
     * 
     * @param tipoUsuario id del tipo
     * @return Json con tipo de usuario
     */
    @WebMethod(operationName = "getTipoUsuarioByTipo")
    public String getTipoUsuarioByTipo(@WebParam(name = "tipoUsuario")int tipoUsuario) {
        Gson gson = new Gson();
        TipoUsuario lista = new daoTipoUsuario().listarTipoUsuario(tipoUsuario);
        return gson.toJson(lista);
    }
    
    /**
     * Inicia el proceso de recuperación de contraseña,
     * Genera una nueva contraseña temporal y la envía al correo
     * *El email del usuario debe ser un email valido
     * 
     * @param rut rut del usuario 
     * @return true o false
     */
    @WebMethod(operationName = "RecuperarContrasena")
    public boolean RecuperarContrasena(@WebParam(name = "Rut") int rut) {
        boolean recupera = new Mail().recuperarMail(rut);
        return recupera;
    }
    
    /**
     * Traer todos los tipos de usuario en la BD
     *
     * @return JSON con Array de tipo de usuario
     */
    @WebMethod(operationName = "ListarTipoUsuario")
    public String ListarTipoUsuario() {
        Gson gson = new Gson();
        ArrayList<TipoUsuario> lista = new daoTipoUsuario().listarTipoUsuario();
        return gson.toJson(lista);
    }
    
    /**
     * Traer todas las ventas por vendedor
     * 
     * @param rut rut del usuario a consultar
     * @return Json con Array de ventas
     */
    @WebMethod(operationName = "ListarVentasByVendedor")
    public String ListarVentasByVendedor(@WebParam(name = "Rut") int rut) {
        Gson gson = new Gson();
        ArrayList<Venta> lista = new daoVenta().ListarVentasByVendedor(rut);
        return gson.toJson(lista);
    }
    
    /**
     * Traer ventas por comprador
     *
     * @param rut rut del comprador
     * @return Json con Array de Ventas
     */
    @WebMethod(operationName = "ListarVentasByComprador")
    public String ListarVentasByComprador(@WebParam(name = "Rut") int rut) {
        Gson gson = new Gson();
        ArrayList<Venta> lista = new daoVenta().ListarVentasByComprador(rut);
        return gson.toJson(lista);
    }

    /**
     * Traer venta por id
     *
     * @param id id de la venta
     * @return Json con venta
     */
    @WebMethod(operationName = "getVentaById")
    public String getVentaById(@WebParam(name = "id") int id) {
        Gson gson = new Gson();
        Venta asd = new daoVenta().getVentaById(id);
        return gson.toJson(asd);
    }
    
    /**
     * Insertar nueva venta
     * 
     * @param total nuevo dato
     * @param rutVende nuevo dato
     * @param rutCompra nuevo dato
     * @param estado nuevo dato
     * @return true o false
     */
    @WebMethod(operationName = "insVenta")
    public boolean insVenta(@WebParam(name = "Total")int total, @WebParam(name = "rutVende")int rutVende, @WebParam(name = "rutCompra")int rutCompra, @WebParam(name = "Estado")int estado) {
        return new daoVenta().insVenta(total, rutVende, rutCompra, estado);
    }

    /**
     * Actualizar venta 
     *
     * @param id id de la venta a actualizar
     * @param total nuevo dato
     * @param rutVende nuevo dato
     * @param rutCompra nuevo dato
     * @param estado nuevo dato
     * @return true o false
     */
    @WebMethod(operationName = "updVenta")
    public boolean updVenta(@WebParam(name = "Id")int id, @WebParam(name = "Total")int total, @WebParam(name = "rutVende")int rutVende, @WebParam(name = "rutCompra")int rutCompra, @WebParam(name = "Estado")int estado) {
        return new daoVenta().updVenta(id, total, rutVende, rutCompra, estado);
    }
}
