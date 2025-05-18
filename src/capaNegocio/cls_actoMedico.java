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
    String strSQL1;
    cls_Cita objCita = new cls_Cita();

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

        // Si no existe la cita, rs.next() será false
        if (!rs.next()) {
            try {
                strSQL = "INSERT INTO acto_medico (cita_id, observaciones) VALUES (" + cita_id + ", '" + observaciones + "')";

                int duracion = objCita.obtenerDiferenciaEntreHoras(Integer.parseInt(cita_id));

                strSQL1 = "UPDATE cita SET duracion = '" + duracion + "' where cita_id = " + cita_id;

                objBD.ejecutarBDTransacciones(strSQL, strSQL1);
            } catch (Exception e) {
                throw new Exception("Error al insertar acto médico y actualizar cita: " + e.getMessage());
            }
        } else {
            // Si ya existe, solo actualiza la observación
            actualizarObservacion(observaciones, cita_id);
        }
    }

    public ResultSet consultarBd(String cita_id) throws Exception {
        strSQL = "select * from acto_medico where cita_id =" + cita_id;
        try {
            rs = objBD.ConsultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al actualizar persona " + e.getMessage());
        }
    }

}
