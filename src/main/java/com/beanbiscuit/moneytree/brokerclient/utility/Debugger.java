package com.beanbiscuit.moneytree.brokerclient.utility;

import org.glassfish.jersey.logging.LoggingFeature;

import javax.ws.rs.client.Client;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Debugger {

    private static final Logger LOG = Logger.getLogger(Debugger.class.getSimpleName());
    private final boolean enabled;

    public Debugger(boolean enabled) {
        this.enabled = enabled;
    }

    public Debugger() {
        this.enabled = true;
    }

    public void attachLogger(Client client, Level level) {
        if (this.enabled) {
            Logger logger = Logger.getLogger(client.getClass().getName());
            client.register(new LoggingFeature(logger, level, null, null));
        }
    }

    public void logJson(String str) {
        LOG.log(Level.parse("DEBUG"), JsonPrettyPrint.print(str));
    }
}
