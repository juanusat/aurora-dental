/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaNegocio;

import capaDatos.clsJDBC;
import java.sql.ResultSet;
import java.util.Date;

import capaDatos.clsJDBC;
import java.sql.ResultSet;

public class cls_actoMedico {

    clsJDBC objBD = new clsJDBC();
    ResultSet rs = null;
    String strSQL;

    public void actualizarObservacion(String observacion, String cita_id) throws Exception {
        strSQL = "update acto_medico set observaciones='" + observacion + "' where cita_id = '" + cita_id + "'";
        try {
            objBD.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al actualizar persona " + e.getMessage());
        }

    }

    public void insertarActoMedico(String observaciones, String cita_id) throws Exception {
        rs = consultarBd(cita_id);
        if (rs.next() == false) {
            strSQL = "insert into acto_medico(cita_id, observaciones) values (" + cita_id + ", '" + observaciones + "')";
            try {
                objBD.ejecutarBD(strSQL);
            } catch (Exception e) {
                throw new Exception("Error al actualizar persona " + e.getMessage());
            }
        } else {
            actualizarObservacion(observaciones, cita_id);
        }

    }

    public ResultSet consultarBd(String cita_id) throws Exception {
        strSQL = "select * from acto_medico where cita_id ='" + cita_id + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al actualizar persona " + e.getMessage());
        }
    }

}
