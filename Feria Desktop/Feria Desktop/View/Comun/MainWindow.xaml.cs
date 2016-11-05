using Feria_Desktop.View.Comun;
using Feria_Desktop.View.Mantenedor;
using Feria_Desktop.View.Producto;
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

namespace Feria_Desktop
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void btnInicio_Click(object sender, RoutedEventArgs e)
        {
            FramePrincipal.Navigate(new Inicio());
        }

        private void btnProductos_Click(object sender, RoutedEventArgs e)
        {
            FramePrincipal.Navigate(new ListadoProductos());
        }

        private void btnUsuarios_Click(object sender, RoutedEventArgs e)
        {
            FramePrincipal.Navigate(new ListadoUsuarios());
        }

        private void btnManTipoProd_Click(object sender, RoutedEventArgs e)
        {
            FramePrincipal.Navigate(new TipoProducto());
        }

        private void btnManTipoUsu_Click(object sender, RoutedEventArgs e)
        {
            FramePrincipal.Navigate(new TipoUsuario());
        }

        private void btnManBodega_Click(object sender, RoutedEventArgs e)
        {
            FramePrincipal.Navigate(new Bodega());
        }
    }
}
