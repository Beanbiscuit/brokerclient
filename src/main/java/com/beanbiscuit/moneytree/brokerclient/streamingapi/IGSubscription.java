package com.beanbiscuit.moneytree.brokerclient.streamingapi;

import com.beanbiscuit.moneytree.brokerclient.StreamingApiClient;
import com.beanbiscuit.moneytree.brokerclient.StreamingApiException;
import com.beanbiscuit.moneytree.brokerclient.api.authentication.IGApiSession;
import com.beanbiscuit.moneytree.brokerclient.streamingapi.adapter.IGListenerAdapter;
import com.lightstreamer.ls_client.UpdateInfo;

abstract class IGSubscription {

    private static final String TRADE_PATTERN = "TRADE:{accountId}";
    private static final String ACCOUNT_BALANCE_INFO_PATTERN = "ACCOUNT:{accountId}";
    private static final String MARKET_L1_PATTERN = "MARKET:{epic}";
    private static final String SPRINT_MARKET_PATTERN = "MARKET:{epic}";
    private static final String CHART_TICK_PATTERN = "CHART:{epic}:TICK";
    private static final String CHART_CANDLE_PATTERN = "CHART:{epic}:{scale}";

    protected final StreamingApiClient client;
    protected IGSubscriptionKey key;
    protected IGListenerAdapter adapter = new IGListenerAdapter();

    public IGSubscription(StreamingApiClient client) {
        this.client = client;
    }

    public IGSubscription() {
        this.client = new StreamingApiClient();
    }

    public final void open(IGApiSession session) throws StreamingApiException {
        this.client.connect(session);
    }

    public IGSubscriptionKey getKey() {
        return key;
    }

    public abstract void connect() throws StreamingApiException;

    /**
     *
     * @throws StreamingApiException
     */
    public final void close() throws StreamingApiException {
        this.client.close();
    }

    /**
     * @return
     */
    public UpdateInfo getUpdateItem() {
        return adapter.getLatestUpdateInfo();
    }
}
