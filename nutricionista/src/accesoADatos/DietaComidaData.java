/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoADatos;

import accesoADatos.ComidaData;
import entidades.DietaComida;
import entidades.Comida;
import entidades.Dieta;
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
    public void crearDietaComida(DietaComida dieta) {
        try{
            String sql = "SELECT * FROM dietacomida WHERE iddieta = ? AND idcomida = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dieta.getIdDieta());
            ps.setInt(2, dieta.getIdComida());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getInt("iddieta") == dieta.getIdDieta() && rs.getInt("idcomida") == dieta.getIdComida()){
                    System.out.println("Ya existe la relacion");
                }
                ps.close();
            }else{
                try{
                    String sql1 = "INSERT INTO dietacomida(iddieta, idcomida) VALUES (?, ?)";
                    PreparedStatement ps1 = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
                    ps1.setInt(1, dieta.getIdDieta());
                    ps1.setInt(2, dieta.getIdComida());
                    ps1.executeUpdate();
                    ResultSet rs1 = ps1.getGeneratedKeys();
                    if(rs1.next()){
                        System.out.println("Relacion añadida");
                    }
                    ps1.close();
                }catch(SQLException e){
                    System.out.println("Error al agregar la relacion, id: " + dieta.getIdDieta() + ", " + dieta.getIdComida());
                }
            }
        }catch(SQLException ex){
            System.out.println("Error al intentar conectarse con la base de datos");
        }
    }

    public List<Comida> listarComidasXDieta(int idDieta) {
        List<Comida> comidas = new ArrayList<>();
        
        try{
            ComidaData cd = new ComidaData();
            String sql = "SELECT * FROM dietacomida WHERE iddieta = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                comidas.add(cd.buscarComida(rs.getInt("idcomida")));
            }
            
        }catch(SQLException ex){
            System.out.println("Error al conectarse a la base de datos");
        
        }

        return comidas;
    }

    public void modificarDietaComida(int idDietaA, int idDietaN, int idComidaA, int idComidaN) {
        try{
            String sql = "UPDATE dietacomida SET iddieta = ?, idcomida = ? WHERE iddieta = ? AND idcomida = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDietaN);
            ps.setInt(2, idComidaN);
            ps.setInt(1, idDietaA);
            ps.setInt(2, idComidaA);
            int filas = ps.executeUpdate();
            
            if(filas == 1){
                System.out.println("Actualizado con exito");
            }else{
                System.out.println("Hubo un problema");
            }
            ps.close();
        }catch(SQLException ex){
            System.out.println("Error en la base de datos");
        }
    }

    public void eliminarDietaComida(int idDieta, int idComida) {
        try{
            String sql = "DELETE FROM dietacomida WHERE iddieta = ? AND idcomida = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ps.setInt(2, idComida);
            int filas = ps.executeUpdate();
            
            if(filas == 1){
                System.out.println("Eliminado con exito");
            }else{
                System.out.println("Hubo un problema");
            }
            ps.close();
        }catch(SQLException ex){
            System.out.println("Error en la base de datos");
        }
    } 
}
