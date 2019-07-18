package com.beanbiscuit.moneytree.brokerclient.api.reponse.dealing;

import com.beanbiscuit.moneytree.brokerclient.utility.ObjectPrettyPrint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Position data.
 *
 * API reference for the model;
 * https://labs.ig.com/rest-trading-api-reference/service-detail?id=545
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Position {

    @JsonProperty("contractSize")
    private final long contractSize;
    @JsonProperty("controlledRisk")
    private final boolean controlledRisk;
    @JsonProperty("createdDate")
    private final String createdDate;
    @JsonProperty("createdDateUTC")
    private final String createdDateUTC;
    @JsonProperty("currency")
    private final String currency;
    @JsonProperty("dealId")
    private final String dealId;
    /**
     * Constant the deal direction e.g. BUY, SELL
     */
    @JsonProperty("dealReference")
    private final String dealReference;
    @JsonProperty("level")
    private final float level;
    @JsonProperty("limitLevel")
    private final float limitLevel;
    @JsonProperty("size")
    private final float size;
    @JsonProperty("stopLevel")
    private final float stopLevel;
    @JsonProperty("trailingStep")
    private final float trailingStep;
    @JsonProperty("trailingStopDistance")
    private final float trailingStopDistance;

    public Position(
        long contractSize,
        boolean controlledRisk,
        String createdDate,
        String createdDateUTC,
        String currency,
        String dealId,
        String dealReference,
        float level,
        float limitLevel,
        float size,
        float stopLevel,
        float trailingStep,
        float trailingStopDistance
    ) {
        this.contractSize = contractSize;
        this.controlledRisk = controlledRisk;
        this.createdDate = createdDate;
        this.createdDateUTC = createdDateUTC;
        this.currency = currency;
        this.dealId = dealId;
        this.dealReference = dealReference;
        this.level = level;
        this.limitLevel = limitLevel;
        this.size = size;
        this.stopLevel = stopLevel;
        this.trailingStep = trailingStep;
        this.trailingStopDistance = trailingStopDistance;
    }

    public Position() {
        this.contractSize = 0;
        this.controlledRisk = false;
        this.createdDate = null;
        this.createdDateUTC = null;
        this.currency = null;
        this.dealId = null;
        this.dealReference = null;
        this.level = 0;
        this.limitLevel = 0;
        this.size = 0;
        this.stopLevel = 0;
        this.trailingStep = 0;
        this.trailingStopDistance = 0;
    }

    public long getContractSize() {
        return contractSize;
    }

    public boolean isControlledRisk() {
        return controlledRisk;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getCreatedDateUTC() {
        return createdDateUTC;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDealId() {
        return dealId;
    }

    public String getDealReference() {
        return dealReference;
    }

    public float getLevel() {
        return level;
    }

    public float getLimitLevel() {
        return limitLevel;
    }

    public float getSize() {
        return size;
    }

    public float getStopLevel() {
        return stopLevel;
    }

    public float getTrailingStep() {
        return trailingStep;
    }

    public float getTrailingStopDistance() {
        return trailingStopDistance;
    }

    @Override
    public String toString() {
        return ObjectPrettyPrint.print(this);
    }
}