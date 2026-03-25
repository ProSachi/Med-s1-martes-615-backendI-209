package model;

public class Talento extends Empleado {
    @Override
    public void trabajar() {
        System.out.println("El empleado trabaja contratando nuevos empleados.");
    }
}
