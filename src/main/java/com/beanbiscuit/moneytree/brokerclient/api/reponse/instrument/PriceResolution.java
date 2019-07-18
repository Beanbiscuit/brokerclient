package com.beanbiscuit.moneytree.brokerclient.api.reponse.instrument;

/**
 * Price resolution
 *
 * Defines the resolution of requested prices.
 */
public enum PriceResolution {

    DAY("DAY"),
    HOUR("HOUR"),
    HOUR_2("HOUR_2"),
    HOUR_3("HOUR_3"),
    HOUR_4("HOUR_4"),
    MINUTE("MINUTE"),
    MONTH_10("MINUTE_10"),
    MONTH_15("MINUTE_15"),
    MINUTE_2("MINUTE_2"),
    MINUTE_3("MINUTE_3"),
    MINUTE_30("MINUTE_30"),
    MINUTE_5("MINUTE_5"),
    MONTH("MONTH"),
    SECOND("SECOND"),
    WEEK("WEEK");

    private final String value;

    PriceResolution(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
