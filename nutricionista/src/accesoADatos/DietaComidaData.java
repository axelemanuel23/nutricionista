
package accesoADatos;

import entidades.DietaComida;
import entidades.Comida;
import entidades.Dieta;
import entidades.Paciente;
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
    
    
    /**
     * crearDietaComida
     * Recibe un objeto DietaComida y lo añade a la base de datos
     * @param dietaComida DietaComida
     */
    public void crearDietaComida(DietaComida dietaComida) {
        try{
            String sql = "SELECT * FROM dietacomida WHERE iddieta = ? AND idcomida = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dietaComida.getIdDieta());
            ps.setInt(2, dietaComida.getIdComida());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getInt("iddieta") == dietaComida.getIdDieta() && rs.getInt("idcomida") == dietaComida.getIdComida()){
                    System.out.println("Ya existe la relacion");
                }
                ps.close();
            }else{
                try{
                    String sql1 = "INSERT INTO dietacomida(iddieta, idcomida) VALUES (?, ?)";
                    PreparedStatement ps1 = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
                    ps1.setInt(1, dietaComida.getIdDieta());
                    ps1.setInt(2, dietaComida.getIdComida());
                    ps1.executeUpdate();
                    ResultSet rs1 = ps1.getGeneratedKeys();
                    if(rs1.next()){
                        System.out.println("Relacion añadida");
                    }
                    ps1.close();
                }catch(SQLException e){
                    System.out.println("Error al agregar la relacion, id: " + dietaComida.getIdDieta() + ", " + dietaComida.getIdComida());
                }
            }
        }catch(SQLException ex){
            System.out.println("Error al intentar conectarse con la base de datos");
        }
    }
    /**
     * buscarIdDietaComida
     * Buscar una relacion mediante la relacion
     * @param idDieta Entero - id de la dieta
     * @param idComida Entero - id de la comida
     * @return Entero - Si existe una dieta, devuelve el id.
     */
    public int buscarIdDietaComida(int idDieta, int idComida){
        int id = 0;
        try{
            String sql = "SELECT * FROM dietacomida WHERE iddieta = ? AND idcomida = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ps.setInt(2, idComida);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                id=rs.getInt("iddietacomida");
            }else{
                System.out.println("No existe");
            }
            
        }catch(SQLException ex){
            System.out.println("Error al conectarse a la base de datos");
        
        }

        return id;
    }
    /**
     * listarComidasXDieta
     * Lista las comidas de una dieta
     * @param idDieta Entero - id de la dieta
     * @return Lista de Comida
     */
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
    /**
     * caloriasXDieta
     * Calcula las cantidad de calorias por dieta sumando el atributo cantCalorias de cada Comida.
     * @param idDieta Entero - idDieta de la dieta a calcular
     * @return Entero - Suma de todas las calorias.
     */
    public int caloriasXDieta(int idDieta){
        List<Comida> comidas = listarComidasXDieta(idDieta);
        int calorias = 0;
        for(Comida comida:comidas){
            calorias += comida.getCantCalorias();
        }
        return calorias;
    }
    
    /**
     * modificarDietaComida
     * Modifica la relacion con sus nuevos valores
     * @param idDietaComida Entero - id de la dietacomida
     * @param idDieta Entero - id de la nueva dieta
     * @param idComida Entero - id de la nueva comida
     */
    public void modificarDietaComida(int idDietaComida, int idDieta, int idComida) {
        try{
            String sql = "UPDATE dietacomida SET iddieta = ?, idcomida = ? WHERE iddieta = ? AND idcomida = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ps.setInt(2, idComida);
            ps.setInt(3, idDietaComida);
            int filas = ps.executeUpdate();
            
            if(filas == 1){
                System.out.println("Actualizado con exito");
            }else{
                System.out.println("Hubo un problema");
            }
            ps.close();
        }catch(SQLException ex){
            System.out.println("Error en la base de datos");
            System.out.println("Actualizando");
        }
    }
    /**
     * eliminarDietaComida
     * Elimiar una relacion del registro
     * @param idDietaComida Entero - id de la dietacomida
     */
    public void eliminarDietaComida(int idDietaComida) {
        try{
            String sql = "DELETE FROM dietacomida WHERE iddietacomida = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDietaComida);
            int filas = ps.executeUpdate();
            
            if(filas >= 1){
//                System.out.println("Eliminado con exito");
            }else{
                System.out.println("Hubo un problema");
            }
            ps.close();
        }catch(SQLException ex){
            System.out.println("Error en la base de datos");
        }
    }
    public void eliminarRelacionesXidDieta(int idDieta) {
        try{
            String sql = "DELETE FROM dietacomida WHERE iddieta = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);

            int filas = ps.executeUpdate();
            System.out.println(filas);
////            if(filas == 1){
////                System.out.println("Eliminado con exito");
////            }else{
////                System.out.println("Hubo un problema");
////            }
            ps.close();
        }catch(SQLException ex){
            System.out.println("Error en la base de datos");
        }
    }
    public void eliminarRelacionesXidComida(int idComida) {
        try{
            String sql = "DELETE FROM dietacomida WHERE idcomida = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idComida);
            ResultSet Relaciones = ps.executeQuery();
            while(Relaciones.next()){
                System.out.println(Relaciones.getInt("iddietacomida"));
            }
//            int filas = ps.executeUpdate();
//            
//            if(filas == 1){
//                System.out.println("Eliminado con exito");
//            }else{
//                System.out.println("Hubo un problema");
//            }
            ps.close();
        }catch(SQLException ex){
            System.out.println("Error en la base de datos");
        }
    }
    /**
     * listarPacientesExitosos
     * Lista de Pacientes que han finalizado con exito su dieta
     * @return Lista de Pacientes
     */
    public List<Paciente> listarPacientesExitosos(){
        List<Paciente> pacientes = new ArrayList<>();
        List<Dieta> dietasExitosas = new ArrayList<>();
        
        DietaData dd = new DietaData();
        
        dietasExitosas = dd.listarDietasExitosas();
        for(Dieta dieta : dietasExitosas){
            pacientes.add(dieta.getPaciente());
        }
        return pacientes;
    }
    /**
     * listarPacientesSinExito
     * Lista de Pacientes que han finalizado sin exito su dieta
     * @return Lista de Pacientes
     */
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
    
    /**
     * listarComidasDeDieta
     * Lista las Comidas de una determinada Dieta
     * @param idDieta Entero - id de la Dieta
     * @return Lista de Comidas
     */
    public List<Comida> listarComidasDeDieta(int idDieta) {
        List<Comida> comidas = new ArrayList<>();
        Comida comida = new Comida();
        
        ComidaData cd = new ComidaData();
        try {
            String sql = "SELECT * FROM dietacomida WHERE iddieta = ?";
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
    public List<Comida> listarComidasNoDieta(int idDieta) {
        List<Comida> comidas = new ArrayList<>();
        Comida comida = new Comida();
        
        ComidaData cd = new ComidaData();
        try {
            String sql = "SELECT * FROM comida WHERE idcomida NOT IN ( SELECT idcomida FROM dietacomida WHERE iddieta = ?)";
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
}
