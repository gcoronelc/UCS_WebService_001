package pe.egcc.rest.server;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import pe.egcc.rest.model.Mensaje;
import pe.egcc.rest.model.Movimiento;
import pe.egcc.rest.service.CuentaService;

@Path(value = "/wszany")
public class WSZany {
  
  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  public Mensaje getMensaje(){
    Mensaje bean = new Mensaje(1, "Hola todos, estamos listos.");
    return bean;
  }
  
  @GET
  @Path(value = "sumar")
  @Produces({MediaType.APPLICATION_JSON })
  public Mensaje sumar( 
          @QueryParam("n1") int n1, 
          @QueryParam("n2") int n2
  ){
    int suma = n1 + n2;
    Mensaje bean = new Mensaje();
    bean.setCode(1);
    bean.setTexto(n1 + " + " + n2 + " = " + suma);
    return bean;
  }
  
  @GET
  @Path(value = "/movimientos/{cuenta}")
  @Produces({MediaType.APPLICATION_JSON })
  public List<Movimiento> leerMovimientos(
          @PathParam("cuenta") String cuenta){
    // Proceso
    CuentaService service = new CuentaService();
    List<Movimiento> lista = service.leerMovimientos(cuenta);
    // Reporte
    return lista;
  }
  
  
}
