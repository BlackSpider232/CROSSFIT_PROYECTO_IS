/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author SnakeEyes96
 */
public class Insertar {
    Conectar cc = new Conectar();
    Connection cn = cc.conexion();
    
    public void insParticipante(int dpi,String nombre,String apellido,String fecha,String nacionalidad,String pnacimiento,String presidencia,String direccion,String provincia,String ciudad,int telefono,String email,String genero,String estado){
            
            try{
                PreparedStatement pr =  cn.prepareStatement("INSERT INTO participante (dpi, nombre,apellido,fecha_nacimiento,nacionalidad,paisNacimiento,paisResidencia,direccion,estadoProvincia,ciudad,telefono,email,genero,estado)"
                    +"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pr.setInt(1, dpi);
                pr.setString(2, nombre);
                pr.setString(3, apellido);
                pr.setString(4, fecha);
                pr.setString(5, nacionalidad);
                pr.setString(6, pnacimiento);
                pr.setString(7, presidencia);
                pr.setString(8, direccion);
                pr.setString(9, provincia);
                pr.setString(10, ciudad);
                pr.setInt(11, telefono);
                pr.setString(12, email);
                pr.setString(13, genero);
                pr.setString(14, estado);
                pr.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Dato Ingresado");
            }
            catch(SQLException e){
                 JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión con la base de datos 1");
                 e.printStackTrace();
            }
    }      
    
        
    public void insEjercicio(String nombre,String descripcion){
            try{
                PreparedStatement pr =  cn.prepareStatement("INSERT INTO ejercicio (nombre, descripcion)"
                    +"VALUES (?,?)");
                pr.setString(1, nombre);
                pr.setString(2, descripcion);
                pr.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Dato Ingresado");
            }
            catch(SQLException e){
                 JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión con la base de datos 1");
                 e.printStackTrace();
            }
        }
    public void insEvento(String nombre,String descripcion,String fechaInicio,String fechaFin,String horaInicio,String horaFin,String requisitos){
            try{
                PreparedStatement pr =  cn.prepareStatement("INSERT INTO evento (nombre, descripcion,fechaInicio,fechaFin,horaInicio,horaFin,requisitos)"
                    +"VALUES (?,?,?,?,?,?,?)");
                pr.setString(1, nombre);
                pr.setString(2, descripcion);
                pr.setString(3, fechaInicio);
                pr.setString(4, fechaFin);
                pr.setString(5, horaInicio);
                pr.setString(6, horaFin);
                pr.setString(7, requisitos);
                pr.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Dato Ingresado");
            }
            catch(SQLException e){
                 JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión con la base de datos 1");
                 e.printStackTrace();
            }
        } 
   public void insAsignarEjercicio(int ejercicio,int dpi,int repeticiones){
            try{
                PreparedStatement pr =  cn.prepareStatement("INSERT INTO asignacion ejercicio (id_ejercicio, dpi,repeticiones)"
                    +"VALUES (?,?,?)");
                pr.setInt(1, ejercicio);
                pr.setInt(2, dpi);
                pr.setInt(3, repeticiones);
                pr.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Dato Ingresado");
            }
            catch(SQLException e){
                 JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión con la base de datos 1");
                 e.printStackTrace();
            }
        }
            
}
