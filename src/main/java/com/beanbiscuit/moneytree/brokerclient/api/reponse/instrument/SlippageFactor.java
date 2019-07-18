package com.beanbiscuit.moneytree.brokerclient.api.reponse.instrument;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Slippage factor details for a given market.
 */
public class SlippageFactor {

    @JsonProperty("unit")
    private final String unit;
    @JsonProperty("value")
    private final float value;

    public SlippageFactor(String unit, float value) {
        this.unit = unit;
        this.value = value;
    }

    public SlippageFactor() {
        this.unit = null;
        this.value = 0;
    }

    public String getUnit() {
        return unit;
    }

    public float getValue() {
        return value;
    }
}
