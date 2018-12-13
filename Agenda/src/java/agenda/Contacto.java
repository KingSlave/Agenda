/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author carlos
 */
public class Contacto {
    
 private String nombre;
 private String email; 
 private String telCasa;
 private String telCel;
 private String nota;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelCasa() {
        return telCasa;
    }

    public void setTelCasa(String telCasa) {
        this.telCasa = telCasa;
    }

    public String getTelCel() {
        return telCel;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
 private static String cadenaConexion; 
 private  Connection con;

 private void conectar(){     
     
     try {
           
            Class.forName("com.mysql.jdbc.Driver").newInstance();             
            con = DriverManager.getConnection(Contacto.cadenaConexion, "root", "binario");
                        
            if(con==null){
                System.err.println("Conexion " + Contacto.cadenaConexion);
                System.out.println("Error en los datos de conexion");
            }
     
        } catch (SQLException ex) {            
            System.err.println("Conexion: " + Contacto.cadenaConexion);
            System.out.println("Error inesperado al conectarse: " + ex.getMessage());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            System.err.println("Error en el motor " + ex.getMessage());
        }
 }
 
 public void guardar() throws SQLException{
     if(con==null || con.isClosed())
         conectar();
     String SQL = "insert into Contactos values(?,?,?,?,?)";
     PreparedStatement comando = con.prepareStatement(SQL);
     comando.setString(1, nombre);
     comando.setString(2, email);
     comando.setString(3, telCasa);
     comando.setString(4, telCel);
     comando.setString(5, nota);
     comando.execute();
     con.close();     
 }
 
 public void eliminar() throws SQLException{
 if(con==null || con.isClosed())
         conectar();
     String SQL = "delete from Contactos where email = ?";
     PreparedStatement comando = con.prepareStatement(SQL);     
     comando.setString(1, email);     
     con.close();   
 }
 
 public void update() throws SQLException{
     if(con==null || con.isClosed())
         conectar();
     String SQL = "update Contactos set nombre=?,email=?,telCasa=?,telCel=?,nota=? where email=?";
     PreparedStatement comando = con.prepareStatement(SQL);
     comando.setString(1, nombre);
     comando.setString(2, email);
     comando.setString(3, telCasa);
     comando.setString(4, telCel);
     comando.setString(5, nota);
     comando.setString(6, email);
     comando.execute();
     con.close();   
 }
 
 public  List<Contacto> consultar() throws SQLException{
     if(con==null || con.isClosed())
         conectar();
        List<Contacto> contactos = new ArrayList<>();
        String SQL = "select * from Contactos";
        PreparedStatement comando = con.prepareStatement(SQL);        
        ResultSet res = comando.executeQuery();
            while(res.next()){
               Contacto x = new Contacto();
               x.setNombre(res.getString("nombre"));
               x.setEmail(res.getString("email"));
               x.setTelCasa(res.getString("telCasa"));
               x.setTelCel(res.getString("telCel"));
               x.setNota(res.getString("nota"));
               contactos.add(x);
               } 
        res.close();
        con.close();
     
     return contactos;
 }
 
 //Ejecucion de  SQL:
// PreparedStatement comando = this.con.prepareStatement(SQL);
// comando.setObject(i++, parametro);
// comando.execute();
 //con.close();
 
 
 //cargar resultados SQL:
// PreparedStatement comando = this.con.prepareStatement(SQL);
// comando.setObject(i++, parametro); 
// ResultSet res = comando.executeQuery();
 //while(res.next()){
//          x = res.getObject("atributo"); 
//        } 
// res.close();
// con.close();
 
 
 public Contacto(){
     Contacto.cadenaConexion = "jdbc:mysql://127.0.0.1:3306/agenda?useOldAliasMetadataBehavior=true";
 }
 
        
}
