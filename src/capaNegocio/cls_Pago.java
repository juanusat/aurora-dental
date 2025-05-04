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
        strSQL = "select c.cita_id as cita_id, tr.nombre as tratamiento, per2.nombre as doctor , c.costo as costo, "
                + "case "
                + "when c.reagendada is not null then c.reagendada "
                + "else c.fecha_hora "
                + "end as fecha, "
                + "c.estado as estado, "
                + "coalesce(sum(p.monto),0) as monto_pagado "
                + "from cita c "
                + "inner join pago p on c.cita_id = p.cita_id "
                + "inner join cliente cl on c.cliente_id = cl.cliente_id "
                + "inner join persona per on cl.persona_id = per.persona_id "
                + "inner join tratamiento tr on c.tratamiento_id = tr.tratamiento_id "
                + "inner join trabajador t on c.medico_id = t.trabajador_id "
                + "inner join persona per2 on t.persona_id = per2.persona_id "
                + "where c.estado in ('agendada', 'realizada', 'reagendada') "
                + "and per.nombre='" + nombre + "' and per.apellido='" + apellido + "' "
                + "group by c.cita_id, tr.nombre ,per2.nombre, c.costo, fecha, c.estado";
        try {
            rs = objBD.ConsultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar citas de cliente + monto_pago " + e.getMessage());
        }

    }
    
    public void registrarPago(int cita_id, String emisor, float monto, String metodo) throws Exception{
        strSQL="Insert into pago(cita_id,emisor,monto,metodo) values("+cita_id+",'"+emisor+"',"+monto+",'"+metodo+"');"; 
        try {
            objBD.ejecutarBD(strSQL); 
        } catch (Exception e) {
            throw new Exception("Error al registrar pago de cita " +e.getMessage()); 
        }
    }

}
