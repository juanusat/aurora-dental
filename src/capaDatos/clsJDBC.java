/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaDatos;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import io.github.cdimascio.dotenv.Dotenv;

public class clsJDBC {

    private String driver, url, user, password;
    private Connection con;
    private Statement sent = null;

    //Constructor
    public clsJDBC() {
        Dotenv dotenv = Dotenv.load();

        this.driver = "org.postgresql.Driver";
        this.url = dotenv.get("DB_URL");
        this.user = dotenv.get("DB_USER");
        this.password = dotenv.get("DB_PASSWORD");
        this.con = null;
    }

    //conectar
    public void conectar() throws Exception {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception("Error al conectar a la BD");
        }
    }

    //Desconectar
    public void desconectar() throws Exception {
        try {
            con.close();
        } catch (SQLException ex) {
            throw new Exception("Error al desconectar la bd!");
        }
    }

    //Ejecutar una consulta SELECT
    public ResultSet ConsultarBD(String srtSQL) throws Exception {
        ResultSet rs = null;
        try {
            conectar();
            sent = con.createStatement();
            rs = sent.executeQuery(srtSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al ejecutar consulta ");
        } finally {
            if (con != null) {
                desconectar();
            }
        }
    }

    public int ejecutarBD(String srtSQL) throws Exception {
        ResultSet rs = null;
        int r;
        try {
            conectar();
            sent = con.createStatement();
            r = sent.executeUpdate(srtSQL);
            return r;
        } catch (Exception e) {
            throw new Exception("Error al ejecutar Update --> " + e.getMessage());
        } finally {
            if (con != null) {
                desconectar();
            }
        }
    }
}
