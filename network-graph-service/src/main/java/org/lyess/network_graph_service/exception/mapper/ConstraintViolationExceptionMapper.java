package org.lyess.network_graph_service.exception.mapper;

import org.lyess.network_graph_service.exception.GraphExceptionResponse;
import org.lyess.network_graph_service.exception.entity.ErrorResponse;
import org.lyess.network_graph_service.exception.entity.ValidationError;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 1:38 p.m.
 */
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        List<ErrorResponse> errors = exception.getConstraintViolations()//
                .stream()//
                .map(this::toValidationError)//
                .collect(Collectors.toList());

        GraphExceptionResponse x = new GraphExceptionResponse(exception.getMessage(), Status.BAD_REQUEST);
        x.setDetails(errors);

        return Response.status(Status.BAD_REQUEST).entity(x).type(MediaType.APPLICATION_JSON).build();
    }

    private ValidationError toValidationError(ConstraintViolation<?> constraintViolation) {
        ValidationError error = new ValidationError();
        error.setProperty(extractProperty(constraintViolation.getPropertyPath().toString()));
        error.setMessage(constraintViolation.getMessage());
        return error;
    }

    private String extractProperty(String path) {
        return path.substring(path.lastIndexOf('.') + 1);
    }

}
