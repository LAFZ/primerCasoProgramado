/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBD;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_MantenimientoMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Hogar
 */
public class Controlador_FRM_MantenimientoMatricula implements ActionListener{
    FRM_MantenimientoMatricula frm_Matricula;
    ConexionBD conexion;
    boolean encontroEstudiante=false;
    boolean encontroCurso=false;
    int archivoElegido=0;
    public Controlador_FRM_MantenimientoMatricula(FRM_MantenimientoEstudiantes frm_Matricula, FRM_MantenimientoCursos mantenimientoCursos, FRM_MantenimientoMatricula frm_mantenimientoMatricula, ConexionBD conexion){
        this.conexion=conexion;
        this.frm_Matricula=frm_mantenimientoMatricula;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("ConsultaRapidaEstudiante")){
            System.out.println("Estudiante");
            if(this.conexion.consultarEstudiante(this.frm_Matricula.devolverCarnet())){
                String arreglo[]=this.conexion.getArregloInformacionEstudiante();
                frm_Matricula.mostrarNombreEstudiante(arreglo[0]);
                encontroEstudiante=true;
            }else{
                frm_Matricula.mostrarMensaje("El estudiante consultado no se encuentra,\n favor dirigirse al modulo mantenimiento estudiantes");
            }
        }
        if(e.getActionCommand().equals("ConsultaRapidaCurso")){
            System.out.println("Curso");
            if( this.conexion.consultarCurso(this.frm_Matricula.devolverSigla())){
                String arreglo[]=this.conexion.getArregloInformacionCurso();
                this.frm_Matricula.mostrarNombreCurso(arreglo[0]);
                encontroCurso=true;
            }else{
                frm_Matricula.mostrarMensaje("El curso consultado no se encuentra,\n favor dirigirse al modulo mantenimiento curso");
            }
        }
       if(e.getActionCommand().equals("Agregar")){
            System.out.println("Agregar");
            frm_Matricula.cargarTabla();
            encontroCurso=false;
            frm_Matricula.estadoInicial();
            frm_Matricula.limpiarCurso();
            frm_Matricula.limpiarEstudiante();
            colocarCodigo();
            
       } 
       if(e.getActionCommand().equals("Finalizar")){
            System.out.println("Finalizar");
            for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++){
                this.conexion.registrarMatricula(frm_Matricula.getInformacionTabla(contador));
            }
            
            this.frm_Matricula.resetearInterfaz();
       }
       if(e.getActionCommand().equals("Consultar")){
           buscar();
       }
       if(encontroEstudiante&&encontroCurso){
           frm_Matricula.habilitarAgregar();
       }
       if(e.getActionCommand().equals("Modificar")){
            this.conexion.actualizarMatricula(this.frm_Matricula.devolverCodigo(),this.frm_Matricula.devolverCarnet(), this.frm_Matricula.devolverSigla());
            //this.frm_Matricula.limpiar();
            this.frm_Matricula.estadoInicial();
        System.out.println("Modificar");
        }
        if(e.getActionCommand().equals("Eliminar")){
            this.conexion.eliminarMatricula(this.frm_Matricula.devolverCodigo());
            //this.frm_Matricula.limpiar();
            this.frm_Matricula.estadoInicial();
        System.out.println("Eliminar");
        }
    }
    public String colocarCodigo(){
        return this.conexion.devolverCodigo();
    }
    
    public void buscar(){
        
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
    
//    public String colocarCodigo(){
//        return conexion.devolverCodigo();
//    }
public int setTipoDeArchivo(int tipoArchivoElegido){
     this.archivoElegido=tipoArchivoElegido;
     System.out.println("Tipo de archivo para la matricula "+tipoArchivoElegido);
     return archivoElegido;
 }
}
