package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.business.CommandeBusiness;

@Path("/commandes")                              // [4]
@Produces(MediaType.APPLICATION_JSON)          // [5]
@Consumes(MediaType.APPLICATION_JSON)          // [5]
public class CommandeResources {

    private final CommandeBusiness business = CommandeBusiness.getInstance();

    @GET
    @Path("/all")
    public Response getAllCommands() {
        if (!business.getAllCommandes().isEmpty()) {
            return Response.status(Response.Status.OK).entity(business.getAllCommandes()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/{id}")
    public Response getCommandById(@PathParam("id") int id) {
        if (business.getCommandeById(id) != null) {
            return Response.status(Response.Status.OK).entity(business.getCommandeById(id)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
