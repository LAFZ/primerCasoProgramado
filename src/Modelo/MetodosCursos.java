
package Modelo;

import java.util.ArrayList;


public class MetodosCursos {
    ArrayList <Curso> arrayCursos;
    String arregloInformacion[];
    
    public MetodosCursos(){
        arrayCursos=new ArrayList <Curso>();
        arregloInformacion=new String[3];
    }
    
    public void agregarCurso(String informacion[]){
        Curso temporal=new Curso(informacion[0], informacion[1],Integer.parseInt(informacion[2]), informacion[3]);
        this.arrayCursos.add(temporal);
    }
    
    public void mostrarInformacionCursos(){
        Curso temporal;
        temporal=this.arrayCursos.get(0);
        System.out.println(temporal.getInformacion());
    }
    
    public boolean consultarCurso(String sigla)
    {
        boolean itemEncontrado=false;
        for(int i=0;i<arrayCursos.size();i++)
        {
           if(arrayCursos.get(i).getSiglas().equals(sigla))
                {
                    arregloInformacion[0]=arrayCursos.get(i).getNombreDelCurso();
                    arregloInformacion[1]=""+arrayCursos.get(i).getCreditos();
                    this.arregloInformacion[2]=arrayCursos.get(i).getHorario();
                    itemEncontrado=true;
                }
        }
        return itemEncontrado;
    }
    public void modificarCurso(String sigla, String nombre, int credito, String horario){
    for(int i=0;i<arrayCursos.size();i++)
        {
           if(arrayCursos.get(i).getSiglas().equals(sigla))
            {
                this.arrayCursos.get(i).setNombreDelCurso(nombre);
                this.arrayCursos.get(i).setCreditos(credito);
                this.arrayCursos.get(i).setHorario(horario);
            }
        }
    }
    public void eliminarCurso (String sigla)
    {
        for(int i=0;i<arrayCursos.size();i++)
        {
           if(arrayCursos.get(i).getSiglas().equals(sigla))
            {
               this.arrayCursos.remove(i);
            }
        }
    }
    public String[] getArregloInformacion(){
        return arregloInformacion;
    }
    public ArrayList<Curso> getArray(){
        return this.arrayCursos;
    }
    
    public void setArray(ArrayList<Curso> cursos){
        this.arrayCursos=cursos;
    }
}
