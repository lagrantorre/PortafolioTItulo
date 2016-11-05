using Feria_Desktop.Model;
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
using System.Windows.Shapes;

namespace Feria_Desktop.View.Usuario
{
    /// <summary>
    /// Lógica de interacción para vEditarUsuario.xaml
    /// </summary>
    public partial class vEditarTipoProducto : Window
    {
        public vEditarTipoProducto(string titulo)
        {
            InitializeComponent();
            lblTitulo.Content = titulo;
        }

        public vEditarTipoProducto(string titulo, TipoProductoClass tipProdEdit)
        {
            InitializeComponent();
            lblTitulo.Content = titulo;

            txbNombre.Text = tipProdEdit.tip_nombre;
        }

        private void btnCerrar_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void btnGrabar_Click(object sender, RoutedEventArgs e)
        {
            //mandar datos al servicio
        }

    }
}
