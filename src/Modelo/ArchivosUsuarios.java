
package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;




public class ArchivosUsuarios {
    ObjectOutputStream archivoSalidaUsuarios;
    ObjectInputStream archivoEntradaUsuarios;
ArrayList <Usuarios> arrayUsuarios;
ArrayList<Usuarios> array;
    public ArchivosUsuarios() {
        array= new ArrayList<Usuarios>();
        arrayUsuarios=new ArrayList<Usuarios>();
        cargarArchivosUsuarios();
        devolverInformacionDelArchivosUsuarios();
    }
    public boolean cargarArchivosUsuarios(){
    boolean existe=false;
    try{
        this.archivoEntradaUsuarios=new ObjectInputStream(new FileInputStream("ArchivoUsuarios.dat"));
        System.out.println("se cargo el archivo ");
    }catch(Exception e){
        System.out.println("no se cargo el archivo "+e);
    }
    return existe;
    }
    public void crearArchivosUsuarios(){
        try{
            this.archivoSalidaUsuarios=new ObjectOutputStream(new FileOutputStream("ArchivoUsuarios.dat"));
            System.out.println("Se creo el archivo estudiantes de forma correcta.");
        }catch(Exception e){
            System.out.println("Error al crear el archivo usuarios");
        }
    }
    public void ingresarInformacionAlArchivosUsuarios(Usuarios estudiante){
        
        try{
            this.archivoSalidaUsuarios.writeObject(estudiante);
            System.out.println("Se ingreso informacion al archivo usuarios");
        }catch(Exception e){
            System.out.println("Error al ingresar informacion al archivo usuarios"+e);
        }
    }
    public ArrayList<Usuarios> devolverInformacionDelArchivosUsuarios(){
        //ArrayList<Usuarios> array=new ArrayList<Usuarios>();
        System.out.println(""+arrayUsuarios);
        try{
            while(true){
                array.add((Usuarios)this.archivoEntradaUsuarios.readObject());
            }
        }catch(Exception e){
            System.out.println("Se llego al final del archivo usuarios"+e);
        }
        return array;
    }
    public boolean consultarUsuarioLogin(String nombreUsuario, String password){
        arrayUsuarios = array;
        boolean itemEncontrado=false;
        System.out.println(""+arrayUsuarios);
        for(int i=0;i<arrayUsuarios.size();i++)
        {            
            System.out.println("entro al for");
            if(this.arrayUsuarios.get(i).getNombreUsuario().equals(nombreUsuario)&&this.arrayUsuarios.get(i).getPassword().equals(password)){
            System.out.println("encontro al usuario");
            itemEncontrado=true;
            }     
        }
        System.out.println("Metodos Usuario2: "+nombreUsuario+" "+password);   
        return itemEncontrado;
     }
    public int devolverTamanoDelArchivo()
    {
        int contador=0;
        Usuarios temporal;
        try
        {
            this.archivoEntradaUsuarios=new ObjectInputStream(new FileInputStream("ArchivoUsuarios.dat"));
            while(true)
            {
              temporal=(Usuarios)archivoEntradaUsuarios.readObject();
              contador++;
            }
        }
        catch(Exception e)
        {
         System.out.println("Fin del archivo Usuarios: "+e);        
        }
//      catch(EOFException e)
//        {
//         System.out.println("Error al devolver el tamaño del archivo de Usuarios: "+e);        
//        }
        return contador;
    }
    public boolean verificarExistenciaDeArchivoDeUsuarios()
    {
        boolean existeArchivo=true;
        try{
        archivoEntradaUsuarios=new ObjectInputStream(new FileInputStream("ArchivoUsuarios.dat"));
        System.out.println("Verifico ");
        }
        catch(Exception e)
        {
            existeArchivo=false;
            System.out.println("Error al cargar el archivo de Usuarios: "+e);
        }
            
        return existeArchivo;
    }
public Usuarios[] devolverInformacionDelArchivoComoArreglo()
    {
        int tamano=devolverTamanoDelArchivo();
        Usuarios arregloUsuarioss[]=new Usuarios[tamano];
        try
        {
            archivoEntradaUsuarios=new ObjectInputStream(new FileInputStream("ArchivoUsuarios.dat"));
            for(int contador=0;contador<tamano;contador++)
            {
                arregloUsuarioss[contador]=(Usuarios)archivoEntradaUsuarios.readObject();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error devolver información del archivo de Usuarios como un arreglo: "+e);
        }  
        return arregloUsuarioss;
    }
}
