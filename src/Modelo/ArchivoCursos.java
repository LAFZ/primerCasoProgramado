/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Hogar
 */
public class ArchivoCursos {
    ObjectOutputStream archivoSalidaCurso;
    ObjectInputStream archivoEntradaCurso;

    public ArchivoCursos() {
        if(cargarArchivoCurso()){
            System.out.println("Se cargo el archivo curso de forma correcta");
        }else{
            System.out.println("Error al cargar el archivo.");
        }
    }
    public boolean cargarArchivoCurso(){
    boolean existe=false;
    try{
        this.archivoEntradaCurso=new ObjectInputStream(new FileInputStream("ArchivoCurso.dat"));
    }catch(Exception e){
        System.out.println(""+e);
    }
    return existe;
    }
    public void crearArchivoCurso(){
        try{
            this.archivoSalidaCurso=new ObjectOutputStream(new FileOutputStream("ArchivoCurso.dat"));
            System.out.println("Se creo el archivo curso de forma correcta.");
        }catch(Exception e){
            System.out.println("Error al crear el archivo curso");
        }
    }
    public void ingresarInformacionAlArchivoCurso(Curso curso){
        
        try{
            this.archivoSalidaCurso.writeObject(curso);
            System.out.println("Se ingreso informacion al archivo curso");
        }catch(Exception e){
            System.out.println("Error al ingresar informacion al archivo curso"+e);
        }
    }
    public ArrayList<Curso> devolverInformacionDelArchivoCurso(){
        ArrayList<Curso> array=new ArrayList<Curso>();
        try{
            while(true){
                array.add((Curso)this.archivoEntradaCurso.readObject());
            }
        }catch(Exception e){
            System.out.println("Se llego al final del archivo curso"+e);
        }
        return array;
    }
}
