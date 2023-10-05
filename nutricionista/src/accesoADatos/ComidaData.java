/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import entidades.Comida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danig
 */
public class ComidaData {
    private Connection con;

    public ComidaData() {
        con = Conexion.getConexion();
    }
    
    /**
     * guardarComida
     * Guardar una comida en la base de datos
     * @param comida Comida - Objeto a guardar
     */
    public void guardarComida (Comida comida) {
        try {
            String sqlnombre = "SELECT nombre FROM comida WHERE nombre = ?";
            
            PreparedStatement psnombre = con.prepareStatement(sqlnombre);
            psnombre.setString(1, comida.getNombre());
            
            ResultSet rsnombre = psnombre.executeQuery();
             
           if (rsnombre.next()) {
               if(rsnombre.getString("nombre").equals(comida.getNombre())) {
                   System.out.println("Comida existente");
               }
           } else {
               String sql = "INSERT INTO comida(nombre, detalle, cantCalorias) VALUES (?, ?, ?)";
               
               PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
               ps.setString(1, comida.getNombre());
               ps.setString(2, comida.getDetalle());
               ps.setDouble(3, comida.getCantCalorias());
               ps.executeUpdate();
               
               ResultSet rs = ps.getGeneratedKeys();
               
               if (rs.next()) {
                  System.out.println("Se añadio con exito");
               }
            }
        } catch (SQLException ex) {
            System.out.println("Error en la base de datos");
        }
  
    }
    /**
     * modificarComida
     * Modifica una comida ubicada por su id por los nuevos datos del objeto Comida
     * @param idComida Entero - Id de ña comida a modificar
     * @param comida Comida - Objeto de reemplazo
     */
    public void modificarComida (int idComida, Comida comida) {
        try {
            String sql = "UPDATE comida SET nombre = ?, detalle = ?, cantCalorias = ? WHERE idComida = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setDouble(3, comida.getCantCalorias());
            ps.setInt(4, idComida);
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                System.out.println("Se actualizó con exito");
            } else {
                System.out.println("La comida no existe");
            }
            ps.close();    
            
        } catch (SQLException ex) {
            System.out.println("Error en la base de datos");
        }
    }
    /**
     * listarComida
     * Retorna una lista de todas las comidas
     * @return Lista de todas las comidas
     */
    public List<Comida> listarComida () {
        List<Comida> comidas = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM comida";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Comida comida = new Comida();
                
                comida.setIdComida(rs.getInt("idComida"));
                comida.setNombre(rs.getString("nombre"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCantCalorias(rs.getInt("cantcalorias"));
                
                comidas.add(comida);
            }
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error en la base de datos");
        }
        
        return comidas;
    }
    /**
     * buscarComida
     * Busca una comida por su nombre
     * @param nombre String - Nombre de la comida
     * @return Comida
     */
    public Comida buscarComida (String nombre) {
        Comida comida = new Comida();
        
        try {
            String sql = "SELECT * FROM comida WHERE nombre = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                comida.setIdComida(rs.getInt("idcomida"));
                comida.setNombre(rs.getString("nombre"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCantCalorias(rs.getInt("cantcalorias"));
                
            }else{
                System.out.println("No existe esa comida");
            }
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error en la base de datos");
        }
        
        return comida;
    }
    /**
     * buscarComida
     * Busca una comida por id
     * @param idComida Entero - id de la comida
     * @return Comida
     */
    public Comida buscarComida (int idComida) {
        Comida comida = new Comida();
        
        try {
            String sql = "SELECT * FROM comida WHERE idcomida = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idComida);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                comida.setIdComida(rs.getInt("idcomida"));
                comida.setNombre(rs.getString("nombre"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCantCalorias(rs.getInt("cantcalorias"));
                
            }else{
                System.out.println("No existe esa comida");
            }
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error en la base de datos");
        }
        
        return comida;
    }
    /**
     * buscarCaloriasMax
     * Busca comidas con un valor maximo de calorias
     * @param calorias Entero - Cantidad maxima de calorias
     * @return Lista de comidas
     */
    public List<Comida> buscarCaloriasMax (int calorias) {
        List<Comida> comidas = new ArrayList<>();
        Comida comida = new Comida();
        
        try {
            String sql = "SELECT * FROM comida WHERE cantcalorias <= ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, calorias);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                while(rs.next()){
                    comidas.add(buscarComida(rs.getInt("idcomida")));
                }
            }else{
                System.out.println("No existe esa comida");
            }
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error en la base de datos");
        }
        
        return comidas;
    }
    /**
     * buscarCaloriasMin
     * Busca comidas con un valor minimo de calorias
     * @param calorias Entero - Cantidad minima de calorias
     * @return Lista de comidas
     */
    public List<Comida> buscarCaloriasMin (int calorias) {
        List<Comida> comidas = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM comida WHERE cantcalorias >= ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, calorias);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                while(rs.next()){
                    comidas.add(buscarComida(rs.getInt("idcomida")));
                }
            }else{
                System.out.println("No existe esa comida");
            }
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error en la base de datos");
        }
        
        return comidas;
    }
    /**
     * eliminarComida
     * Elimina la comida de la base de datos
     * @param idComida Entero - id de la comida
     */
    public void eliminarComida( int idComida) {
        try{
            String sql = "DELETE FROM comida WHERE idcomida = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idComida);
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
