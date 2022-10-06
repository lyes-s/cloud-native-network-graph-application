package org.lyess.network_graph_service.exception;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.lyess.network_graph_service.exception.entity.ErrorResponse;
import org.lyess.network_graph_service.exception.entity.ValidationError;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbTransient;
import javax.ws.rs.core.Response.Status;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 1:35 p.m.
 */
public class GraphExceptionResponse {

    @JsonbDateFormat(value = "yyyy-MM-dd hh:mm:ss")
    @Schema(required = true, format = "yyyy-MM-dd hh:mm:ss", example = "2022-10-04 06:38:52")
    private LocalDateTime timeStamp;

    @Schema(required = true)
    private String message;

    @Schema(required = true)
    private String error;

    @JsonbTransient
    private Status responseStatus;

    @Schema(required = true)
    private String status;


    @Schema(allOf = {ValidationError.class}, implementation = ErrorResponse.class)
    private List<ErrorResponse> details;

    public GraphExceptionResponse(String message, Status status) {
        this.timeStamp = LocalDateTime.now();
        this.responseStatus = status;
        this.status = status.getStatusCode() + "";
        this.error = status.getReasonPhrase();
        this.message = message;
    }

    public GraphExceptionResponse(String message, int statusCode, String reasonPhrase ) {
        this.timeStamp = LocalDateTime.now();
        this.status = statusCode + "";
        this.error = reasonPhrase;
        this.message = message;
    }


    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }

    public Status getResponseStatus() {
        return responseStatus;
    }

    public String getStatus() {
        return status;
    }

    public List<ErrorResponse> getDetails() {
        return details;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setResponseStatus(Status responseStatus) {
        this.responseStatus = responseStatus;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDetails(List<ErrorResponse> details) {
        this.details = details;
    }
}
