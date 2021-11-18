package co.edu.unicundi.discotiendawar.controller;

import co.edu.unicundi.discotiendajar.entity.Administrador;
import co.edu.unicundi.discotiendajar.service.IAdministradorService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ALEJANDRA
 */
@Stateless
@Path("/administrador")
public class AdministradorController {
    @EJB
    private IAdministradorService service;
    
    @POST
    @Path("/guardar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(Administrador administrador)  {
        this.service.guardar(administrador);
        return Response.status(Response.Status.CREATED).build();
    }
}
