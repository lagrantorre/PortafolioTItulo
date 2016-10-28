using AppWeb_FrutosFrescos.Models;
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
    }
}