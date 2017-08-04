
package pe.egcc.ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.TablaFila;

@WebService(serviceName = "WSTablaMultiplicar")
public class WSTablaMultiplicar {

 
   
    @WebMethod(operationName = "Multiplica")
    public List<TablaFila> Multiplica(@WebParam(name = "numero") int numero) {
        
      List<TablaFila> lista= new ArrayList<>();
        
     for(int i = 1; i <=12; i++){
      TablaFila tablaFila= new TablaFila(numero,i,numero*i,"*");    
      lista.add(tablaFila);
      }
      return lista;
       
    }
}
