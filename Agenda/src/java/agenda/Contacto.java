/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;


import java.sql.*;


/**
 *
 * @author carlos
 */
public class Contacto {
    
 private static String cadenaConexion; 
 private  Connection con;

 private void conectar(){     
     
     try {
           
            Class.forName("com.mysql.jdbc.Driver").newInstance();             
            con = DriverManager.getConnection(Contacto.cadenaConexion, "root", "pass1234");
                        
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
     Contacto.cadenaConexion = "jdbc:mysql://servidor:3306/agenda?useOldAliasMetadataBehavior=true";
 }
 
        
}
