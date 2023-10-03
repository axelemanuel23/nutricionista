
package nutricionista;

import accesoADatos.PacienteData;
import accesoADatos.DietaData;
import accesoADatos.ComidaData;
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
        System.out.println(p1.toString());
        //Pruebas PacienteData
        PacienteData pd = new PacienteData();
        pd.crearPaciente(p1);
        pd.crearPaciente(p2);
        pd.crearPaciente(p3);
        Paciente p4 = pd.buscarPaciente(12345678);
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
        
        for(Comida comida: cd.listarComida()){
            System.out.println(comida.toString());
        };
        //------------------------------------
        //------------------------------------
        //Pruebas Dieta
        Dieta d1 = new Dieta("Dieta Ensalada",p4,LocalDate.of(2023, Month.OCTOBER, 1),80,70,75,LocalDate.of(2023, Month.OCTOBER, 3));
        System.out.println(d1.finalizado());
        System.out.println(d1.metaCumplida());
        //Pruebas DietaData
        DietaData dd = new DietaData();
        dd.crearDieta(d1);
        //------------------------------------
        //------------------------------------
        //Pruebas DietaComida
        DietaComida dc1 = new DietaComida(d1.getIdDieta(),c1.getIdComida());
        //------------------------------------
    }
    
}
