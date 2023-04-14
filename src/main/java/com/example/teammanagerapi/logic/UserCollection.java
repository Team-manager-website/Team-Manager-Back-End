package com.example.teammanagerapi.logic;

import com.example.teammanagerapi.dal.interfaces.IDALUserCollection;
import com.example.teammanagerapi.logic.interfaces.IUserCollection;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCollection implements IUserCollection {
    private IDALUserCollection dalUserCollection;
    @Autowired
    UserCollection(IDALUserCollection dalUserCollection){
        this.dalUserCollection = dalUserCollection;
    }
    @Override
    public void CreateAccount(String jsonUserData) throws Exception {
        dalUserCollection.createUser(ReadJson.readOutJsonString(jsonUserData, "name"), ReadJson.readOutJsonString(jsonUserData, "userId"));
    }

}
