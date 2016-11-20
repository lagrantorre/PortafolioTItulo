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
            wsFrutos2Client ws2 = new wsFrutos2Client();

            
            var lstProductos = JsonConvert.DeserializeObject<ProdUsuario>(ws2.getProductoUsuario(idProductor));
            
            ViewBag.lstProductos = lstProductos;
            ViewBag.idProductor = idProductor;

            var asdf = ws.ListarVentasByComprador(1);


            ViewBag.carrito = Session["carrito"] as List<Carrito>;
            return View();
        }

        [HttpPost]
        public ActionResult Detalle(int idProductor, int cantidad, int idProducto, int stockid, int costo)
        {
            wsFrutosClient ws = new wsFrutosClient();
            wsFrutos2Client ws2 = new wsFrutos2Client();
                      
            var usr = Session["usuario"] as Usuario;          

            
            // Ver si existe una compra con estado 2 y perteneciente al productor que vende
            var ventas = JsonConvert.DeserializeObject<List<Venta>>(ws.ListarVentasByComprador(usr.rut));            
            var ventaCarrito = ventas.Where(a => a.estado == 2 && a.rutVende == idProductor).ToList<Venta>();

            // Crear una compra si no o añadir el detalle
            if (ventaCarrito.Count == 0)
            {
                ws.insVenta(0, idProductor, usr.rut, 2);
                // Consulto nuevamente las compras
                var ventas2 = JsonConvert.DeserializeObject<List<Venta>>(ws.ListarVentasByComprador(usr.rut));          
                // Selecciono la del productos
                var ventaCarrito2 = ventas2.Where(a => a.estado == 2 && a.rutVende == idProductor).ToList<Venta>();
                ws2.insDetalle(cantidad, costo, stockid, ventaCarrito2[0].id);
            }
            else
            {
                ws2.insDetalle(cantidad, costo, stockid, ventaCarrito[0].id);
            }

            new LoginController().CargaCarrito();
            
            var lstProductos = JsonConvert.DeserializeObject<List<Producto>>(ws.listarProducto(idProductor));

            ViewBag.lstProductos = lstProductos;
            ViewBag.idProductor = idProductor;
            ViewBag.carrito = Session["carrito"] as List<Carrito>;
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

        public ActionResult Eliminar(int idDeta)
        {
            wsFrutosClient ws = new wsFrutosClient();
            wsFrutos2Client ws2 = new wsFrutos2Client();

            if (ws2.delDetalle(idDeta))
            {
                new LoginController().CargaCarrito();
            }



            return View("Index");

        }
    }
}