package com.beanbiscuit.moneytree.brokerclient.api.authentication;

import com.fasterxml.jackson.annotation.JsonGetter;

public class OauthToken {

    private final String accessToken;
    private final String refreshToken;
    private final String scope;
    private final String expiresIn;
    private final String tokenType;

    /**
     * Default for jackson and JPA
     */
    public OauthToken() {
        this.accessToken = null;
        this.refreshToken = null;
        tokenType = null;
        expiresIn = null;
        scope = null;
    }

    /**
     * @param accessToken - An oauth access token
     * @param refreshToken - A refresh token returned from an OAuth service.
     * @param scope
     * @param expiresIn
     * @param tokenType
     */
    public OauthToken(String accessToken, String refreshToken, String scope, String expiresIn, String tokenType) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.scope = scope;
        this.expiresIn = expiresIn;
        this.tokenType = tokenType;
    }

    @JsonGetter("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    @JsonGetter("refresh_token")
    public String getRefreshToken() {
        return refreshToken;
    }

    @JsonGetter("scope")
    public String getScope() {
        return scope;
    }

    @JsonGetter("expires_in")
    public String getExpiresIn() {
        return expiresIn;
    }

    @JsonGetter("token_type")
    public String getTokenType() {
        return tokenType;
    }

    /**
     * @return - Returns the current access token or empty string.
     */
    public String toString() {
        return (this.accessToken == null) ? "": this.accessToken;
    }
}
