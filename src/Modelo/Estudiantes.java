
package Modelo;

import java.io.Serializable;


public class Estudiantes implements Serializable{
    
    private String cedula;
    private String nombre;
    private String direccion;
    
    public Estudiantes(String cedula, String nombre, String direccion){
    this.cedula=cedula;
    this.nombre=nombre;
    this.direccion=direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getInformacion()
    {
        return "Cedula: "+cedula+" \nNombre: "+nombre+ "\n Direccion: "+direccion;
    }
}
