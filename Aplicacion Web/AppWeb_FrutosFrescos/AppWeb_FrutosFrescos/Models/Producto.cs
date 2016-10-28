using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AppWeb_FrutosFrescos.Models
{
    public class Producto
    {
        public int id { get; set; }
        public string nombre { get; set; }
        public int tipo { get; set; }
        public Tipo_Prod oTipoProd { get; set; }


        //public List<Producto> GetLista()
        //{
        //    var a = new List<Producto>();

        //    a.Add(new Producto { pr_id = 1, pr_nombre = "Manzana", tip_id = 1 });
        //    a.Add(new Producto { pr_id = 2, pr_nombre = "Arándano", tip_id = 1});
        //    a.Add(new Producto { pr_id = 3, pr_nombre = "Durazno", tip_id = 1});
        //    a.Add(new Producto { pr_id = 4, pr_nombre = "Kiwi", tip_id = 1});
        //    a.Add(new Producto { pr_id = 5, pr_nombre = "Calafate", tip_id = 1});
        //    a.Add(new Producto { pr_id = 6, pr_nombre = "Guinda", tip_id = 1});
        //    a.Add(new Producto { pr_id = 7, pr_nombre = "Lechuga", tip_id = 2});
        //    a.Add(new Producto { pr_id = 8, pr_nombre = "Tomate", tip_id = 2});
        //    a.Add(new Producto { pr_id = 9, pr_nombre = "Zanahoria", tip_id = 2});
        //    a.Add(new Producto { pr_id = 10, pr_nombre = "Acelga", tip_id = 2});
        //    a.Add(new Producto { pr_id = 11, pr_nombre = "Choclo", tip_id = 2});

        //    return a;
        //}
    }
    
}