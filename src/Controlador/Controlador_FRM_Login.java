
package Controlador;


import Modelo.ConexionBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Modelo.Metodos_Login;
import Vista.FRM_Login;


public class Controlador_FRM_Login implements ActionListener{
    
    FRM_Login login;
    Metodos_Login solucion;
    int archivoElegido=0;
    public Controlador_FRM_Login(FRM_Login login,Metodos_Login metodosLogin, ConexionBD conexion)
    {
        this.login=login;
        solucion=metodosLogin;
        this.login.setVisible(true);
        
        if(archivoElegido==1){
        if(solucion.verificarExistenciaDeArchivoDeUsuarios())
        {
            login.hacerLogin();
        }
        else
        {
            login.noHacerLogin();
        }
        }
    }
    public void actionPerformed(ActionEvent event)
    {
        if(event.getActionCommand().equals("Login"))
        {
            buscar();
             
           
        }
    }
    public void buscar()
    {
        if(solucion.buscarUsuarioEnElArray(login.getJTUsuario(),login.getJTPassword()))
        {
            login.loginPositivo();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "¡Usuario o Contraseña Incorrecto!");
        }
    }
    public int setTipoDeArchivo(int tipoArchivoElegido){
     this.archivoElegido=tipoArchivoElegido;
     return archivoElegido;
 }
    public void habilitarLogin(){
        this.login.setVisible(true);
    }
}
