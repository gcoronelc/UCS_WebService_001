package pe.egcc.eureka.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.egcc.eureka.service.CuentaService;

@WebService(serviceName = "WSCuenta")
public class WSCuenta {

  @WebMethod(operationName = "consultaSaldo")
  public double consultaSaldo(@WebParam(name = "cuenta") String cuenta) {
  
    CuentaService service = new CuentaService();
    double saldo = service.leerSaldo(cuenta);
    return saldo;
    
  }


}
