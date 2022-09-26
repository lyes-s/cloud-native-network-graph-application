package org.lyess.network_graph_service.exception.mapper;

import org.lyess.network_graph_service.exception.GraphException;
import org.lyess.network_graph_service.exception.entity.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 1:40 p.m.
 */
@Provider
public class GraphExceptionMapper implements ExceptionMapper<GraphException> {

    @Override
    public Response toResponse(GraphException exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage());
        return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
    }

}
