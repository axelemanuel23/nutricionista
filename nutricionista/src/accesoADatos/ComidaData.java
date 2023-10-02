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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author danig
 */
public class ComidaData {
    private Connection con;

    public ComidaData() {
        con = Conexion.getConexion();
    }
    
    
    public void guardarComida (Comida comida) {
        
        try {
            String sqlnombre = "SELECT nombre FROM comida WHERE nombre = ?";
            
            PreparedStatement psnombre = con.prepareStatement(sqlnombre);
            psnombre.setString(1, comida.getNombre());
            
            ResultSet rsnombre = psnombre.executeQuery();
             
           if (rsnombre.next()) {
               if(rsnombre.getString("nombre").equals(comida.getNombre())) {
                   JOptionPane.showMessageDialog(null, "Comida existente");
               }
           } else {
               String sql = "INSERT INTO comida(nombre, detalle, cantCalorias) VALUES (?, ?, ?)";
               
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1, comida.getNombre());
               ps.setString(2, comida.getDetalle());
               ps.setDouble(3, comida.getCantCalorias());
               ps.executeUpdate();
               
               ResultSet rs = ps.getGeneratedKeys();
               
               if (rs.next()) {
                        //
                        JOptionPane.showMessageDialog(null, "Comida añadida : \n "+ "Nombre: " + comida.getNombre()
                                                      + "\n" + " Detalle: "+ comida.getDetalle()
                                                      + "\n" + " Calorias: "+ comida.getCantCalorias()
                                                      + "\n" + " Codigo: "+rs);
                    }
        
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(ComidaData.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
    public void modificarComida (Comida comida) {
        
        try {
            String sql = "UPDATE comida SET nombre = ?, detalle = ?, cantCalorias = ? WHERE idComida = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setDouble(3, comida.getCantCalorias());
            ps.setInt(4, comida.getIdComida());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Comida modificada : \n "+ "Nombre: " + comida.getNombre()
                                                      + "\n" + " Detalle: "+ comida.getDetalle()
                                                      + "\n" + " Calorias: "+ comida.getCantCalorias()
                                                      + "\n" + " Codigo: "+comida.getIdComida());
            } else {
                JOptionPane.showMessageDialog(null, "La comida no existe");
            }
            ps.close();    
            
        } catch (SQLException ex) {
            Logger.getLogger(ComidaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
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
            Logger.getLogger(ComidaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return comidas;
    }
    
    
}
