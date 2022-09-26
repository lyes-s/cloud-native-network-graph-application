package org.lyess.network_graph_service.exception.entity;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 1:31 p.m.
 */
public class ValidationError {

    private String property;
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
