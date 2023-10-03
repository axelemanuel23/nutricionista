package accesoADatos;

import entidades.Dieta;
import entidades.Comida;
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
    public void crearDieta(Dieta dieta) {
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
                dieta.setPaciente(pacienteData.buscarPaciente(rs.getInt("idpaciente")));
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
                dieta.setPaciente(pacienteData.buscarPaciente(rs.getInt("idpaciente")));
                dieta.setFechaFinal(rs.getDate("fechaNacimiento").toLocalDate());
                dieta.setPesoInicial(rs.getInt("pesoinicial"));
                dieta.setMeta(rs.getInt("meta"));
                dieta.setPesoFinal(rs.getInt("pesofinal"));
                dieta.setFechaInicial(rs.getDate("fechainicial").toLocalDate());
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla Dieta");
        }
        return dietas;
    }
    
    public List<Comida> listarComidasDeDieta(int idDieta) {
        List<Comida> comidas = new ArrayList<>();
        Comida comida = new Comida();
        
        PacienteData pacienteData= new PacienteData();
        ComidaData cd = new ComidaData();
        try {
            String sql = "SELECT * FROM comidadieta WHERE iddieta = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,idDieta);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                comida = cd.buscarComida(rs.getInt("idcomida"));
                comidas.add(comida);
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al acceder a la tabla ComidaDieta");
        }
        return comidas;
    }
    
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
                dieta.setPaciente(pacienteData.buscarPaciente(rs.getInt("idpaciente")));
                dieta.setFechaFinal(rs.getDate("fechaNacimiento").toLocalDate());
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

    public void modificarDieta(Dieta dieta) {
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
            ps.setInt(8, dieta.getIdDieta());

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
}
