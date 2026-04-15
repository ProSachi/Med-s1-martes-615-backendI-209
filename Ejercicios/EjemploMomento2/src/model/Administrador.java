package model;

public class Administrador extends Usuario {
    private int nivelAcceso;

    public Administrador(int id, String nombre, String correo, int nivelAcceso) {
        super(id, nombre, correo);
        this.nivelAcceso = nivelAcceso;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    @Override
    public String getRol() {
        return "Administrador";
    }

    @Override
    public String resumen() {
        return super.resumen() + " | Nivel acceso: " + nivelAcceso;
    }
}
