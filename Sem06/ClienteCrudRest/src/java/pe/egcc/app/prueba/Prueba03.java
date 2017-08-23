package pe.egcc.app.prueba;

import pe.egcc.app.model.ClienteModel;
import pe.egcc.app.service.ClienteService;

public class Prueba03 {

  public static void main(String[] args) {
    
    ClienteModel model = new ClienteModel();
    model.setNombre("CA");
    model.setPaterno("CO");
        
    ClienteService service = new ClienteService();
    
    service.getClientes(model).stream()
      .forEach(r -> System.out.println(r.toString()) );
        
  }
  
}
