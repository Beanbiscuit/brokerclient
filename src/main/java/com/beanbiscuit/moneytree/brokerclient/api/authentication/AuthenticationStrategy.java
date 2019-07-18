package com.beanbiscuit.moneytree.brokerclient.api.authentication;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public interface AuthenticationStrategy {

    String AUTH_ENDPOINT = "/session";
    String HEADER_VERSION = "VERSION";
    String HEADER_IG_API_KEY = "X-IG-API-KEY";
    String HEADER_IG_ACCOUNT = "IG-ACCOUNT-ID";

    /**
     *
     * @param client
     * @param apiDetail
     * @param credentials
     * @param userAgentTitle
     * @return
     * @throws AuthenticationException
     */
    IGApiSession authentication(
        Client client,
        IGApiDetail apiDetail,
        AccountCredential credentials,
        String userAgentTitle
    ) throws AuthenticationException;

    /**
     *
     * @param apiEndpoint
     * @param session
     * @param apiDetail
     * @param userAgentTitle
     * @return
     */
    Invocation.Builder authorize(WebTarget apiEndpoint, IGApiSession session, IGApiDetail apiDetail, String userAgentTitle);

    /**
     *
     * @param session
     * @param client
     * @param apiDetail
     * @param userAgentTitle
     * @return
     */
    int logout(IGApiSession session, Client client, IGApiDetail apiDetail, String userAgentTitle);
}
