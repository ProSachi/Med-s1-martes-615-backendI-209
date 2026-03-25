package model;

public class TarjetaCredito extends MetodoPago {

    @Override
    public void procesar(double monto) {
        System.out.println("Cobrando $" + monto + " a la tarjeta VISA terminada en 1234");
    }

}
