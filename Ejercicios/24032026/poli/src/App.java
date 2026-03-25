import model.MetodoPago;
import model.PayPal;
import model.TarjetaCredito;

public class App {
    public static void main(String[] args) throws Exception {
       
        MetodoPago pago1 = new MetodoPago();
        MetodoPago pago2 = new TarjetaCredito();
        MetodoPago pago3 = new PayPal();


        pago1.procesar(20);
        pago2.procesar(100);
        pago3.procesar(200);


    }
}
