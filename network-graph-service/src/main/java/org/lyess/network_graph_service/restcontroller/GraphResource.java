package org.lyess.network_graph_service.restcontroller;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.lyess.network_graph_service.domain.Graph;
import org.lyess.network_graph_service.exception.GraphExceptionResponse;
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
@OpenAPIDefinition(info = @Info(title = "Network Graph : Query Service API", version = "1.0", description = "Network Graph : Query Service API",
        contact = @Contact(url = "https://github.com/lyes-s/cloud-native-network-graph-application", name = "Lyes Sefiane"),
        license = @License(name = "License", url = "https://github.com/lyes-s/cloud-native-network-graph-application/blob/main/LICENSE.md")))
public class GraphResource {

    @Inject
    private IGraphService<Graph, String> graphService;

    @Context
    private UriInfo uriInfo;

    @GET
    @Path("/")
    @Operation(summary = "Get All Graphs")
    @APIResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Graph.class)))
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
    @Operation(summary = "Find Graph By Id")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Graph.class))),
            @APIResponse(responseCode = "404", description = "NOT_FOUND", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GraphExceptionResponse.class))),
            @APIResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content(schema = @Schema(implementation = GraphExceptionResponse.class)))
    })
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
