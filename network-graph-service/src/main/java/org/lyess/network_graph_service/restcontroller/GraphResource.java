package org.lyess.network_graph_service.restcontroller;

import org.lyess.network_graph_service.domain.Graph;
import org.lyess.network_graph_service.exception.GraphNotFoundException;
import org.lyess.network_graph_service.service.IGraphService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 2:55 p.m.
 */
@Path("/v1/graph")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GraphResource {

    @Inject
    private IGraphService<Graph, String> graphService;

    @GET
    public Response getAllGraphs(){
        List<Graph> graphs = graphService.getAll();
        return Response.status(Status.OK).entity(graphs).build();
    }

    @GET
    @Path("{id}")
    public Response getGraphById(final @PathParam("id") String id){
        Graph graph = graphService.findGraphById(id)//
                .orElseThrow(() -> new GraphNotFoundException("Graph Id = " + id + " Not Found !"));
        return Response.status(Status.OK).entity(graph).build();
    }
}
