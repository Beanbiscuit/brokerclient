package com.beanbiscuit.moneytree.brokerclient.api.authentication;

public class AuthenticationException extends Exception {

    public AuthenticationException(int statusCode, String message) {
        super(statusCode + ": " + message);
    }
}
