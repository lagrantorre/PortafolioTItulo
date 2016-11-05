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
    public partial class vEditarTipoUsuario : Window
    {
        public vEditarTipoUsuario()
        {
            InitializeComponent();
        }

        private void btnCerrar_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }
    }
}
