package com.beanbiscuit.moneytree.brokerclient.api.reponse.dealing;

import com.beanbiscuit.moneytree.brokerclient.utility.ObjectPrettyPrint;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.ArrayList;
import java.util.List;

public class PositionCollection {

    private final List<OpenPosition> positions = new ArrayList<>();

    @JsonGetter("positions")
    public List<OpenPosition> getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        return ObjectPrettyPrint.print(this);
    }
}
