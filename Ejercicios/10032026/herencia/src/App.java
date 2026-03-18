import model.Enfermero;
import model.Medico;
import model.Paciente;

public class App {
    public static void main(String[] args) throws Exception {

        // Objeto Medico
        System.out.println("Medico \n");
        Medico primerMedico = new Medico("Cardiologia", "Roman", "1010", 25);
        primerMedico.diagnosticar();
        primerMedico.caminar();
        System.out.println(primerMedico.correr());

        // Objeto enfermero
System.out.println("Enfermero \n");
        Enfermero primerEnfermero = new Enfermero("Santiago", "2020", 40, "Basiquito");
        primerEnfermero.caminar();
        primerEnfermero.correr();
        primerEnfermero.historia();

        // Objeto de paciente
System.out.println("Paciente \n");
        Paciente primerPaciente = new Paciente("Tatiana", "3030", 21, "Asiste a clase pero no presenta el trabajo");

        primerPaciente.caminar();
        System.out.println(primerPaciente.correr());
        primerPaciente.esperar();

    }
}
