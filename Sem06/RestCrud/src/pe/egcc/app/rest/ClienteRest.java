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
import javax.ws.rs.core.Response;

import pe.egcc.app.dao.ClienteDao;
import pe.egcc.app.domain.ClienteModel;
import pe.egcc.app.dto.MensajeDto;

@Path("clientes")
public class ClienteRest {

   private ClienteDao clienteDao;

   public ClienteRest() {
      clienteDao = new ClienteDao();
   }

   @GET
   @Produces({ MediaType.APPLICATION_JSON })
   public List<ClienteModel> getAll() {
      return this.clienteDao.getAll();
   }

   @GET
   @Path("traer")
   @Produces({ MediaType.APPLICATION_JSON })
   public List<ClienteModel> getClientes(
       @QueryParam("paterno") String paterno, 
       @QueryParam("materno") String materno,
       @QueryParam("nombre") String nombre) {

      ClienteModel model = new ClienteModel();
      model.setPaterno(paterno);
      model.setMaterno(materno);
      model.setNombre(nombre);
      model.establecerVacios();
      return clienteDao.getClientes(model);

   }

   @GET
   @Path("{codigo}")
   @Produces({ MediaType.APPLICATION_JSON })
   public ClienteModel getCliente(@PathParam("codigo") String codigo) {
      ClienteModel cliente = clienteDao.getCliente(codigo);
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
   public MensajeDto add(ClienteModel bean) {
      MensajeDto dto = new MensajeDto();
      try {
         clienteDao.insertar(bean);
         dto.setCodigo(1);
         dto.setMensaje("Proceso ok. Codigo: " + bean.getCodigo() + ".");
      } catch (Exception e) {
         dto.setCodigo(-1);
         dto.setMensaje(e.getMessage());
      }
      return dto;
   }
   
   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public MensajeDto update(ClienteModel bean) {
      MensajeDto dto = new MensajeDto();
      try {
         clienteDao.actualizar(bean);
         dto.setCodigo(1);
         dto.setMensaje("Proceso ok.");
      } catch (Exception e) {
         dto.setCodigo(-1);
         dto.setMensaje(e.getMessage());
      }
      return dto;
   }

   @DELETE
   @Path("{codigo}")
   @Produces(MediaType.APPLICATION_JSON)
   public MensajeDto remove(@PathParam("codigo") String codigo) {
      MensajeDto dto = new MensajeDto();
      try {
         clienteDao.eliminar(codigo);
         dto.setCodigo(1);
         dto.setMensaje("Proceso ok.");
      } catch (Exception e) {
         dto.setCodigo(-1);
         dto.setMensaje(e.getMessage());
      }
      return dto;
   }   
   
}
