
package Modelo;

import java.io.Serializable;


public class Curso implements Serializable{
private String nombreDelCurso;
private String siglas;
private int creditos;
private String horario;

public Curso(String nombreDelCurso, String siglas, int creditos, String horario){
    this.nombreDelCurso=nombreDelCurso;
    this.siglas=siglas;
    this.creditos=creditos;
    this.horario=horario;
}

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNombreDelCurso() {
        return nombreDelCurso;
    }

    public void setNombreDelCurso(String nombreDelCurso) {
        this.nombreDelCurso = nombreDelCurso;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    
    public String getInformacion(){
    return "Nombre del Curso: "+nombreDelCurso+"\nSiglas: "+siglas+"\nCreditos: "+creditos+"\nHorario: "+horario;
    }
}
