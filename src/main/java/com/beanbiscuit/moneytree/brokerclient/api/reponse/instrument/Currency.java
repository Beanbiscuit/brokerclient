package com.beanbiscuit.moneytree.brokerclient.api.reponse.instrument;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
public class Currency {

    @JsonProperty("baseExchangeRate")
    private final float baseExchangeRate;
    /**
     * Code, to be used when placing orders
     */
    @JsonProperty("code")
    private final String code;
    @JsonProperty("exchangeRate")
    private final float exchangeRate;
    @JsonProperty("isDefault")
    private final boolean isDefault;
    @JsonProperty("symbol")
    private final String symbol;

    public Currency(float baseExchangeRate, String code, float exchangeRate, boolean isDefault, String symbol) {
        this.baseExchangeRate = baseExchangeRate;
        this.code = code;
        this.exchangeRate = exchangeRate;
        this.isDefault = isDefault;
        this.symbol = symbol;
    }

    public Currency() {
        this.baseExchangeRate = 0;
        this.code = null;
        this.exchangeRate = 0;
        this.isDefault = false;
        this.symbol = null;
    }

    public float getBaseExchangeRate() {
        return baseExchangeRate;
    }

    public String getCode() {
        return code;
    }

    public float getExchangeRate() {
        return exchangeRate;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public String getSymbol() {
        return symbol;
    }
}
