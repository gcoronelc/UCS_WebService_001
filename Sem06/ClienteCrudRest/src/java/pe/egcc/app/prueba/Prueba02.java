package pe.egcc.app.prueba;

import pe.egcc.app.service.ClienteService;

public class Prueba02 {

  public static void main(String[] args) {
    
    ClienteService service = new ClienteService();
    
    service.getAll().stream()
      .forEach(r -> System.out.println(r.toString()) );
  }
  
}
