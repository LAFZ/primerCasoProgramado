/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author user
 */
public class ArchivosUsuarios {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    public ArchivosUsuarios()
    {
        if(verificarExistenciaDeArchivoDeUsuarios()==true){
            cargarArchivo();
        }else
        {
            crearArchivo();
        }
    }
    public void cargarArchivo()
    {
        try{
        archivoEntrada=new ObjectInputStream(new FileInputStream("usuarios.dat"));
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar el archivo de Usuarios: "+e);
        }
    }
    public boolean verificarExistenciaDeArchivoDeUsuarios()
    {
        boolean existeArchivo=true;
        try{
        archivoEntrada=new ObjectInputStream(new FileInputStream("usuarios.dat"));
        }
        catch(Exception e)
        {
            existeArchivo=false;
            System.out.println("Error al cargar el archivo de Usuarios: "+e);
        }
            
        return existeArchivo;
    }
        
    public void crearArchivo()
    {
        try{
            archivoSalida=new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
        }
        catch(Exception e)
        {
            System.out.println("Error al crear el archivo de Usuarios: "+e);   
        } 
    }
    public void escribirInformacionEnArchivo(Usuarios usuario)
    {
        try
        {
            archivoSalida.writeObject(usuario);
        }
        catch(Exception e)
        {
             System.out.println("Error al escribir en el archivo de Usuarios: "+e);
        }
    }
    public Usuarios[] devolverInformacionDelArchivoComoArreglo()
    {
        int tamano=devolverTamanoDelArchivo();
        Usuarios arregloUsuarioss[]=new Usuarios[tamano];
        try
        {
            archivoEntrada=new ObjectInputStream(new FileInputStream("usuarios.dat"));
            for(int contador=0;contador<tamano;contador++)
            {
                arregloUsuarioss[contador]=(Usuarios)archivoEntrada.readObject();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error devolver información del archivo de Usuarios como un arreglo: "+e);
        }  
        return arregloUsuarioss;
    }
    public int devolverTamanoDelArchivo()
    {
        int contador=0;
        Usuarios temporal;
        try
        {
            archivoEntrada=new ObjectInputStream(new FileInputStream("usuarios.dat"));
            while(true)
            {
              temporal=(Usuarios)archivoEntrada.readObject();
              contador++;
            }
        }
        catch(EOFException e)
        {
         System.out.println("Fin del archivo Usuarios: "+e);        
        }
        catch(Exception e)
        {
         System.out.println("Error al devolver el tamaño del archivo de Usuarios: "+e);        
        }
        return contador;
    }
    
}
