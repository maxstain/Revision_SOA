package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.business.ProduitBusiness;
import org.example.entities.Produit;

@Path("/produits")
@Produces(MediaType.APPLICATION_JSON)          // [5]
@Consumes(MediaType.APPLICATION_JSON)
public class ProduitResources {

    private final ProduitBusiness business = ProduitBusiness.getInstance();

    @GET
    @Path("/all")
    public Response getAllProduits() {
        if (!business.getListeProduits().isEmpty()) {
            return Response.status(Response.Status.OK).entity(business.getListeProduits()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/{id}")
    public Response getProduitById(@PathParam("id") int id) {
        if (business.getProduitById(id) != null) {
            return Response.status(Response.Status.OK).entity(business.getProduitById(id)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addProduit(org.example.entities.Produit p) {
        business.addProduit(p);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/update/{id}")
    public Response updateProduit(@PathParam("id") int id, Produit p) {
        Produit existingProduit = business.getProduitById(id);
        if (existingProduit != null) {
            business.deleteProduit(existingProduit);
            business.addProduit(p);
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
