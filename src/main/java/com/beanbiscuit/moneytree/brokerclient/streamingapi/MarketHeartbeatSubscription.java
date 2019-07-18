package com.beanbiscuit.moneytree.brokerclient.streamingapi;

import com.beanbiscuit.moneytree.brokerclient.StreamingApiClient;
import com.beanbiscuit.moneytree.brokerclient.StreamingApiException;
import com.lightstreamer.ls_client.ExtendedTableInfo;
import com.lightstreamer.ls_client.SubscrException;
import com.lightstreamer.ls_client.UpdateInfo;

/**
 * Single class for each subscription.
 * Will need to be used in and endpoint class
 * There are not endpoints, move into subscription package
 *
 * streaming-api sub apackage contetns
 *
 * repository
 * adapter
 * subscription
 * table
 *
 * api subpackage contents
 *
 * repository
 * query
 * authenticatiob
 *
 */
public class MarketHeartbeatSubscription extends IGSubscription {

    public MarketHeartbeatSubscription(StreamingApiClient client) {
        super(client);
    }

    public MarketHeartbeatSubscription() {
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

    /**
     * Returns the most recent subscription content update.
     *
     * @return
     */
    public UpdateInfo getUpdateItem() {
        return adapter.getLatestUpdateInfo();
    }
}