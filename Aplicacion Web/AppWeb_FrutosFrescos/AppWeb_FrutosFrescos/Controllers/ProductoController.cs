using AppWeb_FrutosFrescos.Models;
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

        [HttpGet]
        public ActionResult Index(int tipoProd)
        {
            return View();
        }

        public ActionResult Detalle(int id)
        {
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