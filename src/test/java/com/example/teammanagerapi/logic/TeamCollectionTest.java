package com.example.teammanagerapi.logic;

import com.example.teammanagerapi.dal.interfacesjpa.ITeamRepository;
import com.example.teammanagerapi.dal.jpa.Team;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class TeamCollectionTest {
    private TestRestTemplate restTemplate;

    private ITeamRepository teamRepository;

//    @Test
//    void createTeam() {
//        String teamName = "VVV";
//
//        ResponseEntity<Void> response = restTemplate.postForEntity("/team/CreateTeam", teamName, Void.class);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//
//        String savedTeam = teamRepository.findByTeamName("VVV");
//        assertNotNull(savedTeam);
//        assertEquals(teamName, savedTeam.getTeamName());
//    }
}