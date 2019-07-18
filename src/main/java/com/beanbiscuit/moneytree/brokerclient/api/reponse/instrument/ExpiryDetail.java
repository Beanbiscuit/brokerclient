package com.beanbiscuit.moneytree.brokerclient.api.reponse.instrument;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Market expiry details
 */
public class ExpiryDetail {

    @JsonProperty("lastDealingDate")
    private final String lastDealingDate;
    @JsonProperty("settlementInfo")
    private final String settlementInfo;

    public ExpiryDetail(String lastDealingDate, String settlementInfo) {
        this.lastDealingDate = lastDealingDate;
        this.settlementInfo = settlementInfo;
    }

    public ExpiryDetail() {
        this.lastDealingDate = null;
        this.settlementInfo = null;
    }

    public String getLastDealingDate() {
        return lastDealingDate;
    }

    public String getSettlementInfo() {
        return settlementInfo;
    }
}
