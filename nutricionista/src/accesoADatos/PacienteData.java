
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
    /**
     * crearPaciente
     * Crea un paciente en la base de datos
     * @param paciente Paciente - Objeto a guardar
     */
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
                        paciente.setIdPaciente(buscarPacienteXDNI(paciente.getDni()).getIdPaciente());
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
    /**
     * buscarPacienteXDNI
 Busca un paciente por su dni
     * @param dni Entero - DNI del paciente
     * @return Paciente
     */
    public Paciente buscarPacienteXDNI(int dni) {
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
    
        public Paciente buscarPacienteXID(int idPaciente) {
        Paciente paciente = null;

        try {
            String sql = "SELECT * FROM paciente WHERE idpaciente = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);

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
    
    /**
     * listarPacientes
     * Lista de todos los pacientes
     * @return Lista de Pacientes
     */
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
    
    public List<Paciente> listarPacientesActivos() {
        List<Paciente> pacientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM paciente WHERE estado = true";
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
    
     public List<Paciente> listarPacientesInactivos() {
        List<Paciente> pacientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM paciente WHERE estado = false";
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
     /**
      * modificarPaciente
      * Modificar un Paciente ubicandolo por su id y reemplazandolo con un objeto nuevo
      * @param idPaciente Entero - id del Pacinte a reemplazar
      * @param paciente Paciente - Nuevo objeto
      */
    public void modificarPaciente(int idPaciente, Paciente paciente) {
        try {
            String sql = "UPDATE paciente SET dni = ? , nombre = ?, domicilio = ?, telefono = ? WHERE idPaciente = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, paciente.getDni());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getDomicilio());
            ps.setString(4, paciente.getTelefono());
            ps.setInt(5, idPaciente);

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
    /**
     * darBajaPaciente
     * Modifica el estado del paciente para no tener que eliminarlo de la base de datos
     * @param id Entero - id del paciente a dar de baja
     */
    public void darBajaPaciente(int id) {
        try {
            String sql = "UPDATE paciente SET estado = ? WHERE idPaciente = ? ";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setBoolean(1, false);
            ps.setInt(2, id);

            int fila = ps.executeUpdate();

            if (fila == 1) {
                //Parte grafica del mensaje
            System.out.println("Actualizado con exito");
            }
            ps.close();
        } catch (SQLException e) {
            //Parte grafica del mensaje
            System.out.println("Error al acceder a la tabla paciente");
        }
    } 
    
    public void reactivarPaciente(int id) {
        try {
            String sql = "UPDATE paciente SET estado = ? WHERE idPaciente = ? ";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setBoolean(1, true);
            ps.setInt(2, id);

            int fila = ps.executeUpdate();

            if (fila == 1) {
                //Parte grafica del mensaje
            System.out.println("Se ha reactivado con exito");
            }
            ps.close();
        } catch (SQLException e) {
            //Parte grafica del mensaje
            System.out.println("Error al acceder a la tabla paciente");
        }
    } 
    /**
     * eliminarPaciente
     * Elimina un paciente de la base de datos
     * @param id Entero - id del Paciente a eliminar
     */
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
