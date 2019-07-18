package com.beanbiscuit.moneytree.brokerclient.streamingapi.adapter;

import com.beanbiscuit.moneytree.brokerclient.utility.Debugger;
import com.lightstreamer.ls_client.HandyTableListener;
import com.lightstreamer.ls_client.SubscribedTableKey;
import com.lightstreamer.ls_client.UpdateInfo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class IGListenerAdapter implements HandyTableListener {

    protected static final Logger LOG = Logger.getLogger(IGListenerAdapter.class.getSimpleName());

    protected final Debugger debug;
    protected UpdateInfo latestUpdateInfo;
    protected SubscribedTableKey subscribedTableKey;

    /**
     * Instantiate the streaming adapter instance in debug mode.
     *
     * @param debug
     */
    public IGListenerAdapter(Debugger debug) {
        this.debug = debug;
    }

    public IGListenerAdapter() {
        this.debug = null;
    }

    /**
     * Returns the most recent update from the streaming server.
     *
     * @return
     */
    public UpdateInfo getLatestUpdateInfo() {
        return latestUpdateInfo;
    }

    /**
     * Updates the local update info instance with the latest values in the stream.
     *
     * @todo use object output and object input to stream the data from adapter to calling class
     * @param i
     * @param s
     * @param updateInfo
     */
    @Override
    public void onUpdate(int i, String s, UpdateInfo updateInfo) {
        LOG.log(Level.INFO,updateInfo.getItemName() + " " + i + " " + s + " " + updateInfo);
        this.latestUpdateInfo = updateInfo;
    }

    @Override
    public void onSnapshotEnd(int i, String s) {
        LOG.log(Level.FINEST,"Snapshot ended " + i + " " + s);
    }

    @Override
    public void onRawUpdatesLost(int i, String s, int i1) {
        LOG.log(Level.WARNING,"Raw update is lost " + i + " " + s + " " + i1);
    }

    @Override
    public void onUnsubscr(int i, String s) {
        LOG.log(Level.INFO,"Unsubscribed " + i + " " + s);
    }

    @Override
    public void onUnsubscrAll() {
        LOG.log(Level.FINEST,"Unsubscribed all.");
    }

    /**
     * Adapter instances are uniquely identified by the stream subscription key.
     *
     * Allows client code to keep a register of adapters by using the subscription key as identifier.
     *
     * @return
     */
    public SubscribedTableKey getSubscribedTableKey() {
        return subscribedTableKey;
    }

    /**
     *
     * @param subscribedTableKey
     */
    public void setSubscribedTableKey(SubscribedTableKey subscribedTableKey) {
        LOG.log(Level.FINEST,"Setting new subscription key: " + subscribedTableKey.toString());
        this.subscribedTableKey = subscribedTableKey;
    }
}
