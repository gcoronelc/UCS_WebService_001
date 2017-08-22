package pe.egcc.rest.prueba;

import java.util.List;
import pe.egcc.rest.model.Cuenta;
import pe.egcc.rest.service.CuentaService;

public class Prueba04 {

  public static void main(String[] args) {
    
    try {

      // Datos
      String sucucodigo = "";
      
      // Proceso
      CuentaService service = new CuentaService();
      List<Cuenta> lista = service.leerCuentas(sucucodigo);
      
      // Reporte
      for (Cuenta cuenta : lista) {
        System.out.println(cuenta.getCuencodigo() + " - " + cuenta.getCuensaldo());
      }
      
    } catch (Exception e) {
      
      System.err.println(e.getMessage());
      
    }
    
  }
  
}
