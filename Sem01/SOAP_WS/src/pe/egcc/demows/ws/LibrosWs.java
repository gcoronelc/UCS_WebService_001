package pe.egcc.demows.ws;

import java.util.List;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import pe.egcc.demows.model.Libro;
import pe.egcc.demows.service.LibroService;

@WebService
public class LibrosWs {

  public List<Libro> traerLibros() {
    LibroService libroService = new LibroService();
    return libroService.traerLibros();
  }

  public static void main(String[] args) {

    Endpoint.publish("http://localhost:8087/librosws", new LibrosWs());
    System.out.println("Servicio inicializado!");

  }

}
