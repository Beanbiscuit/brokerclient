package com.beanbiscuit.moneytree.brokerclient.streamingapi.adapter;

import com.lightstreamer.ls_client.ConnectionListener;
import com.lightstreamer.ls_client.PushConnException;
import com.lightstreamer.ls_client.PushServerException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class ConnectionListenerAdapter implements ConnectionListener {

    private static final Logger LOG = Logger.getLogger(ConnectionListenerAdapter.class.getSimpleName());

    @Override
    public void onConnectionEstablished() {
        LOG.log(Level.FINEST, "Connection established.");
    }

    @Override
    public void onSessionStarted(boolean b) {
        LOG.log(Level.FINEST, "Session started: " + b);
    }

    @Override
    public void onNewBytes(long l) {

    }

    @Override
    public void onDataError(PushServerException e) {
        LOG.log(Level.WARNING, "Data Error: " + e.getMessage());
    }

    @Override
    public void onActivityWarning(boolean b) {
        LOG.log(Level.WARNING, "Activity warning: " + b);
    }

    @Override
    public void onClose() {
        LOG.log(Level.INFO, "Closing stream.");
    }

    @Override
    public void onEnd(int i) {
        LOG.log(Level.FINEST, "End status: " + i);
    }

    @Override
    public void onFailure(PushServerException e) {
        LOG.log(Level.FINEST, "Failure. Push server: " + e.getMessage());
    }

    @Override
    public void onFailure(PushConnException e) {
        LOG.log(Level.WARNING, "Failure. Push connection: " + e.getMessage());
    }
}
