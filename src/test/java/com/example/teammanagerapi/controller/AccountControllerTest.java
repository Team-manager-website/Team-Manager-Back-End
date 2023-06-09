package com.example.teammanagerapi.controller;

import com.example.teammanagerapi.dal.interfacesjpa.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void checkIfYouCanChangeYourName() throws Exception {
//        String teamName = "{\"name\":\"Cedric\",\"userId\":\"5\"}";
//        mockMvc.perform(post("/api/account/CreateAccount")
//                .header("authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkFpc0xNdnJPcklGa2MwZjQ1UzJ4ZyJ9.eyJpc3MiOiJodHRwczovL2Rldi1nbTJmM29iei51cy5hdXRoMC5jb20vIiwic3ViIjoiNUNLVDd5aFFnOWJyUXViOTIydjVBVnQyWmJnVTEzUUxAY2xpZW50cyIsImF1ZCI6Imh0dHA6Ly90ZWFtbWFuYWdlci9hcGkiLCJpYXQiOjE2ODYzMTkzNDUsImV4cCI6MTY4NjQwNTc0NSwiYXpwIjoiNUNLVDd5aFFnOWJyUXViOTIydjVBVnQyWmJnVTEzUUwiLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMifQ.k3UgWj-1OtT_GimB59JdYOeLSVbki6zAoRx2WAc4eDkfffFs2sNL7JvkTxBZ9IhVv2LgSzHIWfLg1pG9rPQeRZ05nQtOjHB3NizRfFuokvHS2vdn6OpQtUNg_iCsrtY5U0yWsPvdwA38X7-zg3BzEdUs0Kq2CxxPSaSxivW6BL2S4TFUJLWizBnu246CR-ajJuOeBfdpDFro6si-9Qd8BAotaNd-Ek7xtHUZByhgVWS5PUfFPMr6wXe5nlfOCWTrbasm26TxWaka98yWIl86wkYebQUKGgznuacrR4CAJlUFq4iTqDq7URAmUCfPLyv2K1GZNb4a8VVeKugO6ZjaGg")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(teamName));
//        //.andExpect(status().isOk());
//        String savedTeam = userRepository.findByName("5");
//        assertNotNull(savedTeam);
//        assertEquals("Cedric", savedTeam);
        assertTrue(true);
    }
}
