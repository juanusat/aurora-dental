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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class cls_Cita {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    clsJDBC objBD = new clsJDBC();
    ResultSet rs = null;
    String strSQL;

    public void insertCita(int cliente_id, int tratamiendo_id, int medico_id, int agendador_id, LocalDateTime fechaHora, float costo) throws Exception {
        strSQL = "Insert into cita (cliente_id,tratamiento_id,medico_id,agendador_id,fecha_hora,costo) "
                + "values ('" + cliente_id + "','" + tratamiendo_id + "','" + medico_id + "','" + agendador_id + "','" + fechaHora.format(formatter) + "','" + costo + "')";
        try {
            objBD.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al insertar cita " + e.getMessage());
        }
    }

    public ResultSet buscarCitas(String nombre) throws Exception {
        strSQL = "Select p.nombre as Nombre_C , t.nombre as Nombre_T ,p2.nombre as Nombre_D ,c.fecha_hora, c.costo from cita c "
                + "inner join cliente cl on c.cliente_id = cl.cliente_id "
                + "inner join persona p on cl.persona_id = p.persona_id "
                + "inner join tratamiento t on c.tratamiento_id = t.tratamiento_id "
                + "inner join trabajador d on c.medico_id=d.trabajador_id "
                + "inner join persona p2 on d.persona_id = p2.persona_id "
                + "where p.nombre ='" + nombre + "' and c.estado in ('agendada', 'reagendada')";
        try {
            rs = objBD.ConsultarBD(strSQL);

            return rs;

        } catch (Exception e) {
            throw new Exception("Error al buscar citas de paciente " + e.getMessage());
        }
    }

    public int buscarCita_id(int cliente_id, LocalDateTime fechaHora) throws Exception {
        strSQL = "Select c.cita_id from cita c "
                + "inner join cliente cl on c.cliente_id=cl.cliente_id "
                + "where c.cliente_id='" + cliente_id + "' and c.fecha_hora='" + fechaHora.format(formatter) + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("cita_id");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar cita_id " + e.getMessage());
        }
        return 0;
    }

    public int modificarCitaSF(int cita_id, int doctor_id, int tratamiento_id, int agendor_id) throws Exception {
        strSQL = "Update cita set tratamiento_id='" + tratamiento_id + "',medico_id='" + doctor_id + "',agendador_id='" + agendor_id + "',estado='reagendada' "
                + "where cita_id='" + cita_id + "'";
        try {
            int i = objBD.ejecutarBD(strSQL);
            return i;
        } catch (Exception e) {
            throw new Exception("Error al modificar cita " + e.getMessage());
        }
    }

    public int modificarCita(int cita_id, int doctor_id, int tratamiento_id, int agendor_id, LocalDateTime fecha_Hora) throws Exception {
        strSQL = "Update cita set tratamiento_id='" + tratamiento_id + "',medico_id='" + doctor_id + "',agendador_id='" + agendor_id + "',reagendada='" + fecha_Hora.format(formatter) + "',estado='reagendada' "
                + "where cita_id='" + cita_id + "'";
        try {
            int i = objBD.ejecutarBD(strSQL);
            return i;
        } catch (Exception e) {
            throw new Exception("Error al modificar cita " + e.getMessage());
        }
    }

    public int anularCita(int cita_id) throws Exception {
        strSQL = "Update cita set estado='cancelada' "
                + "where cita_id='" + cita_id + "'";
        try {
            int r = objBD.ejecutarBD(strSQL);
            return r;
        } catch (Exception e) {
            throw new Exception("Error al modificar cita " + e.getMessage());
        }
    }

    public ResultSet buscarTodasCitasPaciente(String nombre, String apellido) throws Exception {
        strSQL = "Select t.nombre as Nombre_T ,p2.nombre as Nombre_D ,c.fecha_hora, c.costo, c.reagendada, c.estado from cita c "
                + "inner join cliente cl on c.cliente_id = cl.cliente_id "
                + "inner join persona p on cl.persona_id = p.persona_id "
                + "inner join tratamiento t on c.tratamiento_id = t.tratamiento_id "
                + "inner join trabajador d on c.medico_id=d.trabajador_id "
                + "inner join persona p2 on d.persona_id = p2.persona_id "
                + "where p.nombre ='" + nombre + "'and p.apellido='" + apellido + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            while (rs.next()) {
                return rs;
            }

        } catch (Exception e) {
            throw new Exception("Error al buscar todas citas de paciente " + e.getMessage());
        }
        return rs = null;
    }
    
    public ResultSet buscarTodasCitasDoctor(String nombre) throws Exception {
        strSQL = "Select p.nombre as Nombre_C ,p.documento as DNI ,t.nombre as Nombre_T, c.fecha_hora, c.reagendada, c.estado, CASE WHEN c.estado = 'reagendada' THEN 'Sí' ELSE 'No' END AS Reagendado from cita c "
            + "inner join cliente cl on c.cliente_id = cl.cliente_id "
            +  "inner join persona p on cl.persona_id = p.persona_id "
               + "inner join tratamiento t on c.tratamiento_id = t.tratamiento_id "
               + "inner join trabajador d on c.medico_id = d.trabajador_id "
               + "inner join persona p2 on d.persona_id = p2.persona_id "
               + "where p2.nombre ='" +nombre + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            while (rs.next()) {
                return rs;
            }

        } catch (Exception e) {
            throw new Exception("Error al buscar todas citas del doctor " + e.getMessage());
        }
        return rs = null;
    }

}
