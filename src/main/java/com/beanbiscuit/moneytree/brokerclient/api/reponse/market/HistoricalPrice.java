package com.beanbiscuit.moneytree.brokerclient.api.reponse.market;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Historical market price snapshot.
 */
public class HistoricalPrice {

    @JsonProperty("closePrice")
    private final Price closePrice;
    @JsonProperty("highPrice")
    private final Price highPrice;
    @JsonProperty("lastTradedVolume")
    private final int lastTradedVolume;
    @JsonProperty("lowPrice")
    private final Price lowPrice;
    @JsonProperty("openPrice")
    private final Price openPrice;
    @JsonProperty("snapshotTime")
    private final String snapshotTime;
    @JsonProperty("snapshotTimeUTC")
    private final String snapshotTimeUTC;

    public HistoricalPrice(
        Price closePrice,
        Price highPrice,
        int lastTradedVolume,
        Price lowPrice,
        Price openPrice,
        String snapshotTime, String snapshotTimeUTC) {
        this.closePrice = closePrice;
        this.highPrice = highPrice;
        this.lastTradedVolume = lastTradedVolume;
        this.lowPrice = lowPrice;
        this.openPrice = openPrice;
        this.snapshotTime = snapshotTime;
        this.snapshotTimeUTC = snapshotTimeUTC;
    }

    public HistoricalPrice() {
        this.closePrice = null;
        this.highPrice = null;
        this.lastTradedVolume = 0;
        this.lowPrice = null;
        this.openPrice = null;
        this.snapshotTime = null;
        this.snapshotTimeUTC = null;
    }

    public Price getClosePrice() {
        return closePrice;
    }

    public Price getHighPrice() {
        return highPrice;
    }

    public int getLastTradedVolume() {
        return lastTradedVolume;
    }

    public Price getLowPrice() {
        return lowPrice;
    }

    public Price getOpenPrice() {
        return openPrice;
    }

    /**
     * Snapshot local time, format is yyyy/MM/dd hh:mm:ss
     *
     * @return
     */
    public String getSnapshotTime() {
        return snapshotTime;
    }

    /**
     * Snapshot time.
     *
     * @return
     */
    public String getSnapshotTimeUTC() {
        return snapshotTimeUTC;
    }
}
