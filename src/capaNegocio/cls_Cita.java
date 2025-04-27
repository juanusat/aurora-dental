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
    
 public void insertCita (int cliente_id,int tratamiendo_id,int medico_id,int agendador_id,LocalDateTime fechaHora,float costo) throws Exception{
     strSQL= "Insert into cita (cliente_id,tratamiento_id,medico_id,agendador_id,fecha_hora,costo) "
             + "values ('"+cliente_id+"','"+tratamiendo_id+"','"+medico_id+"','"+agendador_id+"','"+fechaHora.format(formatter)+"','"+costo+"')"; 
     try {
         objBD.ejecutarBD(strSQL); 
     } catch (Exception e) {
         throw new Exception("Error al insertar cita " +e.getMessage());
     }
 }
    
    
}
