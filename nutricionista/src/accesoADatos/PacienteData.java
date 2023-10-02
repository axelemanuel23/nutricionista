/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoADatos;

import entidades.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PacienteData {    

    private Connection con = null;

    public PacienteData() {
        con = Conexion.getConexion();
    }
    public void crearPaciente(Paciente paciente) {

        try {
            //Consulta SQL 
            String sqlDni = "SELECT dni FROM paciente WHERE dni = ?";
            PreparedStatement psDni = con.prepareStatement(sqlDni);
            psDni.setInt(1, paciente.getDni());
            ResultSet rsdni = psDni.executeQuery();
            if (rsdni.next()) {
                if (paciente.getDni() == rsdni.getInt("dni")) {
                    JOptionPane.showMessageDialog(null, "Dni existente");
                }
            } else {
                try {
                    String sql = "INSERT INTO paciente(dni, nombre, domicilio, telefono) VALUES (?, ?, ?, ?)";
                    PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, paciente.getDni());
                    ps.setString(2, paciente.getNombre());
                    ps.setString(3, paciente.getDomicilio());
                    ps.setString(4, paciente.getTelefono());
                    ps.executeUpdate();
                    ResultSet rs = ps.getGeneratedKeys();

                    if (rs.next()) {
                        //    alumno.setIdAlumno(rs.getInt("idAlumno"));
                        JOptionPane.showMessageDialog(null, "Paciente añadido con exito");
                    }
                    ps.close();
                } catch (SQLException e) {
                    JOptionPane.showConfirmDialog(null, "Error al acceder a la tabla Paciente" + e.getMessage());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Paciente buscarPaciente(int dni) {
        Paciente paciente = null;

        try {
            String sql = "SELECT * FROM paciente WHERE dni = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setTelefono(rs.getString("telefono"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el paciente");
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente" + e.getMessage());
        }
        return paciente;
    }

    public List<Paciente> listarPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM paciente";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente();

                paciente.setNombre(rs.getString("nombre"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setDomicilio(rs.getString("domicilio"));
                paciente.setTelefono(rs.getString("telefono"));
                pacientes.add(paciente);
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente" + e.getMessage());
        }
        return pacientes;
    }

    public void modificarPaciente(Paciente paciente) {
        try {
            String sql = "UPDATE paciente SET dni = ? , nombre = ?, domicilio = ?, telefono = ? WHERE idPaciente = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, paciente.getDni());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getDomicilio());
            ps.setString(4, paciente.getTelefono());
            ps.setInt(5, paciente.getIdPaciente());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificacion con exito");
            } else {
                JOptionPane.showMessageDialog(null, "El paciente no existe");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente" + e.getMessage());
        }
    }

    public void eliminarAlumno(int id) {
        try {
            String sql = "DELETE FROM paciente WHERE idPaciente = ? ";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino con exito");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente" + e.getMessage());
        }
    } 
}
