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
public class SecurityTokenAccess implements AuthenticationStrategy {

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
            .header(HEADER_VERSION, "2")
            .header(HttpHeaders.USER_AGENT, userAgentTitle);

        this.credentials.put("identifier", credentials.getUsername());
        this.credentials.put("password", credentials.getPassword());

        final Response authResponse = requestBuilder.post(Entity.json(this.credentials));
        this.credentials.clear();

        if (authResponse.getStatus() != 200) {
            throw new AuthenticationException(authResponse.getStatus(), authResponse.readEntity(String.class));
        }

        final IGApiSession igApiSession = authResponse.readEntity(IGApiSession.class);
        igApiSession.setCst(authResponse.getHeaders().get("CST").get(0).toString());
        igApiSession.setXSecurityToken(authResponse.getHeaders().get("X-SECURITY-TOKEN").get(0).toString());

        return igApiSession;
    }

    public int logout(
        IGApiSession session,
        Client client,
        IGApiDetail apiDetail,
        String userAgentTitle)
    {
        final WebTarget authenticationEndpoint = client.target(apiDetail.getApiBaseUrl().concat(AuthenticationStrategy.AUTH_ENDPOINT));
        final Invocation.Builder requestBuilder = authenticationEndpoint
            .request(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .header(HEADER_IG_ACCOUNT, session.getAccountId())
            .header(AuthenticationStrategy.HEADER_IG_API_KEY, apiDetail.getApiKey())
            .header(AuthenticationStrategy.HEADER_VERSION, "1")
            .header(HttpHeaders.USER_AGENT, userAgentTitle);

        final Response authResponse = requestBuilder.delete();
        return authResponse.getStatus();
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
}
