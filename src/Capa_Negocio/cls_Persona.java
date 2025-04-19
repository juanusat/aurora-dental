/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Negocio;

import java.util.Date;
import Capa_Datos.clsJDBC;
import java.sql.ResultSet;
import java.util.Date;

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

}
