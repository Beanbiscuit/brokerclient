package com.beanbiscuit.moneytree.brokerclient.api.reponse.market;

import com.beanbiscuit.moneytree.brokerclient.utility.ObjectPrettyPrint;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketHierarchyNode {

    @JsonProperty("id")
    private final String id;
    @JsonProperty("name")
    private final String name;

    public MarketHierarchyNode(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public MarketHierarchyNode() {
        this.id = null;
        this.name = null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return ObjectPrettyPrint.print(this);
    }
}