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
        mockMvc.perform(post("/team/CreateTeam")
                        .header("authorization", "Bearer eyJhbGciOiJSUI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkFpc0xNdnJPcklGa2MwZjQ1UzJ4ZyJ9.eyJpc3MiOiJodHRwczovL2Rldi1nbTJmM29iei51cy5hdXRoMC5jb20vIiwic3ViIjoiNUNLVDd5aFFnOWJyUXViOTIydjVBVnQyWmJnVTEzUUxAY2xpZW50cyIsImF1ZCI6Imh0dHA6Ly90ZWFtbWFuYWdlci9hcGkiLCJpYXQiOjE2ODUwODc2MDMsImV4cCI6MTY4NTE3NDAwMywiYXpwIjoiNUNLVDd5aFFnOWJyUXViOTIydjVBVnQyWmJnVTEzUUwiLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMifQ.NufZd0DaSVFwSVOAq42I4QJn-aAW669UsVrDTZ9e0kQZtjlIGqbv5sW5-sWqjmSY2lKaiqrzuCPkwmnWvABjkLePJ1CUF7JvfWm3-Kzj1YylfDnm0FgD-K0v-MjW_zEFOG6egJSpQEc0c1ebThLjr15JcqsxYFXkhHcGjmvGFE3naPtn50RHLqq4I5rbWhO2LAiPTJ7g-6cmaGDTncdIgAwSvc1uqYlAuB0FkKbdWTYgn-o7r7Ajb08PbXAb8jSfqpMwGwnPVLo4sISzMOnHREUVLdVCnO8U53GekD8Q_iHDOljSvvvzoAkdwZ4zdqc6UDqe4ty8D4Y4whJowMwVPg")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(teamName))
                .andExpect(status().isOk());
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