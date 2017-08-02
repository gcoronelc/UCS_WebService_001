package pe.egcc.app.prueba;

import pe.egcc.app.service.DivisasService;

public class Prueba01 {
  
  public static void main(String[] args) {
    
    // Dato
    double soles = 1000.0;
    
    // Proceso
    DivisasService service = new DivisasService();
    double dolares = service.solesToDolares(soles);
    
    // Reporte
    System.out.println("Soles: " + soles);
    System.out.println("Dolares: " + dolares);
    
  }
  
}
