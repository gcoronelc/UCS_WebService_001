package pe.egcc.app.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.egcc.app.service.DivisasService;

@WebService(serviceName = "DivisasWS")
public class DivisasWS {


  @WebMethod(operationName = "solesToDolares")
  public double solesToDolares(@WebParam(name = "soles") double soles) {
    DivisasService service = new DivisasService();
    double dolares = service.solesToDolares(soles);
    return dolares;
  }
  
  
}
