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
    cls_Persona per = new cls_Persona();
    clsUsuario usr = new clsUsuario();

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
                + "where cg.cargo_id=1 and p.nombre ='" + nomDoc + "'";
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
                + "where cg.cargo_id=2 and p.nombre ='" + nomRec + "'";
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

    public ResultSet listarOdontologos() throws Exception {
        strSQL = "select t.trabajador_id, p.nombre, p.apellido, p.documento, p.sexo, p.email, p.telefono, "
                + "p.fecha_nacimiento, p.direccion, t.especialidad, t.numero_licencia "
                + "from trabajador t "
                + "join persona p on t.persona_id = p.persona_id "
                + "where t.cargo_id = (select cargo_id from cargo where nombre_cargo = 'Odontologo')";
        try {
            return objBD.ConsultarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al listar odontólogos: " + e.getMessage());
        }
    }

    public void eliminarOdontologo(Integer trabajadorId) throws Exception {
        try {
            String sql = "delete from trabajador where trabajador_id=" + trabajadorId;
            objBD.ejecutarBD(sql);
        } catch (Exception e) {
            throw new Exception("Error al eliminar odontólogo: " + e.getMessage());
        }
    }

    public Integer obtenerPersonaIdPorTrabajadorId(Integer trabajadorId) throws Exception {
        strSQL = "select persona_id from trabajador where trabajador_id = " + trabajadorId;
        try {
            rs = objBD.ConsultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("persona_id");
            } else {
                throw new Exception("No se encontró persona con ese trabajador_id.");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener persona_id: " + e.getMessage());
        }
    }

    public Integer registrarOdontologoCompleto(String nombre, String apellido, String documento,
            String sexo, String email, String telefono, String fechaNacimiento,
            String direccion, String username, String passwordHash,
            Integer codCargo, String numeroLicencia, String especialidad,
            String fechaIngreso) throws Exception {
        try {
            Integer usuarioId = usr.registrarUsuario(username, passwordHash);

            Integer personaId = per.registrarPersona2(nombre, apellido, documento,
                    sexo, email, telefono,
                    fechaNacimiento, direccion);

            String sqlTrab = "insert into trabajador(persona_id, cargo_id, usuario_id, numero_licencia, especialidad, creado_en) "
                    + "values (" + personaId + "," + codCargo + "," + usuarioId + ",'"
                    + numeroLicencia + "','" + especialidad + "','" + fechaIngreso + "') returning trabajador_id";
            rs = objBD.ConsultarBD(sqlTrab);
            if (rs.next()) {
                return rs.getInt("trabajador_id");
            } else {
                throw new Exception("No se obtuvo trabajador_id al insertar trabajador.");
            }
        } catch (Exception e) {
            throw new Exception("Error al registrar odontólogo completo: " + e.getMessage());
        }
    }

    public void modificarOdontologoCompleto(int trabajadorId, String nombre, String apellido, String documento,
            String sexo, String email, String telefono, String fechaNacimiento,
            String direccion, String username, String passwordHash,
            Integer codCargo, String numeroLicencia, String especialidad,
            String fechaIngreso) throws Exception {
        try {
            Integer personaId = per.obtenerIdPersonaPorTrabajador(trabajadorId); // Método para obtener persona_id de trabajador
            per.modificarPersona(personaId, nombre, apellido, documento, email, telefono, fechaNacimiento, direccion, sexo.charAt(0));

            Integer usuarioId = usr.obtenerIdUsuarioPorTrabajador(trabajadorId); // Método para obtener usuario_id de trabajador
            usr.modificarUsuario(usuarioId, username, passwordHash);

            String sqlTrab = "update trabajador set cargo_id = " + codCargo + ", numero_licencia = "
                    + (numeroLicencia != null ? "'" + numeroLicencia + "'" : "null") + ", especialidad = "
                    + (especialidad != null ? "'" + especialidad + "'" : "null") + ", creado_en = '" + fechaIngreso + "' "
                    + "where trabajador_id = " + trabajadorId;
            int filas = objBD.ejecutarBD(sqlTrab);
            if (filas == 0) {
                throw new Exception("No se pudo modificar el trabajador.");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public int buscarID_Persona(String nomTra) throws Exception {
        strSQL = "Select t.persona_id from trabajador t "
                + "inner join persona p on t.persona_id = p.persona_id "
                + "where p.nombre ='" + nomTra + "'";
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
