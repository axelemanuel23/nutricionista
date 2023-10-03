/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoADatos;

import entidades.DietaComida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DietaComidaData {    

    private Connection con = null;

    public DietaComidaData() {
        con = Conexion.getConexion();
    }
    public void crearDietaComida(int idDieta, int idComida) {
        try{
            String sql = "SELECT * FROM dietacomida WHERE iddieta = ? AND idcomida = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ps.setInt(2, idComida);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getInt("iddieta") == idDieta && rs.getInt("idcomida") == idComida){
                    System.out.println("Ya existe la relacion");
                }
                ps.close();
            }else{
                try{
                    String sql1 = "INSERT INTO dietacomida(iddieta, idcomida) VALUES (?, ?)";
                    PreparedStatement ps1 = con.prepareStatement(sql1);
                    ps1.setInt(1, idDieta);
                    ps1.setInt(2, idComida);
                    ResultSet rs1 = ps1.getGeneratedKeys();
                    if(rs1.next()){
                        System.out.println("Relacion añadida");
                    }
                    ps1.close();
                }catch(SQLException e){
                    System.out.println("Error al agregar la relacion");
                }
            }
        }catch(SQLException ex){
            System.out.println("Error al intentar conectarse con la base de datos");
        }
    }

    public DietaComida buscarDietaComida() {
        DietaComida dietaComida = null;

        return dietaComida;
    }

    public List<DietaComida> listarDietaComida() {
        List<DietaComida> dc = new ArrayList<>();
        return dc;
    }

    public void modificarDietaComida() {
        
    }

    public void eliminarDietaComida() {
        
    } 
}
