package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.business.ClientBusiness;
import org.example.entities.Client;
import org.example.entities.Commande;

import java.util.List;

@Path("/clients")                              // [4]
@Produces(MediaType.APPLICATION_JSON)          // [5]
@Consumes(MediaType.APPLICATION_JSON)          // [5]
public class ClientResources {

    private final ClientBusiness clientBusiness = ClientBusiness.getInstance();

    @GET                                        // [7]
    @Path("/{id_client}/commandes")             // [8]
    public Response getAllCmdByClient(@PathParam("id_client") int id_client) {
        List<Commande> commandes = clientBusiness.getCommandesClient(id_client); // [9]
        if (!commandes.isEmpty()) {
            return Response.status(Response.Status.OK).entity(commandes).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addClient(Client client) {
        clientBusiness.addClient(client);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public Response getClientById(@PathParam("id") int id) {
        if (clientBusiness.getClientById(id) != null) {
            return Response.status(Response.Status.OK).entity(clientBusiness.getClientById(id)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/all")
    public Response getAllClients() {
        if (!clientBusiness.getAllClients().isEmpty()) {
            return Response.status(Response.Status.OK).entity(clientBusiness.getAllClients()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public Response clientsByName(@QueryParam("name") String name) { // [11] + [12]
        if (name != null && !name.isEmpty()) {      // [13]
            Client client = clientBusiness.getClientByNom(name); // [14]
            if (client != null) {                    // [15]
                return Response.status(Response.Status.OK).entity(client).build(); // [16]
            } else {
                return Response.status(Response.Status.NOT_FOUND).build(); // [17]
            }
        } else {
            List<Client> allClients = clientBusiness.getAllClients(); // [18]
            return Response.status(Response.Status.OK).entity(allClients).build(); // [19]
        }
    }

}
