using AppWeb_FrutosFrescos.Models;
using AppWeb_FrutosFrescos.wsFrutos;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace AppWeb_FrutosFrescos.Controllers
{
    public class ProductoController : Controller
    {
        // GET: Producto
        public ActionResult Index()
        {
            return View();
        }

        //[HttpGet]
        //public ActionResult Index(int tipoProd)
        //{
        //    return View();
        //}

        public ActionResult Detalle(int idProductor)
        {
            wsFrutosClient ws = new wsFrutosClient();
            var lstProductos = JsonConvert.DeserializeObject<List<Producto>>(ws.listarProducto(idProductor));
            ViewBag.lstProductos = lstProductos;
            ViewBag.idProductor = idProductor;
            return View();
        }

        [HttpPost]
        public ActionResult Detalle(int idProductor, int cantidad, int idProducto)
        {

            if (Session["carrito"] == null)
                Session["carrito"] = new List<Carrito>();

            var carrito =  Session["carrito"] as List<Carrito>;

            carrito.Add(new Carrito { cantidad = cantidad, idProducto = idProducto });
                        
            wsFrutosClient ws = new wsFrutosClient();
            var lstProductos = JsonConvert.DeserializeObject<List<Producto>>(ws.listarProducto(idProductor));
            ViewBag.lstProductos = lstProductos;
            ViewBag.idProductor = idProductor;
            return View();
        }


        public ActionResult Agregar()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Agregar(Producto prod)
        {
            return View();
        }
    }
}