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

namespace Feria_Desktop.View.Comun
{
    /// <summary>
    /// Lógica de interacción para Login.xaml
    /// </summary>
    public partial class Login : Window
    {
        public Login()
        {
            InitializeComponent();
            txb_usuario.Focus();
        }

        private void btn_entrar_Click(object sender, RoutedEventArgs e)
        {
            MainWindow inicio = new MainWindow();
            if (txb_usuario.Text.Length == 0)
            {
                blq_error.Text = "Debe ingresar un usuario";
                txb_usuario.Focus();
            }
            else
            {
                /*Verificar retorno de WS
                 * si es valido logear
                 * si no, pasar a siguienta paso
                 */

                string usuario = txb_usuario.Text;
                string password = txb_password.Password;

               /* Llamada a servicio de login
                * wsTaller.TallerWSClient consumWS = new wsTaller.TallerWSClient();
                string returnString;
                returnString = consumWS.loginUsuario(usuario, password);*/
                string returnString = "1";

                if (!returnString.Equals("0"))
                {
                    //string username = "usuario prueba";
                    // inicio. TextBlockName.Text = "Bienvenido " + usuario;//Texto de bienvenida.
                    inicio.Show();
                    Close();
                }
                else
                {
                    blq_error.Text = "Usuario no valido";
                }
            }
        }
    }
}
