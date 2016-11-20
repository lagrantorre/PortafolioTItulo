using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AppWeb_FrutosFrescos.Models
{
    public class Carrito
    {
        public int cantidad { get; set; }
        public int idProducto { get; set; }
        public int total { get; set; }
        public int idProductor { get; set; }
        public int idDetalle { get; set; }
        public int idVenta { get; set; }
        public int idStock { get; set; }
        public string nombreProducto { get; set; }
    }
}