package com.beanbiscuit.moneytree.brokerclient.api.authentication;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class OAuthTokenAccess implements AuthenticationStrategy {

    private final Map<String, String> credentials = new HashMap<>();

    @Override
    public IGApiSession authentication(
        Client client,
        IGApiDetail apiDetail,
        AccountCredential credentials,
        String userAgentTitle
    ) throws AuthenticationException {
        final WebTarget authenticationEndpoint = client.target(apiDetail.getApiBaseUrl().concat(AUTH_ENDPOINT));

        final Invocation.Builder requestBuilder = authenticationEndpoint
            .request(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .header(HEADER_IG_API_KEY, apiDetail.getApiKey())
            .header(HEADER_VERSION, "3")
            .header(HttpHeaders.USER_AGENT, userAgentTitle);

        this.credentials.put("identifier", credentials.getUsername());
        this.credentials.put("password", credentials.getPassword());

        final Response authResponse = requestBuilder.post(Entity.json(this.credentials));
        this.credentials.clear();

        final IGApiSession apiSession = authResponse.readEntity(IGApiSession.class);
        if (apiSession.getErrorCode() != null) {
            throw new AuthenticationException(authResponse.getStatus(), apiSession.getErrorCode());
        }

        return apiSession;
    }

    /**
     *
     * @param apiEndpoint
     * @param session
     * @param apiDetail
     * @param userAgentTitle
     * @return
     */
    public Invocation.Builder authorize(WebTarget apiEndpoint, IGApiSession session, IGApiDetail apiDetail, String userAgentTitle) {
        return apiEndpoint
            .request(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .header(HEADER_IG_API_KEY, apiDetail.getApiKey())
            .header(HttpHeaders.AUTHORIZATION, "Bearer " + session.getOauthToken().getAccessToken())
            .header(HEADER_IG_ACCOUNT, session.getAccountId())
            .header(HttpHeaders.USER_AGENT, userAgentTitle);
    }

    /**
     *
     * @param session
     * @param client
     * @param apiDetail
     * @param userAgentTitle
     * @return
     */
    public int logout(IGApiSession session, Client client, IGApiDetail apiDetail, String userAgentTitle)  {
        return 0;
    }
}
