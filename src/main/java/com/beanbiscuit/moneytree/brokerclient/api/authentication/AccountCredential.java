package com.beanbiscuit.moneytree.brokerclient.api.authentication;

/**
 * AccountCredential provider for api clients
 */
public class AccountCredential {

    private final String password;
    private final String username;

    public AccountCredential(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
