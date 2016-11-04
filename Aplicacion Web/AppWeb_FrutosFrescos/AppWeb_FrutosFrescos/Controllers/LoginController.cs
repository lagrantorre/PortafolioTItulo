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

            Usuario dataUser;

            wsFrutosClient ws = new wsFrutosClient();
            
                dataUser = JsonConvert.DeserializeObject<Usuario>(ws.Login(Int32.Parse(data.User), data.Pass));
                
            

            if (dataUser != null)
            {
                Session["usuario"] = dataUser;                

                return RedirectToAction("Index", "Home");
            }
            else
            {
               
                return RedirectToAction("Index", "Login", new { error = "Usuario no existe o la contraseña es incorrecta" });
            }
        }

        [HttpPost]
        public ActionResult CrearCuenta(Usuario user)
        {
            return RedirectToAction("Index", "Home");
        }
    }


    public class DataUser
    {
        public string User { get; set; }
        public string Pass { get; set; }
    }
}