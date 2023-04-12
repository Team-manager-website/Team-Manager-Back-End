package com.example.teammanagerapi.logic;

import com.example.teammanagerapi.dal.interfaces.IDALTeamCollection;
import com.example.teammanagerapi.logic.interfaces.ITeamCollection;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamCollection implements ITeamCollection {
    private IDALTeamCollection dalteamCollection;
    @Autowired
    public TeamCollection(IDALTeamCollection dalTeamCollection){
        this.dalteamCollection = dalTeamCollection;
    }
    @Override
    public void createTeam(String teamName) throws Exception {
        dalteamCollection.createTeam(readOutJsonString(teamName));
    }

    private static String readOutJsonString(String jsonString) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);
        String inputString = jsonNode.get("input").asText();
        return inputString;
    }
}
