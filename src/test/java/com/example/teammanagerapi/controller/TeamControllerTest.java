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
                        .header("authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkFpc0xNdnJPcklGa2MwZjQ1UzJ4ZyJ9.eyJpc3MiOiJodHRwczovL2Rldi1nbTJmM29iei51cy5hdXRoMC5jb20vIiwic3ViIjoiNUNLVDd5aFFnOWJyUXViOTIydjVBVnQyWmJnVTEzUUxAY2xpZW50cyIsImF1ZCI6Imh0dHA6Ly90ZWFtbWFuYWdlci9hcGkiLCJpYXQiOjE2ODQ5Mjc0MTcsImV4cCI6MTY4NTAxMzgxNywiYXpwIjoiNUNLVDd5aFFnOWJyUXViOTIydjVBVnQyWmJnVTEzUUwiLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMifQ.dljSNr2_RfTAnZqjLF5JXBewYFkA5Rt_NbECmCbcJmyaCB7jVzS9FR61McSyJ3WmzkFBuP3GHSGIvxR3MdVewC_l-4Yj--jywR3qtbbjraUrqfYiCcbXR0I7nsXur3Be-HCPeqtUdK9uzpsOHU3SdHz4T7bVaI0q_aZ_WDfKvkWSZhuvC5crYyqztOrV8y_VsHIRUAQ81j3IgCCxnh3HRrfWnnphndUP1qtMHD8S8PYv1Xfs6pizAbHzp96WVwMC3Rid-AbQ25lv_tALZvIdHqsvBfXTG8h6_Pq1pOGAUc1NHH4WGxntZENsGSlbzLOETd6cR8rPabKgkDUQiD6TvA")
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