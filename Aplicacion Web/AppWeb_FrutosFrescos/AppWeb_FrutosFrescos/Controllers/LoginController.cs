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

            bool result = ws.insUsuario(Int32.Parse(data.User), ushort.Parse(data.Dv), data.Nombre, data.Email, " ", " ", data.Pass, " ", true, 1);

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