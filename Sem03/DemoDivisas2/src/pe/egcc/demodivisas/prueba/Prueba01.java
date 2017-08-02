package pe.egcc.demodivisas.prueba;

import pe.egcc.demodivisas.service.CambioService;

public class Prueba01 {

  public static void main(String[] args) {
    // Dato
    double soles = 6000.0;
    
    // Proceso
    CambioService service = new CambioService();
    double dolares = service.solesToDolares(soles);
    
    // Reporte
    System.out.println("Dolares: " + dolares);
    
  }
  
}
