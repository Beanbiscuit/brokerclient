package com.beanbiscuit.moneytree.brokerclient.api.reponse.market;

import com.beanbiscuit.moneytree.brokerclient.api.reponse.dealing.DealingRuleComposite;
import com.beanbiscuit.moneytree.brokerclient.api.reponse.instrument.Instrument;
import com.beanbiscuit.moneytree.brokerclient.api.reponse.instrument.Snapshot;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class MarketDetail {

    @JsonProperty("dealingRules")
    private final DealingRuleComposite dealingRules;
    @JsonProperty("instrument")
    private final Instrument instrument;
    @JsonProperty("snapshot")
    private final Snapshot snapshot;

    public MarketDetail(DealingRuleComposite dealingRule, Instrument instrument, Snapshot snapshot) {
        this.dealingRules = dealingRule;
        this.instrument = instrument;
        this.snapshot = snapshot;
    }

    public MarketDetail() {
        this.dealingRules = null;
        this.instrument = null;
        this.snapshot = null;
    }

    public DealingRuleComposite getDealingRules() {
        return dealingRules;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public Snapshot getSnapshot() {
        return snapshot;
    }
}
