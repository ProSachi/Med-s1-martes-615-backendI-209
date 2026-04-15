package model;

public abstract class EntidadBancaria {
    // 1. Atributos normales permitidos
    protected String titular;
    
    // 2. Constructor permitido (solo invocable vía super())
    public EntidadBancaria(String titular) {
        this.titular = titular;
    }
    
    // 3. Método normal con cuerpo permitido
    public void imprimirComprobante() {
        System.out.println("Comprobante a nombre de: " + titular);
    }

        public abstract void mostrarSaldo();
}

