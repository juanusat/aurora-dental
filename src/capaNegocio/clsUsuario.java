/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaNegocio;

import capaDatos.clsJDBC;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.Connection;

import capaDatos.clsJDBC;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

public class clsUsuario {

    clsJDBC objBD = new clsJDBC();
    ResultSet rs = null;
    String strSQL;

    public String validarIngreso(String usu, String password) throws Exception {
        String strSQL = "SELECT * FROM usuario usu inner join trabajador tra on usu.usuario_id = tra.usuario_id "
                + "WHERE usu.username = ? "
                + "AND usu.password_hash = encode(digest(? || ? || 'DENTAL', 'sha256'), 'hex') "
                + "AND tra.estado = 'true'";
        try {
            Connection con = null;
            objBD.conectar();
            con = objBD.getCon();
            PreparedStatement sp = con.prepareStatement(strSQL);

            sp.setString(1, usu);
            sp.setString(2, usu);
            sp.setString(3, password);

            ResultSet rs = sp.executeQuery();
            if (rs.next()) {
                return rs.getString("username");
            }
        } catch (Exception e) {
            throw new Exception("Error al validar ingreso: " + e.getMessage());
        }
        return "";
    }

    public void asignarHoraUltimoAcceso(String user) throws Exception {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        String fechaHoraFormateada = fechaHoraActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String strSQL = "UPDATE usuario SET ultimo_acceso = '" + fechaHoraFormateada + "' where username = '" + user + "'";

        try {
            objBD.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al actualizar hora del último acceso: " + e.getMessage());
        }
    }

    public int obtenerIdUsu(String usu) throws Exception {
        strSQL = "Select usuario_id from usuario where username='" + usu + "'";
        try {
            rs = objBD.ConsultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("usuario_id");
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void actualizarPassword(String usu, String password) throws Exception {
        strSQL = "Update usuario set password_hash = encode(digest(? || ? || 'DENTAL', 'sha256'), 'hex') "
                + "where username='" + usu + "'";
        try {
            Connection con = null;
            objBD.conectar();
            con = objBD.getCon();
            PreparedStatement sp = con.prepareStatement(strSQL);

            sp.setString(1, usu);
            sp.setString(2, password);

            sp.executeUpdate();

        } catch (Exception e) {
            throw new Exception("Error al actualizar password" + e.getMessage());
        }
    }

    public Integer registrarUsuario(String username, String passwordHash) throws Exception {
        strSQL = "insert into usuario(username, password_hash) "
                + "values ('" + username + "','" + passwordHash + "') returning usuario_id";
        rs = objBD.ConsultarBD(strSQL);
        if (rs.next()) {
            return rs.getInt("usuario_id");
            
        } else {
            throw new Exception("No se obtuvo usuario_id al insertar usuario.");
        }
    }

}
