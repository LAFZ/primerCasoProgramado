
package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ArchivoMatricula {
    ObjectOutputStream archivoSalidaMatricula;
    ObjectInputStream archivoEntradaMatricula;

    public ArchivoMatricula() {
        if(cargarArchivoMatricula()){
            System.out.println("Se cargo el archivo matricula de forma correcta");
        }else{
            System.out.println("Error al cargar el archivo.");
        }
    }
    public boolean cargarArchivoMatricula(){
    boolean existe=false;
    try{
        this.archivoEntradaMatricula=new ObjectInputStream(new FileInputStream("ArchivoMatricula.dat"));
    }catch(Exception e){
        System.out.println(""+e);
    }
    return existe;
    }
    public void crearArchivoMatricula(){
        try{
            this.archivoSalidaMatricula=new ObjectOutputStream(new FileOutputStream("ArchivoMatricula.dat"));
            System.out.println("Se creo el archivo matricula de forma correcta.");
        }catch(Exception e){
            System.out.println("Error al crear el archivo matricula");
        }
    }
    public void ingresarInformacionAlArchivoMatricula(Matricula matricula){
        
        try{
            this.archivoSalidaMatricula.writeObject(matricula);
            System.out.println("Se ingreso informacion al archivo matricula");
        }catch(Exception e){
            System.out.println("Error al ingresar informacion al archivo matricula"+e);
        }
    }
    public ArrayList<Matricula> devolverInformacionDelArchivoMatricula(){
        ArrayList<Matricula> array=new ArrayList<Matricula>();
        try{
            while(true){
                array.add((Matricula)this.archivoEntradaMatricula.readObject());
            }
        }catch(Exception e){
            System.out.println("Se llego al final del archivo matricula"+e);
        }
        return array;
    }
}
