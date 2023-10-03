/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nutricionista;

import accesoADatos.PacienteData;
import entidades.Paciente;

public class Nutricionista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //------------------------------------
        //Pruebas Paciente
        Paciente p1 = new Paciente("Roberto Raul", 12345678, "Avenida Siempre Viva", "+5412345678");
        System.out.println(p1.toString());
        PacienteData pd = new PacienteData();
        pd.crearPaciente(p1);
        
        //------------------------------------
    }
    
}
