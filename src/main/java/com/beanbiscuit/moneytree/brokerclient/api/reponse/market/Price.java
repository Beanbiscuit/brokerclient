package com.beanbiscuit.moneytree.brokerclient.api.reponse.market;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The market price.
 */
public class Price {

    @JsonProperty("ask")
    private final float ask;
    @JsonProperty("bid")
    private final float bid;
    @JsonProperty("lastTraded")
    private final float lastTraded;

    public Price(float ask, float bid, float lastTraded) {
        this.ask = ask;
        this.bid = bid;
        this.lastTraded = lastTraded;
    }

    public Price() {
        this.ask = 0;
        this.bid = 0;
        this.lastTraded = 0;
    }

    /**
     * The ask price.
     *
     * @return
     */
    public float getAsk() {
        return ask;
    }

    /**
     * The bid price.
     *
     * @return
     */
    public float getBid() {
        return bid;
    }

    /**
     * Last traded price. This will generally be null for non exchange-traded instruments.
     *
     * @return
     */
    public float getLastTraded() {
        return lastTraded;
    }
}
