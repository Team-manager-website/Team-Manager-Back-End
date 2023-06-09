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
                        .header("authorization", "Bearer eyJhbiOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkFpc0xNdnJPcklGa2MwZjQ1UzJ4ZyJ9.eyJpc3MiOiJodHRwczovL2Rldi1nbTJmM29iei51cy5hdXRoMC5jb20vIiwic3ViIjoiNUNLVDd5aFFnOWJyUXViOTIydjVBVnQyWmJnVTEzUUxAY2xpZW50cyIsImF1ZCI6Imh0dHA6Ly90ZWFtbWFuYWdlci9hcGkiLCJpYXQiOjE2ODYyMTE1NzIsImV4cCI6MTY4NjI5Nzk3MiwiYXpwIjoiNUNLVDd5aFFnOWJyUXViOTIydjVBVnQyWmJnVTEzUUwiLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMifQ.FzdgbVTHJaNsrarJLyBrFnqDMmylyw6ZZPParmfvtqXHOFhzXrzGF7IRfOcuU9sBFR91kKyFv_AxgYJgG046bzM0qDVjlDoehRVZr-CumZdyLSRVy_S8UdwFjCu3XmUBwtueM89uFsNqqM6PzOvADKQAdMb_cI2XLYJ4GMN4RG4RZ5h0rbT71ZBaYo8ZESHbHcEuwP0xVNJ4QWvW8GXMpZjm4Bc1ukKa7J6yaezWF7TAZjUYGXI9ezHcOTH2IVEVj6lNSnX4baDP6bt7LRVnPrzRvsmRb3oJ_P94CsR4NU4AUntKc5d9fWewzTqvpZQa57P1k4wkuUk7U-hATJOwyg")
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