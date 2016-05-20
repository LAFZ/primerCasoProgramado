/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.Metodos_Login;
import Vista.FRM_Login;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_MantenimientoMatricula;
import Vista.FRM_MantenimientoUsuarios;
import Vista.FRM_MenuPrincipal;
import Vista.FRM_SeleccionDeArchivo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Hogar
 */
public class Controlador_FRM_MenuPrincipal implements ActionListener{
    FRM_MantenimientoEstudiantes mantenimientoEstudiantes;
    FRM_MantenimientoCursos mantenimientoCursos;
    FRM_MantenimientoMatricula mantenimientoMatricula;
    FRM_MantenimientoUsuarios mantenimientoUsuarios;
    FRM_Login login;
    FRM_SeleccionDeArchivo tipoDeArchivo;
    FRM_MenuPrincipal menuPrincipal;
    ConexionBD conexion;
    Metodos_Login metodosLogin;
    int archivoElegido=0;

public Controlador_FRM_MenuPrincipal(FRM_MenuPrincipal menuPrincipal){
this.conexion = new ConexionBD();
this.metodosLogin= new Metodos_Login();
this.mantenimientoEstudiantes=new FRM_MantenimientoEstudiantes(conexion);
this.mantenimientoCursos=new FRM_MantenimientoCursos(conexion);
this.mantenimientoMatricula=new FRM_MantenimientoMatricula(mantenimientoEstudiantes, mantenimientoCursos, conexion);

this.tipoDeArchivo=new FRM_SeleccionDeArchivo(this,menuPrincipal, metodosLogin, conexion);
this.mantenimientoUsuarios =new FRM_MantenimientoUsuarios( conexion);
this.tipoDeArchivo.setVisible(true);

}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Salir")){
        System.exit(0);
        }
        if(e.getActionCommand().equals("Estudiantes")){
            this.mantenimientoEstudiantes.setVisible(true);
            System.out.println("Presiono el menú Estudiantes");
        }
        if(e.getActionCommand().equals("Cursos")){
            this.mantenimientoCursos.setVisible(true);
            System.out.println("presiono el menú Cursos");
        }
        if(e.getActionCommand().equals("Matricula")){
            this.mantenimientoMatricula.setVisible(true);
            this.mantenimientoMatricula.colocarCodigo();
            System.out.println("presiono el menú Matricula");
        }
         if(e.getActionCommand().equals("Usuarios")){
            this.mantenimientoUsuarios.setVisible(true);
            System.out.println("presiono el menú Usuarios");
        }
  }
 public int setTipoDeArchivo(int tipoArchivoElegido){
     this.archivoElegido=tipoArchivoElegido;
     this.mantenimientoCursos.controlador_FRM_MantenimientoCursos.setTipoDeArchivo(tipoArchivoElegido);
     this.mantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.setTipoDeArchivo(tipoArchivoElegido);
     this.mantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.setTipoDeArchivo(tipoArchivoElegido);
     this.mantenimientoMatricula.controlador_FRM_Matricula.setTipoDeArchivo(tipoArchivoElegido);
     return archivoElegido;
     
 }
 public boolean verificarUsuarioBD(){
     return conexion.verificarUsuarioBD();
 }
 
}



