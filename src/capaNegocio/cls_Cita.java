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
import java.sql.*;
import java.sql.ResultSet;
import java.time.Duration;
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

    public ResultSet buscarCitas(String cliente_id) throws Exception {
        strSQL = "Select c.cita_id,c.reagendada ,p.nombre as Nombre_C , d.trabajador_id ,t.nombre as Nombre_T ,p2.nombre ||' '|| p2.apellido as Nombre_D ,c.fecha_hora, c.costo from cita c "
                + "inner join cliente cl on c.cliente_id = cl.cliente_id "
                + "inner join persona p on cl.persona_id = p.persona_id "
                + "inner join tratamiento t on c.tratamiento_id = t.tratamiento_id "
                + "inner join trabajador d on c.medico_id=d.trabajador_id "
                + "inner join persona p2 on d.persona_id = p2.persona_id "
                + "where cl.cliente_id =" + cliente_id + " and c.estado in ('agendada', 'reagendada') and c.fecha_hora > CURRENT_TIMESTAMP ";
        try {
            rs = objBD.ConsultarBD(strSQL);

            return rs;

        } catch (Exception e) {
            throw new Exception("Error al buscar citas de paciente " + e.getMessage());
        }
    }

    public int buscarCita_id(int cita_id) throws Exception {

        strSQL = "Select c.cita_id from cita c "
                + "inner join cliente cl on c.cliente_id=cl.cliente_id "
                + "where c.cita_id=" + cita_id;
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

    public ResultSet buscarCita(int cita_id) throws Exception {

        strSQL = "Select * from cita "
                + "where cita_id=" + cita_id;
        try {
            rs = objBD.ConsultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar cita_id " + e.getMessage());
        }
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
                + "where cita_id=" + cita_id;
        System.out.println("S Format : " + fecha_Hora);
        System.out.println("C Format : " + fecha_Hora.format(formatter));
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

    public ResultSet buscarTodasCitasPaciente(String cliente_id) throws Exception {
        strSQL = "Select t.nombre as Nombre_T ,p2.nombre as Nombre_D ,c.fecha_hora, c.costo, c.reagendada, c.estado from cita c "
                + "inner join cliente cl on c.cliente_id = cl.cliente_id "
                + "inner join persona p on cl.persona_id = p.persona_id "
                + "inner join tratamiento t on c.tratamiento_id = t.tratamiento_id "
                + "inner join trabajador d on c.medico_id=d.trabajador_id "
                + "inner join persona p2 on d.persona_id = p2.persona_id "
                + "where cl.cliente_id =" + cliente_id;
        try {
            rs = objBD.ConsultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar todas citas de paciente " + e.getMessage());
        }

    }

    public ResultSet buscarTodasCitasDoctor(String nombre) throws Exception {
        strSQL = "Select p.nombre as Nombre_C ,p.documento as DNI ,t.nombre as Nombre_T, c.fecha_hora, c.reagendada, c.estado, CASE WHEN c.estado = 'reagendada' THEN 'Sí' ELSE 'No' END AS Reagendado from cita c "
                + "inner join cliente cl on c.cliente_id = cl.cliente_id "
                + "inner join persona p on cl.persona_id = p.persona_id "
                + "inner join tratamiento t on c.tratamiento_id = t.tratamiento_id "
                + "inner join trabajador d on c.medico_id = d.trabajador_id "
                + "inner join persona p2 on d.persona_id = p2.persona_id "
                + "where p2.nombre ='" + nombre + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            return rs;

        } catch (Exception e) {
            throw new Exception("Error al buscar todas citas del doctor " + e.getMessage());
        }

    }

    public ResultSet buscarCitasDeHoyPorUsuario(String usu) throws Exception {

        strSQL = "Select c.cita_id, p.nombre as nom_cliente, p.apellido as ape_cliente, c.fecha_hora, c.reagendada, c.duracion, c.costo, c.estado, p2.nombre as nom_medico, p2.apellido as ape_medico, p.documento, ac_med.observaciones, p.telefono as telefono, p.sexo as sexo  from cita c "
                + "inner join cliente cl on c.cliente_id = cl.cliente_id "
                + "inner join persona p on cl.persona_id = p.persona_id "
                + "inner join tratamiento t on c.tratamiento_id = t.tratamiento_id "
                + "inner join trabajador d on c.medico_id = d.trabajador_id "
                + "inner join persona p2 on d.persona_id = p2.persona_id "
                + "inner join usuario usu on usu.usuario_id = d.usuario_id "
                + "left join acto_medico ac_med on ac_med.cita_id = c.cita_id "
                + "where CAST(c.fecha_hora AS date)= CURRENT_DATE and usu.username ='" + usu + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            return rs;

        } catch (Exception e) {
            throw new Exception("Error al buscar todas citas del usuario " + e.getMessage());
        }
    }

    public ResultSet buscarInfoCitasDni(String dni) throws Exception {

        strSQL = "Select per_cl.apellido as Ape_cliente, per_cl.nombre as Nom_cliente,  per_cl.fecha_nacimiento, per_cl.sexo, per_cl.telefono, per_tra.nombre as nom_medico, c.fecha_hora, c.reagendada from cita c "
                + "inner join cliente cl on c.cliente_id=cl.cliente_id "
                + "inner join persona per_cl on cl.persona_id=per_cl.persona_id "
                + "inner join trabajador tra on c.medico_id=tra.trabajador_id "
                + "inner join persona per_tra on tra.persona_id=per_tra.persona_id "
                + "inner join acto_medico ac_med on ac_med.cita_id = c.cita_id "
                + "where per_cl.documento= '" + dni + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar citas de hoy " + e.getMessage());
        }
    }

    public void actualizarObservacion(String observacion, String cita_id) throws Exception {
        strSQL = "update acto_medico set observaciones='" + observacion + "' where cita_id = '" + cita_id + "'";
        try {
            objBD.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al actualizar persona " + e.getMessage());
        }
    }

    public int obtenerDiferenciaEntreHoras(int cita_id) throws Exception {
        rs = buscarCita(cita_id);
        rs.next();
        Timestamp fechaHoraPasada;
        if (rs.getTimestamp("reagendada") == null) {
            fechaHoraPasada = rs.getTimestamp("fecha_hora");
        } else {
            fechaHoraPasada = rs.getTimestamp("reagendada");
        }

        // ✅ Conversión directa sin errores de formato
        LocalDateTime fechaAnterior = fechaHoraPasada.toLocalDateTime();
        LocalDateTime ahora = LocalDateTime.now();

        Duration duracion = Duration.between(fechaAnterior, ahora);
        return (int) duracion.toMinutes();
    }

    public boolean verificarDisponibilidadDoctor(int doctor_id,
            LocalDateTime fechaHoraNueva,
            int duracionNuevaMin) throws Exception {
        String inicioNueva = fechaHoraNueva.format(formatter);
        String finNueva = fechaHoraNueva.plusMinutes(duracionNuevaMin).format(formatter);
        strSQL
                = "select 1 "
                + "  from cita c                                      \n"
                + "  JOIN tratamiento t ON c.tratamiento_id = t.tratamiento_id \n"
                + " WHERE c.medico_id = " + doctor_id + "             \n"
                + "   AND c.estado IN ('agendada','reagendada')       \n"
                + "   AND (                                           \n"
                + "          '" + inicioNueva + "' < (COALESCE(c.reagendada, c.fecha_hora) + (t.duracion_estimada || ' minutes')::interval) \n"
                + "       AND COALESCE(c.reagendada, c.fecha_hora) < '" + finNueva + "' \n"
                + "       )";
        try {
            rs = objBD.ConsultarBD(strSQL);
            return !rs.next();          // true  →   libre
        } catch (Exception e) {
            throw new Exception("Error al verificar disponibilidad del doctor: " + e.getMessage());
        }
    }

    public boolean verificarDisponibilidadDoctor(int doctor_id,
            LocalDateTime fechaHoraNueva,
            int duracionNuevaMin,
            int citaIdExcluir) throws Exception {

        String inicioNueva = fechaHoraNueva.format(formatter);
        String finNueva = fechaHoraNueva.plusMinutes(duracionNuevaMin).format(formatter);

        strSQL
                = "SELECT 1 \n"
                + "  FROM cita c                                         \n"
                + "  JOIN tratamiento t ON c.tratamiento_id = t.tratamiento_id \n"
                + " WHERE c.medico_id = " + doctor_id + "                \n"
                + "   AND c.estado IN ('agendada','reagendada')          \n"
                + "   AND c.cita_id <> " + citaIdExcluir + "             \n"
                + // ← excluye la propia cita
                "   AND (                                             \n"
                + "        '" + inicioNueva + "' < (COALESCE(c.reagendada, c.fecha_hora) + \n"
                + "                               (t.duracion_estimada || ' minutes')::interval) \n"
                + "    AND COALESCE(c.reagendada, c.fecha_hora) < '" + finNueva + "' \n"
                + "       )";

        try {
            rs = objBD.ConsultarBD(strSQL);
            return !rs.next();   // true → el horario está libre
        } catch (Exception e) {
            throw new Exception("Error al verificar disponibilidad del doctor: " + e.getMessage());
        }
    }

;
}
