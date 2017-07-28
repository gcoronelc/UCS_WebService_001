package pe.egcc.service;

public class MateService {

  public static int sumar(int num1, int num2) {
    pe.egcc.ws.WSMate_Service service = new pe.egcc.ws.WSMate_Service();
    pe.egcc.ws.WSMate port = service.getWSMatePort();
    return port.sumar(num1, num2);
  }

  public static int restar(int num1, int num2) {
    pe.egcc.ws.WSMate_Service service = new pe.egcc.ws.WSMate_Service();
    pe.egcc.ws.WSMate port = service.getWSMatePort();
    return port.restar(num1, num2);
  }

  

  
}
