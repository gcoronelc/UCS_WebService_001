
package pe.egcc.service;


public class MultiplicaService {

    public static java.util.List<pe.egcc.ws.TablaFila> multiplica(int numero) {
        pe.egcc.ws.WSTablaMultiplicar_Service service = new pe.egcc.ws.WSTablaMultiplicar_Service();
        pe.egcc.ws.WSTablaMultiplicar port = service.getWSTablaMultiplicarPort();
        return port.multiplica(numero);
    }
 }
