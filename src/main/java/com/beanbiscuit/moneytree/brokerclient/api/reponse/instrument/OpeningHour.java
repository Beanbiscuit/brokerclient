package com.beanbiscuit.moneytree.brokerclient.api.reponse.instrument;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class OpeningHour {

    @JsonProperty("marketTimes")
    private final List<TimeRange> marketTimes = new ArrayList<>();

    public List<TimeRange> getMarketTimes() {
        return marketTimes;
    }
}
