
package accesoADatos;

import entidades.DietaComida;
import entidades.Comida;
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
            String sql = "DELETE FROM dietacomida WHERE AND iddietacomida = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDietaComida);
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
