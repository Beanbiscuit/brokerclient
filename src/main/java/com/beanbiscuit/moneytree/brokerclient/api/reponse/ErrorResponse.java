package com.beanbiscuit.moneytree.brokerclient.api.reponse;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 *
 */
public class ErrorResponse {

    private final String errorCode;

    public ErrorResponse(String errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorResponse() {
        this.errorCode = null;
    }

    @JsonGetter("errorCode")
    public String getErrorCode() {
        return errorCode;
    }
}
