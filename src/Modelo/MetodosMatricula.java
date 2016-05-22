/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Hogar
 */
public class MetodosMatricula {
    ArrayList<Matricula>arrayMatricula;
    String arregloInformacion[];
    ArchivoMatricula archivoMatricula;
    public MetodosMatricula(ArchivoMatricula archivoMatricula)
    {
        this.archivoMatricula=archivoMatricula;
        arrayMatricula=new ArrayList <Matricula>();
    }
    public void agregarMatricula(String informacion[]){
        Matricula temporal=new Matricula(informacion[0],informacion[1], informacion[2]);
        this.arrayMatricula.add(temporal);
    }
    public void mostrarInformacionMatricula(){
        for(int i=0;i<arrayMatricula.size();i++){
            System.out.println(arrayMatricula.get(i).getInformacion());
//        Matricula temporal;
//        temporal=arrayMatricula.get(0);
//        System.out.println(temporal.getInformacion());
        }
    }
    public boolean consultarMatricula(int codigo)
    {
        boolean itemEncontrado=false;
        System.out.println("Entro consultar matricula");
        for(int i=0;i<arrayMatricula.size();i++)
        {
            System.out.println("Entro al for consultar matricula");
            if(this.arrayMatricula.get(i).getCodigo().equals(codigo)){
            arregloInformacion[0]=arrayMatricula.get(i).getCedula();
            arregloInformacion[1]=arrayMatricula.get(i).getSigla();
            itemEncontrado=true;
            }     
        }
        return itemEncontrado;
    }
    public void modificarMatricula(int codigo, String carnet, String sigla){
        
        for(int i=0;i<arrayMatricula.size();i++){
                if(this.arrayMatricula.get(i).getCodigo().equals(codigo)){
                this.arrayMatricula.get(i).setSigla(sigla);
                this.arrayMatricula.get(i).setCedula(carnet);
                }
        }
    
    }
    public boolean consultarMatriculaEnArchivo(int codigo){
        System.out.println("Metodos consultar matricula: "+codigo);    
         boolean itemEncontrado=false;
         if(this.archivoMatricula.consultarMatricula(codigo)==true){
            itemEncontrado=true;
        }
         return itemEncontrado;
        }
    
    public void eliminarMatricula (int  codigo)
    {
        for(int i=0;i<arrayMatricula.size();i++){
                if(this.arrayMatricula.get(i).getCodigo().equals(codigo)){
                arrayMatricula.remove(i);
                }
        }
    }
    public String[] getArregloInformacion(){
        return arregloInformacion;
        
    }
    public ArrayList<Matricula> getArray(){
        return this.arrayMatricula;
    }
    
    public void setArray(ArrayList<Matricula> matricula){
        this.arrayMatricula=matricula;
    }
    public String devolverCodigo()
    {
        String codigo="0000";
        if(this.arrayMatricula.size()==0){
            codigo="0001";
        }
        else{
            for(int contador=0;contador<arrayMatricula.size();contador++){
                if(this.arrayMatricula.get(contador)!=null){
                    codigo=this.arrayMatricula.get(contador).getCodigo();
                }
            }
            int numero=Integer.parseInt(codigo);
            numero++;
            codigo=""+numero;
        }
        return codigo;
    }
}
