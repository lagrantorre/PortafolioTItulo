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
    public partial class vEditarUsuario : Window
    {
        public vEditarUsuario(string titulo)
        {
            InitializeComponent();
            lblTitulo.Content = titulo;
        }

        public vEditarUsuario(string titulo, UsuarioClass usuarioEdit)
        {
            InitializeComponent();
            lblTitulo.Content = titulo;

            txbRut.Text = usuarioEdit.us_rut.ToString();
            txbDigito.Text = usuarioEdit.us_dv.ToString();
            txbEmail.Text = usuarioEdit.us_email.ToString();
            txbGeoData.Text = usuarioEdit.us_geo_data.ToString();
            txbGeoTipo.Text = usuarioEdit.us_geo_tipo.ToString();
            txbNombre.Text = usuarioEdit.us_nombre;
            cmbTipoUsu.SelectedValue = usuarioEdit.tipo_usuario_tip_id;
        }


        private void btnCerrar_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void btnGrabar_Click(object sender, RoutedEventArgs e)
        {
            //mandar los datos al servicio
        }
    }
}
