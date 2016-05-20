
package Modelo;

import java.io.Serializable;


public class Usuarios implements Serializable{
    private String nombreUsuario;
    private String password;
    private String nombres;
    private String apellidos;

    public Usuarios(String nombreUsuario, String password, String nombres, String apellidos) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getInformacion(){
        return "Nombre de Usuario: "+nombreUsuario+" \nPassword: "+password+" \nNombre: "+nombres+" \nApellidos: "+apellidos;
    }
}
