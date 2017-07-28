package pe.egcc.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WSMate")
public class WSMate {

  @WebMethod(operationName = "sumar")
  public int sumar(@WebParam(name = "num1") int num1, @WebParam(name = "num2") int num2) {
    return (num1 + num2);
  }

  @WebMethod(operationName = "restar")
  public int restar(@WebParam(name = "num1") int num1, @WebParam(name = "num2") int num2) {
    return (num1 - num2);
  }

}
