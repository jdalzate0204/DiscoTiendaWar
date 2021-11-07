package co.edu.unicundi.discotiendawar.controller;

import co.edu.unicundi.discotiendajar.entity.*;
import co.edu.unicundi.discotiendajar.service.IArtistaService;
import java.util.List;
import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author acer
 */
@Stateless
@Path("/artistas")
public class ArtistaController {
    
    @EJB
    private IArtistaService service;
    
    @GET
    @Path("/listarSexo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerSexo() {
        List<Sexo> lista = service.obtenerSexo();
        return Response.status(Response.Status.OK).entity(lista).build();
    }
    
    @GET
    @Path("/listarGenero")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerGenero() {
        List<GeneroMusical> lista = service.obtenerGenero();
        return Response.status(Response.Status.OK).entity(lista).build();
    }
    
}
