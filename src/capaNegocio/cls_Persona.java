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

    public void registrarPersona(String nombre, String apellido, String dni, String correo, String telefono, String fecha_nac, String direccion, String sexo) throws Exception {
        strSQL = "Insert into persona(nombre, apellido, documento, email, telefono, fecha_nacimiento, direccion, sexo) values('" + nombre + "','" + apellido + "','" + dni + "','" + correo + "','" + telefono + "','" + fecha_nac + "','" + direccion + "','" + sexo + "')";
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
        strSQL = "Select*from persona where documento= '" + dni + "'";
        try {
            System.out.println("si");
            rs = objBD.ConsultarBD(strSQL);
            System.out.println("consulta hecha");
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
        strSQL = "Select*from persona where documento= '" + dni + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
           return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar persona por dni" + e.getMessage());
        }
    }
    public ResultSet buscarPersonaCompletoId(String id) throws Exception {
        strSQL = "Select*from persona where persona_id= '" + id + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
           return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar persona por id" + e.getMessage());
        }
    }
    public void actualizarPersona(String nombre, String apellido, String dni, String sexo, String correo, String telefono, Date fecha_nac, String direccion) throws Exception{
        strSQL = "update persona set nombre='" +nombre+"',apellido='"+apellido+"',documento="+dni+",sexo='"+sexo+"',email='"+correo+"',telefono='"+telefono+"',fecha_nacimiento='"+fecha_nac+"',direccion='"+direccion+"' where documento = '"+dni + "'"; 
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
    public Integer generarNuevoCodigoPaciente() throws Exception{
        strSQL = "Select COALESCE(Max(persona_id), 0) + 1 as codigo from persona";
        try {
             rs =objBD.ConsultarBD(strSQL);
             while (rs.next()) {                
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar cliente_id por nombre de persona " + e.getMessage()); 
        }
        return 0;
    }
}
