
package accesoADatos;

import entidades.Dieta;
import entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteData {    

    private Connection con = null;

    public PacienteData() {
        con = Conexion.getConexion();
    }
    public void crearPaciente(Paciente paciente) {

        try {
            //Corroborar si el DNI ya existe
            String sqlDni = "SELECT dni FROM paciente WHERE dni = ?";
            PreparedStatement psDni = con.prepareStatement(sqlDni);
            psDni.setInt(1, paciente.getDni());
            ResultSet rsdni = psDni.executeQuery();
            if (rsdni.next()) {
                if (paciente.getDni() == rsdni.getInt("dni")) {
                    //Parte Grafica del mensaje
                    System.out.println("Dni existente: " + paciente.getDni());
                    System.out.println("Registro NO añadido");
                }
            } else {
                //Si no hay ningun DNI se agrega a la base de datos
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
                        paciente.setIdPaciente(rs.getInt("idpaciente"));
                        //Parte Grafica del mensaje
                        System.out.println("Paciente añadido con exito");
                    }
                    ps.close();
                } catch (SQLException e) {
                    //Parte grafica del mensaje
                    System.out.println("Error al acceder a la tabla paciente");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error en la base de datos");
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
                //Parte Grafica del mensaje
                System.out.println("No existe el paciente");
            }
            ps.close();

        } catch (SQLException e) {
            //Parte grafica del mensaje
            System.out.println("Error al acceder a la tabla paciente");
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
            //Parte grafica del mensaje
            System.out.println("Error al acceder a la tabla paciente");
        }
        return pacientes;
    }
    
    public List<Paciente> listarPacientesExitosos(){
        List<Paciente> pacientes = new ArrayList<>();
        List<Dieta> dietas = new ArrayList<>();
        
        DietaData dd = new DietaData();
        
        dietas = dd.listarDietasExitosas();
        
        for(Dieta dieta : dietas){
            pacientes.add(dieta.getPaciente());
        }
        
        
        return pacientes;
    }
     public List<Paciente> listarPacientesSinExito(){
        List<Paciente> pacientes = new ArrayList<>();
        List<Dieta> dietas = new ArrayList<>();
        
        DietaData dd = new DietaData();
        
        dietas = dd.listarDietasSinExito();
        
        for(Dieta dieta : dietas){
            pacientes.add(dieta.getPaciente());
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
                //Parte grafica del mensaje
                System.out.println("Actualización exitosa");
            } else {
                //Parte grafica del mensaje
                System.out.println("El paciente no existe");
            }
            ps.close();
        } catch (SQLException e) {
            //Parte grafica del mensaje
            System.out.println("Error al acceder a la tabla paciente");
        }
    }

    public void eliminarPaciente(int id) {
        try {
            String sql = "DELETE FROM paciente WHERE idPaciente = ? ";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int fila = ps.executeUpdate();

            if (fila == 1) {
                //Parte grafica del mensaje
            System.out.println("Borrado con exito");
            }
            ps.close();
        } catch (SQLException e) {
            //Parte grafica del mensaje
            System.out.println("Error al acceder a la tabla paciente");
        }
    } 
}
