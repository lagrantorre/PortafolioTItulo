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

namespace Feria_Desktop.View.Mantenedor
{
    /// <summary>
    /// Lógica de interacción para PTipoProducto.xaml
    /// </summary>
    public partial class TipoProducto : Page
    {
        public List<TipoProductoClass> dgTipoProductosData;
        private vEditarTipoProducto modEditarTipoProducto;

        public TipoProducto()
        {
            InitializeComponent();
        }

        private void btnNuevo_Click(object sender, RoutedEventArgs e)
        {
            modEditarTipoProducto = new vEditarTipoProducto("Nuevo Tipo Producto");
            modEditarTipoProducto.ShowDialog();
        }

        private void btnEditar_Click(object sender, RoutedEventArgs e)
        {
            if (dgTipoProductos.SelectedIndex < 0) return;

            TipoProductoClass tipoProd = dgTipoProductosData[dgTipoProductos.SelectedIndex];

            modEditarTipoProducto = new vEditarTipoProducto("Editar Tipo Producto", tipoProd);
            modEditarTipoProducto.ShowDialog();
        }
    }
}
