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

public class clsUsuario {

    clsJDBC objBD = new clsJDBC();
    ResultSet rs = null;
    String strSQL;

    public String validarIngreso(String usu, String password) throws Exception {
        String strSQL = "SELECT * FROM usuario "
                + "WHERE username = ? "
                + "AND password_hash = encode(digest(? || ? || 'DENTAL', 'sha256'), 'hex');";
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
    
    public int obtenerIdUsu(String usu) throws Exception{
        strSQL="Select usuario_id from usuario where username='"+usu+"'"; 
        try {
            rs=objBD.ConsultarBD(strSQL); 
            while (rs.next()) {                
                return rs.getInt("usuario_id"); 
            }
        } catch (Exception e) {
        }
        return 0; 
    }
    public void actualizarPassword(String usu,String password) throws Exception{
        strSQL="Update usuario set password_hash = encode(digest(? || ? || 'DENTAL', 'sha256'), 'hex') "
                +"where username='"+usu+"'";
        try {
            Connection con=null;
            objBD.conectar();
            con=objBD.getCon(); 
            PreparedStatement sp = con.prepareStatement(strSQL); 
            
            sp.setString(1, usu);
            sp.setString(2,password);
            
            sp.executeUpdate();
            
        } catch (Exception e) {
            throw new Exception("Error al actualizar password" + e.getMessage());
        }
    }
    

}
