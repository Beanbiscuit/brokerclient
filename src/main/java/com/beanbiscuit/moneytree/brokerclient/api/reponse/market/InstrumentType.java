package com.beanbiscuit.moneytree.brokerclient.api.reponse.market;

/**
 *
 */
public enum InstrumentType {

    BINARY("Binaries"),
    BUNGEE_CAPPED("Capped bungees"),
    BUNGEE_COMMODITIES("Commodity bungees"),
    BUNGEE_CURRENCIES("Currency bungees"),
    BUNGEE_INDICES("Index bungees"),
    COMMODITIES("Commodities"),
    CURRENCIES("Currencies"),
    INDICES("Indices"),
    OPT_COMMODITIES("Commodity options"),
    OPT_CURRENCIES("Currency options"),
    OPT_INDICES("Index options"),
    OPT_RATES("FX options"),
    OPT_SHARES("Share options"),
    RATES("Rates"),
    SECTORS("Sectors"),
    SHARES("Shares"),
    SPRINT_MARKET("Sprint Market"),
    TEST_MARKET("Test market"),
    UNKNOWN("Unknown");

    private final String value;

    InstrumentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
