package com.example.teammanagerapi.logic;

import com.example.teammanagerapi.logic.interfaces.ITeamCollection;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TeamCollection implements ITeamCollection {
    @Override
    public void createTeam(String teamName) {
        System.out.println(teamName);
    }

    private static String readOutJsonString(String jsonString) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);
        String inputString = jsonNode.get("input").asText();
        return inputString;
    }
}
