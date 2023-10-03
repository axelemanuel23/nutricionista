/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nutricionista;

import accesoADatos.PacienteData;
import accesoADatos.DietaData;
import accesoADatos.ComidaData;
import entidades.Paciente;
import entidades.Comida;
import entidades.Dieta;
import java.time.LocalDate;
import java.time.Month;

public class Nutricionista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //------------------------------------
        //Pruebas Paciente
        Paciente p1 = new Paciente("Roberto Rodriguez", 12345678, "Avenida Siempre Viva", "+5412345678");
        Paciente p2 = new Paciente("Edgardo Perez", 12345678, "Avenida Siempre Viva", "+5412345678");
        Paciente p3 = new Paciente("Martin Nuñez", 98765432, "Avenida Siempre Viva", "+5412345678");
        System.out.println(p1.toString());
        //Pruebas PacienteData
        PacienteData pd = new PacienteData();
        pd.crearPaciente(p2);
        
        //------------------------------------
        //------------------------------------
        //Pruebas Comida
        Comida c1 = new Comida("Ensalada de Papas","Mezcla de papas y algo mas",400);
        Comida c2 = new Comida("Ensalada de Arroz","Mezcla de arroz y algo mas",300);
        Comida c3 = new Comida("Ensalada de Lechuga","Mezcla de lechuga y algo mas",200);
        Comida c4 = new Comida("Pollo Frito","Mezcla de papas y algo mas",500);
        System.out.println(c3.toString());
        //Pruebas ComidaData
        ComidaData cd = new ComidaData();
        cd.guardarComida(c3);
        cd.guardarComida(c4);
        cd.guardarComida(c3);
        
        //------------------------------------
        //------------------------------------
        //Pruebas Dieta
        Dieta d1 = new Dieta("Dieta Ensalada",p1,LocalDate.of(2023, Month.OCTOBER, 1),80,70,75,LocalDate.of(2023, Month.OCTOBER, 3));
        DietaData dd = new DietaData();
        //Pruebas DietaData
        dd.crearDieta(d1);
//------------------------------------
    }
    
}
