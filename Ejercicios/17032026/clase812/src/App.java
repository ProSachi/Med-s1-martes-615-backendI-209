import model.Cuenta;
import model.CuentaAhorro;
import model.CuentaCorriente;

public class App {
    public static void main(String[] args) throws Exception {
        
        Cuenta juan = new CuentaAhorro();
        CuentaAhorro pedro = new CuentaAhorro();
        CuentaCorriente luis = new CuentaCorriente();

        pedro.consultarSaldo();
        luis.consultarSaldo();
        juan.consultarSaldo();

    }
}
