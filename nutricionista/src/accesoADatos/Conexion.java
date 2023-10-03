/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String DB = "nutricionista";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    
    private static Connection connection;

    public Conexion() {
    }
    public static Connection getConexion(){
        if (connection == null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL+DB + "?useLegacyDatetimeCode=false&serverTimezone=UTC" +"&user=" + USUARIO + "&password=" + PASSWORD);
                
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Error SQL= "+ ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error De Drivers= "+ ex.getMessage());
            }
        }
        return connection;
        
        
    }
}
