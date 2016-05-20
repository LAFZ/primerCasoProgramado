
package Controlador;


import Modelo.ArchivoEstudiantes;
import Modelo.ConexionBD;
import Modelo.Estudiantes;
import Modelo.MetodosEstudiantes;

import Vista.FRM_MantenimientoEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener {
    public MetodosEstudiantes metodos;
    
    ArchivoEstudiantes archivoEstudiantes;
    ConexionBD conexion;
    FRM_MantenimientoEstudiantes mantenimientoEstudiantes;
    public int archivoElegido=0;
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes mantenimientoEstudiantes, ConexionBD conexion)
    {
        this.mantenimientoEstudiantes=mantenimientoEstudiantes;
        this.conexion=conexion;
        metodos=new MetodosEstudiantes();
        archivoEstudiantes= new ArchivoEstudiantes();
        this.metodos.setArray(this.archivoEstudiantes.devolverInformacionDelArchivoEstudiantes());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Consultar")){
            if(archivoElegido==1){
                buscarEnArchivosPlanos();
            }else
            if(archivoElegido==2){
                buscarBD();
            }else
            if(archivoElegido==3){
                buscarXML();
            }
                 
            
            //this.mantenimientoEstudiantes.estadoInicial();
        }
        if(e.getActionCommand().equals("Agregar")){
        System.out.println("Agregar");
        if(archivoElegido==1){
               this.metodos.agregarEstudiante(this.mantenimientoEstudiantes.devolverInformacion());
               this.metodos.mostrarInformacionEstudiantes();
               this.mantenimientoEstudiantes.limpiar();
               this.mantenimientoEstudiantes.estadoInicial();
            }else
            if(archivoElegido==2){
                this.conexion.registrarEstudiante(this.mantenimientoEstudiantes.devolverInformacion());
                this.mantenimientoEstudiantes.limpiar();
                this.mantenimientoEstudiantes.estadoInicial();
            }else
            if(archivoElegido==3){
                buscarXML();
            }
        
        }
        if(e.getActionCommand().equals("Modificar")){
        System.out.println("Modificar");
        if(archivoElegido==1){
                this.metodos.modificarEstudiante(this.mantenimientoEstudiantes.devolverCedula(), this.mantenimientoEstudiantes.devolverNombre(),this.mantenimientoEstudiantes.devolverDireccion());
                this.mantenimientoEstudiantes.limpiar();
                this.mantenimientoEstudiantes.estadoInicial();
            }else
            if(archivoElegido==2){
                 this.conexion.actualizarEstudiante(this.mantenimientoEstudiantes.devolverCedula(), this.mantenimientoEstudiantes.devolverNombre(), this.mantenimientoEstudiantes.devolverDireccion());
                 this.mantenimientoEstudiantes.limpiar();
                 this.mantenimientoEstudiantes.estadoInicial();
            }else
            if(archivoElegido==3){
                buscarXML();
            }
        }
        if(e.getActionCommand().equals("Eliminar")){
            System.out.println("Eliminar");
        if(archivoElegido==1){
                this.metodos.eliminarEstudiante(this.mantenimientoEstudiantes.devolverCedula());
                this.mantenimientoEstudiantes.limpiar();
                this.mantenimientoEstudiantes.estadoInicial();
            }else
            if(archivoElegido==2){
                this.conexion.eliminarEstudiante(this.mantenimientoEstudiantes.devolverCedula());
                this.mantenimientoEstudiantes.limpiar();
                this.mantenimientoEstudiantes.estadoInicial();
            }else
            if(archivoElegido==3){
                buscarXML();
            }
        }
    }
    //////////////////////////////////////Metodo para buscar estudiantes en Archivos Planos//////////////////////////////////////
    public void buscarEnArchivosPlanos(){
        if(metodos.consultarEstudiante(this.mantenimientoEstudiantes.devolverCedula())){
            this.mantenimientoEstudiantes.mostrarInformacion(metodos.getArregloInformacion());
            this.mantenimientoEstudiantes.habilitarOpciones();
            this.mantenimientoEstudiantes.deshabilitarCedula();
            this.mantenimientoEstudiantes.mostrarMensaje("El estudiante con el carnet: "+this.mantenimientoEstudiantes.devolverCedula()+" se encuentra registrado");
        }
        else{
            mantenimientoEstudiantes.mostrarMensaje("El estudiante con este carnet "+this.mantenimientoEstudiantes.devolverCedula()+" no existe");
            this.mantenimientoEstudiantes.habilitarAgregar();
        }
    }
    public void escribirInformacionEnElArchivoEstudiantes(){
        this.archivoEstudiantes.crearArchivoEstudiantes();
        ArrayList<Estudiantes> arrayTemporal=this.metodos.getArray();
        for(int i=0;i<arrayTemporal.size();i++){
            this.archivoEstudiantes.ingresarInformacionAlArchivoEstudiantes(arrayTemporal.get(i));
        }
    }
    //////////////////////////////////////Metodo para buscar estudiantes en base de datos//////////////////////////////////////
    public void buscarBD(){
        System.out.println("aqui buscar "+this.mantenimientoEstudiantes.devolverCedula());
        if(this.conexion.consultarEstudiante(this.mantenimientoEstudiantes.devolverCedula())==true){
            System.out.println("aqui buscar 2 "+this.mantenimientoEstudiantes.devolverCedula());
            this.mantenimientoEstudiantes.mostrarInformacion(this.conexion.getArregloInformacionEstudiante());
            this.mantenimientoEstudiantes.habilitarOpciones();
            this.mantenimientoEstudiantes.deshabilitarCedula();
            this.mantenimientoEstudiantes.mostrarMensaje("El estudiante con el carnet: "+this.mantenimientoEstudiantes.devolverCedula()+" se encuentra registrado");
        }
        else{
            mantenimientoEstudiantes.mostrarMensaje("El estudiante con este carnet "+this.mantenimientoEstudiantes.devolverCedula()+" no existe");
            this.mantenimientoEstudiantes.habilitarAgregar();
        }
    }
    //////////////////////////////////////Metodo para buscar estudiantes en XML//////////////////////////////////////
    public void buscarXML(){
    
    }
    public int setTipoDeArchivo(int tipoArchivoElegido){
     this.archivoElegido=tipoArchivoElegido;
     return archivoElegido;
 }
}
