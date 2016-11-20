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
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public ActionResult Index(string error = "")
        {
            ViewBag.Error = error;
            return View();
        }

        public ActionResult Salir()
        {
            Session.Abandon();
            
            return View("Index");
        }

        [HttpPost]
        public ActionResult Ingreso(DataUser data)
        {

        
            Usuario dataUser;

            wsFrutosClient ws = new wsFrutosClient();
            wsFrutos2Client ws2 = new wsFrutos2Client();

            try
            {
                dataUser = JsonConvert.DeserializeObject<Usuario>(ws.Login(Int32.Parse(data.User), data.Pass));
            }
            catch (Exception)
            {
                dataUser = null;
            }

            if (dataUser != null)
            {
                Session["usuario"] = dataUser;

                CargaCarrito();



                return RedirectToAction("Index", "Home");
            }
            else
            {
                ViewBag.Error = "Usuario no existe o la contraseña es incorrecta";
                return View("Index");                
            }
        }

        [HttpPost]
        public ActionResult CrearCuenta(DataUser data)
        {


            wsFrutosClient ws = new wsFrutosClient();

            wsFrutos2Client ws2 = new wsFrutos2Client();

            bool result = ws.insUsuario(Int32.Parse(data.User), data.Dv, data.Nombre, data.Email, " ", " ", data.Pass, " ", true, 1);

            if (result)
            {
                ViewBag.Success = "Cuenta creada exitosamente, por favor ingrese.";
                return View("Index");
            }
            else
            {
                ViewBag.Error = "Cuenta no creada, por favor intente denuevo.";
                return View("Index");
            }

          
        }


        public void CargaCarrito()
        {

            wsFrutosClient ws = new wsFrutosClient();
            wsFrutos2Client ws2 = new wsFrutos2Client();

            var usr = System.Web.HttpContext.Current.Session["usuario"] as Usuario;

            // Obtiene las ventas
            var ventas = JsonConvert.DeserializeObject<List<Venta>>(ws.ListarVentasByComprador(usr.rut));
            // Obtiene ventas en estado 2
            var ventaCarrito = ventas.Where(a => a.estado == 2).ToList<Venta>();
            // Obtiene el detalle de la venta en estado 2 *carrito

            var detalleVentas = new List<DetalleVenta>();

            //if (System.Web.HttpContext.Current.Session["carrito"] == null)
                System.Web.HttpContext.Current.Session["carrito"] = new List<Carrito>();

            var carrito = System.Web.HttpContext.Current.Session["carrito"] as List<Carrito>;

            foreach (var item in ventaCarrito)
            {
                item.lstDetalle = JsonConvert.DeserializeObject<List<DetalleVenta>>(ws2.ListarDetalleByIdVenta(item.id));
                int rutVenta = item.rutVende;
                foreach (var item2 in item.lstDetalle)
                {
                    carrito.Add(new Carrito
                    {
                        idDetalle = item2.id,
                        cantidad = item2.cantidad,
                        idVenta = item2.ventaId,
                        idProducto = item2.prodId,
                        idProductor = rutVenta,
                        total = item2.total,
                        idStock = item2.stockId,
                        nombreProducto = item2.prodNombre
                    });
                }
            }
            System.Web.HttpContext.Current.Session["carrito"] = carrito;
        }

    }


    public class DataUser
    {
        public string User { get; set; }
        public string Pass { get; set; }
        public string Dv { get; set; }
        public string Nombre { get; set; }
        public string Email { get; set; }        
    }
}