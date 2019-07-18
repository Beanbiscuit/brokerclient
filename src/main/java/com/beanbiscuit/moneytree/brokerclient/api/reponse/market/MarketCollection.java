package com.beanbiscuit.moneytree.brokerclient.api.reponse.market;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class MarketCollection {

    @JsonProperty("markets")
    private final List<Market> markets = new ArrayList<>();

    public List<Market> getMarkets() {
        return markets;
    }
}
