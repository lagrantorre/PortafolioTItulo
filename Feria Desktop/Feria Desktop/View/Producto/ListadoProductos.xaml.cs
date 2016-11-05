using Feria_Desktop.Model;
using Feria_Desktop.View.Usuario;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Feria_Desktop.View.Producto
{
    /// <summary>
    /// Lógica de interacción para ListadoProductos.xaml
    /// </summary>
    public partial class ListadoProductos : Page
    {
        public List<ProductoClass> dgProductosData;
        private vEditarProducto modEditarProducto;

        public ListadoProductos()
        {
            InitializeComponent();
        }

        private void btnNuevo_Click(object sender, RoutedEventArgs e)
        {
            modEditarProducto = new vEditarProducto("Nuevo Producto");
            modEditarProducto.ShowDialog();
        }

        private void btnEditar_Click(object sender, RoutedEventArgs e)
        {
            if (dgProductos.SelectedIndex < 0) return;

            ProductoClass productoFila = dgProductosData[dgProductos.SelectedIndex];

            modEditarProducto = new vEditarProducto("Editar Producto", productoFila);
            modEditarProducto.ShowDialog();
        }
    }
}
