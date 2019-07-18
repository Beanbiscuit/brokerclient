package com.beanbiscuit.moneytree.brokerclient.api.reponse.market;

public enum MarketDetailsFilterType {

    ALL("ALL"),
    SNAPSHOT_ONLY("SNAPSHOT_ONLY");

    private final String value;

    MarketDetailsFilterType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
