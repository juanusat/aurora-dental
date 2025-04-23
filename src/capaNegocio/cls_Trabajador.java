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

    public ResultSet listarDoctores() throws Exception {
        strSQL = "Select p.nombre from trabajador t inner join persona p on t.persona_id = p.persona_id outer join cliente c on t.persona_id = c.persona_id where c.persona_id=null ";
       
        try {
            rs=objBD.ConsultarBD(strSQL); 
            return rs; 
        } catch (Exception e) {
            throw new Exception("Error al listarDoctores" + e.getMessage());  
        } 
    } 
    
    public String nombreCompleto (String usu)throws Exception{
        strSQL="Select P.nombre ||' '|| P.apellido as nombre_completo from persona P " 
                +"inner join trabajador T on P.persona_id=T.persona_id "
                +"inner join usuario U on T.usuario_id=U.usuario_id where U.username='"+usu+"'";
        String nombre="";
        try {
            rs=objBD.ConsultarBD(strSQL); 
            while (rs.next()) {                
                nombre= rs.getString("nombre_completo");
                return nombre;
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener nombre completo " +e.getMessage());
        }
        return ""; 
    } 
    public String obtenerCargo (String usu)throws Exception{
        strSQL= "Select CA.nombre_cargo from cargo CA "
                +"inner join trabajador T on CA.cargo_id = T.cargo_id "
                +"inner join usuario U on T.usuario_id = U.usuario_id where U.username='"+usu+"'" ;
        try {
            rs=objBD.ConsultarBD(strSQL); 
            while (rs.next()) {                
                String cargo = rs.getString("nombre_cargo");
                return cargo;
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener cargo" +e.getMessage());
        }
        return ""; 
    } 
 
    
}
