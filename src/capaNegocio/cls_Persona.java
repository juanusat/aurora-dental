/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaNegocio;

import java.util.Date;
import capaDatos.clsJDBC;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio
 */
public class cls_Persona {

    clsJDBC objBD = new clsJDBC();
    ResultSet rs = null;
    String strSQL;

    public void registrarPersona(String nombre, String apellido, String dni, boolean sexo, String correo, String telefono, Date fecha_nac, String direccion) throws Exception {
        strSQL = "Insert into persona values('" + nombre + "','" + apellido + "','" + dni + "','" + correo + "','" + telefono + "','" + fecha_nac + "','" + direccion + "')";
        try {
            objBD.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar Persona" + e.getMessage());
        }
    }
    
    public Integer registrarPersona2(String nombre, String apellido, String documento,
            String sexo, String email, String telefono, String fechaNacimiento,
            String direccion) throws Exception {
        String sql = "insert into persona(nombre, apellido, documento, sexo, email, telefono, fecha_nacimiento, direccion) "
                + "values ('" + nombre + "','" + apellido + "','" + documento + "','" + sexo + "','" + email + "','"
                + telefono + "','" + fechaNacimiento + "','" + direccion + "') returning persona_id";
         rs = objBD.ConsultarBD(sql);
        if (rs.next()) {
            return rs.getInt("persona_id");
        } else {
            throw new Exception("No se obtuvo persona_id al insertar persona.");
        }
    }

    public int buscarPersona(String dni) throws Exception {
        strSQL = "Select*from persona where documento=" + dni;
        try {
            rs = objBD.ConsultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("persona_id");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar persona por dni" + e.getMessage());
        }
        return 0;
    }

    public int buscarPersonaNom(String nom) throws Exception {
        strSQL = "Select*from persona where nombre=" + nom;
        try {
            rs = objBD.ConsultarBD(strSQL);
            return rs.getInt("persona_id");
        } catch (Exception e) {
            throw new Exception("Error al buscar persona por nombre" + e.getMessage());
        }
    }

    public ResultSet buscarPersonaCompleto(String dni) throws Exception {
        strSQL = "Select*from persona where documento=" + dni;
        try {
            rs = objBD.ConsultarBD(strSQL);
           return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar persona por dni" + e.getMessage());
        }
    }
    public void actualizarPersona(String nombre, String apellido, String dni, boolean sexo, String correo, String telefono, Date fecha_nac, String direccion, int persona_id) throws Exception{
        strSQL = "update persona set nombre='" +nombre+"',apellido='"+apellido+"',documento="+dni+",sexo='"+sexo+"',email='"+correo+"',telefono='"+telefono+"',fecha_nacimiento='"+fecha_nac+"',direccion='"+direccion+"' where persona_id ="+persona_id; 
        try {
            objBD.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al actualizar persona " +e.getMessage());
        }
    } 
    
    public String obtenerCorreo(String usu) throws Exception{
        strSQL="Select P.email from persona P " 
                +"inner join trabajador T on P.persona_id = T.persona_id "
                +"inner join usuario U on T.usuario_id = U.usuario_id where U.username='"+usu+"'";
        try {
            rs=objBD.ConsultarBD(strSQL); 
            while (rs.next()) {                
                return rs.getString("email");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener correo " + e.getMessage());
        }
        
        return ""; 
    } 
    
    public int modificarCorreo(String correo, String usu) throws Exception{
        strSQL="Update persona set email='"+correo+"' where email='"+obtenerCorreo(usu)+"'";
        int r;
        try {
            r=objBD.ejecutarBD(strSQL); 
            return r;
        } catch (Exception e) {
            throw new Exception("Error al actualizar correo :" + e.getMessage()); 
        }
    }  
    public int buscarCliente_id (String nombre)throws Exception{
        strSQL="Select c.cliente_id from cliente c inner join persona p on c.persona_id = p.persona_id where p.nombre='"+nombre+"'"; 
        try {
             rs =objBD.ConsultarBD(strSQL);
             while (rs.next()) {                
                return rs.getInt("cliente_id");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar cliente_id por nombre de persona " + e.getMessage()); 
        }
        return 0;
    }

}
