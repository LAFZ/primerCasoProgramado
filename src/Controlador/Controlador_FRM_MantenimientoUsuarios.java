/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBD;
import Vista.FRM_MantenimientoUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Hogar
 */
public class Controlador_FRM_MantenimientoUsuarios implements ActionListener{
    FRM_MantenimientoUsuarios mantenimientoUsuarios;
    ConexionBD conexion;
    int archivoElegido=0;
    public Controlador_FRM_MantenimientoUsuarios(FRM_MantenimientoUsuarios mantenimientoUsuarios, ConexionBD conexion) {
        this.mantenimientoUsuarios = mantenimientoUsuarios;
        this.conexion = conexion;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Consultar")){
            buscar();
            System.out.println("Consultar");
        }
        if(e.getActionCommand().equals("Agregar")){
            System.out.println("Agregar");
            this.conexion.registrarUsuario(mantenimientoUsuarios.devolverInformacion());
            this.mantenimientoUsuarios.limpiar();
            this.mantenimientoUsuarios.estadoInicial();
        }
        if(e.getActionCommand().equals("Modificar")){
            this.conexion.actualizarUsuario(this.mantenimientoUsuarios.devolverIDUsuario(),this.mantenimientoUsuarios.devolverPassword(),this.mantenimientoUsuarios.devolverNombre(),this.mantenimientoUsuarios.devolverApellidos());
            this.mantenimientoUsuarios.limpiar();
            System.out.println("Modificar");
            this.mantenimientoUsuarios.limpiar();
            this.mantenimientoUsuarios.estadoInicial();
        }
        if(e.getActionCommand().equals("Eliminar")){
            this.conexion.eliminarUsuario(this.mantenimientoUsuarios.devolverIDUsuario());
            System.out.println("Eliminar");
            this.mantenimientoUsuarios.limpiar();
            this.mantenimientoUsuarios.estadoInicial();
        }
    }
    
     public void buscar(){
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
}
