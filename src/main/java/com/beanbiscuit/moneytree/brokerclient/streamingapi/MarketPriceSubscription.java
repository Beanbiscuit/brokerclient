package com.beanbiscuit.moneytree.brokerclient.streamingapi;

import com.beanbiscuit.moneytree.brokerclient.StreamingApiClient;
import com.beanbiscuit.moneytree.brokerclient.StreamingApiException;
import com.lightstreamer.ls_client.ExtendedTableInfo;
import com.lightstreamer.ls_client.SubscrException;

public class MarketPriceSubscription extends IGSubscription {

    private static final String SUBSCRIPTION_NAME = "MARKET";

    public MarketPriceSubscription(StreamingApiClient client) {
        super(client);
    }

    public MarketPriceSubscription() {
        super();
    }

    /**
     *
     * @throws StreamingApiException
     */
    public void connect() throws StreamingApiException {
        try {
            ExtendedTableInfo table = new ExtendedTableInfo(
                new String[]{"TRADE:HB.U.HEARTBEAT.IP"},
                "MERGE",
                new String[]{"HEARTBEAT"},
                false
            );
            this.key = client.subscribe(adapter, table);
        } catch (SubscrException e) {
            throw new StreamingApiException(e.getMessage(), e);
        }
    }
}
