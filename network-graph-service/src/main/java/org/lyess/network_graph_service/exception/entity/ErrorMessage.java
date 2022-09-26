package org.lyess.network_graph_service.exception.entity;

import java.util.Arrays;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2022-09-26 1:28 p.m.
 */
public class ErrorMessage {
    private String errorMessageValue;
    private String errorMessageKey;

    public ErrorMessage() {
        //
    }

    public ErrorMessage(String errorMessageValue) {
        this.errorMessageValue = errorMessageValue;
        this.errorMessageKey = Arrays.stream(ErrorMessages.values())
                .filter(bl -> bl.getErrorMessage().equalsIgnoreCase(errorMessageValue))
                .findFirst()
                .orElse(ErrorMessages.ERROR_MESSAGE)
                .name();

    }

    public ErrorMessage(String errorMessageValue, String errorMessageKey) {
        this.errorMessageValue = errorMessageValue;
        this.errorMessageKey = errorMessageKey;
    }

    public String getErrorMessageValue() {
        return errorMessageValue;
    }

    public void setErrorMessageValue(String errorMessageValue) {
        this.errorMessageValue = errorMessageValue;
    }

    public String getErrorMessageKey() {
        return errorMessageKey;
    }

    public void setErrorMessageKey(String errorMessageKey) {
        this.errorMessageKey = errorMessageKey;
    }
}
