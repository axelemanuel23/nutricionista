package accesoADatos;

import entidades.Dieta;
import accesoADatos.PacienteData;
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

public class DietaData {
    private Connection con = null;
    public DietaData() {
        con = Conexion.getConexion();
    }
    public void crearDieta(Dieta dieta) {


                try {
                    String sql = "INSERT INTO dieta(nombre, idpaciente, fechainicial, pesoinicial, pesofinal, fechafinal) VALUES (?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, dieta.getNombre());
                    ps.setInt(2, dieta.getPaciente().getIdPaciente());
                    ps.setString(3, dieta.getNombre());
                    ps.setDate(4, Date.valueOf(dieta.getFechaInicial()));
                    ps.setDate(5, Date.valueOf(dieta.getFechaFinal()));
                    ps.executeUpdate();
                    ResultSet rs = ps.getGeneratedKeys();

                    if (rs.next()) {
                        //    alumno.setIdAlumno(rs.getInt("idAlumno"));
                        JOptionPane.showMessageDialog(null, "Dieta añadida con exito");
                    }
                    ps.close();
                } catch (SQLException e) {
                    JOptionPane.showConfirmDialog(null, "Error al acceder a la tabla Dieta" + e.getMessage());
                }
            
     
    }

    public Dieta buscarDieta(int id) {
        Dieta dieta = null;

        try {
            String sql = "SELECT nombre, idpaciente, fechainicial, pesoinicial, pesofinal, fechafinal FROM dieta WHERE iddieta = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            PacienteData pacienteData= new PacienteData();
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dieta = new Dieta();
                dieta.setIdDieta(id);
                dieta.setNombre(rs.getString("nombre"));
                dieta.setPaciente(pacienteData.buscarPaciente(rs.getInt("idpaciente")));
                dieta.setFechaFinal(rs.getDate("fechaNacimiento").toLocalDate());
                dieta.setPesoInicial(rs.getInt("pesoinicial"));
                dieta.setPesoFinal(rs.getInt("pesofinal"));
                dieta.setFechaInicial(rs.getDate("fechainicial").toLocalDate());
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe la Dieta");
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta" + e.getMessage());
        }
        return dieta;
    }

//    public Alumno buscarAlumnoPorDni(int dni) {
//        Alumno alumno = null;
//
//        try {
//            String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni = ? AND estado = 1";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, dni);
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                alumno = new Alumno();
//                alumno.setIdAlumno(rs.getInt("idAlumno"));
//                alumno.setDni(rs.getInt("dni"));
//                alumno.setNombre(rs.getString("nombre"));
//                alumno.setApellido(rs.getString("apellido"));
//                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
//                alumno.setActivo(true);
//            } else {
//                JOptionPane.showMessageDialog(null, "No existe el alumno");
//            }
//            ps.close();
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno" + e.getMessage());
//        } 
//        return alumno;
//        }


    public List<Dieta> listarDieta() {
        List<Dieta> Dietas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dieta";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            PacienteData pacienteData= new PacienteData();

            while (rs.next()) {
                Dieta dieta = new Dieta();
                dieta.setIdDieta(rs.getInt("iddieta"));
                dieta.setNombre(rs.getString("nombre"));
                dieta.setPaciente(pacienteData.buscarPaciente(rs.getInt("idpaciente")));
                dieta.setFechaFinal(rs.getDate("fechaNacimiento").toLocalDate());
                dieta.setPesoInicial(rs.getInt("pesoinicial"));
                dieta.setPesoFinal(rs.getInt("pesofinal"));
                dieta.setFechaInicial(rs.getDate("fechainicial").toLocalDate());
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta" + e.getMessage());
        }
        return Dietas;
    }

    public void modificarAlumno(Dieta dieta) {
        try {
            String sql = "UPDATE dieta SET nombre=?,idpaciente=?,fechainicial=?,pesoinicial=?,pesofinal=?,fechafinal=? WHERE iddieta = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, dieta.getNombre());
            ps.setInt(2, dieta.getPaciente().getIdPaciente());
            ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
            ps.setDouble(4,dieta.getPesoInicial());
            ps.setDouble(5,dieta.getPesoFinal());
            ps.setDate(6, Date.valueOf(dieta.getFechaFinal()));
            ps.setInt(5, dieta.getIdDieta());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificacion con exito");
            } else {
                JOptionPane.showMessageDialog(null, "La Dieta no exite");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta" + e.getMessage());
        }
    }

    public void eliminarDieta(int id) {
        try {
            String sql = "DELETE FROM dieta WHERE iddieta = ? ";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se elimino con exito");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta" + e.getMessage());
        }
    } 
}
