
package Controlador;



import Modelo.ConexionBD;
import Modelo.Metodos_Login;
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
   
    public Controlador_FRM_SeleccionDeArchivo(FRM_SeleccionDeArchivo frm_SeleccionDeArchivo,  
           Controlador_FRM_MenuPrincipal controlador_FRM_MenuPrincipal,FRM_MenuPrincipal menuPrincipal,  Metodos_Login metodosLogin, ConexionBD conexion) {
       this.controlador_FRM_MenuPrincipal = controlador_FRM_MenuPrincipal;
        this.login = new FRM_Login(menuPrincipal, metodosLogin, conexion, this);
        this.frm_SeleccionDeArchivo = frm_SeleccionDeArchivo;
       this.menuPrincipal = menuPrincipal;
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
            if(tipoDeArchivo==2){
            if(controlador_FRM_MenuPrincipal.verificarUsuarioBD()){
            login.setVisible(true);
            }else{
            menuPrincipal.setVisible(true);
            }
            }
            frm_SeleccionDeArchivo.setVisible(false);
            
            System.out.println(""+tipoDeArchivo);
        }
    }
    public int devolverTipoDeArchivo(){
        return this.tipoDeArchivo;
    }
    public boolean eligioArchivo(){
        eligioArchivo=true;
        return eligioArchivo;
    }
}
