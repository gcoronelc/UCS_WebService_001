package pe.egcc.wsclient;

import java.util.List;
import pe.egcc.demows.ws.Libro;
import pe.egcc.demows.ws.LibrosWs;
import pe.egcc.demows.ws.LibrosWsService;

public class ClasePrincipal {

  public static void main(String[] args) {
    
    // Inicializando la fabrica de proxies
    LibrosWsService factory = new LibrosWsService();
    
    // Obtener un proxy 
    LibrosWs librosWS = factory.getLibrosWsPort();
    
    // Ejecutar el método remoto 
    List<Libro> lista = librosWS.traerLibros(); 
    
    // Reporte
    for (Libro libro : lista) { 
      System.out.println(libro.getTitulo()); 
    }
    
  }
  
}
