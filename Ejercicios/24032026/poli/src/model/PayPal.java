package model;

public class PayPal extends MetodoPago {
    @Override
    public void procesar(double monto) {
        System.out.println("Redirigiendo a PayPal para cobrar $" + monto);
    }
}
