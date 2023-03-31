package com.example.teammanagerapi.controller;

import com.example.teammanagerapi.logic.interfaces.ITeamCollection;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
@CrossOrigin(origins = "http://localhost:5173")
public class TeamController {
    private ITeamCollection teamCollection;
    @Autowired
    public TeamController(ITeamCollection teamCollection){
        this.teamCollection = teamCollection;
    }

    @PostMapping("/CreateTeam")
    public String GetTeamName(@RequestBody String teamName) throws Exception {

        teamCollection.createTeam(teamName);
        System.out.println(teamName);
        return teamName;
    }
}
