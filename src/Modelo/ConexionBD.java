

package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConexionBD {
    
    Connection con = null;
    String arregloInformacionEstudiante[];
    String arregloInformacionCurso[];
    String arregloInformacionMatricula[];
    String arregloInformacionUsuario[];
    public ConexionBD()
    {
        realizarConexion();
        arregloInformacionEstudiante=new String[2];
        arregloInformacionCurso= new String[3];
        arregloInformacionMatricula= new String[2];
        arregloInformacionUsuario=new String[3];
       
    }
    public void realizarConexion()
    {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/Matricula";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    
//////////////////////////////"Metodos de EStudiante"///////////////////////////    

    public boolean registrarEstudiante(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                
                ejecuto = cmd.execute("INSERT INTO estudiantes(cedula, nombre, direccion) VALUES ('"+informacion[0]+"','"+informacion[1]+"','"+informacion[2]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean actualizarEstudiante(String cedula, String nombre, String direccion)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE estudiantes SET cedula='"+cedula+"',nombre='"+nombre+"',direccion='"+direccion+"' WHERE cedula='"+cedula+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean consultarEstudiante(String cedula)
    {
     //   System.out.println("aqui si"+cedula);
        ResultSet rs = null;
        Statement cmd = null;
        boolean itemEncontrado=false;
        try {
       //     System.out.println("aqui si"+cedula);
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM estudiantes where cedula='"+cedula+"'");
                
                while (rs.next()) 
                {
                    
                    String nombre = rs.getString("Nombre");
                    String direccion=rs.getString("direccion");
                    //int edad = rs.getInt(2);
                    itemEncontrado=true;
                    arregloInformacionEstudiante[0]=nombre;
                    arregloInformacionEstudiante[1]=direccion;
                    System.out.println("Información de la BD: "+nombre); 
                    System.out.println("Información de la BD: "+direccion); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            itemEncontrado=true;
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return itemEncontrado;
    }
     
    public boolean eliminarEstudiante(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM estudiantes where cedula='"+cedula+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public String[] getArregloInformacionEstudiante(){
        return arregloInformacionEstudiante;
    }
//////////////////////////////"Metodos de Curso"////////////////////////////////
    public boolean registrarCurso(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO cursos(sigla, nombre, creditos, horario) VALUES ('"+informacion[1]+"','"+informacion[0]+"','"+informacion[2]+"','"+informacion[3]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean actualizarCurso(String sigla, String nombre, int creditos, String horario)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE cursos SET sigla='"+sigla+"',nombre='"+nombre+"',creditos='"+creditos+"',horario='"+horario+"' WHERE sigla='"+sigla+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean consultarCurso(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean itemEncontrado=false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM cursos where sigla='"+sigla+"'");
                
                while (rs.next()) 
                {
                    
                    String nombre = rs.getString("nombre");
                    String creditos=rs.getString("creditos");
                    String horario=rs.getString("horario");
                    //int edad = rs.getInt(2);
                    itemEncontrado=true;
                    arregloInformacionCurso[0]=nombre;
                    arregloInformacionCurso[1]=creditos;
                    arregloInformacionCurso[2]=horario;
                    System.out.println("Información de la BD: "+nombre); 
                    System.out.println("Información de la BD: "+creditos);
                    System.out.println("Información de la BD: "+horario);
                }
                rs.close();
        }
        catch(Exception e)
        {
            itemEncontrado=true;
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return itemEncontrado;
    }
     
    public boolean eliminarCurso(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM cursos where sigla='"+sigla+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public String[] getArregloInformacionCurso(){
        return arregloInformacionCurso;
    }
//////////////////////////////"Metodos de Matricula"////////////////////////////  
    //numero = a codigo de la matricula.
public boolean registrarMatricula(String informacion[])
    {
        boolean resultado=false;
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                if(consultarMatricula(Integer.parseInt(informacion[0]))==false){
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO matricula(numero, cedula) VALUES ('"+informacion[0]+"','"+informacion[1]+"')");
                ejecuto = cmd.execute("INSERT INTO detalle_matricula(numero, sigla) VALUES ('"+informacion[0]+"','"+informacion[2]+"')");
                resultado=true;
                //return true;
               // rs.close();
                }else{
                if(consultarMatricula(Integer.parseInt(informacion[0]))==true){
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO detalle_matricula(numero, sigla) VALUES ('"+informacion[0]+"','"+informacion[2]+"')");
               resultado=true;
                // return true;
               // rs.close();
                }
                }
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            resultado=false;
            //return false;
        }
        return resultado;
    }
    public boolean actualizarMatricula(int numero, String cedula, String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE detalle_matricula SET numero='"+numero+"',sigla='"+sigla+"' WHERE numero='"+numero+"'");
                ejecuto = cmd.execute("UPDATE matricula SET numero='"+numero+"',cedula='"+cedula+"' WHERE numero='"+numero+"'");
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean consultarMatricula(int numero)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean itemEncontrado=false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM matricula where numero='"+numero+"'");
                
                while (rs.next()) 
                {
                    
                    String cedula = rs.getString("cedula");
                    //int edad = rs.getInt(2);
                    itemEncontrado=true;
                    arregloInformacionMatricula[0]=cedula;
                    System.out.println("Información de la BD: "+cedula); 
                    
                }
                rs.close();
                
        }catch(Exception e)
        {
            //itemEncontrado=true;
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM detalle_matricula where numero='"+numero+"'");
                
                while (rs.next()) 
                {
                    
                    
                    String sigla=rs.getString("sigla");
                    //int edad = rs.getInt(2);
                    itemEncontrado=true;
                    arregloInformacionMatricula[1]=sigla;
                    System.out.println("Información de la BD: "+sigla); 
                    
                }
                rs.close();
                
        }
        catch(Exception e)
        {
            //itemEncontrado=true;
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return itemEncontrado;
    }
     
    public boolean eliminarMatricula(int numero)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM detalle_matricula where numero='"+numero+"'");
                ejecuto = cmd.execute("DELETE FROM matricula where numero='"+numero+"'");
                return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public String[] getArregloInformacionMatricula(){
        return arregloInformacionMatricula;
    }
    
     public String devolverCodigo(){
     ResultSet rs = null;
        Statement cmd = null;
        String numeroGenerado= "000";
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT MAX(numero) AS numero FROM matricula");
                
                while (rs.next()) 
                {
                    
                    String numeroEncontrado = rs.getString("numero");
                    int numero=Integer.parseInt(numeroEncontrado);
                    numero++;
                    numeroGenerado=""+numero;
                    System.out.println("Información de la BD: "+numeroGenerado); 
                    
                }
                rs.close();
        }
        catch(Exception e)
        {
            
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return numeroGenerado;
     }
////////////////////////////////////////////////////////////////////////////////////////////
     public boolean registrarUsuario(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO usuarios(nombreUsuario, password, nombres, apellidos) VALUES ('"+informacion[0]+"','"+informacion[1]+"','"+informacion[2]+"','"+informacion[3]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean actualizarUsuario(String IDUsuario, String password, String nombre, String apellidos)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE usuarios SET nombreUsuario='"+IDUsuario+"',password='"+password+"',nombre='"+nombre+"',apellidos='"+apellidos+"' WHERE nombreUsuario='"+IDUsuario+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean consultarUsuario(String IDUsuario)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean itemEncontrado=false;
        try {
                cmd = con.createStatement();
                System.out.println(""+IDUsuario);
                rs = cmd.executeQuery("SELECT * FROM usuarios where nombreUsuario='"+IDUsuario+"'");
                
                while (rs.next()) 
                {
                    
                    String password = rs.getString("password");
                    String nombre=rs.getString("nombres");
                    String apellidos=rs.getString("apellidos");
                    //int edad = rs.getInt(2);
                    itemEncontrado=true;
                    arregloInformacionUsuario[0]=password;
                    arregloInformacionUsuario[1]=nombre;
                    arregloInformacionUsuario[2]=apellidos;
                    System.out.println("Información de la BD: "+password); 
                    System.out.println("Información de la BD: "+nombre);
                    System.out.println("Información de la BD: "+apellidos);
                }
                rs.close();
        }
        catch(Exception e)
        {
            itemEncontrado=true;
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return itemEncontrado;
    }
     public boolean consultarUsuarioLogin(String IDUsuario, String password)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean itemEncontrado=false;
        try {
                cmd = con.createStatement();
                System.out.println(""+IDUsuario+" "+password);
                rs = cmd.executeQuery("SELECT * FROM usuarios where nombreUsuario='"+IDUsuario+"' AND password= '"+password+"'");
                
                while (rs.next()) 
                {
                                    
                    String nombre=rs.getString("nombres");
                    String apellidos=rs.getString("apellidos");
                    //int edad = rs.getInt(2);
                    itemEncontrado=true;
                    
                    System.out.println("Información de la BD: "+password); 
                    System.out.println("Información de la BD: "+nombre);
                    System.out.println("Información de la BD: "+apellidos);
                }
                rs.close();
        }
        catch(Exception e)
        {
            itemEncontrado=true;
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return itemEncontrado;
    }
    public boolean eliminarUsuario(String IDUsuario)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM usuarios where nombreUsuario='"+IDUsuario+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public String[] getArregloInformacionUsuario(){
        return arregloInformacionUsuario;
    }
    
    public boolean verificarUsuarioBD(){
        
        ResultSet rs = null;
        Statement cmd = null;
        try {
       //     System.out.println("aqui si"+cedula);
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM usuarios");
                if(rs.next()){
                return  true;
                }else{
                return false;
                }      
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return false;
    }
    
    
}
    
    
    

