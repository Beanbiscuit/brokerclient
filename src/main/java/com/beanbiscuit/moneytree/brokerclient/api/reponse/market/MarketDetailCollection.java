package com.beanbiscuit.moneytree.brokerclient.api.reponse.market;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class MarketDetailCollection {

    @JsonProperty("marketDetails")
    private List<MarketDetail> marketDetails = new ArrayList<>();

    public List<MarketDetail> getMarketDetails() {
        return marketDetails;
    }
}
