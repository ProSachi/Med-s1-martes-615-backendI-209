package model;

public class Perro {
    public Perro(String raza, String color, String nombre, double peso) {
        this.raza = raza;
        this.color = color;
        this.nombre = nombre;
        this.peso = peso;
    }

    private String raza;
    private String color;
    private String nombre;
    private double peso;
    private int edad;

    // Constructor vacio
    public Perro() {
    }

    // Constructo con argumentos
    public Perro(String raza, String color, String nombre, double peso, int edad) {
        this.raza = raza;
        this.color = color;
        this.nombre = nombre;
        setPeso(peso);
        this.edad = edad;
    }

    // Constructor con varios argumentos, no todos.

    public void llamar() {
        System.out.println("Llamando al perro");
        System.out.println("El perro viene");
    }

    public String ladrar() {
        String ladrando = "El perro esta ladrando";
        return ladrando;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso >= 0 && peso < 50) {
            this.peso = peso;
        } else {
            System.out.println("El peso no es correcto");
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
