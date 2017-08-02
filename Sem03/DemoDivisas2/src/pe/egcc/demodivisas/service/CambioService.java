package pe.egcc.demodivisas.service;

public class CambioService {

  public double solesToDolares(double soles) {
    pe.egcc.ws.divisas.DivisasWS_Service service = new pe.egcc.ws.divisas.DivisasWS_Service();
    pe.egcc.ws.divisas.DivisasWS port = service.getDivisasWSPort();
    return port.solesToDolares(soles);
  }
  
  
}
