package pe.egcc.app.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import pe.egcc.app.model.ClienteModel;
import pe.egcc.app.model.MensajeModel;
import pe.egcc.app.service.ClienteService;

@Path("clientes")
public class ClienteRest {

  private ClienteService service;

  public ClienteRest() {
    service = new ClienteService();
  }

  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public List<ClienteModel> getAll() {
    return this.service.getAll();
  }

  @GET
  @Path("traer")
  @Produces({MediaType.APPLICATION_JSON})
  public List<ClienteModel> getClientes(
          @QueryParam("paterno") String paterno,
          @QueryParam("materno") String materno,
          @QueryParam("nombre") String nombre) {

    ClienteModel model = new ClienteModel();
    model.setPaterno(paterno);
    model.setMaterno(materno);
    model.setNombre(nombre);
    model.establecerVacios();

    return service.getClientes(model);

  }

  @GET
  @Path("{codigo}")
  @Produces({MediaType.APPLICATION_JSON})
  public ClienteModel getCliente(@PathParam("codigo") String codigo) {
    ClienteModel cliente = service.getCliente(codigo);
    if (cliente == null) {
      cliente = new ClienteModel();
      cliente.setCodigo("-1");
    }
    cliente.establecerVacios();
    return cliente;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public MensajeModel add(ClienteModel bean) {

    MensajeModel mensaje = new MensajeModel();

    try {

      service.insertar(bean);
      mensaje.setCodigo(1);
      mensaje.setMensaje("Proceso ok. Codigo: " + bean.getCodigo() + ".");

    } catch (Exception e) {

      mensaje.setCodigo(-1);
      mensaje.setMensaje(e.getMessage());

    }

    return mensaje;

  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public MensajeModel update(ClienteModel bean) {
    MensajeModel mensaje = new MensajeModel();
    try {
      service.actualizar(bean);
      mensaje.setCodigo(1);
      mensaje.setMensaje("Proceso ok.");
    } catch (Exception e) {
      mensaje.setCodigo(-1);
      mensaje.setMensaje(e.getMessage());
    }
    return mensaje;
  }

  @DELETE
  @Path("{codigo}")
  @Produces(MediaType.APPLICATION_JSON)
  public MensajeModel remove(@PathParam("codigo") String codigo) {
    
    MensajeModel mensaje = new MensajeModel();
    try {
      service.eliminar(codigo);
      mensaje.setCodigo(1);
      mensaje.setMensaje("Proceso ok.");
    } catch (Exception e) {
      mensaje.setCodigo(-1);
      mensaje.setMensaje(e.getMessage());
    }
    return mensaje;
    
  }

}
