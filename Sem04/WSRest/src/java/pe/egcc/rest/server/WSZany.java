package pe.egcc.rest.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import pe.egcc.rest.model.Mensaje;

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
  public Mensaje sumar( @QueryParam("n1") int n1, @QueryParam("n2") int n2){
    int suma = n1 + n2;
    Mensaje bean = new Mensaje();
    bean.setCode(1);
    bean.setTexto(n1 + " + " + n2 + " = " + suma);
    return bean;
  }
  
  
}
