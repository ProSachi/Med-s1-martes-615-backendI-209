package model;

public class Enfermero extends Persona {

    private String jerarquia;

    public Enfermero(String jerarquia) {
        this.jerarquia = jerarquia;
    }

    public Enfermero(String nombre, String documento, int edad, String jerarquia) {
        super(nombre, documento, edad);
        this.jerarquia = jerarquia;
    }

    public void historia() {
        System.out.println("El enfermero esta construyendo la historia");
    }

    public String getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(String jerarquia) {
        this.jerarquia = jerarquia;
    }

}