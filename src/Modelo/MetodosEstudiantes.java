
package Modelo;

import java.util.ArrayList;


public class MetodosEstudiantes {
    
    ArrayList <Estudiantes> arrayEstudiantes;
    String arregloInformacion[];
    
    public MetodosEstudiantes()
    {
        arrayEstudiantes=new ArrayList<Estudiantes>();
        arregloInformacion=new String[2];
    }
    public void agregarEstudiante(String informacion[]){
        Estudiantes temporal=new Estudiantes(informacion[0],informacion[1], informacion[2]);
        this.arrayEstudiantes.add(temporal);
    }
    public void mostrarInformacionEstudiantes(){
        Estudiantes temporal;
        temporal=arrayEstudiantes.get(0);
        System.out.println(temporal.getInformacion());
    }
    public boolean consultarEstudiante(String cedula)
    {
        boolean itemEncontrado=false;
        for(int i=0;i<arrayEstudiantes.size();i++)
        {
            System.out.println("entro al for");
            if(this.arrayEstudiantes.get(i).getCedula().equals(cedula)){
            System.out.println("entro al if");
            arregloInformacion[0]=arrayEstudiantes.get(i).getNombre();
            arregloInformacion[1]=arrayEstudiantes.get(i).getDireccion();
            itemEncontrado=true;
            }     
        }
        return itemEncontrado;
    }
    public void modificarEstudiante(String cedula, String nombre, String direccion){
        
        for(int i=0;i<arrayEstudiantes.size();i++){
                if(this.arrayEstudiantes.get(i).getCedula().equals(cedula)){
                this.arrayEstudiantes.get(i).setNombre(nombre);
                this.arrayEstudiantes.get(i).setDireccion(direccion);
                }
        }
    }
    
    public void eliminarEstudiante (String cedula)
    {
        for(int i=0;i<arrayEstudiantes.size();i++){
                if(this.arrayEstudiantes.get(i).getCedula().equals(cedula)){
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
