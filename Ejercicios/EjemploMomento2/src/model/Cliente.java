package model;

public class Cliente extends Usuario {
    private int puntosFidelidad;

    public Cliente(int id, String nombre, String correo, int puntosFidelidad) {
        super(id, nombre, correo);
        this.puntosFidelidad = puntosFidelidad;
    }

    public int getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public void setPuntosFidelidad(int puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    @Override
    public String getRol() {
        return "Cliente";
    }

    @Override
    public String resumen() {
        return super.resumen() + " | Puntos: " + puntosFidelidad;
    }
}
