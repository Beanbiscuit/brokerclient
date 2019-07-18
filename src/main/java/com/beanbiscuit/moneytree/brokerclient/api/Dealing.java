package com.beanbiscuit.moneytree.brokerclient.api;

import com.beanbiscuit.moneytree.brokerclient.ApiClient;
import com.beanbiscuit.moneytree.brokerclient.ApiException;
import com.beanbiscuit.moneytree.brokerclient.api.authentication.IGApiSession;
import com.beanbiscuit.moneytree.brokerclient.api.request.ApiQuery;
import com.beanbiscuit.moneytree.brokerclient.api.reponse.dealing.PositionCollection;

/**
 *
 */
public class Dealing {

    private final ApiClient client;
    private final ApiQuery query = new ApiQuery();

    public Dealing(ApiClient client) {
        this.client = client;
    }

    /**
     * Version 2
     * https://labs.ig.com/rest-trading-api-reference/service-detail?id=545
     *
     * @param from
     * @param to
     * @param session
     * @return
     * @throws ApiException
     */
    public PositionCollection positions(String from, String to, IGApiSession session) throws ApiException {
        query.setHeader("VERSION", "2");
        return (PositionCollection) this.client.get("/positions", query, session, PositionCollection.class);
    }
}
