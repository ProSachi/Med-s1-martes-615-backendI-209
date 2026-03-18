package model;

public class Paciente extends Persona {

    private String historia;

    public Paciente(String historia) {
        this.historia = historia;
    }

    public Paciente(String nombre, String documento, int edad, String historia) {
        super(nombre, documento, edad);
        this.historia = historia;
    }

        public void esperar(){
        System.out.println("El paciente esta esperando en la sala de espera");
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

}