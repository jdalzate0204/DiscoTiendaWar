package co.edu.unicundi.discotiendawar.controller;

import co.edu.unicundi.discotiendajar.dto.CancionDto;
import co.edu.unicundi.discotiendajar.entity.Formato;
import co.edu.unicundi.discotiendajar.exception.ResourceIllegalArgumentException;
import co.edu.unicundi.discotiendajar.service.ICancionService;
import java.util.List;
import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author acer
 */
@Stateless
@Path("/canciones")
public class CancionController {
    
    @EJB
    private ICancionService service;
    
    @GET
    @Path("/listarFormato")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerFormato(){
        List<Formato> lista = service.obtenerFormato();
        return Response.status(Response.Status.OK).entity(lista).build();
    }
    
    @POST
    @Path("/guardar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardar(CancionDto cancion) throws ResourceIllegalArgumentException {
        this.service.guardar(cancion);
        return Response.status(Response.Status.CREATED).build();
    }
}
