
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
        Paciente p1 = new Paciente("Roberto Rodriguez", 64575667, "Avenida Siempre Viva", "+5412345678");
        Paciente p2 = new Paciente("Edgardo Perez", 45645645, "Avenida Siempre Viva", "+5412345678");
        Paciente p3 = new Paciente("Martin Nuñez", 98765432, "Avenida Siempre Viva", "+5412345678");
        Paciente p4 = new Paciente("Luciano Pereyra", 124675678, "Avenida Siempre Viva", "+5412345678");
        Paciente p5 = new Paciente("Martina Quiroga", 987654432, "Avenida Siempre Viva", "+5412345678");
        //Pruebas PacienteData
        PacienteData pd = new PacienteData();
        pd.crearPaciente(p1);
        p1.setIdPaciente(pd.buscarPacienteXDNI(p1.getDni()).getIdPaciente());
        System.out.println(p1.toString());
        pd.crearPaciente(p2);
        pd.crearPaciente(p3);
        pd.crearPaciente(p4);
        pd.crearPaciente(p5);
        Paciente pM = pd.buscarPacienteXDNI(p2.getDni());
        // ABM de la clase Paciente (PacienteData) y pruebas desde el main
        pM.setNombre("Luciana Robles");
        pd.modificarPaciente(2,pM);
        //pd.eliminarPaciente(pd.buscarPacienteXDNI(p6.getDni()).getIdPaciente());
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
        //Pruebas ComidaData
        ComidaData cd = new ComidaData();
        cd.guardarComida(c1);
        c1.setIdComida(cd.buscarComida(c1.getNombre()).getIdComida());
        System.out.println(c3.toString());
        cd.guardarComida(c2);
        c2.setIdComida(cd.buscarComida(c2.getNombre()).getIdComida());
        cd.guardarComida(c3);
        c3.setIdComida(cd.buscarComida(c3.getNombre()).getIdComida());
        cd.guardarComida(c4);
        cd.guardarComida(c5);
        cd.guardarComida(c6);
        System.out.println("Lista todas las comidas");
        for(Comida comida: cd.listarComida()){
            System.out.println(comida.toString());
        };
        
        //Consultar la búsqueda de comidas que tengan una cantidad menor de un determinado número de calorías:
        System.out.println("Lista todas las comidas que tengan un maximo de 300 calorias");
        for (Comida comida : cd.buscarCaloriasMax(300)) {
            System.out.println(comida.toString());
        }
        System.out.println("Lista todas las comidas que tengan como minimo 300 calorias");
        for (Comida comida : cd.buscarCaloriasMin(300)) {
            System.out.println(comida.toString());
        }
        //------------------------------------
        //------------------------------------
        //Pruebas Dieta
        Paciente pa1 = pd.buscarPacienteXDNI(p3.getDni());
        Paciente pa2 = pd.buscarPacienteXDNI(p4.getDni());
        Dieta d1 = new Dieta("Dieta Ensalada Verdes",pa1,LocalDate.of(2023, Month.OCTOBER, 1),80,70,75,LocalDate.of(2023, Month.OCTOBER, 3));
        System.out.println("Ha finalizado la dieta?: " + d1.finalizado());
        System.out.println("Ha cumplido la meta?:" + d1.metaCumplida());
        Dieta d2 = new Dieta("Dieta Proteinas Muscular",pa2,LocalDate.of(2023, Month.OCTOBER, 1),80,90,90,LocalDate.of(2023, Month.OCTOBER, 3));
        System.out.println("Ha finalizado la dieta?: " + d2.finalizado());
        System.out.println("Ha cumplido la meta?:" + d2.metaCumplida());
        
        //Pruebas DietaData
        DietaData dd = new DietaData();
        dd.crearDieta(d1);
        d1.setIdDieta(dd.buscarDieta(d1.getNombre()).getIdDieta());
        dd.crearDieta(d2);
        System.out.println(d1.toString());
        System.out.println(d2.toString());
        //------------------------------------
        //------------------------------------
        //Pruebas DietaComida
        // La d1 del paciente pa1 incluye todas las ensalada        
        //los id quedan e 0
        DietaComida dc1 = new DietaComida(d1.getIdDieta(),c1.getIdComida());//segun el uml recibe como parametro los objetos Dieta y Comida
        /*
        No parece eficiente asignar Objeto Comida y Objeto Dieta al Objeto DietaComida; si una Dieta tiene 4 Comida habria 4 Objetos DietaComida con una copia del Objeto Dieta.
        En cualquier caso con el id podemos traer esos objetos.
        */
        DietaComida dc2 = new DietaComida(d1.getIdDieta(),c2.getIdComida());
        DietaComidaData dCData = new DietaComidaData();
        dCData.crearDietaComida(dc1);
        dCData.crearDietaComida(dc2);
        // La d2 del paciente pa2 incluye todas las proteinas
        //dCData.modificarDietaComida(12,1, 12,4);
        
        //saber las comidas incluidas en una dieta específica y agregar o borrar comidas a una Dieta:
        System.out.println("En la dieta -" + d2.getNombre() + "- :");
        List<Comida> comidas = dCData.listarComidasXDieta(d1.getIdDieta());
        for (Comida comida : comidas ) {
            System.out.println(comida.toString());
        }
        DietaComida dc6= new DietaComida(28,10);
        //dCData.eliminarDietaComida(12,4);
        
        
        
        //------------------------------------
    }
    
}
