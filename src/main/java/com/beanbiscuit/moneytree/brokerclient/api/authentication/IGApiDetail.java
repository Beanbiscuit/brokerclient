package com.beanbiscuit.moneytree.brokerclient.api.authentication;

/**
 *
 */
public class IGApiDetail {

    private final String apiKey;
    private final String apiBaseUrl;

    public IGApiDetail(String apiKey, String apiBaseUrl) {
        this.apiKey = apiKey;
        this.apiBaseUrl = apiBaseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }
}
