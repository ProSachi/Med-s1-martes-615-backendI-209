package model;

public abstract class Reporte {

    protected String nombre;

    public Reporte() {
    }

    public Reporte(String nombre) {
        this.nombre = nombre;
    }

    public abstract void prepararCabecera();
    
    
}
