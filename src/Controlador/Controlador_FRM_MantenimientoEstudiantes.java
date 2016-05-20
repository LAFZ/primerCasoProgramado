
package Controlador;


import Modelo.ConexionBD;
import Modelo.Estudiantes;

import Vista.FRM_MantenimientoEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener {
    ConexionBD conexion;
    FRM_MantenimientoEstudiantes mantenimientoEstudiantes;
    int archivoElegido=0;
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes mantenimientoEstudiantes, ConexionBD conexion)
    {
        this.mantenimientoEstudiantes=mantenimientoEstudiantes;
        this.conexion=conexion;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Consultar")){
            buscar();        
            //this.mantenimientoEstudiantes.estadoInicial();
        }
        if(e.getActionCommand().equals("Agregar")){
        System.out.println("Agregar");
        this.conexion.registrarEstudiante(this.mantenimientoEstudiantes.devolverInformacion());
        this.mantenimientoEstudiantes.limpiar();
        this.mantenimientoEstudiantes.estadoInicial();
        }
        if(e.getActionCommand().equals("Modificar")){
            this.conexion.actualizarEstudiante(this.mantenimientoEstudiantes.devolverCedula(), this.mantenimientoEstudiantes.devolverNombre(), this.mantenimientoEstudiantes.devolverDireccion());
            this.mantenimientoEstudiantes.limpiar();
            this.mantenimientoEstudiantes.estadoInicial();
        System.out.println("Modificar");
        }
        if(e.getActionCommand().equals("Eliminar")){
            this.conexion.eliminarEstudiante(this.mantenimientoEstudiantes.devolverCedula());
            this.mantenimientoEstudiantes.limpiar();
            this.mantenimientoEstudiantes.estadoInicial();
        System.out.println("Eliminar");
        }
    }
    
    public void buscar(){
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
    public int setTipoDeArchivo(int tipoArchivoElegido){
     this.archivoElegido=tipoArchivoElegido;
     return archivoElegido;
 }
}
