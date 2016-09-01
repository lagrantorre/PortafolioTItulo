/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wspack;

import com.google.gson.Gson;
import dao.daoLogin;
import dao.daoProducto;
import dao.daoTipoProd;
import dao.daoTipoUsuario;
import dao.daoUsuario;
import util.Cript;
import dto.Producto;
import dto.TipoProd;
import dto.TipoUsuario;
import dto.Usuario;
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
        Usuario dto = new daoLogin().validar(rut, Cript.encriptar(pass));
        if (!dto.isVigente()){
            return "";
        }else{
            gson = new Gson();
            return gson.toJson(dto);
        }
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getTipoProd")
    public String getTipoProd() {
        Gson gson = new Gson();
        ArrayList<TipoProd> lista = new daoTipoProd().listarTipoProd();
        return gson.toJson(lista);
    }
    
    /**
     * Web service operation
     * @param tipoProd
     * @return 
     */
    @WebMethod(operationName = "getProdByTipo")
    public String getProdByTipo(@WebParam(name = "tipoProducto")int tipoProd) {
        Gson gson = new Gson();
        ArrayList<Producto> lista = new daoProducto().listarProdByTipo(tipoProd);
        return gson.toJson(lista);
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
    
    /**
     * Web service operation
     * @param rut
     * @return 
     */
    @WebMethod(operationName = "ListarVentasByVendedor")
    public String ListarVentasByVendedor(@WebParam(name = "Rut") int rut) {
        Gson gson = new Gson();
        ArrayList<Usuario> lista = new daoUsuario().ListarUsuario(rut);
        return gson.toJson(lista);
    }
}
