package com.example.teammanagerapi.controller;

import com.example.teammanagerapi.dal.interfacesjpa.ITeamRepository;
import com.example.teammanagerapi.dal.jpa.Team;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TeamControllerTest {

//    @Autowired
//    private TestRestTemplate restTemplate;

    @Autowired
    private ITeamRepository teamRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getTeamName() throws Exception {
        String teamName = "{\"input\":\"VVV\"}";
        mockMvc.perform(post("/team/CreateTeam")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(teamName))
                .andExpect(status().isOk());
        String savedTeam = teamRepository.findByTeamName("VVV");
        assertNotNull(savedTeam);
        assertEquals("VVV", savedTeam);
    }


//    @Test
//    void getTeamName() {
//        String teamName = "VVV";
//
//        ResponseEntity<Void> response = this.restTemplate.postForEntity("/team/CreateTeam", teamName, Void.class);
//
//        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
//
//        Team savedTeam = teamRepository.findByTeamName("VVV");
//        assertNotNull(savedTeam);
//        assertEquals(teamName, savedTeam.getTeamName());
//    }
}