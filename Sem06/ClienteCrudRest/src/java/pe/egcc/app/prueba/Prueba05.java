package pe.egcc.app.prueba;

import pe.egcc.app.model.ClienteModel;
import pe.egcc.app.service.ClienteService;

public class Prueba05 {

  public static void main(String[] args) {
    
    try {
    
      // Dato
      ClienteModel bean = new ClienteModel();
      bean.setPaterno("AAAAAAA");
      bean.setMaterno("AAAAAAA");
      bean.setNombre("AAAAAAA");
      bean.setDni("AAAAAAAdsfsfdsfdsfdf");
      bean.setCiudad("AAAAAAA");
      bean.setDireccion("AAAAAAA");
      bean.setTelefono("AAAAAAA");
      bean.setEmail("AAAAAAA");
      
      // Proceso
      ClienteService service = new ClienteService();
      service.insertar(bean);
      
      // Reporte
      System.out.println("Código: " + bean.getCodigo());
      
    } catch (Exception e) {
    
      System.err.println(e.getMessage());
      
    }
    
  }
  
}
