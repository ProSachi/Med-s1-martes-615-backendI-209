import java.util.ArrayList;
import java.util.List;

import model.Archivo;
import model.ArchivoPdf;
import model.ArchivoWord;

public class App {
    public static void main(String[] args) throws Exception {
        List<Archivo> documento = new ArrayList<>();
    
        documento.add(new Archivo());
        documento.add(new ArchivoPdf());
        documento.add(new ArchivoWord());

        for (Archivo a : documento) {
            a.abrir();
        }
        

    }
}
