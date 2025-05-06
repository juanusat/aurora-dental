package capaNegocio;

import capaDatos.clsJDBC;
import java.sql.*;

/**
 *
 * @author Antonio
 */
public class cls_Tratamiento {

    clsJDBC objBD = new clsJDBC();
    ResultSet rs = null;
    String strSQL;

    public cls_Tratamiento() {
    }

    public ResultSet listarTratamientos() throws Exception {
        strSQL = "select * from tratamiento";
        try {
            rs = objBD.ConsultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar tratamientos: " + e.getMessage());
        }
    }

    public int precioTratamiento(String nombre) throws Exception {
        strSQL = "Select costo from tratamiento where nombre='" + nombre + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("costo");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener precio de tratamiento " + e.getMessage());
        }
        return 0;
    }

    public ResultSet buscarTratamientosPorNombre(String nombre) throws Exception {
        strSQL = "select * from tratamiento where nombre ilike '%" + nombre + "%'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar tratamientos por nombre: " + e.getMessage());
        }
    }

    public Integer generarCodigoTratamiento() throws Exception {
        strSQL = "select coalesce(max(tratamiento_id),0)+1 as codigo from tratamiento";
        try {
            rs = objBD.ConsultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar código de tratamiento: " + e.getMessage());
        }
        return 0;
    }

    public int registrar(Integer cod, String nombre, String descripcion, Integer duracion, Double costo) throws Exception {
        strSQL = "insert into tratamiento values(" + cod + ",'" + nombre + "','" + descripcion + "'," + duracion + "," + costo + ")";
        try {
            int rp = objBD.ejecutarBD(strSQL);
            return rp;
        } catch (Exception e) {
            throw new Exception("Error al registrar el tratamiento: " + e.getMessage());
        }
    }

    public int modificar(Integer cod, String nombre, String descripcion, Integer duracion, Double costo) throws Exception {
        strSQL = "UPDATE tratamiento SET nombre='" + nombre + "', descripcion='" + descripcion + "', duracion_estimada=" + duracion + ", costo=" + costo + " WHERE tratamiento_id=" + cod;
        try {
            int rp = objBD.ejecutarBD(strSQL);
            return rp;
        } catch (Exception e) {
            throw new Exception("Error al modificar tratamiento: " + e.getMessage());
        }
    }

    public int buscarTratamiento_id(String nomTra) throws Exception {
        strSQL = "SELECT tratamiento_id FROM tratamiento WHERE nombre = '" + nomTra + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("tratamiento_id");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar tratamiento_id por nombre " + e.getMessage());
        }
        return 0;
    }

    public int eliminar(Integer cod) throws Exception {
        strSQL = "delete from tratamiento where tratamiento_id=" + cod;
        try {
            int rp = objBD.ejecutarBD(strSQL);
            return rp;
        } catch (Exception e) {
            throw new Exception("Error al eliminar tratamiento: " + e.getMessage());
        }
    }

}
