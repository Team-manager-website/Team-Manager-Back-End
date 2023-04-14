package com.example.teammanagerapi.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson {
    public static String readOutJsonString(String jsonString, String stringName) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);
        String inputString = jsonNode.get(stringName).asText();
        return inputString;
    }
}
