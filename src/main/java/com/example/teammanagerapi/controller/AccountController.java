package com.example.teammanagerapi.controller;

import com.example.teammanagerapi.logic.interfaces.IUserCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class AccountController {
    private IUserCollection userCollection;
    @Autowired
    AccountController(IUserCollection userCollection){
        this.userCollection = userCollection;
    }
    @PostMapping("/CreateAccount")
    public String CreateAccount(@RequestBody String jsonData) throws Exception {

        userCollection.CreateAccount(jsonData);
        return jsonData;
    }

    @GetMapping(value = "/public")
    public String publicEndpoint() {
        return "All good. You DO NOT need to be authenticated to call /api/public.";
    }
}
