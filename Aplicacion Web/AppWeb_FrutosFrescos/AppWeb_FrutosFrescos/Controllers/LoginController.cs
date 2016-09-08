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

        [HttpPost]
        public ActionResult Ingreso(DataUser data)
        {

            var wea = data;

            if (wea.User == "Felipe" && wea.Pass == "123")
            {
                return RedirectToAction("Index", "Home");
            }
            else
            {
               
                return RedirectToAction("Index", "Login", new { error = "Usuario no existe o la contraseña es incorrecta" });
            }
        }
    }


    public class DataUser
    {
        public string User { get; set; }
        public string Pass { get; set; }
    }
}