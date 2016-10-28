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
    public class HomeController : Controller
    {
        public ActionResult Index()
        {


            wsFrutosClient ws = new wsFrutosClient();

            var lstUsr = JsonConvert.DeserializeObject<List<Usuario>>(ws.getUsuarios());

            ViewBag.lstUsr = lstUsr;

            return View();
        }

        [HttpGet]
        public ActionResult Index(int idUsr = 0, int tipoProd = 0)
        {
            wsFrutosClient ws = new wsFrutosClient();

            var lstUsr = JsonConvert.DeserializeObject<List<Usuario>>(ws.getUsuarios());

            ViewBag.lstUsr = lstUsr;

            if (idUsr != 0 || tipoProd != 0)
            {
                ViewBag.resultado = lstUsr.Where(a => a.rut == idUsr);
            }
               

            return View();


        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}