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

    public String buscarCliente(String nombre, String dni) throws Exception {
        strSQL = "select c.cliente_id , p.nombre, p.apellido from paciente p inner join cliente c on p.persona_id = c.persona_id where p.nombre='" + nombre + "' and p.documento='" + dni + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            while (rs.next()) {
                return rs.getString("nombre") + rs.getString("apellido");
            }
        } catch (Exception e) {
        }
        return "";
    }
    
    public ResultSet buscarCliente2(String nombre, String dni) throws Exception {
        strSQL = "SELECT c.cliente_id, p.nombre, p.apellido, p.documento "
                + "FROM cliente c inner join persona p ON p.persona_id = c.persona_id "
                + "WHERE p.nombre ='" + nombre + "' AND p.documento ='" + dni + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            System.out.println(rs);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar cliente" + e.getMessage());
        }

    }

    
}
