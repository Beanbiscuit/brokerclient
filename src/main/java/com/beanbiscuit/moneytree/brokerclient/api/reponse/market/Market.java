package com.beanbiscuit.moneytree.brokerclient.api.reponse.market;

import com.beanbiscuit.moneytree.brokerclient.utility.ObjectPrettyPrint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Market data.
 *
 * API reference for the model;
 * https://labs.ig.com/rest-trading-api-reference/service-detail?id=545
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Market {

    @JsonProperty("bid")
    private final float bid;
    @JsonProperty("delayTime")
    private final long delayTime;
    /**
     * The markets unique id.
     */
    @JsonProperty("epic")
    private final String epic;
    @JsonProperty("expiry")
    private final String expiry;
    @JsonProperty("high")
    private final float high;
    /**
     * The name of the market.
     */
    @JsonProperty("instrumentName")
    private final String instrumentName;
    /**
     * Constant, the market type e.g. Indices, Forex, Sprint etc
     */
    @JsonProperty("instrumentType")
    private final String instrumentType;
    @JsonProperty("lotSize")
    private final float lotSize;
    @JsonProperty("low")
    private final float low;
    /**
     * Constant, the status of the market e.g. CLOSED, OFFLINE etc
     */
    @JsonProperty("marketStatus")
    private final String marketStatus;
    @JsonProperty("netChange")
    private final float netChange;
    @JsonProperty("offer")
    private final float offer;
    @JsonProperty("percentageChange")
    private final float percentageChange;
    @JsonProperty("scalingFactor")
    private final float scalingFactor;
    @JsonProperty("streamingPricesAvailable")
    private final boolean streamingPricesAvailable;
    @JsonProperty("updateTime")
    private final String updateTime;
    @JsonProperty("updateTimeUTC")
    private final String updateTimeUTC;

    public Market(
        float bid,
        long delayTime,
        String epic,
        String expiry,
        float high,
        String instrumentName,
        String instrumentType,
        float lotSize,
        float low,
        String marketStatus,
        float netChange,
        float offer,
        float percentageChange,
        float scalingFactor,
        boolean streamingPricesAvailable,
        String updateTime,
        String updateTimeUTC
    ) {
        this.bid = bid;
        this.delayTime = delayTime;
        this.epic = epic;
        this.expiry = expiry;
        this.high = high;
        this.instrumentName = instrumentName;
        this.instrumentType = instrumentType;
        this.lotSize = lotSize;
        this.low = low;
        this.marketStatus = marketStatus;
        this.netChange = netChange;
        this.offer = offer;
        this.percentageChange = percentageChange;
        this.scalingFactor = scalingFactor;
        this.streamingPricesAvailable = streamingPricesAvailable;
        this.updateTime = updateTime;
        this.updateTimeUTC = updateTimeUTC;
    }

    public Market() {
        this.bid = 0;
        this.delayTime = 0;
        this.epic = null;
        this.expiry = null;
        this.high = 0;
        this.instrumentName = null;
        this.instrumentType = null;
        this.lotSize = 0;
        this.low = 0;
        this.marketStatus = null;
        this.netChange = 0;
        this.offer = 0;
        this.percentageChange = 0;
        this.scalingFactor = 0;
        this.streamingPricesAvailable = false;
        this.updateTime = null;
        this.updateTimeUTC = null;
    }

    public float getBid() {
        return bid;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public String getEpic() {
        return epic;
    }

    public String getExpiry() {
        return expiry;
    }

    public float getHigh() {
        return high;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public float getLotSize() {
        return lotSize;
    }

    public float getLow() {
        return low;
    }

    public String getMarketStatus() {
        return marketStatus;
    }

    public float getNetChange() {
        return netChange;
    }

    public float getOffer() {
        return offer;
    }

    public float getPercentageChange() {
        return percentageChange;
    }

    public float getScalingFactor() {
        return scalingFactor;
    }

    public boolean isStreamingPricesAvailable() {
        return streamingPricesAvailable;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getUpdateTimeUTC() {
        return updateTimeUTC;
    }

    @Override
    public String toString() {
        return ObjectPrettyPrint.print(this);
    }
}