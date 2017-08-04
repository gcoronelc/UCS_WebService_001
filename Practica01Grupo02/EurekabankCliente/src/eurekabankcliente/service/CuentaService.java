/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eurekabankcliente.service;

/**
 *
 * @author CSarmiento
 */
public class CuentaService {

    public static java.util.List<pe.eurekabank.ws.Movimiento> leerMovimientos(java.lang.String numeroCuenta) {
        pe.eurekabank.ws.WSCuenta_Service service = new pe.eurekabank.ws.WSCuenta_Service();
        pe.eurekabank.ws.WSCuenta port = service.getWSCuentaPort();
        return port.leerMovimientos(numeroCuenta);
    }
    
}
