package com.beanbiscuit.moneytree.brokerclient;

/**
 * Adds an API status to API exception messages.
 */
public class ApiException extends Exception {

    public ApiException(int statusCode, String message) {
        super(statusCode + ": " + message);
    }
}
