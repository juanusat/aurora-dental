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
public class cls_Tratamiento { 
    clsJDBC objBD = new clsJDBC();
    ResultSet rs = null;
    String strSQL;

    public cls_Tratamiento() {
    }

    public ResultSet listarTratamientos() throws Exception{
        strSQL= "Select nombre from tratamiento"; 
        try {
            rs= objBD.ConsultarBD(strSQL); 
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar tratamientos " +e.getMessage()); 
        }
    }
    public int buscarTratamiento_id(String nomTra) throws Exception{
        strSQL="Select tratamiento_id from tratamiento where nombre ='"+nomTra+"'";
        try {
            rs=objBD.ConsultarBD(strSQL); 
            while (rs.next()) {                
                return rs.getInt("tratamiento_id");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar tratamiento_id por nombre " + e.getMessage()); 
        }
        return 0;
    } 
    public int precioTratamiento(String nombre) throws Exception{
        strSQL="Select costo from tratamiento where nombre='"+nombre+"'"; 
        try {
            rs =objBD.ConsultarBD(strSQL); 
            while (rs.next()) {                
                return rs.getInt("costo");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener precio de tratamiento " +e.getMessage());
        }
        return 0;
    }
    
    
}
