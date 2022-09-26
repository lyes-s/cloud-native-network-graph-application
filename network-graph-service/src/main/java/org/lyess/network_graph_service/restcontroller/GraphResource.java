package org.lyess.network_graph_service.restcontroller;

import org.lyess.network_graph_service.domain.Graph;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 2:55 p.m.
 */
@Path("/v1/graph")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GraphResource {

    @GET
    public Response getAllGraphs(){
        return null;
    }

    @GET
    @Path("{id}")
    public Response getGraphById(final @PathParam("id") Long id){
        return null;
    }

    @POST
    public Response saveGraph(final Graph graph) {
        return null;
    }

    @PUT
    @Path("{id}")
    public Response updateGraph(final @PathParam("id") Long id, final Graph graph) {
        return null;
    }

    @DELETE
    @Path("{id}")
    public Response deleteGraph(final @PathParam("id") Long id){
        return null;
    }
}
