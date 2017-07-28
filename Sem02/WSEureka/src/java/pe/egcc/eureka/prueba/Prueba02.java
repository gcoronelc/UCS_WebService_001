package pe.egcc.eureka.prueba;

import pe.egcc.eureka.service.CuentaService;

public class Prueba02 {

  public static void main(String[] args) {
    
    // Dato
    String cuenta = "00100001";
    
    // Proceso
    CuentaService service = new CuentaService();
    double saldo = service.leerSaldo(cuenta);
    
    // Reporte
    System.out.println("Saldo: " + saldo);
            
  }
  
}
