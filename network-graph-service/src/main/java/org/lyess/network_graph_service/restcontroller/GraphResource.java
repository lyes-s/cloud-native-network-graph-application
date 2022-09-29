package org.lyess.network_graph_service.restcontroller;

import org.lyess.network_graph_service.domain.Graph;
import org.lyess.network_graph_service.exception.GraphNotFoundException;
import org.lyess.network_graph_service.hypermedia.LinkResource;
import org.lyess.network_graph_service.service.IGraphService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 2:55 p.m.
 */
@Stateless
@Path("/v1/graph")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GraphResource {

    @Inject
    private IGraphService<Graph, String> graphService;

    @Context
    private UriInfo uriInfo;

    @GET
    @Path("/")
    public Response getAllGraphs(){
        List<Graph> graphs = graphService.getAll();
        graphs.stream().forEach(graph -> {
            LinkResource self = buildLink(graph, "getAllGraphs", "self", "Get");
            graph.addLink(self);
        });
        return Response.status(Status.OK).entity(graphs).build();
    }

    @GET
    @Path("{id}")
    public Response getGraphById(final @PathParam("id") @NotBlank String id){
        Graph graph = graphService.findGraphById(id)//
                .orElseThrow(() -> new GraphNotFoundException("Graph Id = " + id + " Not Found !"));
        LinkResource self = buildLink(graph, "getGraphById", "self", "Get");
        graph.addLink(self);
        return Response.status(Status.OK).entity(graph).build();
    }

    private LinkResource buildLink(Graph graph, String method, String rel, String type) {
        Link link = Link//
                .fromUri(uriInfo//
                        .getBaseUriBuilder()//
                        .path(getClass())//
                        .path(getClass(), method)//
                        .build(graph.getId()))//
                .rel(rel)//
                .type(type)//
                .build();

        return new LinkResource(link);
    }
}
