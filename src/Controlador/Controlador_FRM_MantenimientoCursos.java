
package Controlador;


import Modelo.ArchivoCursos;
import Modelo.ConexionBD;
import Modelo.Curso;
import Modelo.MetodosCursos;
import Vista.FRM_MantenimientoCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Controlador_FRM_MantenimientoCursos implements ActionListener{
    ConexionBD conexion;
    FRM_MantenimientoCursos mantenimientoCursos;
    public int archivoElegido=0;
    public MetodosCursos metodos;
    ArchivoCursos archivoCursos;

public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos mantenimientoCursos, ConexionBD conexion)
{
    this.mantenimientoCursos=mantenimientoCursos;
     this.conexion=conexion;
     metodos=new MetodosCursos();
    archivoCursos=new ArchivoCursos();
    this.archivoCursos.cargarArchivoCurso();
    metodos.setArray(this.archivoCursos.devolverInformacionDelArchivoCurso());
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Consultar")){
            System.out.println("Consultar");
            if(archivoElegido==1){
                buscarEnArchivosPlanos();
            }else
            if(archivoElegido==2){
                buscarBD();
            }else
            if(archivoElegido==3){
                buscarXML();
            }
        }
        if(e.getActionCommand().equals("Agregar")){
            System.out.println("Agregar");
            if(archivoElegido==1){
                this.metodos.agregarCurso(mantenimientoCursos.devolverInformacion());
                metodos.mostrarInformacionCursos();
                this.mantenimientoCursos.limpiar();
                this.mantenimientoCursos.estadoInicial();
            }else
            if(archivoElegido==2){
                this.conexion.registrarCurso(mantenimientoCursos.devolverInformacion());
                this.mantenimientoCursos.limpiar();
                this.mantenimientoCursos.estadoInicial();
            }else
            if(archivoElegido==3){
                buscarXML();
            }
            
        }
        if(e.getActionCommand().equals("Modificar")){
             if(archivoElegido==1){
                this.metodos.modificarCurso(this.mantenimientoCursos.devolverSigla(),this.mantenimientoCursos.devolverNombre(),Integer.parseInt(this.mantenimientoCursos.devolverCreditos()),this.mantenimientoCursos.devolverHorario());
                this.mantenimientoCursos.limpiar();
                this.mantenimientoCursos.limpiar();
                this.mantenimientoCursos.estadoInicial();
            }else
            if(archivoElegido==2){
                this.conexion.actualizarCurso(this.mantenimientoCursos.devolverSigla(),this.mantenimientoCursos.devolverNombre(),Integer.parseInt(this.mantenimientoCursos.devolverCreditos()),this.mantenimientoCursos.devolverHorario());
                this.mantenimientoCursos.limpiar();
                System.out.println("Modificar");
                this.mantenimientoCursos.limpiar();
                this.mantenimientoCursos.estadoInicial();
            }else
            if(archivoElegido==3){
                buscarXML();
            }
            
        }
        if(e.getActionCommand().equals("Eliminar")){
             if(archivoElegido==1){
                this.metodos.eliminarCurso(this.mantenimientoCursos.devolverSigla());
                this.mantenimientoCursos.limpiar();
                this.mantenimientoCursos.estadoInicial();
            }else
            if(archivoElegido==2){
                this.conexion.eliminarCurso(this.mantenimientoCursos.devolverSigla());
                this.mantenimientoCursos.limpiar();
                this.mantenimientoCursos.estadoInicial();
            }else
            if(archivoElegido==3){
                buscarXML();
            }
            
        }
    }
    //////////////////////////////////////Metodo para buscar estudiantes en Archivos Planos//////////////////////////////////////
    public void buscarEnArchivosPlanos(){
        if(metodos.consultarCurso(this.mantenimientoCursos.devolverSigla())){
            this.mantenimientoCursos.mostrarInformacion(metodos.getArregloInformacion());
            this.mantenimientoCursos.habilitarOpciones();
            this.mantenimientoCursos.deshabilitarSigla();
            this.mantenimientoCursos.mostrarMensaje("El curso con las siglas: "+this.mantenimientoCursos.devolverSigla()+" se encuentra registrado");
        }
        else{
            this.mantenimientoCursos.mostrarMensaje("El curso consultado con las siglas: "+this.mantenimientoCursos.devolverSigla()+" no esta registrado.");
            this.mantenimientoCursos.habilitarAgregar();
        }
    }
    public void escribirInformacionEnElArchivoCursos(){
        
        this.archivoCursos.crearArchivoCurso();
        ArrayList<Curso> arrayTemporal=this.metodos.getArray();
        for(int i=0;i<arrayTemporal.size();i++){
        this.archivoCursos.ingresarInformacionAlArchivoCurso(arrayTemporal.get(i));
        }
    }
    //////////////////////////////////////Metodo para buscar cursos en base de datos/////////////////////////////////////////////
    public void buscarBD(){
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
    //////////////////////////////////////Metodo para buscar estudiantes en XML///////////////////////////////////////////////////
   public void buscarXML(){
   
   }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int setTipoDeArchivo(int tipoArchivoElegido){
     this.archivoElegido=tipoArchivoElegido;
     return archivoElegido;
 }
}
