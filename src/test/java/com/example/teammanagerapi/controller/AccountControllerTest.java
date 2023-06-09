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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
                .header("authorization", "Bearer eyJhbGciOJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IkFpc0xNdnJPcklGa2MwZjQ1UzJ4ZyJ9.eyJpc3MiOiJodHRwczovL2Rldi1nbTJmM29iei51cy5hdXRoMC5jb20vIiwic3ViIjoiNUNLVDd5aFFnOWJyUXViOTIydjVBVnQyWmJnVTEzUUxAY2xpZW50cyIsImF1ZCI6Imh0dHA6Ly90ZWFtbWFuYWdlci9hcGkiLCJpYXQiOjE2ODYyMTE1NzIsImV4cCI6MTY4NjI5Nzk3MiwiYXpwIjoiNUNLVDd5aFFnOWJyUXViOTIydjVBVnQyWmJnVTEzUUwiLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMifQ.FzdgbVTHJaNsrarJLyBrFnqDMmylyw6ZZPParmfvtqXHOFhzXrzGF7IRfOcuU9sBFR91kKyFv_AxgYJgG046bzM0qDVjlDoehRVZr-CumZdyLSRVy_S8UdwFjCu3XmUBwtueM89uFsNqqM6PzOvADKQAdMb_cI2XLYJ4GMN4RG4RZ5h0rbT71ZBaYo8ZESHbHcEuwP0xVNJ4QWvW8GXMpZjm4Bc1ukKa7J6yaezWF7TAZjUYGXI9ezHcOTH2IVEVj6lNSnX4baDP6bt7LRVnPrzRvsmRb3oJ_P94CsR4NU4AUntKc5d9fWewzTqvpZQa57P1k4wkuUk7U-hATJOwyg")
                .contentType(MediaType.APPLICATION_JSON)
                .content(teamName));
        //.andExpect(status().isOk());
        String savedTeam = userRepository.findByName("5");
        assertNotNull(savedTeam);
        assertEquals("Cedric", savedTeam);
    }
}
