package model;

public class Medico extends Persona {

    private String especialidad;

    public Medico() {
    }

    public Medico(String especialidad, String nombre, String documento, int edad) {
        super(nombre, documento, edad);
        this.especialidad = especialidad;
    }

    public void diagnosticar(){
        System.out.println("El medico me esta revisando");
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    



}