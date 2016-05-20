
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
    Controlador_FRM_SeleccionDeArchivo seleccionArchivos;
   
    public Controlador_FRM_Login(FRM_Login login,Metodos_Login metodosLogin, ConexionBD conexion,Controlador_FRM_SeleccionDeArchivo seleccionArchivo)
    {
        this.login=login;
        solucion=metodosLogin;
        this.login.setVisible(true);
        seleccionArchivos = seleccionArchivo;
        
        
    }
    
    
    public void actionPerformed(ActionEvent event)
    {
        if(event.getActionCommand().equals("Login"))
        {
             login();
           
        }
    }
    public void login()
    {
        
        if(seleccionArchivos.devolverTipoDeArchivo()==1){
            System.out.println("Busco en Archivos");
        }
        if(seleccionArchivos.devolverTipoDeArchivo()==2){
          
            System.out.println("Busco en BD");
        }
        if(seleccionArchivos.devolverTipoDeArchivo()==3){
            System.out.println("Busco en XML");
        }
        
        
    }
    
    public void habilitarLogin(){
        this.login.setVisible(true);
    }
}
