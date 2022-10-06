package org.lyess.network_graph_service.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 1:36 p.m.
 */
public class GraphNotFoundException extends WebApplicationException {

    public GraphNotFoundException(String message) {
        super(message, Response.Status.NOT_FOUND);
    }
}
