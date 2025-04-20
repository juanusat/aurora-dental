/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaNegocio;

import capaDatos.clsJDBC;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author Antonio
 */
public class cls_Cliente {

    clsJDBC objBD = new clsJDBC();
    ResultSet rs = null;
    String strSQL;

    public void registrarPaciente(int persona_id) throws Exception {
        strSQL = "Insert into cliente values(" + persona_id + ")";
        try {
            objBD.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar Paciente" + e.getMessage());
        }
    }

    public void registrarDoctorcmPaciente(int persona_id) throws Exception {
        strSQL = "Insert into cliente values(" + persona_id + ")";
        try {
            objBD.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar Paciente" + e.getMessage());
        }
    }
    public String buscarCliente(String nombre, String dni)throws Exception{
        strSQL="select c.clliente_id , p.nombre, p.apellido from paciente p innerjoin cliente c on p.persona_id = c.persona_id where p.nombre='"+nombre+"' and p.documento='"+dni+"'"; 
        try {
            rs=objBD.ConsultarBD(strSQL); 
            while (rs.next()) {                
                return rs.getString("nombre") + rs.getString("apellido");
            }
        } catch (Exception e) {
        }
        return ""; 
    }
       
}