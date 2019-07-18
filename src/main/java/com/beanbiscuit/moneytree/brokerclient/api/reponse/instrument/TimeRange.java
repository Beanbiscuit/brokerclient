package com.beanbiscuit.moneytree.brokerclient.api.reponse.instrument;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class TimeRange {

    @JsonProperty("closeTime")
    private final String closeTime;
    @JsonProperty("openTime")
    private final String openTime;

    public TimeRange(String closeTime, String openTime) {
        this.closeTime = closeTime;
        this.openTime = openTime;
    }

    public TimeRange() {
        this.closeTime = null;
        this.openTime = null;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public String getOpenTime() {
        return openTime;
    }
}
