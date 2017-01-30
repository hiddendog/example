/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import io.swagger.annotations.Api;
import javax.ejb.Asynchronous;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.demoiselle.jee.rest.annotation.CacheControl;

/**
 *
 * @author gladson
 */
@Api("Logradouro")
@Path("logradouro")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class LogradouroFacadeREST {

    @Inject
    private BaseInMemory dao;

    @GET
    @Asynchronous
    @Path(value = "{logradouro}")
    @CacheControl(value = "max-age=259200000")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public void findLogradouro(@Suspended final AsyncResponse asyncResponse, @PathParam(value = "logradouro") final String logradouro) {
        asyncResponse.resume(doFindLogradouro(logradouro));
    }

    private Response doFindLogradouro(@PathParam("logradouro") String logradouro) {
        return Response.ok().entity(dao.getLogradouro(logradouro)).build();
    }

}
