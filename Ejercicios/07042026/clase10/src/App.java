import model.Circulo;
import model.Figura;
import model.Triangulo;

public class App {
    public static void main(String[] args) throws Exception {

        Figura paco = new Circulo("azul", "Paco El circulo", 3);
        paco.mostrarColor();
        paco.mostrarNombre();
        System.out.printf("Área del circulo: %.2f", paco.calularArea());
System.out.println("");

        Figura perla = new Triangulo("Verde", "Perla", 4, 6);
        perla.mostrarColor();
        perla.mostrarNombre();
        System.out.printf("Área del tringulo: %.2f", perla.calularArea());
       


    }
}
