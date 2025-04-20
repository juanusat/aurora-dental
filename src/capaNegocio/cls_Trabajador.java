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
 
    
}
