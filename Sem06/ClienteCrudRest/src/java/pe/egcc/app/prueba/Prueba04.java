package pe.egcc.app.prueba;

import pe.egcc.app.model.ClienteModel;
import pe.egcc.app.service.ClienteService;

public class Prueba04 {

  public static void main(String[] args) {
           
    ClienteService service = new ClienteService();
    
    ClienteModel model = service.getCliente("00001");
        
    System.out.println(model.toString());
    
  }
  
}
