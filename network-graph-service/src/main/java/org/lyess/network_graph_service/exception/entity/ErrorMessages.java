package org.lyess.network_graph_service.exception.entity;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 1:30 p.m.
 */
public enum ErrorMessages {

    COULD_NOT_CREATE_GRAPH("Could not create graph"),
    COULD_NOT_UPDATE_GRAPH("Could not update graph"),
    COULD_NOT_DELETE_GRAPH("Could not delete graph"),
    NO_GRAPH_FOUND("No graph found for provided id"),
    GRAPH_ALREADY_EXISTS("graph already exists"),
    ERROR_MESSAGE("Error Message");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
