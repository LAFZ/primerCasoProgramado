
package Controlador;


import Modelo.ConexionBD;
import Modelo.MetodosUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Modelo.Metodos_Login;
import Modelo.Metodos_XML_Usuario;
import Vista.FRM_Login;
import Vista.FRM_MenuPrincipal;


public class Controlador_FRM_Login implements ActionListener{
    
    FRM_Login login;
    Metodos_Login solucion;
    Controlador_FRM_SeleccionDeArchivo seleccionArchivos;
    FRM_MenuPrincipal menuPrincipal;
    MetodosUsuarios metodosUsuarios;
    Metodos_XML_Usuario metodos_XML_Usuario;
    public int archivoElegido=0;
    ConexionBD conexion;
   
    public Controlador_FRM_Login(FRM_Login login,Metodos_Login metodosLogin, ConexionBD conexion, FRM_MenuPrincipal menuPrincipal, Metodos_XML_Usuario metodos_XML_Usuario)//ola k ase
    {
        this.menuPrincipal=menuPrincipal;
        this.login=login;
        this.conexion=conexion;
        solucion=metodosLogin;
        this.metodos_XML_Usuario=metodos_XML_Usuario;
        //this.login.setVisible(true);
                    
    }
    
    
    
    public void actionPerformed(ActionEvent event)
    {
        if(event.getActionCommand().equals("Login"))
            System.out.println("Login: "+archivoElegido);
            if(archivoElegido==1){
                if(this.solucion.consultarUsuarioLogin(this.login.getJTUsuario(),this.login.getJTPassword())==true){
                    
                this.menuPrincipal.setVisible(true);
             }
            }else
            if(archivoElegido==2){
              if(this.conexion.consultarUsuarioLogin(this.login.getJTUsuario(),this.login.getJTPassword())==true){
                  this.menuPrincipal.setVisible(true);
                  this.login.hide();
            }
            }else
            if(archivoElegido==3){
                if(this.metodos_XML_Usuario.consultarLoginEnXml(this.login.getJTUsuario(),this.login.getJTPassword())==true){
                    this.menuPrincipal.setVisible(true);
                    this.login.hide();
                }
            }
        }
    
    public void login()
    {
        
        if(archivoElegido==1){
            System.out.println("Aqui entro");
            
            if(this.solucion.verificarExistenciaDeArchivoDeUsuarios()){
                if(this.solucion.devolverTamanoDelArchivo()!=0){
                     System.out.println("Aqui entro 3");
                    this.login.setVisible(true);
                  }else{
                    System.out.println("Aqui entro 4");
                   this.menuPrincipal.setVisible(true);
                }
              }else{
                   this.menuPrincipal.setVisible(true);
            }
            }else
        if(archivoElegido==2){
            System.out.println("Aqui entro 2");
            if(this.conexion.verificarUsuarioBD()){
                System.out.println("Aqui entro 3");
                this.login.setVisible(true);
            }else{
                this.menuPrincipal.setVisible(true);
            }
        }
        if(archivoElegido==3){
            System.out.println("Busco en XML");
            if(this.metodos_XML_Usuario.verificarInformacionExisteneEnXml()==true){
                this.login.setVisible(true);
            }else{
                this.menuPrincipal.setVisible(true);
            }
        }
        
        
    }
    
    public void habilitarLogin(){
        this.login.setVisible(true);
    }
      public int setTipoDeArchivo(int tipoArchivoElegido){
     this.archivoElegido=tipoArchivoElegido;
     return archivoElegido;
 }
}
