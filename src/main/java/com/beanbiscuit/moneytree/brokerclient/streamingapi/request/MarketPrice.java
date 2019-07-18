package com.beanbiscuit.moneytree.brokerclient.streamingapi.request;

import java.util.ArrayList;
import java.util.List;

public class MarketPrice extends IGQuery {

    public static final String MID_OPEN = "MID_OPEN";
    public static final String HIGH = "HIGH";
    public static final String LOW = "LOW";
    public static final String CHANGE = "CHANGE";
    public static final String CHANGE_PCT = "CHANGE_PCT";
    public static final String UPDATE_TIME = "UPDATE_TIME";
    public static final String MARKET_DELAY = "MARKET_DELAY";
    public static final String MARKET_STATE = "MARKET_STATE";
    public static final String BID = "BID";
    public static final String OFFER = "OFFER";
    public static final String STRIKE_PRICE = "STRIKE_PRICE";
    public static final String ODDS = "ODDS";

    public static final String NAME = "MARKET";
    public static final String MODE = "MERGE";

    private final List<String> fields = new ArrayList<>();

    /**
     * @param field
     * @return
     */
    public MarketPrice addField(String field) {
        fields.add(field);
        return this;
    }

    public String getQuery() {
        return null;
    }

    public String getMode() {
        return MODE;
    }

    public String getName() {
        return NAME;
    }

}
