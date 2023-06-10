package com.example.teammanagerapi.dal;

import com.example.teammanagerapi.dal.interfaces.IDALUserCollection;
import com.example.teammanagerapi.dal.interfacesjpa.IUserRepository;
import com.example.teammanagerapi.dal.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DALUser implements IDALUserCollection {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public void createUser(String userName, String userId) {
        userRepository.save(new User(userId, userName));
    }
}
