package com.example.teammanagerapi.controller;

import com.example.teammanagerapi.dal.interfacesjpa.ITeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.net.http.HttpResponse;

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
        mockMvc.perform(post("/api/team/CreateTeam")
                        .header("authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkFpc0xNdnJPcklGa2MwZjQ1UzJ4ZyJ9.eyJpc3MiOiJodHRwczovL2Rldi1nbTJmM29iei51cy5hdXRoMC5jb20vIiwic3ViIjoiNUNLVDd5aFFnOWJyUXViOTIydjVBVnQyWmJnVTEzUUxAY2xpZW50cyIsImF1ZCI6Imh0dHA6Ly90ZWFtbWFuYWdlci9hcGkiLCJpYXQiOjE2ODY2MDA2MjIsImV4cCI6MTY4NjY4NzAyMiwiYXpwIjoiNUNLVDd5aFFnOWJyUXViOTIydjVBVnQyWmJnVTEzUUwiLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMifQ.IL_Nj2WVEKDKfTpvAUeGY4hPnCc6_gCvosESqrdTkN3t_QXTrBmzDVJ3J65jh1IwShZKAyaouWOACIF1nl1iSDUuVz-UEsoykpcZx2MC9iXOP_SiQxU4qg7R33cweVolPog1ZDO70xAxQSYXKPW6kYUVWshauQ1bJby3G_68djr4T8YDs_5Xy3Sg7SiFgpJmwjBmCAVWmB6EKiNLUOV9v7w9cLd0K2t0dYSE9cPrmBO1pCberEXsJk-kBpQo9QsfOHCKD5-k-61xDEyF2AECgbakKD-iHEehpXPJZVsGRUzs2FrZ3qWT8fg4nt2BCRdaWD0C3chNGiGSnS9m9ti0gA")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(teamName));
                //.andExpect(status().isOk());
        String savedTeam = teamRepository.findByTeamName("VVV");
        assertNotNull(savedTeam);
        assertEquals("VVV", savedTeam);
    }

//    private String getAuthToken() throws Exception {
//        HttpResponse<String> response = (HttpResponse<String>) Unirest.post("https://dev-gm2f3obz.us.auth0.com/oauth/token")
//                .header("content-type", "application/x-www-form-urlencoded")
//                .body("grant_type=client_credentials&client_id=%24%7Baccount.clientId%7D&client_secret=0dYaxu_EVlDiuJdLrFCEnZ5UxDVkA_oR97OIZ21kokFsUjLPo-IZdtpWjxo6vlNQ&audience=http://teammanager/api")
//                .asString();
//        System.out.println(response);
//        return " ";
//    }

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