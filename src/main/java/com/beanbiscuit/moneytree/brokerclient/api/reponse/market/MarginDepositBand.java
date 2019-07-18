package com.beanbiscuit.moneytree.brokerclient.api.reponse.market;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class MarginDepositBand {

    /**
     * The currency for this currency band factor calculation
     */
    @JsonProperty("currency")
    private final String currency;
    @JsonProperty("margin")
    private final float margin;
    @JsonProperty("max")
    private final float max;
    @JsonProperty("min")
    private final float min;

    public MarginDepositBand(String currency, float margin, float max, float min) {
        this.currency = currency;
        this.margin = margin;
        this.max = max;
        this.min = min;
    }

    public MarginDepositBand() {
        this.currency = null;
        this.margin = 0;
        this.max = 0;
        this.min = 0;
    }

    public String getCurrency() {
        return currency;
    }

    public float getMargin() {
        return margin;
    }

    public float getMax() {
        return max;
    }

    public float getMin() {
        return min;
    }
}
