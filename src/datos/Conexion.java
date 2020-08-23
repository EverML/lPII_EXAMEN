/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ever
 */
public class Conexion {

    private String db = "examen_lenguaje";
    private String user = "postgres";
    private String pass = "admin";
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost:5432/" + db;

    public Connection conectar() 
    {
        try 
        {
            Connection link = null;
            Class.forName(driver);
            link = DriverManager.getConnection(url, user, pass);
            return link;
        } catch (ClassNotFoundException | SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

}
