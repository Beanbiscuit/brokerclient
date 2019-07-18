package com.beanbiscuit.moneytree.brokerclient.api.reponse.market;

import com.beanbiscuit.moneytree.brokerclient.utility.ObjectPrettyPrint;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MarketNavigation {

    @JsonProperty("markets")
    private List<Market> markets = new ArrayList<>();
    @JsonProperty("nodes")
    private List<MarketHierarchyNode> hierarchyNodes = new ArrayList<>();

    public List<Market> getMarkets() {
        return markets;
    }

    public List<MarketHierarchyNode> getHierarchyNodes() {
        return hierarchyNodes;
    }

    @Override
    public String toString() {
        return ObjectPrettyPrint.print(this);
    }
}