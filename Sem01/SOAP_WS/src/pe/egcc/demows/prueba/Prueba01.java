package pe.egcc.demows.prueba;

import java.util.List;
import pe.egcc.demows.model.Libro;
import pe.egcc.demows.service.LibroService;

public class Prueba01 {

  public static void main(String[] args) {
    
    // Proceso
    LibroService service = new LibroService();
    List<Libro> lista = service.traerLibros();
    
    // Reporte
    for (Libro libro : lista) {
      
      System.out.println(libro.getAnio() 
              + " - " + libro.getTitulo());
      
    }
    
  }
  
}
