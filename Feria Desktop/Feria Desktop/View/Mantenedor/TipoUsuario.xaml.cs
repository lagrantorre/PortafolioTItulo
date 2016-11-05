﻿using Feria_Desktop.View.Usuario;
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
    /// Lógica de interacción para TipoUsuario.xaml
    /// </summary>
    public partial class TipoUsuario : Page
    {
        private vEditarTipoUsuario modEditarTipoUsuario;

        public TipoUsuario()
        {
            InitializeComponent();
        }

        private void btnNuevo_Click(object sender, RoutedEventArgs e)
        {
            modEditarTipoUsuario = new vEditarTipoUsuario();
            modEditarTipoUsuario.ShowDialog();
        }
    }
}
