using Feria_Desktop.Model;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
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

namespace Feria_Desktop.View.Usuario
{
    /// <summary>
    /// Lógica de interacción para ListadoUsuarios.xaml
    /// </summary>
    public partial class ListadoUsuarios : Page
    {
        public List<UsuarioClass> dgUsuariosData;
        private vEditarUsuario modEditarUsuarios;
        

        public ListadoUsuarios()
        {
            InitializeComponent();
            cargaInicial();
        }


        private void cargaInicial() 
        {
            var respuesta = new ObservableCollection<UsuarioClass>(); //Llamada a servicio
            /*string source = "{\r\n   \"id\": \"100000280905615\", \r\n \"name\": \"Jerard Jones\",  \r\n   \"first_name\": \"Jerard\", \r\n   \"last_name\": \"Jones\", \r\n   \"link\": \"https://www.facebook.com/Jerard.Jones\", \r\n   \"username\": \"Jerard.Jones\", \r\n   \"gender\": \"female\", \r\n   \"locale\": \"en_US\"\r\n}";
                dynamic data = JObject.Parse(source);
                Console.WriteLine(data.id);
                Console.WriteLine(data.first_name);  //Esto no va acá, es solo un apunte. Esto va en View model correspondiente
             */

            if (respuesta != null )
            {
                dgUsuariosData.AddRange(respuesta);
                
            }
        }

        private void btnNuevo_Click(object sender, RoutedEventArgs e)
        {
            modEditarUsuarios = new vEditarUsuario("Nuevo Usuario");
            modEditarUsuarios.ShowDialog();
        }

        private void btnEditar_Click(object sender, RoutedEventArgs e)
        {
            if (dgUsuarios.SelectedIndex < 0) return;
            
            UsuarioClass usuarioFila =  dgUsuariosData[dgUsuarios.SelectedIndex];

            modEditarUsuarios = new vEditarUsuario("Editar Usuario", usuarioFila);
            modEditarUsuarios.ShowDialog();
        }
    }
}
