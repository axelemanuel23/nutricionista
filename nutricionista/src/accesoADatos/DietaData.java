package accesoADatos;

import entidades.Dieta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DietaData {
    private Connection con = null;
    public DietaData() {
        con = Conexion.getConexion();
    }
    /**
     * crearDieta
     * Crea una dieta en la base de datos
     * @param dieta Dieta - Objeto a guardar
     */
    public void crearDieta(Dieta dieta) {
        try {
            String sql1 = "SELECT * FROM dieta WHERE idpaciente = ?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, dieta.getPaciente().getIdPaciente());
            ps1.setString(2, dieta.getNombre());

            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {
                System.out.println("Ya existe la dieta");
            } else {
                try {
                    String sql = "INSERT INTO dieta(nombre, idpaciente, fechainicial, pesoinicial,meta, pesofinal, fechafinal) VALUES (?,?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, dieta.getNombre());
                    ps.setInt(2, dieta.getPaciente().getIdPaciente());
                    ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
                    ps.setDouble(4, dieta.getPesoInicial());
                    ps.setDouble(5, dieta.getMeta());
                    ps.setDouble(6, dieta.getPesoFinal());
                    ps.setDate(7, Date.valueOf(dieta.getFechaFinal()));
                    ps.executeUpdate();
                    ResultSet rs = ps.getGeneratedKeys();

                    if (rs.next()) {
                        System.out.println("Dieta añadida con exito");
                    }
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("Error al acceder a la tabla Dieta");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error en la base de datos");
        }
    }
    /**
     * buscarDieta
     * Busca una dieta por su id
     * @param id Entero - id de la Dieta
     * @return Dieta
     */
    public Dieta buscarDieta(int id) {
        Dieta dieta = null;

        try {
            String sql = "SELECT nombre, idpaciente, fechainicial, pesoinicial,meta, pesofinal, fechafinal FROM dieta WHERE iddieta = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            PacienteData pacienteData= new PacienteData();
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dieta = new Dieta();
                dieta.setIdDieta(id);
                dieta.setNombre(rs.getString("nombre"));
                dieta.setPaciente(pacienteData.buscarPacienteXDNI(rs.getInt("idpaciente")));
                dieta.setFechaFinal(rs.getDate("fechaNacimiento").toLocalDate());
                dieta.setPesoInicial(rs.getInt("pesoinicial"));
                dieta.setMeta(rs.getInt("meta"));
                dieta.setPesoFinal(rs.getInt("pesofinal"));
                dieta.setFechaInicial(rs.getDate("fechainicial").toLocalDate());
                
            } else {
                System.out.println("No existe la Dieta");
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Dieta" );
        }
        return dieta;
    }
    /**
     * buscarDieta
     * Busca una dieta por su nombre
     * @param nombre String - nombre de la Dieta
     * @return Dieta
     */
    public Dieta buscarDieta(String nombre) {
        Dieta dieta = null;

        try {
            String sql = "SELECT iddieta, nombre, idpaciente, fechainicial, pesoinicial,meta, pesofinal, fechafinal FROM dieta WHERE nombre = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            PacienteData pacienteData= new PacienteData();
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dieta = new Dieta();
                dieta.setIdDieta(rs.getInt("iddieta"));
                dieta.setNombre(rs.getString("nombre"));
                dieta.setPaciente(pacienteData.buscarPacienteXDNI(rs.getInt("idpaciente")));
                dieta.setFechaFinal(rs.getDate("fechaNacimiento").toLocalDate());
                dieta.setPesoInicial(rs.getInt("pesoinicial"));
                dieta.setMeta(rs.getInt("meta"));
                dieta.setPesoFinal(rs.getInt("pesofinal"));
                dieta.setFechaInicial(rs.getDate("fechainicial").toLocalDate());
                
            } else {
                System.out.println("No existe la Dieta");
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Dieta" );
        }
        return dieta;
    }
    /**
     * listarDietas
     * Lista todas las Dietas
     * @return Lista de Dietas
     */
    public List<Dieta> listarDietas() {
        List<Dieta> dietas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dieta";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            PacienteData pacienteData= new PacienteData();

            while (rs.next()) {
                Dieta dieta = new Dieta();
                dieta.setIdDieta(rs.getInt("iddieta"));
                dieta.setNombre(rs.getString("nombre"));
                dieta.setPaciente(pacienteData.buscarPacienteXID(rs.getInt("idpaciente")));
                dieta.setFechaFinal(rs.getDate("fechafinal").toLocalDate());
                dieta.setPesoInicial(rs.getInt("pesoinicial"));
                dieta.setMeta(rs.getInt("meta"));
                dieta.setPesoFinal(rs.getInt("pesofinal"));
                dieta.setFechaInicial(rs.getDate("fechainicial").toLocalDate());
                dietas.add(dieta);
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Dieta");
        }
        return dietas;
    }
    
    /**
     * listarDietasSinExito
     * Lista de dietas que han finalizado y los pacientes NO han llegado a la meta
     * @return Lista de Dietas
     */
    public List<Dieta> listarDietasSinExito() {
        List<Dieta> dietas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dieta";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            PacienteData pacienteData= new PacienteData();

            while (rs.next()) {
                Dieta dieta = new Dieta();
                dieta.setIdDieta(rs.getInt("iddieta"));
                dieta.setNombre(rs.getString("nombre"));
                dieta.setPaciente(pacienteData.buscarPacienteXID(rs.getInt("idpaciente")));
                dieta.setFechaFinal(rs.getDate("fechafinal").toLocalDate());
                dieta.setPesoInicial(rs.getInt("pesoinicial"));
                dieta.setMeta(rs.getInt("meta"));
                dieta.setPesoFinal(rs.getInt("pesofinal"));
                dieta.setFechaInicial(rs.getDate("fechainicial").toLocalDate());
                if(!dieta.metaCumplida()){
                    dietas.add(dieta);
                }
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Dieta");
        }
        return dietas;
    }
    /**
     * listarDietasExitosas
     * Lista de dietas que han finalizado y los pacientes han llegado a la meta
     * @return Lista de Dietas
     */
    public List<Dieta> listarDietasExitosas() {
        List<Dieta> dietas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dieta";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            PacienteData pacienteData= new PacienteData();

            while (rs.next()) {
                Dieta dieta = new Dieta();
                dieta.setIdDieta(rs.getInt("iddieta"));
                dieta.setNombre(rs.getString("nombre"));
                dieta.setPaciente(pacienteData.buscarPacienteXID(rs.getInt("idpaciente")));
                dieta.setFechaFinal(rs.getDate("fechafinal").toLocalDate());
                dieta.setPesoInicial(rs.getInt("pesoinicial"));
                dieta.setMeta(rs.getInt("meta"));
                dieta.setPesoFinal(rs.getInt("pesofinal"));
                dieta.setFechaInicial(rs.getDate("fechainicial").toLocalDate());
                if(dieta.metaCumplida()){
                    dietas.add(dieta);
                }
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Dieta");
        }
        return dietas;
    }
    /**
     * modificarDieta
     * Modificar una dieta ubicada por id por un nuevo ojeto Dieta
     * @param idDieta Entero - id de la dieta a modificar
     * @param dieta Dieta - Objeto de reemplazo
     */
    public void modificarDieta(int idDieta, Dieta dieta) {
        try {
            String sql = "UPDATE dieta SET nombre=?,idpaciente=?,fechainicial=?,pesoinicial=?,meta=?,pesofinal=?,fechafinal=? WHERE iddieta = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, dieta.getNombre());
            ps.setInt(2, dieta.getPaciente().getIdPaciente());
            ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
            ps.setDouble(4,dieta.getPesoInicial());
            ps.setDouble(5,dieta.getMeta());
            ps.setDouble(6,dieta.getPesoFinal());
            ps.setDate(7, Date.valueOf(dieta.getFechaFinal()));
            ps.setInt(8, idDieta);

            int exito = ps.executeUpdate();

            if (exito == 1) {
                System.out.println("Modificacion con exito");
            } else {
                System.out.println("La Dieta no exite");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Dieta");
        }
    }
    /**
     * eliminarDieta
     * Elimina un registro de la base de datos
     * @param id Entero - id del registro a eliminar
     */
    public void eliminarDieta(int id) {
        try {
            String sql = "DELETE FROM dieta WHERE iddieta = ? ";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int fila = ps.executeUpdate();

            if (fila == 1) {
                System.out.println("Se elimino con exito");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Dieta");
        }
    } 
    
    public Dieta buscarDietaXPaciente(int idPaciente) {
        Dieta dieta = null;

        try {
            String sql = "SELECT iddieta, nombre, fechainicial, pesoinicial,meta, pesofinal, fechafinal FROM dieta WHERE idpaciente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            PacienteData pacienteData= new PacienteData();
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dieta = new Dieta();
                dieta.setIdDieta(rs.getInt("iddieta"));
                dieta.setNombre(rs.getString("nombre"));
                dieta.setPaciente(pacienteData.buscarPacienteXID(idPaciente));
                dieta.setFechaFinal(rs.getDate("fechafinal").toLocalDate());
                dieta.setPesoInicial(rs.getInt("pesoinicial"));
                dieta.setMeta(rs.getInt("meta"));
                dieta.setPesoFinal(rs.getInt("pesofinal"));
                dieta.setFechaInicial(rs.getDate("fechainicial").toLocalDate());
                
            } else {
                System.out.println("No existe la Dieta");
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Dieta" );
        }
        return dieta;
    }
}
