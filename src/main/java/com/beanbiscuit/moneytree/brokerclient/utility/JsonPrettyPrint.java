package com.beanbiscuit.moneytree.brokerclient.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class JsonPrettyPrint {

    private JsonPrettyPrint() {}

    public static String print(String json) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapper.readValue(json, Object.class));
        } catch (IOException e) {
            return json;
        }
    }
}
