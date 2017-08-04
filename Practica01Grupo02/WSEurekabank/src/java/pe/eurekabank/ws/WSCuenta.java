/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eurekabank.ws;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.eurekabank.entity.Movimiento;
import pe.eurekabank.servicio.CuentaService;

/**
 *
 * @author CSarmiento
 */
@WebService(serviceName = "WSCuenta")
public class WSCuenta {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "leerMovimientos")
    public List<Movimiento> leerMovimientos(@WebParam(name = "numeroCuenta") String numeroCuenta) {
        //TODO write your implementation code here:
       
        List<Movimiento> movimientos = null;
        
        try {
            CuentaService cuentaService = new CuentaService();
            movimientos = cuentaService.leerMovimientos(numeroCuenta);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return movimientos;
        
    }
}
