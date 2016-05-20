
package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ArchivoEstudiantes {
    ObjectOutputStream archivoSalidaEstudiantes;
    ObjectInputStream archivoEntradaEstudiantes;

    public ArchivoEstudiantes() {
        if(cargarArchivoEstudiantes()){
            System.out.println("Se cargo el archivo estudiantes de forma correcta");
        }else{
            System.out.println("Error al cargar el archivo.");
        }
    }
    public boolean cargarArchivoEstudiantes(){
    boolean existe=false;
    try{
        this.archivoEntradaEstudiantes=new ObjectInputStream(new FileInputStream("ArchivoEstudiantes.dat"));
    }catch(Exception e){
        System.out.println(""+e);
    }
    return existe;
    }
    public void crearArchivoEstudiantes(){
        try{
            this.archivoSalidaEstudiantes=new ObjectOutputStream(new FileOutputStream("ArchivoEstudiantes.dat"));
            System.out.println("Se creo el archivo estudiantes de forma correcta.");
        }catch(Exception e){
            System.out.println("Error al crear el archivo estudiantes");
        }
    }
    public void ingresarInformacionAlArchivoEstudiantes(Estudiantes estudiante){
        
        try{
            this.archivoSalidaEstudiantes.writeObject(estudiante);
            System.out.println("Se ingreso informacion al archivo estudiantes");
        }catch(Exception e){
            System.out.println("Error al ingresar informacion al archivo estudiantes"+e);
        }
    }
    public ArrayList<Estudiantes> devolverInformacionDelArchivoEstudiantes(){
        ArrayList<Estudiantes> array=new ArrayList<Estudiantes>();
        try{
            while(true){
                array.add((Estudiantes)this.archivoEntradaEstudiantes.readObject());
            }
        }catch(Exception e){
            System.out.println("Se llego al final del archivo estudiantes"+e);
        }
        return array;
    }
}
