package com.example.teammanagerapi.controller;

import com.example.teammanagerapi.logic.interfaces.IUserCollection;
//import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/account", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:5173")
public class AccountController {
    private final IUserCollection userCollection;
    @Autowired
    AccountController(IUserCollection userCollection){
        this.userCollection = userCollection;
    }
    @PostMapping("/CreateAccount")
    public String CreateAccount(@RequestBody String jsonData) throws Exception {

        userCollection.CreateAccount(jsonData);
        return jsonData;
    }
}
