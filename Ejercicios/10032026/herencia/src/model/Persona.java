package model;

public class Persona {
    
    private String nombre;
    private String documento;
    private int edad;

    public Persona() {
    }

    public Persona(String nombre, String documento, int edad) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
    }

    public void caminar(){
        System.out.println("Este viene desde la super clase");
    }

    public String correr(){
        return "Esta corriendo";
    }
    
     public Integer volar(){
        return 30;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }



}
