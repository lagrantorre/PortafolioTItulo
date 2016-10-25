using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AppWeb_FrutosFrescos.Models
{
    public class Bodega
    {
        public int bod_id { get; set; }
        public string bod_nombre { get; set; }
        public string bod_direccion { get; set; }
        public string bod_geo_data { get; set; }
        public string bod_geo_tipo { get; set; }
        public char bod_vigente { get; set; }
        public int usuario_us_rut { get; set; }
    }
}