/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendawar.exception;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author PAULA GUZMAN
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Exception>{
@Context UriInfo uriInfo;

    @Override
    public Response toResponse(Exception ex) {
    ex.printStackTrace();
    ExceptionWraper ew;
    
    if (ex instanceof ArrayIndexOutOfBoundsException) {
    ew = new ExceptionWraper(Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase(), ex.getMessage(), uriInfo.getPath());
    return Response.status(Response.Status.BAD_REQUEST).entity(ew).build();
    } else {
    ew = new ExceptionWraper(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), "", uriInfo.getPath());
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ew).build();
    }
   }
}