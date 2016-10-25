using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AppWeb_FrutosFrescos.Models
{
    public class Tipo_Prod
    {
        public int tip_id { get; set; }
        public string tip_nombre { get; set; }
        public List<Producto> LstProd { get; set; }


        public List<Tipo_Prod> GetLista()
        {
            var a = new List<Tipo_Prod>();

            a.Add(new Tipo_Prod { tip_id=  1, tip_nombre = "Fruta" });
            a.Add(new Tipo_Prod { tip_id= 2, tip_nombre = "Hortaliza", });


            return a;
        }

    }
}