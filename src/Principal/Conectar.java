/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Jeredick
 */
public class Conectar {

    Connection conn=null;
     String login="root";
     String password="orejitas.com1996";
     String url="jdbc:mysql://127.0.0.1:3306/crossfit";
     
     public Connection conexion(){
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn=DriverManager.getConnection(url,login,password);
        }
        catch(ClassNotFoundException e){
                
                JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión con la base de datos " + e);
                e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return conn;
    }    
    
}
