
package nutricionista;

import accesoADatos.PacienteData;
import accesoADatos.DietaData;
import accesoADatos.ComidaData;
import accesoADatos.DietaComidaData;
import entidades.Paciente;
import entidades.Comida;
import entidades.Dieta;
import entidades.DietaComida;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Nutricionista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //------------------------------------
        //Pruebas Paciente
        Paciente p1 = new Paciente("Roberto Rodriguez", 12345678, "Avenida Siempre Viva", "+5412345678");
        Paciente p2 = new Paciente("Edgardo Perez", 45645645, "Avenida Siempre Viva", "+5412345678");
        Paciente p3 = new Paciente("Martin Nuñez", 98765432, "Avenida Siempre Viva", "+5412345678");
        Paciente p4 = new Paciente("Luciano Pereyra", 124675678, "Avenida Siempre Viva", "+5412345678");
        Paciente p5 = new Paciente("Martina Quiroga", 987654432, "Avenida Siempre Viva", "+5412345678");
        System.out.println(p1.toString());
        //Pruebas PacienteData
        PacienteData pd = new PacienteData();
        pd.crearPaciente(p1);
        pd.crearPaciente(p2);
        pd.crearPaciente(p3);
        pd.crearPaciente(p4);
        pd.crearPaciente(p5);
        Paciente pM = pd.buscarPaciente(p2.getDni());
        // ABM de la clase Paciente (PacienteData) y pruebas desde el main
        pM.setNombre("Luciana Robles");
        pd.modificarPaciente(pM);
        //pd.eliminarPaciente(pd.buscarPaciente(p6.getDni()).getIdPaciente());
        //Lista de Pacientes
        List<Paciente> pacientes = pd.listarPacientes();
        //------------------------------------
        //------------------------------------
        //Pruebas Comida
        Comida c1 = new Comida("Ensalada de Papas","Mezcla de papas y algo mas",400);
        Comida c2 = new Comida("Ensalada de Arroz","Mezcla de arroz y algo mas",300);
        Comida c3 = new Comida("Ensalada de Lechuga","Mezcla de lechuga y algo mas",200);
        Comida c4 = new Comida("Pechuga de pollo","Carne",500);
        Comida c5 = new Comida("Chuleta de Cerdo","Carne",700);
        Comida c6 = new Comida("Yogurt","Alimento Lacteo",300);
        System.out.println(c3.toString());
        //Pruebas ComidaData
        ComidaData cd = new ComidaData();
        cd.guardarComida(c1);
        cd.guardarComida(c2);
        cd.guardarComida(c3);
        cd.guardarComida(c4);
        cd.guardarComida(c5);
        cd.guardarComida(c6);
        System.out.println("Lista todas las comidas");
        for(Comida comida: cd.listarComida()){
            System.out.println(comida.toString());
        };
        
        //Consultar la búsqueda de comidas que tengan una cantidad menor de un determinado número de calorías:
        System.out.println("Lista todas las comidas con mayor caloria");
        for (Comida comida : cd.buscarCaloriasMax(300)) {
            System.out.println(comida.toString());
        }
        System.out.println("Lista todas las comidas con menor caloria");
        for (Comida comida : cd.buscarCaloriasMin(300)) {
            System.out.println(comida.toString());
        }
        //------------------------------------
        //------------------------------------
        //Pruebas Dieta
        Paciente pa1 = pd.buscarPaciente(p1.getDni());
        Paciente pa2 = pd.buscarPaciente(p2.getDni());
        Dieta d1 = new Dieta("Dieta Ensalada",pa1,LocalDate.of(2023, Month.OCTOBER, 1),80,70,75,LocalDate.of(2023, Month.OCTOBER, 3));
        System.out.println("Ha finalizado la dieta?: " + d1.finalizado());
        System.out.println("Ha cumplido la meta?:" + d1.metaCumplida());
        Dieta d2 = new Dieta("Dieta Proteinas",pa2,LocalDate.of(2023, Month.OCTOBER, 1),80,90,90,LocalDate.of(2023, Month.OCTOBER, 3));
        System.out.println("Ha finalizado la dieta?: " + d2.finalizado());
        System.out.println("Ha cumplido la meta?:" + d2.metaCumplida());
        
        //Pruebas DietaData
        DietaData dd = new DietaData();
        dd.crearDieta(d1);
        dd.crearDieta(d2);
        //------------------------------------
        //------------------------------------
        //Pruebas DietaComida
        // La d1 del paciente pa1 incluye todas las ensalada        
        //los id quedan e 0
        DietaComida dc1 = new DietaComida(d1.getIdDieta(),c1.getIdComida());//segun el uml recibe como parametro los objetos Dieta y Comida
        DietaComida dc2 = new DietaComida(d1.getIdDieta(),c2.getIdComida());
        DietaComidaData dCData = new DietaComidaData();
        dCData.crearDietaComida(dc1);
        dCData.crearDietaComida(dc2);
        // La d2 del paciente pa2 incluye todas las proteinas     
        DietaComida dc4 = new DietaComida(28,2);
        DietaComida dc5 = new DietaComida(28,7);
        dCData.crearDietaComida(dc4);
        dCData.crearDietaComida(dc5);
        
        //saber las comidas incluidas en una dieta específica y agregar o borrar comidas a una Dieta:
        System.out.println("En la dieta " + d2.getNombre() + ":");
        for (Comida c : dCData.listarComidasXDieta(28)) {
            System.out.println(c.getNombre());
        }
        DietaComida dc6= new DietaComida(28,10);
        dCData.crearDietaComida(dc6);
        dCData.eliminarDietaComida(28, 10);
        
        
        
        //------------------------------------
    }
    
}
