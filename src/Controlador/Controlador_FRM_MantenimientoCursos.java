
package Controlador;


import Modelo.ConexionBD;
import Modelo.Curso;
import Vista.FRM_MantenimientoCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Controlador_FRM_MantenimientoCursos implements ActionListener{
    ConexionBD conexion;
    FRM_MantenimientoCursos mantenimientoCursos;
    int archivoElegido=0;

public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos mantenimientoCursos, ConexionBD conexion)
{
    this.mantenimientoCursos=mantenimientoCursos;
     this.conexion=conexion;
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Consultar")){
            buscar();
            System.out.println("Consultar");
        }
        if(e.getActionCommand().equals("Agregar")){
            System.out.println("Agregar");
            this.conexion.registrarCurso(mantenimientoCursos.devolverInformacion());
            this.mantenimientoCursos.limpiar();
            this.mantenimientoCursos.estadoInicial();
        }
        if(e.getActionCommand().equals("Modificar")){
            this.conexion.actualizarCurso(this.mantenimientoCursos.devolverSigla(),this.mantenimientoCursos.devolverNombre(),Integer.parseInt(this.mantenimientoCursos.devolverCreditos()),this.mantenimientoCursos.devolverHorario());
            this.mantenimientoCursos.limpiar();
            System.out.println("Modificar");
            this.mantenimientoCursos.limpiar();
            this.mantenimientoCursos.estadoInicial();
        }
        if(e.getActionCommand().equals("Eliminar")){
            this.conexion.eliminarCurso(this.mantenimientoCursos.devolverSigla());
            System.out.println("Eliminar");
            this.mantenimientoCursos.limpiar();
            this.mantenimientoCursos.estadoInicial();
        }
    }
    public void buscar(){
        System.out.println("aqui entro"+this.mantenimientoCursos.devolverSigla());
        
        if(conexion.consultarCurso(this.mantenimientoCursos.devolverSigla())){
            this.mantenimientoCursos.mostrarInformacion(conexion.getArregloInformacionCurso());
            this.mantenimientoCursos.habilitarOpciones();
            this.mantenimientoCursos.deshabilitarSigla();
            this.mantenimientoCursos.mostrarMensaje("El curso con las siglas: "+this.mantenimientoCursos.devolverSigla()+" se encuentra registrado");
        }
        else{
            this.mantenimientoCursos.mostrarMensaje("El curso consultado con las siglas: "+this.mantenimientoCursos.devolverSigla()+" no esta registrado.");
            this.mantenimientoCursos.habilitarAgregar();
        }
    }
    public int setTipoDeArchivo(int tipoArchivoElegido){
     this.archivoElegido=tipoArchivoElegido;
     return archivoElegido;
 }
}
