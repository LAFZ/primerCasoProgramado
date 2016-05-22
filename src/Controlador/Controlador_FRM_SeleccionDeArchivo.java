
package Controlador;



import Modelo.ConexionBD;
import Modelo.Metodos_Login;
import Modelo.Metodos_XML_Usuario;
import Vista.FRM_Login;
import Vista.FRM_MenuPrincipal;
import Vista.FRM_SeleccionDeArchivo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador_FRM_SeleccionDeArchivo implements ActionListener{
    FRM_SeleccionDeArchivo frm_SeleccionDeArchivo;
    public int tipoDeArchivo=0;
    private boolean eligioArchivo=false;
    private Controlador_FRM_MenuPrincipal controlador_FRM_MenuPrincipal;
   private FRM_MenuPrincipal menuPrincipal;
   private FRM_Login login;
   
    public Controlador_FRM_SeleccionDeArchivo(FRM_SeleccionDeArchivo frm_SeleccionDeArchivo, FRM_Login login,
           Controlador_FRM_MenuPrincipal controlador_FRM_MenuPrincipal,FRM_MenuPrincipal menuPrincipal,  Metodos_Login metodosLogin, ConexionBD conexion,
            Metodos_XML_Usuario metodos_XML_Usuario) {
       this.controlador_FRM_MenuPrincipal = controlador_FRM_MenuPrincipal;
       this.frm_SeleccionDeArchivo = frm_SeleccionDeArchivo;
       this.menuPrincipal = menuPrincipal;
       this.login = login;
       //this.login = new FRM_Login(menuPrincipal, metodosLogin, conexion, this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("ArchivosPlanos")){
            
            this.frm_SeleccionDeArchivo.habilitarContinuar();
            this.tipoDeArchivo=1;
        }
        if(e.getActionCommand().equals("BaseDeDatos")){
            this.frm_SeleccionDeArchivo.habilitarContinuar();
            this.tipoDeArchivo=2;
        }
        if(e.getActionCommand().equals("XML")){
            this.frm_SeleccionDeArchivo.habilitarContinuar();
            this.tipoDeArchivo=3;
        }
        if(e.getActionCommand().equals("Continuar")){
            System.out.println("entro evento");
           // controlador_FRM_MenuPrincipal.METODO SET DE CONTROLADOR PRINCIPAL()
            this.controlador_FRM_MenuPrincipal.setTipoDeArchivo(tipoDeArchivo);
            if(tipoDeArchivo==1){
                System.out.println("login : "+login);
                this.login.controlador.login();
            }else
            if(tipoDeArchivo==2){
                
            if(controlador_FRM_MenuPrincipal.verificarUsuarioBD()){
                this.login.controlador.login();
            }else{
            menuPrincipal.setVisible(true);
            }
            }else
            if(tipoDeArchivo==3){
                this.login.controlador.login();
            }else{
                this.menuPrincipal.setVisible(true);
            }
            frm_SeleccionDeArchivo.setVisible(false);
            
            System.out.println(""+tipoDeArchivo);
        }
    }
    public int devolverTipoDeArchivo(){
        this.login.controlador.setTipoDeArchivo(tipoDeArchivo);
        return this.tipoDeArchivo;
    }
    public boolean eligioArchivo(){
        eligioArchivo=true;
        return eligioArchivo;
    }
}
