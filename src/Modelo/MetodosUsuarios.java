
package Modelo;

import java.util.ArrayList;


public class MetodosUsuarios {
    
    ArrayList <Usuarios> arrayUsuarios;
    String arregloInformacion[];
    
    public MetodosUsuarios()
    {
        arrayUsuarios=new ArrayList<Usuarios>();
        arregloInformacion=new String[3];
    }
    public void agregarUsuario(String informacion[]){
        Usuarios temporal=new Usuarios(informacion[0],informacion[1], informacion[2], informacion[3]);
        this.arrayUsuarios.add(temporal);
    }
    public void mostrarInformacionUsuarios(){
        Usuarios temporal;
        temporal=arrayUsuarios.get(0);
        System.out.println(temporal.getInformacion());
    }

    public boolean consultarUsuario(String nombreUsuario)
    {
        boolean itemEncontrado=false;
        for(int i=0;i<arrayUsuarios.size();i++)
        {
            System.out.println("entro al for");
            if(this.arrayUsuarios.get(i).getNombreUsuario().equals(nombreUsuario)){
            System.out.println("entro al if");
            arregloInformacion[0]=arrayUsuarios.get(i).getPassword();
            arregloInformacion[2]=arrayUsuarios.get(i).getNombres();
            arregloInformacion[3]=arrayUsuarios.get(i).getApellidos();
            itemEncontrado=true;
            }     
        }
        return itemEncontrado;
    }
    public void modificarUsuario(String nombreUsuario, String password, String nombres, String apellidos){
        
        for(int i=0;i<arrayUsuarios.size();i++){
                if(this.arrayUsuarios.get(i).getNombreUsuario().equals(nombreUsuario)){
                this.arrayUsuarios.get(i).setPassword(password);
                this.arrayUsuarios.get(i).setNombres(nombres);
                this.arrayUsuarios.get(i).setApellidos(apellidos);
                }
        }
    }
    
    public void eliminarUsuario (String nombreUsuario)
    {
        for(int i=0;i<arrayUsuarios.size();i++){
                if(this.arrayUsuarios.get(i).getNombreUsuario().equals(nombreUsuario)){
                arrayUsuarios.remove(i);
                }
        }
    }
    public String[] getArregloInformacion(){
        return arregloInformacion;
    }
    public ArrayList<Usuarios> getArray(){
        return this.arrayUsuarios;
    }
    public void setArray(ArrayList<Usuarios> usuarios){
        this.arrayUsuarios=usuarios;
    }
}
