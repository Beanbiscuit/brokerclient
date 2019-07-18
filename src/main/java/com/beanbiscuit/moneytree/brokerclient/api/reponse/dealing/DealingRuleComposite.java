package com.beanbiscuit.moneytree.brokerclient.api.reponse.dealing;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dealing rules.
 */
public class DealingRuleComposite {

    /**
     * Market orders are allowed for the account type and instrument, and the user has enabled market orders in their
     * preferences but decided the default state is off.
     */
    public static final String AVAILABLE_DEFAULT_OFF = "AVAILABLE_DEFAULT_OFF";

    /**
     * Market orders are allowed for the account type and instrument, and the user has enabled market orders in their
     * preferences and has decided the default state is on.
     */
    public static final String AVAILABLE_DEFAULT_ON = "AVAILABLE_DEFAULT_ON";

    /**
     * Market orders are not allowed for the current site and/or instrument.
     */
    public static final String NOT_AVAILABLE = "NOT_AVAILABLE";
    public static final String AVAILABLE = "AVAILABLE";

    /**
     * Constant, Client's market order trading preference
     */
    @JsonProperty("marketOrderPreference")
    private final String marketOrderPreference;
    @JsonProperty("maxStopOrLimitDistance")
    private final DealingRule maxStopOrLimitDistance;
    @JsonProperty("minControlledRiskStopDistance")
    private final DealingRule minControlledRiskStopDistance;
    @JsonProperty("minDealSize")
    private final DealingRule minDealSize;
    @JsonProperty("minNormalStopOrLimitDistance")
    private final DealingRule minNormalStopOrLimitDistance;
    @JsonProperty("minStepDistance")
    private final DealingRule minStepDistance;
    @JsonProperty("trailingStopsPreference")
    private final String trailingStopsPreference;

    public DealingRuleComposite(
        String marketOrderPreference,
        DealingRule maxStopOrLimitDistance,
        DealingRule minControlledRiskStopDistance,
        DealingRule minDealSize,
        DealingRule minNormalStopOrLimitDistance,
        DealingRule minStepDistance,
        String trailingStopsPreference
    ) {
        this.marketOrderPreference = marketOrderPreference;
        this.maxStopOrLimitDistance = maxStopOrLimitDistance;
        this.minControlledRiskStopDistance = minControlledRiskStopDistance;
        this.minDealSize = minDealSize;
        this.minNormalStopOrLimitDistance = minNormalStopOrLimitDistance;
        this.minStepDistance = minStepDistance;
        this.trailingStopsPreference = trailingStopsPreference;
    }

    public DealingRuleComposite() {
        this.marketOrderPreference = null;
        this.maxStopOrLimitDistance = null;
        this.minControlledRiskStopDistance = null;
        this.minDealSize = null;
        this.minNormalStopOrLimitDistance = null;
        this.minStepDistance = null;
        this.trailingStopsPreference = null;
    }

    public String getMarketOrderPreference() {
        return marketOrderPreference;
    }

    public DealingRule getMaxStopOrLimitDistance() {
        return maxStopOrLimitDistance;
    }

    public DealingRule getMinControlledRiskStopDistance() {
        return minControlledRiskStopDistance;
    }

    public DealingRule getMinDealSize() {
        return minDealSize;
    }

    public DealingRule getMinNormalStopOrLimitDistance() {
        return minNormalStopOrLimitDistance;
    }

    public DealingRule getMinStepDistance() {
        return minStepDistance;
    }

    public String getTrailingStopsPreference() {
        return trailingStopsPreference;
    }
}
