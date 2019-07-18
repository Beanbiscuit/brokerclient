package com.beanbiscuit.moneytree.brokerclient.api.reponse.instrument;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Market rollover details
 */
public class RolloverDetail {

    @JsonProperty("lastRolloverTime")
    private final String lastRolloverTime;
    @JsonProperty("rolloverInfo")
    private final String rolloverInfo;

    public RolloverDetail(String lastRolloverTime, String rolloverInfo) {
        this.lastRolloverTime = lastRolloverTime;
        this.rolloverInfo = rolloverInfo;
    }

    public RolloverDetail() {
        this.lastRolloverTime = null;
        this.rolloverInfo = null;
    }

    public String getLastRolloverTime() {
        return lastRolloverTime;
    }

    public String getRolloverInfo() {
        return rolloverInfo;
    }
}
