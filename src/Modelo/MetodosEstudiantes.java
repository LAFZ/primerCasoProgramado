
package Modelo;

import java.util.ArrayList;


public class MetodosEstudiantes {
    
    ArrayList <Estudiantes> arrayEstudiantes;
    String arregloInformacion[];
    
    public MetodosEstudiantes()
    {
        arrayEstudiantes=new ArrayList<Estudiantes>();
        arregloInformacion=new String[1];
    }
    public void agregarEstudiante(String informacion[]){
        Estudiantes temporal=new Estudiantes(informacion[0],informacion[1]);
        this.arrayEstudiantes.add(temporal);
    }
    public void mostrarInformacionEstudiantes(){
        Estudiantes temporal;
        temporal=arrayEstudiantes.get(0);
        System.out.println(temporal.getInformacion());
    }
    public boolean consultarEstudiante(String carnet)
    {
        boolean itemEncontrado=false;
        for(int i=0;i<arrayEstudiantes.size();i++)
        {
            System.out.println("entro al for");
            if(this.arrayEstudiantes.get(i).getCarnet().equals(carnet)){
            System.out.println("entro al if");
            arregloInformacion[0]=arrayEstudiantes.get(i).getNombre();
            itemEncontrado=true;
            }     
        }
        return itemEncontrado;
    }
    public void modificarEstudiante(String carnet, String nombre){
        
        for(int i=0;i<arrayEstudiantes.size();i++){
                if(this.arrayEstudiantes.get(i).getCarnet().equals(carnet)){
                this.arrayEstudiantes.get(i).setNombre(nombre);
                }
        }
    }
    
    public void eliminarEstudiante (String carnet)
    {
        for(int i=0;i<arrayEstudiantes.size();i++){
                if(this.arrayEstudiantes.get(i).getCarnet().equals(carnet)){
                arrayEstudiantes.remove(i);
                }
        }
    }
    public String[] getArregloInformacion(){
        return arregloInformacion;
    }
    public ArrayList<Estudiantes> getArray(){
        return this.arrayEstudiantes;
    }
    public void setArray(ArrayList<Estudiantes> estudiantes){
        this.arrayEstudiantes=estudiantes;
    }
}
