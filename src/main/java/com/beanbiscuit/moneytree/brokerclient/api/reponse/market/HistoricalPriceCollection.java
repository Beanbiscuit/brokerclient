package com.beanbiscuit.moneytree.brokerclient.api.reponse.market;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains response data from queries to the prices end point.
 */
public class HistoricalPriceCollection {

    @JsonProperty("instrumentType")
    private final String instrumentType;
    @JsonProperty("metadata")
    private final HistoricalPriceMetadata metadata;
    @JsonProperty("prices")
    private List<HistoricalPrice> prices = new ArrayList<>();

    public HistoricalPriceCollection(String instrumentType, HistoricalPriceMetadata metadata) {
        this.instrumentType = instrumentType;
        this.metadata = metadata;
    }

    public HistoricalPriceCollection() {
        this.instrumentType = null;
        this.metadata = null;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public HistoricalPriceMetadata getMetadata() {
        return metadata;
    }

    public List<HistoricalPrice> getPrices() {
        return prices;
    }
}
