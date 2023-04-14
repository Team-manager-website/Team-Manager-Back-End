package com.example.teammanagerapi.controller;

import com.example.teammanagerapi.logic.interfaces.IUserCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:5173")
public class AccountController {
    private IUserCollection userCollection;
    @Autowired
    AccountController(IUserCollection userCollection){
        this.userCollection = userCollection;
    }
    @PostMapping("/CreateAccount")
    public String GetTeamName(@RequestBody String jsonData) throws Exception {

        userCollection.CreateAccount(jsonData);
        return jsonData;
    }
}
