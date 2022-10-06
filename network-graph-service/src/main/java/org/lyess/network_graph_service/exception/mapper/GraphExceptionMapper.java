package org.lyess.network_graph_service.exception.mapper;

import org.lyess.network_graph_service.exception.GraphExceptionResponse;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 1:40 p.m.
 */
@Provider
public class GraphExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException exception) {
        GraphExceptionResponse errorMessage = new GraphExceptionResponse(exception.getMessage(), exception.getResponse().getStatus(), exception.getResponse().getStatusInfo().getReasonPhrase());
        return Response.status(exception.getResponse().getStatus()).entity(errorMessage).build();
    }

}
