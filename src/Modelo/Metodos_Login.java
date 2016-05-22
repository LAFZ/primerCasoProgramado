package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Metodos_Login {
    
    ArrayList <Usuarios> array;
    
    
    String nombreUsuario="";
    String apellidos="";
    String nombres="";
    String password="";
    
    ArchivosUsuarios archivosUsuarios;
    MetodosUsuarios metodosUsuarios;
    public Metodos_Login(MetodosUsuarios metodosUsuarios, ArchivosUsuarios archivosUsuarios) {
        
       array = new ArrayList <Usuarios>();
       this.archivosUsuarios= archivosUsuarios;       
       //cargarArchivoAlArray();
       this.metodosUsuarios=metodosUsuarios;
    }
    public boolean verificarExistenciaDeArchivoDeUsuarios()
    {
       return archivosUsuarios.verificarExistenciaDeArchivoDeUsuarios();
    }
    public int devolverTamanoDelArchivo(){
        int cantidad=0;
        if(this.archivosUsuarios.devolverTamanoDelArchivo()!=0){
            cantidad=1;
        }
            return cantidad;
    }
    
        public boolean consultarUsuarioLogin(String nombreUsuario, String password){
        System.out.println("Metodos Login: "+nombreUsuario+" "+password);    
         boolean itemEncontrado=false;
         if(this.archivosUsuarios.consultarUsuarioLogin(nombreUsuario, password)==true){
            itemEncontrado=true;
        }
         return itemEncontrado;
        }
    }
