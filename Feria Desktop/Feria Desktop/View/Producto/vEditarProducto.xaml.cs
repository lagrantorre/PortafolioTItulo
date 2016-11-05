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
    public partial class vEditarProducto : Window
    {
        public vEditarProducto(string titulo)
        {
            InitializeComponent();
            lblTitulo.Content = titulo;
        }

        public vEditarProducto(string titulo, ProductoClass productoEdit)
        {
            InitializeComponent();
            lblTitulo.Content = titulo;

            txbNombre.Text = productoEdit.pr_nombre;
            cmbTipoProd.SelectedValue = productoEdit.tipo_prod_tip_id;
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
