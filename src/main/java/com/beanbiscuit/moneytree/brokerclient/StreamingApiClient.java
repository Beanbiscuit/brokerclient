package com.beanbiscuit.moneytree.brokerclient;

import com.beanbiscuit.moneytree.brokerclient.api.authentication.IGApiSession;
import com.beanbiscuit.moneytree.brokerclient.streamingapi.adapter.ConnectionListenerAdapter;
import com.beanbiscuit.moneytree.brokerclient.streamingapi.adapter.IGListenerAdapter;
import com.beanbiscuit.moneytree.brokerclient.streamingapi.IGSubscriptionKey;
import com.lightstreamer.ls_client.*;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 */
public class StreamingApiClient {

    private static final Logger LOG = Logger.getLogger(StreamingApiClient.class.getSimpleName());

    private final LSClient client;
    private final ConnectionListenerAdapter adapter = new ConnectionListenerAdapter();
    private final ConnectionInfo connectionInfo = new ConnectionInfo();
    private final ArrayList<IGListenerAdapter> adapters = new ArrayList<>();

    public StreamingApiClient() {
        this.client = new LSClient();
    }

    public StreamingApiClient(LSClient client) {
        this.client = client;
    }

    /**
     * @param adapter
     * @param table
     * @throws Exception
     */
    public IGSubscriptionKey subscribe(IGListenerAdapter adapter, ExtendedTableInfo table) throws StreamingApiException {
        try {
            final SubscribedTableKey subscriptionKey = this.client.subscribeTable(
                table,
                adapter,
                false
            );
            adapter.setSubscribedTableKey(subscriptionKey);
            adapters.add(adapter);
            return new IGSubscriptionKey(subscriptionKey.toString());
        } catch (SubscrException | PushServerException | PushUserException | PushConnException e) {
            throw new StreamingApiException(e.getMessage(), e);
        }
    }

    /**
     *
     * @param session
     * @throws StreamingApiException
     */
    public void connect(IGApiSession session) throws StreamingApiException {
        connectionInfo.user = session.getAccountId();
        connectionInfo.password = session.getStreamerPassword();
        connectionInfo.pushServerUrl = session.getLightstreamerEndpoint();

        try {
            this.client.openConnection(connectionInfo, adapter);
        } catch (PushConnException | PushServerException | PushUserException e) {
            throw new StreamingApiException(e.getMessage(), e);
        }
    }

    /**
     *
     * @param adapter
     * @throws Exception
     */
    public void unsubscribe(IGListenerAdapter adapter) throws StreamingApiException {
        try {
            this.client.forceUnsubscribeTable(adapter.getSubscribedTableKey());
            this.adapters.remove(adapter);
        } catch (PushConnException | PushServerException | SubscrException e) {
            throw new StreamingApiException(e.getMessage(), e);
        }
    }

    /**
     * Unsubscribe's the client from all streams and then closes the connection
     *
     * @throws StreamingApiException
     */
    public void close() throws StreamingApiException {
        try {
            for (IGListenerAdapter adapter : adapters) {
                this.client.forceUnsubscribeTable(adapter.getSubscribedTableKey());
            }
        } catch (SubscrException | PushServerException | PushConnException e) {
            throw new StreamingApiException("Failed to unsubscribe stream.", e);
        } finally {
            this.adapters.clear();
            this.client.closeConnection();
        }
    }
}
