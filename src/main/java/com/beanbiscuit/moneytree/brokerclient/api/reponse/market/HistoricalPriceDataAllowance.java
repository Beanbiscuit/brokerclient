package com.beanbiscuit.moneytree.brokerclient.api.reponse.market;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Historical price data allowance
 */
public class HistoricalPriceDataAllowance {

    @JsonProperty("allowanceExpiry")
    private final int allowanceExpiry;
    @JsonProperty("remainingAllowance")
    private final int remainingAllowance;
    @JsonProperty("totalAllowance")
    private final int totalAllowance;

    public HistoricalPriceDataAllowance(int allowanceExpiry, int remainingAllowance, int totalAllowance) {
        this.allowanceExpiry = allowanceExpiry;
        this.remainingAllowance = remainingAllowance;
        this.totalAllowance = totalAllowance;
    }

    public HistoricalPriceDataAllowance() {
        this.allowanceExpiry = 0;
        this.remainingAllowance = 0;
        this.totalAllowance = 0;
    }

    /**
     * The number of seconds till the current allowance period will end and the remaining allowance field is reset.
     *
     * @return
     */
    public int getAllowanceExpiry() {
        return allowanceExpiry;
    }

    /**
     * The number of data points still available to fetch within the current allowance period.
     *
     * @return
     */
    public int getRemainingAllowance() {
        return remainingAllowance;
    }

    /**
     * The number of data points the API key and account combination is allowed to fetch in any given allowance period.
     *
     * @return
     */
    public int getTotalAllowance() {
        return totalAllowance;
    }
}
