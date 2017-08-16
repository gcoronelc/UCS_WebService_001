package pe.egcc.rest.prueba;

import java.util.List;
import pe.egcc.rest.model.Movimiento;
import pe.egcc.rest.service.CuentaService;

public class Prueba02 {

  public static void main(String[] args) {
    
    // Dato
    String cuenta = "00100001";
    
    // Proceso
    CuentaService service = new CuentaService();
    List<Movimiento> lista = service.leerMovimientos(cuenta);
    
    // Reporte
    for (Movimiento r : lista) {
      System.out.println(r.getNumeroMovimiento() + " - " + r.getImporte());
    }
    
  }
  
}
