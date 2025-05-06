/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaNegocio;

import capaDatos.clsJDBC;
import java.sql.ResultSet;

/**
 *
 * @author Antonio
 */
public class cls_Pago {

    clsJDBC objBD = new clsJDBC();
    ResultSet rs = null;
    String strSQL;

    public ResultSet buscarCitasconMontoPagado(String nombre, String apellido) throws Exception {
        strSQL = "SELECT c.cita_id AS cita_id, tr.nombre AS tratamiento, per2.nombre AS doctor, c.costo AS costo, "
                + "CASE "
                + "WHEN c.reagendada IS NOT NULL THEN c.reagendada "
                + "ELSE c.fecha_hora "
                + "END AS fecha, "
                + "c.estado AS estado, "
                + "COALESCE(SUM(p.monto), 0) AS monto_pagado "
                + "FROM persona per "
                + "INNER JOIN cliente cl ON per.persona_id = cl.persona_id "
                + "INNER JOIN cita c ON cl.cliente_id = c.cliente_id "
                + "INNER JOIN tratamiento tr ON c.tratamiento_id = tr.tratamiento_id "
                + "INNER JOIN trabajador t ON c.medico_id = t.trabajador_id "
                + "INNER JOIN persona per2 ON t.persona_id = per2.persona_id "
                + "LEFT JOIN pago p ON c.cita_id = p.cita_id "
                + "WHERE c.estado IN ('agendada', 'realizada', 'reagendada') "
                + "AND per.nombre = '" + nombre + "' AND per.apellido = '" + apellido + "' "
                + "GROUP BY c.cita_id, tr.nombre, per2.nombre, c.costo, "
                + "CASE WHEN c.reagendada IS NOT NULL THEN c.reagendada ELSE c.fecha_hora END, c.estado";

        try {
            rs = objBD.ConsultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar citas de cliente + monto_pago " + e.getMessage());
        }

    }

    public void registrarPago(int cita_id, String emisor, float monto, String metodo) throws Exception {
        strSQL = "Insert into pago(cita_id,emisor,monto,metodo) values(" + cita_id + ",'" + emisor + "'," + monto + ",'" + metodo + "');";
        try {
            objBD.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar pago de cita " + e.getMessage());
        }
    }

    public ResultSet listarPagosCitasCliente(String nombre, String apellido) throws Exception {
        strSQL = "Select tr.nombre as tratamiento , p.emisor as emisor, p.fecha_hora as fecha_hora, p.monto as monto, p.metodo as metodo, p.estado as estado "
                + "from pago p "
                + "inner join cita c on p.cita_id=c.cita_id "
                + "inner join tratamiento tr on c.tratamiento_id =tr.tratamiento_id "
                + "inner join cliente cl on c.cliente_id=cl.cliente_id "
                + "inner join persona per on cl.persona_id = per.persona_id "
                + "where per.nombre ='" + nombre + "' and apellido='" + apellido + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar pagos de citas de cliente " + e.getMessage());
        }
    }

}
