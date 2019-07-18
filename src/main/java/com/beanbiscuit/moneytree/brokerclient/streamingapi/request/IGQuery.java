package com.beanbiscuit.moneytree.brokerclient.streamingapi.request;

import java.util.ArrayList;
import java.util.List;

public class IGQuery {

    private final List<String> fields = new ArrayList<>();

    /**
     * @param field
     * @return
     */
    public IGQuery addField(String field) {
        fields.add(field);
        return this;
    }

    public String getQuery() {
        return null;
    }
}
