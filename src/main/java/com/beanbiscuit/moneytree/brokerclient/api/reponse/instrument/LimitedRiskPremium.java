package com.beanbiscuit.moneytree.brokerclient.api.reponse.instrument;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The limited risk premium.
 *
 * unit (Constant)
 * describes the dimension for a dealing rule value
 * PERCENTAGE
 * POINTS
 * value (Number)
 */
public class LimitedRiskPremium {

    @JsonProperty("unit")
    private final String unit;
    @JsonProperty("value")
    private final String value;

    public LimitedRiskPremium(String unit, String value) {
        this.unit = unit;
        this.value = value;
    }

    public LimitedRiskPremium() {
        this.unit = null;
        this.value = null;
    }
}
