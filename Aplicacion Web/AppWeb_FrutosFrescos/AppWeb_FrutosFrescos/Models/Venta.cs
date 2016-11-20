using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AppWeb_FrutosFrescos.Models
{
    public class Venta
    {
        public int id { get; set; }
        public int total { get; set; }
        public int rutVende { get; set; }
        public int rutCompra { get; set; }
        public int estado { get; set; }
        public List<DetalleVenta> lstDetalle { get; set; }
    }

    public class DetalleVenta
    {
        public int id { get; set; }
        public int cantidad { get; set; }
        public int total { get; set; }
        public int stockId { get; set; }
        public int prodId { get; set; }
        public string prodNombre { get; set; }
        public int ventaId { get; set; }
        public Venta oVentas { get; set; }
    }
}