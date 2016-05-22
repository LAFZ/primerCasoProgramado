/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoMatricula;
import Modelo.ConexionBD;
import Modelo.Matricula;
import Modelo.MetodosCursos;
import Modelo.MetodosEstudiantes;
import Modelo.MetodosMatricula;
import Modelo.Usuarios;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_MantenimientoMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Hogar
 */
public class Controlador_FRM_MantenimientoMatricula implements ActionListener{
    FRM_MantenimientoMatricula frm_Matricula;
    ConexionBD conexion;
    ArchivoMatricula archivoMatricula;
    boolean encontroEstudiante=false;
    boolean encontroCurso=false;
    int archivoElegido=0;
    MetodosCursos metodosCursos;
    MetodosEstudiantes metodosEstudiantes;
    MetodosMatricula metodosMatricula;
    public Controlador_FRM_MantenimientoMatricula(FRM_MantenimientoEstudiantes mantenimientoEstudiantes, FRM_MantenimientoCursos mantenimientoCursos, FRM_MantenimientoMatricula frm_mantenimientoMatricula, ConexionBD conexion, ArchivoMatricula archivoMatricula){
        this.conexion=conexion;
        this.archivoMatricula=archivoMatricula;
        this.frm_Matricula=frm_mantenimientoMatricula;
        this.metodosCursos=mantenimientoCursos.controlador_FRM_MantenimientoCursos.metodos;
        this.metodosEstudiantes=mantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.metodos;
        metodosMatricula=new MetodosMatricula(archivoMatricula);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("ConsultaRapidaEstudiante")){
            System.out.println("Estudiante");
             if(archivoElegido==1){
                 
                 if(metodosEstudiantes.consultarEstudiante(this.frm_Matricula.devolverCarnet())){
                String arreglo[]=this.metodosEstudiantes.getArregloInformacion();
                frm_Matricula.mostrarNombreEstudiante(arreglo[0]);
                encontroEstudiante=true;
            }else{
                frm_Matricula.mostrarMensaje("El estudiante consultado no se encuentra,\n favor dirigirse al modulo mantenimiento estudiantes");
            }
            }else
            if(archivoElegido==2){
            if(this.conexion.consultarEstudiante(this.frm_Matricula.devolverCarnet())){
                String arreglo[]=this.conexion.getArregloInformacionEstudiante();
                frm_Matricula.mostrarNombreEstudiante(arreglo[0]);
                encontroEstudiante=true;
            }else{
                frm_Matricula.mostrarMensaje("El estudiante consultado no se encuentra,\n favor dirigirse al modulo mantenimiento estudiantes");
            }
            }else
            if(archivoElegido==3){
                //aqui va el metodo para traer la informacion del estudiante desde el xml
            }
            
        }
        if(e.getActionCommand().equals("ConsultaRapidaCurso")){
            System.out.println("Curso");
             if(archivoElegido==1){
                if( metodosCursos.consultarCurso(this.frm_Matricula.devolverSigla())){
                String arreglo[]=this.metodosCursos.getArregloInformacion();
                this.frm_Matricula.mostrarNombreCurso(arreglo[0]);
                encontroCurso=true;
            }else{
                frm_Matricula.mostrarMensaje("El curso consultado no se encuentra,\n favor dirigirse al modulo mantenimiento curso");
            }
            }else
            if(archivoElegido==2){
            if( this.conexion.consultarCurso(this.frm_Matricula.devolverSigla())){
                String arreglo[]=this.conexion.getArregloInformacionCurso();
                this.frm_Matricula.mostrarNombreCurso(arreglo[0]);
                encontroCurso=true;
            }else{
                frm_Matricula.mostrarMensaje("El curso consultado no se encuentra,\n favor dirigirse al modulo mantenimiento curso");
            }
            }else
            if(archivoElegido==3){
                //aqui va el metodo para traer la informacion del curso desde el xml
            }
            
        }
       if(e.getActionCommand().equals("Agregar")){
            System.out.println("Agregar");
             if(archivoElegido==1){
                frm_Matricula.cargarTabla();
                encontroCurso=false;
                frm_Matricula.estadoInicial();
                frm_Matricula.limpiarCurso();
                frm_Matricula.limpiarEstudiante();
            }else
            if(archivoElegido==2){
                frm_Matricula.cargarTabla();
                encontroCurso=false;    
                frm_Matricula.estadoInicial();
                frm_Matricula.limpiarCurso();
                frm_Matricula.limpiarEstudiante();
                colocarCodigo();
            }else
            if(archivoElegido==3){
                //aqui va el metodo para agregar la informacion en xml
            }
            
            
       } 
       if(e.getActionCommand().equals("Finalizar")){
            System.out.println("Finalizar");
             if(archivoElegido==1){
               for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++){
                this.metodosMatricula.agregarMatricula(frm_Matricula.getInformacionTabla(contador));
                //escribirInformacionEnElArchivoUsuarios();
            }
            metodosMatricula.mostrarInformacionMatricula();
            this.frm_Matricula.resetearInterfaz();
            }else
            if(archivoElegido==2){
                for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++){
                this.conexion.registrarMatricula(frm_Matricula.getInformacionTabla(contador));
            }
            
            this.frm_Matricula.resetearInterfaz();
            }else
            if(archivoElegido==3){
                //Metodo para accion del boton finalizar
            }
            
       }
       if(e.getActionCommand().equals("Consultar")){
            if(archivoElegido==1){
                this.metodosMatricula.consultarMatriculaEnArchivo(archivoElegido);
               buscarEnArchivosPlanos();
            }else
            if(archivoElegido==2){
                buscarBD();
            }else
            if(archivoElegido==3){
                // falta metodo buscarXML();
            }
       }
       if(encontroEstudiante&&encontroCurso){
           frm_Matricula.habilitarAgregar();
       }
       if(e.getActionCommand().equals("Modificar")){
           if(archivoElegido==1){
              this.metodosMatricula.modificarMatricula(this.frm_Matricula.devolverCodigo(),this.frm_Matricula.devolverCarnet(), this.frm_Matricula.devolverSigla());
              this.frm_Matricula.limpiarCurso();
              this.frm_Matricula.limpiarEstudiante();
              
           }else
            if(archivoElegido==2){
                this.conexion.actualizarMatricula(this.frm_Matricula.devolverCodigo(),this.frm_Matricula.devolverCarnet(), this.frm_Matricula.devolverSigla());
                //this.frm_Matricula.limpiar();
                this.frm_Matricula.estadoInicial();
            }else
            if(archivoElegido==3){
                // falta metodo modificarMatriculaXML();
            }
            
        System.out.println("Modificar");
        }
        if(e.getActionCommand().equals("Eliminar")){
            if(archivoElegido==1){
               this.metodosMatricula.eliminarMatricula(this.frm_Matricula.devolverCodigo());
               this.frm_Matricula.limpiarCurso();
               this.frm_Matricula.limpiarEstudiante();
               this.frm_Matricula.estadoInicial();
            }else
            if(archivoElegido==2){
                this.conexion.eliminarMatricula(this.frm_Matricula.devolverCodigo());
                //this.frm_Matricula.limpiar();
                this.frm_Matricula.estadoInicial();
            }else
            if(archivoElegido==3){
                // falta metodo eliminarMatriculaXML();
            }
            System.out.println("Eliminar");
        }
    }
    public String colocarCodigo(){
        return this.conexion.devolverCodigo();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void buscarEnArchivosPlanos(){
    if(metodosMatricula.consultarMatriculaEnArchivo(this.frm_Matricula.devolverCodigo())){
        this.frm_Matricula.mostrarInformacion(this.metodosMatricula.getArregloInformacion());
        this.frm_Matricula.habilitarOpciones();
        
        this.frm_Matricula.mostrarMensaje("la matricula con el codigo: "+this.frm_Matricula.devolverCodigo()+" se encuentra registrada");
    }else{
    this.frm_Matricula.mostrarMensaje("la matricula con el codigo: "+this.frm_Matricula.devolverCodigo()+" no se encuentra registrada");
    this.frm_Matricula.habilitarAgregar();
    }
    }
    public void escribirInformacionEnElArchivoUsuarios(){
        if(archivoElegido==1){
            this.archivoMatricula.crearArchivoMatricula();
            ArrayList<Matricula> arrayTemporal=this.metodosMatricula.getArray();
            for(int i=0;i<arrayTemporal.size();i++){
                this.archivoMatricula.ingresarInformacionAlArchivoMatricula(arrayTemporal.get(i));
        }
      }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////        
    public void buscarBD(){
        
        if(this.conexion.consultarMatricula(this.frm_Matricula.devolverCodigo())){
            System.out.println("aqui buscar 2 "+this.frm_Matricula.devolverCarnet());
            this.frm_Matricula.mostrarInformacion(this.conexion.getArregloInformacionMatricula());
            this.frm_Matricula.habilitarOpciones();
    ////////////////////////////////////////////////////////////////////////////////////////////////        
            if(this.conexion.consultarEstudiante(this.frm_Matricula.devolverCarnet())){
                String arreglo[]=this.conexion.getArregloInformacionEstudiante();
                frm_Matricula.mostrarNombreEstudiante(arreglo[0]);
                //encontroEstudiante=true;
            }else{
                frm_Matricula.mostrarMensaje("El estudiante consultado no se encuentra,\n favor dirigirse al modulo mantenimiento estudiantes");
            }
    ////////////////////////////////////////////////////////////////////////////////////////////////
             if( this.conexion.consultarCurso(this.frm_Matricula.devolverSigla())){
                String arreglo[]=this.conexion.getArregloInformacionCurso();
                this.frm_Matricula.mostrarNombreCurso(arreglo[0]);
                //encontroCurso=true;
            }else{
                frm_Matricula.mostrarMensaje("El curso consultado no se encuentra,\n favor dirigirse al modulo mantenimiento curso");
            }
    ////////////////////////////////////////////////////////////////////////////////////////////////       
             this.frm_Matricula.cargarTabla();
             
            this.frm_Matricula.mostrarMensaje("La matricula con este codigo: "+this.frm_Matricula.devolverCodigo()+" se encuentra registrado");
            
        }
        else{
            frm_Matricula.mostrarMensaje("La matricula con este codigo: "+this.frm_Matricula.devolverCodigo()+" no existe");
            this.frm_Matricula.habilitarAgregar();
        }
    }
    

public int setTipoDeArchivo(int tipoArchivoElegido){
     this.archivoElegido=tipoArchivoElegido;
     System.out.println("Tipo de archivo para la matricula "+tipoArchivoElegido);
     return archivoElegido;
 }
}
