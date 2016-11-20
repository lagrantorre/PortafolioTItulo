using AppWeb_FrutosFrescos.Models;
using AppWeb_FrutosFrescos.wsFrutos;
using AppWeb_FrutosFrescos.wsFrutos2;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace AppWeb_FrutosFrescos.Controllers
{
    public class CarritoController : Controller
    {
        // GET: Carrito
        public ActionResult Index()
        {
            List<Carrito> carrito;
            if (Session["carrito"] != null)
            {
                carrito = Session["carrito"] as List<Carrito>;

            }
            else
            {
                carrito = new List<Carrito>();
            }

            ViewBag.carrito = carrito;
            return View();
        }

        public ActionResult Comprar()
        {
            wsFrutosClient ws = new wsFrutosClient();
            wsFrutos2Client ws2 = new wsFrutos2Client();

            var usr = System.Web.HttpContext.Current.Session["usuario"] as Usuario;

            var carrito = System.Web.HttpContext.Current.Session["carrito"] as List<Carrito>;



            var ventas = carrito.GroupBy(a => a.idVenta);

            foreach (var item in ventas)
            {
                int idProd = item.FirstOrDefault().idProductor;

                int suma = item.Sum(a => a.total);

                ws.updVenta(item.Key, suma, idProd, usr.rut, 1);   
 


                //ws.updStock
            }

            foreach (var item in carrito)
            {
                //JsonConvert.DeserializeObject<ProdUsuario>(ws2.getProductoUsuario(idProductor));
                var lststock = JsonConvert.DeserializeObject<List<Stock>>(ws2.getStockById(item.idStock));
                var stock = lststock.FirstOrDefault();
                var restante = stock.kilos - item.cantidad;

                ws.updStock(restante, stock.precio, stock.id);

            }

            new LoginController().CargaCarrito();



            return View("Index"); 
        }

        
        public ActionResult Eliminar(int idDeta)
        {
            wsFrutosClient ws = new wsFrutosClient();
            wsFrutos2Client ws2 = new wsFrutos2Client();

            if (ws2.delDetalle(idDeta))
            {
                new LoginController().CargaCarrito();
            }
            
//            var carrito = System.Web.HttpContext.Current.Session["carrito"] as List<Carrito>;

            return View("Index");

        }
    }
}