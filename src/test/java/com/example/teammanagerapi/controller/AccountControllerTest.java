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
        String teamName = "{\"name\":\"Cedric\",\"userId\":\"5\"}";
        mockMvc.perform(post("/api/account/CreateAccount")
                .header("authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkFpc0xNdnJPcklGa2MwZjQ1UzJ4ZyJ9.eyJpc3MiOiJodHRwczovL2Rldi1nbTJmM29iei51cy5hdXRoMC5jb20vIiwic3ViIjoiNUNLVDd5aFFnOWJyUXViOTIydjVBVnQyWmJnVTEzUUxAY2xpZW50cyIsImF1ZCI6Imh0dHA6Ly90ZWFtbWFuYWdlci9hcGkiLCJpYXQiOjE2ODY2MDA2MjIsImV4cCI6MTY4NjY4NzAyMiwiYXpwIjoiNUNLVDd5aFFnOWJyUXViOTIydjVBVnQyWmJnVTEzUUwiLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMifQ.IL_Nj2WVEKDKfTpvAUeGY4hPnCc6_gCvosESqrdTkN3t_QXTrBmzDVJ3J65jh1IwShZKAyaouWOACIF1nl1iSDUuVz-UEsoykpcZx2MC9iXOP_SiQxU4qg7R33cweVolPog1ZDO70xAxQSYXKPW6kYUVWshauQ1bJby3G_68djr4T8YDs_5Xy3Sg7SiFgpJmwjBmCAVWmB6EKiNLUOV9v7w9cLd0K2t0dYSE9cPrmBO1pCberEXsJk-kBpQo9QsfOHCKD5-k-61xDEyF2AECgbakKD-iHEehpXPJZVsGRUzs2FrZ3qWT8fg4nt2BCRdaWD0C3chNGiGSnS9m9ti0gA")
                .contentType(MediaType.APPLICATION_JSON)
                .content(teamName));
        //.andExpect(status().isOk());
        String savedTeam = userRepository.findByName("5");
        assertNotNull(savedTeam);
        assertEquals("Cedric", savedTeam);
    }
}