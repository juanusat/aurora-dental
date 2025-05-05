/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaNegocio;

import java.util.Date;

import capaDatos.clsJDBC;
import java.sql.ResultSet;
import java.util.Date;

import capaDatos.clsJDBC;
import java.sql.ResultSet;

public class cls_Trabajador {

    clsJDBC objBD = new clsJDBC();
    ResultSet rs = null;
    String strSQL;

    public ResultSet listarDoctores() throws Exception {
        strSQL = "Select p.nombre from trabajador t "
                + "inner join persona p on t.persona_id = p.persona_id "
                + "inner join cargo cg on t.cargo_id = cg.cargo_id "
                + "where cg.cargo_id = 1";

        try {
            rs = objBD.ConsultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar Doctores" + e.getMessage());
        }
    }

    public String nombreCompleto(String usu) throws Exception {
        strSQL = "Select P.nombre ||' '|| P.apellido as nombre_completo from persona P "
                + "inner join trabajador T on P.persona_id=T.persona_id "
                + "inner join usuario U on T.usuario_id=U.usuario_id where U.username='" + usu + "'";
        String nombre = "";
        try {
            rs = objBD.ConsultarBD(strSQL);
            while (rs.next()) {
                nombre = rs.getString("nombre_completo");
                return nombre;
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener nombre completo " + e.getMessage());
        }
        return "";
    }

    public String obtenerCargo(String usu) throws Exception {
        strSQL = "Select CA.nombre_cargo from cargo CA "
                + "inner join trabajador T on CA.cargo_id = T.cargo_id "
                + "inner join usuario U on T.usuario_id = U.usuario_id where U.username='" + usu + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            while (rs.next()) {
                String cargo = rs.getString("nombre_cargo");
                return cargo;
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener cargo" + e.getMessage());
        }
        return "";
    }

    public int buscarID_Doctor(String nomDoc) throws Exception {
        strSQL = "Select t.trabajador_id from trabajador t "
                + "inner join cargo cg on t.cargo_id= cg.cargo_id "
                + "inner join persona p on t.persona_id = p.persona_id "
                + "where cg.cargo_id=1 and p.nombre ='"+nomDoc+"'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("trabajador_id");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar id de Doctor " + e.getMessage());
        }
        return 0;
    }

    public int buscarID_Recepcionista(String nomRec) throws Exception {
        strSQL = "Select t.trabajador_id from trabajador t "
                + "inner join cargo cg on t.cargo_id= cg.cargo_id "
                + "inner join persona p on t.persona_id = p.persona_id "
                + "where cg.cargo_id=2 and p.nombre ='"+nomRec+"'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("trabajador_id");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar id de Recepcionista " + e.getMessage());
        }
        return 0;
    }
    public ResultSet listarTrabajadores() throws Exception {
        strSQL = "Select p.nombre from trabajador t "
                + "inner join persona p on t.persona_id = p.persona_id";

        try {
            rs = objBD.ConsultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar trabajadores" + e.getMessage());
        }
    }
    public int buscarID_Persona(String nomTra) throws Exception {
        strSQL = "Select t.persona_id from trabajador t "
                + "inner join persona p on t.persona_id = p.persona_id "
                + "where p.nombre ='"+nomTra+"'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("persona_id");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar id de Doctor " + e.getMessage());
        }
        return 0;
    }
}
