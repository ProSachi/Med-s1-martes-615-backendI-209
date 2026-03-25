import java.util.ArrayList;
import java.util.List;

import model.Disenador;
import model.Empleado;
import model.Programador;
import model.Talento;

public class App {
    public static void main(String[] args) throws Exception {

        // 1. La Lista Genérica (El poder del Polimorfismo)
        // Acepta a cualquier objeto que "SEA UN" Empleado
        List<Empleado> nomina = new ArrayList<>();
        /*
         * Empleado pago1 = new Empleado();
         * Empleado pago2 = new Disenador();
         * Empleado pago3 = new Programador();
         */
        // 2. Upcasting automático al agregar a la lista
        nomina.add(new Empleado());
        nomina.add(new Disenador());
        nomina.add(new Programador());
        nomina.add(new Talento());

        // 3. Ejecución Polimórfica
        System.out.println("--- INICIANDO JORNADA LABORAL ---");
        for (Empleado persona : nomina) {
            persona.trabajar();
        }
    }
}
