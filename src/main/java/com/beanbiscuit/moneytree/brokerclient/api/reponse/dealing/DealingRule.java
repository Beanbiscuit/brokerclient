package com.beanbiscuit.moneytree.brokerclient.api.reponse.dealing;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dealing rule.
 */
public class DealingRule {

    public static final String PERCENTAGE = "PERCENTAGE";
    public static final String POINTS = "POINTS";

    /**
     * Constant, describes the dimension for a dealing rule value
     */
    @JsonProperty("unit")
    private final String unit;
    @JsonProperty("value")
    private final float value;

    public DealingRule(String unit, float value) {
        this.unit = unit;
        this.value = value;
    }

    public DealingRule() {
        this.unit = null;
        this.value = 0;
    }

    /**
     * Describes the dimension for a dealing rule value;
     *
     * PERCENTAGE
     * POINTS
     *
     * @return The dimension.
     */
    public String getUnit() {
        return unit;
    }

    public float getValue() {
        return value;
    }
}
