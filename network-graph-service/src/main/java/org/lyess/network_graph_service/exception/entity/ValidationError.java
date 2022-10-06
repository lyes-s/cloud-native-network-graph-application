package org.lyess.network_graph_service.exception.entity;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 1:31 p.m.
 */
@Schema(name = "ValidationError")
public class ValidationError implements ErrorResponse {

    @Schema(name = "property", required = true)
    private String property;

    @Schema(name = "message", required = true)
    private String message;


    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ValidationError [property=" + property + ", message=" + message + "]";
    }

}
