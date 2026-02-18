package model;

public class Triangulo {
    private double base;
    private double altura;

    // CONSTRUCTOR
    // Responsabilidad: Asegurar el invariante al NACER.
    public Triangulo(double base, double altura) {
        // Si no validamos aquí, el objeto podría nacer "corrupto"
        setBase(base);
        setAltura(altura);
    }

    // SETTER (Mutator)
    // Responsabilidad: Asegurar el invariante al CAMBIAR.
    public void setBase(double base) {
        // Esta es la VALIDACIÓN que protege al INVARIANTE
        if (base > 0) {
            this.base = base;
        } else {
            System.out.println("Error: La base debe ser positiva. (Invariante protegido)");
        }
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            System.out.println("Error: La altura debe ser positiva. Invariante protegida");
        }
    }
}
