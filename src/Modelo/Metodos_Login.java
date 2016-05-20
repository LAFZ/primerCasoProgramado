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
    
    public Metodos_Login() {
        
       array = new ArrayList <Usuarios>();
       archivosUsuarios=new ArchivosUsuarios();       
       cargarArchivoAlArray();
    }
    public boolean verificarExistenciaDeArchivoDeUsuarios()
    {
       return archivosUsuarios.verificarExistenciaDeArchivoDeUsuarios();
    }
    public void escribirInformacionArchivo()
    {
        archivosUsuarios.crearArchivo();
        for(int contador=0;contador<array.size();contador++)
        {
            archivosUsuarios.escribirInformacionEnArchivo(array.get(contador));
        }
    }
    public void cargarArchivoAlArray()
    {
        Usuarios arregloUsuarios[ ]=archivosUsuarios.devolverInformacionDelArchivoComoArreglo();
        for(int contador=0;contador<arregloUsuarios.length;contador++)
        {
            array.add((Usuarios)arregloUsuarios[contador]);
        }
    }
    
    
    public void ingresarUsuarioAlArray(String nombreUsuario, String password, String nombres, String apellidos)
    {
        array.add(new Usuarios(nombreUsuario, password, nombres, apellidos));
        JOptionPane.showMessageDialog(null, "El usuario fué agregado de forma correcta.");
    }
    
    public void modificarUsuarioDelArray(String nombreUsuario, String password, String nombres, String apellidos)
    {
       for(int contador=0;contador<array.size();contador++)
       {
          if(array.get(contador).getNombreUsuario().equals(""+nombreUsuario))
          {
              array.get(contador).setNombres(nombres);
              array.get(contador).setApellidos(apellidos);
              array.get(contador).setPassword(password);
                       
              JOptionPane.showMessageDialog(null, "El usuario fué modificado de forma correcta");
          }
       } 
    } 
    public boolean buscarUsuarioEnElArray(String nombreUsuario, String password)       
    {
       boolean encontro=false;
       for(int contador=0;contador<array.size();contador++)
       {
          if(array.get(contador).getNombreUsuario().equals(""+nombreUsuario) && array.get(contador).getPassword().equals(""+password))
          {
              
              encontro=true;
          }
       } 
       if(encontro)
       {
           JOptionPane.showMessageDialog(null, "El usuario si está en el array");
           
           return true;
       }
       else
       {
           JOptionPane.showMessageDialog(null, "El usuario no está en el array");
           return false;
       }
    }
    public boolean consultarUsuarioEnElArray(String nombreUsuario)       
    {
       boolean encontro=false;
       for(int contador=0;contador<array.size();contador++)
       {
          if(array.get(contador).getNombreUsuario().equals(""+nombreUsuario))
          {
              this.password=array.get(contador).getPassword();
              this.nombres=array.get(contador).getNombres();
              this.apellidos=array.get(contador).getApellidos();
              encontro=true;
          }
       } 
       if(encontro)
       {
           JOptionPane.showMessageDialog(null, "El usuario si está en el array");
           
           return true;
       }
       else
       {
           JOptionPane.showMessageDialog(null, "El usuario no está en el array");
           return false;
       }
    }
    public void eliminarUsuarioDelArray(String nombreUsuario)
    {
        for(int contador=0;contador<array.size();contador++)
        {
          if(array.get(contador).getNombreUsuario().equals(""+nombreUsuario))
          {
              array.remove(contador);
              JOptionPane.showMessageDialog(null, "El usuario fué eliminado de forma correcta");
          }
        } 
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    
}
