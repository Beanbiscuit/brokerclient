package com.beanbiscuit.moneytree.brokerclient.api.reponse.instrument;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * bid (Number)	Bid price
 * binaryOdds (Number)	Binary odds
 * controlledRiskExtraSpread (Number)	the number of points to add on each side of the market as an additional spread when placing a guaranteed stop trade.
 * decimalPlacesFactor (Number)	Number of decimal positions for market levels
 * delayTime (Number)	Price delay
 * high (Number)	Highest price on the day
 * low (Number)	Lowest price on the day
 * marketStatus (Constant)
 * Describes the current status of a given market
 * CLOSED 	Closed
 * EDITS_ONLY	Open for edits
 * OFFLINE	Offline
 * ON_AUCTION	In auction mode
 * ON_AUCTION_NO_EDITS	In no-edits mode
 * SUSPENDED	Suspended
 * TRADEABLE	Open for trades
 * netChange (Number)	Net price change on the day
 * offer (Number)	Offer price
 * percentageChange (Number)	Percentage price change on the day
 * scalingFactor (Number)	Multiplying factor to determine actual pip value for the levels used by the instrument
 * updateTime (String)	Time of last price update
 */
public class Snapshot {

    public static final String CLOSED = "CLOSED";

    /**
     * Open for edits
     */
    public static final String EDITS_ONLY = "EDITS_ONLY";

    public static final String OFFLINE = "OFFLINE";

    /**
     * In auction mode
     */
    public static final String ON_AUCTION = "ON_AUCTION";

    public static final String ON_AUCTION_NO_EDITS = "ON_AUCTION_NO_EDITS";
    public static final String SUSPENDED = "SUSPENDED";
    public static final String TRADEABLE = "TRADEABLE";

    @JsonProperty("bid")
    private final float bid;
    @JsonProperty("binaryOdds")
    private final float binaryOdds;
    @JsonProperty("controlledRiskExtraSpread")
    private final float controlledRiskExtraSpread;
    @JsonProperty("decimalPlacesFactor")
    private final float decimalPlacesFactor;
    @JsonProperty("delayTime")
    private final float delayTime;
    @JsonProperty("high")
    private final float high;
    @JsonProperty("low")
    private final float low;
    @JsonProperty("marketStatus")
    private final String marketStatus;
    @JsonProperty("netChange")
    private final float netChange;
    @JsonProperty("offer")
    private final float offer;
    @JsonProperty("percentageChange")
    private final float percentageChange;
    @JsonProperty("scalingFactor")
    private final boolean scalingFactor;
    @JsonProperty("updateTime")
    private final String updateTime;

    public Snapshot(
        float bid,
        float binaryOdds,
        float controlledRiskExtraSpread,
        float decimalPlacesFactor,
        float delayTime,
        float high,
        float low,
        String marketStatus,
        float netChange,
        float offer,
        float percentageChange,
        boolean scalingFactor,
        String updateTime
    ) {
        this.bid = bid;
        this.binaryOdds = binaryOdds;
        this.controlledRiskExtraSpread = controlledRiskExtraSpread;
        this.decimalPlacesFactor = decimalPlacesFactor;
        this.delayTime = delayTime;
        this.high = high;
        this.low = low;
        this.marketStatus = marketStatus;
        this.netChange = netChange;
        this.offer = offer;
        this.percentageChange = percentageChange;
        this.scalingFactor = scalingFactor;
        this.updateTime = updateTime;
    }

    public Snapshot() {
        this.bid = 0;
        this.binaryOdds = 0;
        this.controlledRiskExtraSpread = 0;
        this.decimalPlacesFactor = 0;
        this.delayTime = 0;
        this.high = 0;
        this.low = 0;
        this.marketStatus = null;
        this.netChange = 0;
        this.offer = 0;
        this.percentageChange = 0;
        this.scalingFactor = false;
        this.updateTime = null;
    }

    public float getBid() {
        return bid;
    }

    public float getBinaryOdds() {
        return binaryOdds;
    }

    /**
     * The number of points to add on each side of the market as an additional spread when placing a guaranteed stop
     * trade.
     *
     * @return
     */
    public float getControlledRiskExtraSpread() {
        return controlledRiskExtraSpread;
    }

    /**
     * Number of decimal positions for market levels.
     *
     * @return
     */
    public float getDecimalPlacesFactor() {
        return decimalPlacesFactor;
    }

    public float getDelayTime() {
        return delayTime;
    }

    public float getHigh() {
        return high;
    }

    public float getLow() {
        return low;
    }

    /**
     * Describes the current status of a given market.
     *
     * @return
     */
    public String getMarketStatus() {
        return marketStatus;
    }

    /**
     * Net price change on the day.
     *
     * @return
     */
    public float getNetChange() {
        return netChange;
    }

    public float getOffer() {
        return offer;
    }

    /**
     * Percentage price change on the day.
     *
     * @return
     */
    public float getPercentageChange() {
        return percentageChange;
    }

    /**
     * Multiplying factor to determine actual pip value for the levels used by the instrument.
     *
     * @return
     */
    public boolean isScalingFactor() {
        return scalingFactor;
    }

    /**
     * Time of last price update.
     *
     * @return
     */
    public String getUpdateTime() {
        return updateTime;
    }
}
