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


    public class ProdUsuario
    {
        public int rut { get; set; }
        public string nombre { get; set; }
        public string geoData { get; set; }
        public List<StockProdUsuario> stock { get; set; }
    }

    public class StockProdUsuario
    {
        public int id { get; set; }
        public string kilos { get; set; }
        public string precios { get; set; }
        public int prId { get; set; }
        public int bodId { get; set; }
        public string nomProd { get; set; }
        public int tipoId { get; set; }
        public string nomTipo { get; set; }
    }

    public class Stock
    {
        public int id { get; set; }
        public int kilos { get; set; }
        public int precio { get; set; }
        public int pr_id { get; set; }
        public int bod_id { get; set; }
    }
        
}