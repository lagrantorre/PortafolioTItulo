/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import dao.daoUsuario;
import dto.Usuario;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
/**
 *
 * @author Robert
 */
public class Mail {
    String miCorreo;
    String miContraseña;
    String servidorSMTP = "smtp.gmail.com";
    String puertoEnvio = "587";
    String mailReceptor;
    String asunto;
    String cuerpo;

    public boolean recuperarMail(int rut) {
        Usuario dto = new daoUsuario().getUsuarioByRut(rut);
        if(dto.getEmail()!=null){
            String newpwd = new Cript().createPassword(9);
            new daoUsuario().updPass(rut, Cript.encriptaEnMD5(newpwd));
            this.miCorreo = "feriafrutosfrescos@gmail.com";
            this.miContraseña = "feriafrutos";
            this.mailReceptor = dto.getEmail();
            this.asunto = "Recuperación de contraseña";
            this.cuerpo = "Estimado: "+dto.getNombre()+"\n\n"+
                    "Según consta en nuestros registros ha solicitado la recuperación de su contraseña en nuestro sistema\n\n"+
                    "Se ha generado la siguiente contraseña provisoria: "+newpwd+"\n\n"+
                    "Por favor ingrese directamente su contraseña en el sistema e intente nuevamente. \n\n"+
                    "Equipo Feria Frutos Frescos";
            Properties props = new Properties();//propiedades a agragar
            props.put("mail.smtp.user", this.miCorreo);//correo origen
            props.put("mail.smtp.host", servidorSMTP);//tipo de servidor
            props.put("mail.smtp.port", puertoEnvio);//puesto de salida
            props.put("mail.smtp.starttls.enable", "true");//inicializar el servidor
            props.put("mail.smtp.debug", "true");
            props.put("mail.smtp.auth", "true");//autentificacion
            props.put("mail.smtp.socketFactory.port", puertoEnvio);//activar el puerto
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
            SecurityManager security = System.getSecurityManager();
            try {
                Authenticator auth = new autentificadorSMTP();//autentificar el correo
                Session session = Session.getInstance(props, auth);//se inica una session
                // session.setDebug(true);
                MimeMessage msg = new MimeMessage(session);//se crea un objeto donde ira la estructura del correo
                msg.setText(this.cuerpo);//seteo el cuertpo del mensaje
                msg.setSubject(this.asunto);//setea asusto (opcional)
                msg.setFrom(new InternetAddress(this.miCorreo));//agrega la la propiedad del correo origen
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(this.mailReceptor));//agrega el destinatario
                Transport.send(msg);//envia el mensaje
                System.out.println("pasa bien la wea'");
                return true;
//JOptionPane.showMessageDialog(null, "Email enviado");//alerta de que mensaje fue enviado correctamente
            } catch (Exception mex) {//en caso de que ocurra un error se crea una excepcion
                System.out.println("cae en catch");
                System.out.println(mex.getMessage());
                return false;
            //JOptionPane.showMessageDialog(null, "Email no enviado");//muestra con cuadro de dialogo un mensaje que correo no fue enviado
            }//fin try-catch
        }else{
            System.out.println("no existe");
            return false;
        }
    }//fin metodo enviaEmail
        private class autentificadorSMTP extends javax.mail.Authenticator {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(miCorreo, miContraseña);//autentifica tanto el correo como la contraseña
            }
        }
}
