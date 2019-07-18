package com.beanbiscuit.moneytree.brokerclient.api;

import com.beanbiscuit.moneytree.brokerclient.ApiClient;
import com.beanbiscuit.moneytree.brokerclient.ApiException;
import com.beanbiscuit.moneytree.brokerclient.api.authentication.IGApiSession;
import com.beanbiscuit.moneytree.brokerclient.api.request.ApiQuery;
import com.beanbiscuit.moneytree.brokerclient.utility.JsonPrettyPrint;

/**
 *
 */
public class Account {

    private final ApiClient client;

    public Account(ApiClient client) {
        this.client = client;
    }
}
