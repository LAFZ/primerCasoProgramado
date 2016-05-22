/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivosUsuarios;
import Modelo.ConexionBD;
import Modelo.MetodosUsuarios;
import Modelo.Usuarios;
import Vista.FRM_MantenimientoUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Hogar
 */
public class Controlador_FRM_MantenimientoUsuarios implements ActionListener{
    FRM_MantenimientoUsuarios mantenimientoUsuarios;
    ConexionBD conexion;
    MetodosUsuarios metodosUsuarios;
    ArchivosUsuarios archivoUsuarios;
    public int archivoElegido=0;
    public Controlador_FRM_MantenimientoUsuarios(FRM_MantenimientoUsuarios mantenimientoUsuarios, ConexionBD conexion, MetodosUsuarios metodosUsuarios, ArchivosUsuarios archivoUsuarios) {
        this.archivoUsuarios = archivoUsuarios;
        this.mantenimientoUsuarios = mantenimientoUsuarios;
        this.conexion = conexion;
        this.metodosUsuarios= metodosUsuarios;
       
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
            
            System.out.println("Consultar");
        }
        if(e.getActionCommand().equals("Agregar")){
            System.out.println("Agregar");
           
            if(archivoElegido==1){
                this.metodosUsuarios.agregarUsuario(this.mantenimientoUsuarios.devolverInformacion());
                this.metodosUsuarios.mostrarInformacionUsuarios();
                this.mantenimientoUsuarios.limpiar();
                this.mantenimientoUsuarios.estadoInicial();
                
            }else
            if(archivoElegido==2){
                 this.conexion.registrarUsuario(mantenimientoUsuarios.devolverInformacion());
            this.mantenimientoUsuarios.limpiar();
            this.mantenimientoUsuarios.estadoInicial();
            }else
            if(archivoElegido==3){
                //buscarXML();
            }
           
        }
        if(e.getActionCommand().equals("Modificar")){
            
            if(archivoElegido==1){
                this.metodosUsuarios.modificarUsuario(this.mantenimientoUsuarios.devolverIDUsuario(), this.mantenimientoUsuarios.devolverPassword(),this.mantenimientoUsuarios.devolverNombre(),this.mantenimientoUsuarios.devolverApellidos());
                this.mantenimientoUsuarios.limpiar();
                this.mantenimientoUsuarios.estadoInicial();
            }else
            if(archivoElegido==2){
                this.conexion.actualizarUsuario(this.mantenimientoUsuarios.devolverIDUsuario(),this.mantenimientoUsuarios.devolverPassword(),this.mantenimientoUsuarios.devolverNombre(),this.mantenimientoUsuarios.devolverApellidos());
            this.mantenimientoUsuarios.limpiar();
            System.out.println("Modificar");
            this.mantenimientoUsuarios.limpiar();
            this.mantenimientoUsuarios.estadoInicial();
            }else
            if(archivoElegido==3){
                //buscarXML();
            }
            
        }
        if(e.getActionCommand().equals("Eliminar")){
            
            if(archivoElegido==1){
               this.metodosUsuarios.eliminarUsuario(this.mantenimientoUsuarios.devolverIDUsuario());
                this.mantenimientoUsuarios.limpiar();
                this.mantenimientoUsuarios.estadoInicial();
            }else
            if(archivoElegido==2){
                this.conexion.eliminarUsuario(this.mantenimientoUsuarios.devolverIDUsuario());
            System.out.println("Eliminar");
            this.mantenimientoUsuarios.limpiar();
            this.mantenimientoUsuarios.estadoInicial();
            }else
            if(archivoElegido==3){
                //buscarXML();
            }
            
        }
    }
    //////////////////////////////////////Metodo para buscar usuarios en Archivos Planos//////////////////////////////////////
    public void buscarEnArchivosPlanos(){
        if(metodosUsuarios.consultarUsuario(this.mantenimientoUsuarios.devolverIDUsuario())){
            this.mantenimientoUsuarios.mostrarInformacion(metodosUsuarios.getArregloInformacion());
            this.mantenimientoUsuarios.habilitarOpciones();
            this.mantenimientoUsuarios.deshabilitarSigla();
            this.mantenimientoUsuarios.mostrarMensaje("El usuario con el carnet: "+this.mantenimientoUsuarios.devolverIDUsuario()+" se encuentra registrado");
        }
        else{
            mantenimientoUsuarios.mostrarMensaje("El usuario con este carnet "+this.mantenimientoUsuarios.devolverIDUsuario()+" no existe");
            this.mantenimientoUsuarios.habilitarAgregar();
        }
    }
    public void escribirInformacionEnElArchivoUsuarios(){
        if(archivoElegido==1){
            this.archivoUsuarios.crearArchivosUsuarios();
            ArrayList<Usuarios> arrayTemporal=this.metodosUsuarios.getArray();
            for(int i=0;i<arrayTemporal.size();i++){
                this.archivoUsuarios.ingresarInformacionAlArchivosUsuarios(arrayTemporal.get(i));
        }
      }
    }
    //////////////////////////////////////Metodo para buscar usuarios en base de datos//////////////////////////////////////
    
     public void buscarBD(){
         if(conexion.consultarUsuario(this.mantenimientoUsuarios.devolverIDUsuario())){
            this.mantenimientoUsuarios.mostrarInformacion(conexion.getArregloInformacionUsuario());
            this.mantenimientoUsuarios.habilitarOpciones();
            this.mantenimientoUsuarios.deshabilitarSigla();
            this.mantenimientoUsuarios.mostrarMensaje("El Usuario con nombre de usuario: "+this.mantenimientoUsuarios.devolverIDUsuario()+" se encuentra registrado");
        }
        else{
            this.mantenimientoUsuarios.mostrarMensaje("El curso consultado con nombre de usuario: "+this.mantenimientoUsuarios.devolverIDUsuario()+" no esta registrado.");
            this.mantenimientoUsuarios.habilitarAgregar();
        }
     }
     public int setTipoDeArchivo(int tipoArchivoElegido){
     this.archivoElegido=tipoArchivoElegido;
     
     return archivoElegido;
 }
///////////////////////////////////////////////////////////////////////////////////////////////////
     public void buscarXML(){
     
     
     }
}
