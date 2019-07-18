package com.beanbiscuit.moneytree.brokerclient.api.reponse.dealing;

import com.beanbiscuit.moneytree.brokerclient.api.reponse.dealing.Position;
import com.beanbiscuit.moneytree.brokerclient.api.reponse.market.Market;
import com.beanbiscuit.moneytree.brokerclient.utility.ObjectPrettyPrint;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OpenPosition {

    private final Market market;
    private final Position position;

    public OpenPosition(Market market, Position position) {
        this.market = market;
        this.position = position;
    }

    public OpenPosition() {
        this.market = null;
        this.position = null;
    }

    @JsonGetter("market")
    public Market getMarket() {
        return market;
    }

    @JsonGetter("position")
    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return ObjectPrettyPrint.print(this);
    }
}
