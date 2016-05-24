package Controlador;

import Modelo.ArchivoCursos;
import Modelo.ConexionBD;
import Modelo.Curso;
import Modelo.MetodosCursos;
import Modelo.Metodos_XML_Cursos;
import Vista.FRM_MantenimientoCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Controlador_FRM_MantenimientoCursos implements ActionListener {

    ConexionBD conexion;
    Metodos_XML_Cursos metodos_XML_Cursos;
    FRM_MantenimientoCursos mantenimientoCursos;
    public int archivoElegido = 0;
    public MetodosCursos metodos;
    ArchivoCursos archivoCursos;

    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos mantenimientoCursos, ConexionBD conexion) {
        this.mantenimientoCursos = mantenimientoCursos;
        metodos_XML_Cursos = new Metodos_XML_Cursos(mantenimientoCursos);
        this.conexion = conexion;
        metodos = new MetodosCursos();
        archivoCursos = new ArchivoCursos();
        this.archivoCursos.cargarArchivoCurso();
        metodos.setArray(this.archivoCursos.devolverInformacionDelArchivoCurso());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Consultar")) {

            if (archivoElegido == 1) {
                buscarEnArchivosPlanos();
            } else if (archivoElegido == 2) {
                buscarBD();
            } else if (archivoElegido == 3) {
                buscarXML();
            }
        }
        if (e.getActionCommand().equals("Agregar")) {

            if (archivoElegido == 1) {
                this.metodos.agregarCurso(mantenimientoCursos.devolverInformacion());
                metodos.mostrarInformacionCursos();
                this.mantenimientoCursos.limpiar();
                this.mantenimientoCursos.estadoInicial();
            } else if (archivoElegido == 2) {
                this.conexion.registrarCurso(mantenimientoCursos.devolverInformacion());
                this.mantenimientoCursos.limpiar();
                this.mantenimientoCursos.estadoInicial();
            } else if (archivoElegido == 3) {
                metodos_XML_Cursos.guardarEnXML(mantenimientoCursos.devolverInformacion());
                mantenimientoCursos.mostrarMensaje("Información agregada al archivo XML de forma correcta.");
                mantenimientoCursos.limpiar();
                mantenimientoCursos.estadoInicial();
            }

        }
        if (e.getActionCommand().equals("Modificar")) {
            if (archivoElegido == 1) {
                this.metodos.modificarCurso(this.mantenimientoCursos.devolverSigla(), this.mantenimientoCursos.devolverNombre(), Integer.parseInt(this.mantenimientoCursos.devolverCreditos()), this.mantenimientoCursos.devolverHorario());
                this.mantenimientoCursos.limpiar();
                this.mantenimientoCursos.limpiar();
                this.mantenimientoCursos.estadoInicial();
            } else if (archivoElegido == 2) {
                this.conexion.actualizarCurso(this.mantenimientoCursos.devolverSigla(), this.mantenimientoCursos.devolverNombre(), Integer.parseInt(this.mantenimientoCursos.devolverCreditos()), this.mantenimientoCursos.devolverHorario());
                this.mantenimientoCursos.limpiar();

                this.mantenimientoCursos.limpiar();
                this.mantenimientoCursos.estadoInicial();
            } else if (archivoElegido == 3) {
                metodos_XML_Cursos.modificarInformacionDelXml(mantenimientoCursos.devolverInformacion());
                mantenimientoCursos.mostrarMensaje("Información modificada en el archivo XML de forma correcta.");
                mantenimientoCursos.limpiar();
                mantenimientoCursos.estadoInicial();
            }

        }
        if (e.getActionCommand().equals("Eliminar")) {
            if (archivoElegido == 1) {
                this.metodos.eliminarCurso(this.mantenimientoCursos.devolverSigla());
                this.mantenimientoCursos.limpiar();
                this.mantenimientoCursos.estadoInicial();
            } else if (archivoElegido == 2) {
                this.conexion.eliminarCurso(this.mantenimientoCursos.devolverSigla());
                this.mantenimientoCursos.limpiar();
                this.mantenimientoCursos.estadoInicial();
            } else if (archivoElegido == 3) {
                metodos_XML_Cursos.eliminarInformacionDelXml(mantenimientoCursos.devolverSigla());
                mantenimientoCursos.mostrarMensaje("Información eliminada del archivo XML de forma correcta.");
                mantenimientoCursos.limpiar();
                mantenimientoCursos.estadoInicial();
            }

        }
    }

    //////////////////////////////////////Metodo para buscar estudiantes en Archivos Planos//////////////////////////////////////

    public void buscarEnArchivosPlanos() {
        if (metodos.consultarCurso(this.mantenimientoCursos.devolverSigla())) {
            this.mantenimientoCursos.mostrarInformacion(metodos.getArregloInformacion());
            this.mantenimientoCursos.habilitarOpciones();
            this.mantenimientoCursos.deshabilitarSigla();
            this.mantenimientoCursos.mostrarMensaje("El curso con las siglas: " + this.mantenimientoCursos.devolverSigla() + " se encuentra registrado");
        } else {
            this.mantenimientoCursos.mostrarMensaje("El curso consultado con las siglas: " + this.mantenimientoCursos.devolverSigla() + " no esta registrado.");
            this.mantenimientoCursos.habilitarAgregar();
        }
    }

    public void escribirInformacionEnElArchivoCursos() {

        this.archivoCursos.crearArchivoCurso();
        ArrayList<Curso> arrayTemporal = this.metodos.getArray();
        for (int i = 0; i < arrayTemporal.size(); i++) {
            this.archivoCursos.ingresarInformacionAlArchivoCurso(arrayTemporal.get(i));
        }
    }

    //////////////////////////////////////Metodo para buscar cursos en base de datos/////////////////////////////////////////////

    public void buscarBD() {

        if (conexion.consultarCurso(this.mantenimientoCursos.devolverSigla())) {
            this.mantenimientoCursos.mostrarInformacion(conexion.getArregloInformacionCurso());
            this.mantenimientoCursos.habilitarOpciones();
            this.mantenimientoCursos.deshabilitarSigla();
            this.mantenimientoCursos.mostrarMensaje("El curso con las siglas: " + this.mantenimientoCursos.devolverSigla() + " se encuentra registrado");
        } else {
            this.mantenimientoCursos.mostrarMensaje("El curso consultado con las siglas: " + this.mantenimientoCursos.devolverSigla() + " no esta registrado.");
            this.mantenimientoCursos.habilitarAgregar();
        }
    }

    //////////////////////////////////////Metodo para buscar estudiantes en XML///////////////////////////////////////////////////

    public void buscarXML() {
        if (metodos_XML_Cursos.consultarInformacionDelXml(mantenimientoCursos.devolverSigla())) {
            mantenimientoCursos.mostrarInformacion(metodos_XML_Cursos.getArregloInformacion());
            mantenimientoCursos.habilitarOpciones();

            mantenimientoCursos.mostrarMensaje("Información encontrada con la Sigla : " + mantenimientoCursos.devolverSigla());
        } else {
            mantenimientoCursos.mostrarMensaje("No se encontró información con la Sigla: " + mantenimientoCursos.devolverSigla());
            mantenimientoCursos.habilitarAgregar();
        }
        mantenimientoCursos.deshabilitarSigla();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public int setTipoDeArchivo(int tipoArchivoElegido) {
        this.archivoElegido = tipoArchivoElegido;
        return archivoElegido;
    }
}
