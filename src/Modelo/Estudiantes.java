
package Modelo;

import java.io.Serializable;


public class Estudiantes implements Serializable{
    
    private String carnet;
    private String nombre;
    
    public Estudiantes(String carnet, String nombre){
    this.carnet=carnet;
    this.nombre=nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getInformacion()
    {
        return "Carnet: "+carnet+" \nNombre: "+nombre;
    }
}
