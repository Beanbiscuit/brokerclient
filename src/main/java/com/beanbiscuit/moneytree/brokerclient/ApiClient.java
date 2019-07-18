package com.beanbiscuit.moneytree.brokerclient;

import com.beanbiscuit.moneytree.brokerclient.api.reponse.ErrorResponse;
import com.beanbiscuit.moneytree.brokerclient.api.authentication.IGApiDetail;
import com.beanbiscuit.moneytree.brokerclient.api.authentication.AccountCredential;
import com.beanbiscuit.moneytree.brokerclient.api.authentication.AuthenticationException;
import com.beanbiscuit.moneytree.brokerclient.api.authentication.AuthenticationStrategy;
import com.beanbiscuit.moneytree.brokerclient.api.authentication.IGApiSession;
import com.beanbiscuit.moneytree.brokerclient.api.request.ApiQuery;
import com.beanbiscuit.moneytree.brokerclient.utility.Debugger;

import javax.ws.rs.client.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;

/**
 *
 */
public class ApiClient {

    public static final String USER_AGENT = "Beanbiscuit IG API Client";

    private final AccountCredential credentials;
    private final IGApiDetail apiDetail;
    private final Client client;
    private final Debugger debug;
    private AuthenticationStrategy authentication;

    public ApiClient(AccountCredential credentials, IGApiDetail apiDetail) {
        this.credentials = credentials;
        this.apiDetail = apiDetail;
        this.client = ClientBuilder.newClient();
        this.debug = null;
    }

    public ApiClient(AccountCredential credentials, IGApiDetail apiDetail, Client client) {
        this.credentials = credentials;
        this.apiDetail = apiDetail;
        this.client = client;
        this.debug = null;
    }

    public ApiClient(AccountCredential credentials, IGApiDetail apiDetail, Debugger debug, Level level) {
        this.credentials = credentials;
        this.apiDetail = apiDetail;
        this.client = ClientBuilder.newClient();
        this.debug = debug;
        this.debug.attachLogger(this.client, level);
    }

    public void setAuthentication(AuthenticationStrategy authentication) {
        this.authentication = authentication;
    }

    public IGApiSession authenticate() throws AuthenticationException {
        return this.authentication.authentication(this.client, this.apiDetail, this.credentials, USER_AGENT);
    }

    public int logout(IGApiSession session) {
        return this.authentication.logout(session, this.client, this.apiDetail, USER_AGENT);
    }

    public Object get(String endpoint, ApiQuery request, IGApiSession session, Class responseType) throws ApiException {
        final WebTarget apiEndpoint = client.target(
            this.apiDetail.getApiBaseUrl().concat(endpoint).concat("?").concat(request.getQueryParameters())
        );

        final Invocation.Builder requestBuilder = this.authentication.authorize(
            apiEndpoint,
            session,
            this.apiDetail,
            USER_AGENT
        );

        if (request.getHeaders().size() > 0) {
            request.getHeaders().forEach((k, v)-> requestBuilder.header(k, v));
        }

        final Response response = requestBuilder.get();
        this.handleErrorResponse(response);

        return response.readEntity(responseType);
    }

    public void close() {
        this.client.close();
    }

    /**
     * @param response
     * @throws ApiException
     */
    private void handleErrorResponse(Response response) throws ApiException {
        if (response.getStatus() != 200) {
            // Deals with responses not formatted as json
            if (!response.getHeaders().get(HttpHeaders.CONTENT_TYPE).toString().equals(MediaType.APPLICATION_JSON)) {
                throw new ApiException(response.getStatus(), "Endpoint not found or invalid request");
            }

            ErrorResponse errorResponse = response.readEntity(ErrorResponse.class);
            throw new ApiException(response.getStatus(), errorResponse.getErrorCode());
        }
    }

    /**
     *
     * @param username
     * @param password
     * @param apiKey
     * @param baseUrl
     * @return
     */
    public static ApiClient newInstance(String username, String password, String apiKey, String baseUrl) {
        return new ApiClient(new AccountCredential(password, username), new IGApiDetail(apiKey, baseUrl));
    }

    /**
     *
     * @param username
     * @param password
     * @param apiKey
     * @param baseUrl
     * @param level
     * @return
     */
    public static ApiClient newDebugInstance(
        String username,
        String password,
        String apiKey,
        String baseUrl,
        Level level
    ) {
        return new ApiClient(
            new AccountCredential(password, username),
            new IGApiDetail(apiKey, baseUrl),
            new Debugger(),
            level
        );
    }
}
