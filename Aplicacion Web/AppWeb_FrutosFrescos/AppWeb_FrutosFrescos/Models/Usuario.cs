using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AppWeb_FrutosFrescos.Models
{
    public class Usuario
    {
        public int rut { get; set; }
        public char dv { get; set; }
        public string nombre { get; set; }
        public string email { get; set; }
        public string geoData { get; set; }
        public string geoTipo { get; set; }
        public string pass { get; set; }
        public string img { get; set; }
        public bool vigente { get; set; }
        public int tipo { get; set; }
    }
}