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
    public MetodosMatricula()
    {
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
    public boolean consultarMatricula(String codigo)
    {
        boolean itemEncontrado=false;
        for(int i=0;i<arrayMatricula.size();i++)
        {
            if(this.arrayMatricula.get(i).getCodigo().equals(codigo)){
            arregloInformacion[0]=arrayMatricula.get(i).getCedula();
            arregloInformacion[1]=arrayMatricula.get(i).getSigla();
            itemEncontrado=true;
            }     
        }
        return itemEncontrado;
    }
    public void modificarMatricula(String codigo, String sigla){
        
        for(int i=0;i<arrayMatricula.size();i++){
                if(this.arrayMatricula.get(i).getCodigo().equals(codigo)){
                this.arrayMatricula.get(i).setSigla(sigla);
                }
        }
    }
    
    public void eliminarMatricula (String codigo)
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
