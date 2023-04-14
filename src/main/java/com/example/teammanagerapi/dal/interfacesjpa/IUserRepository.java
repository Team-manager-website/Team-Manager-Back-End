package com.example.teammanagerapi.dal.interfacesjpa;

import com.example.teammanagerapi.dal.jpa.Team;
import com.example.teammanagerapi.dal.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository  extends JpaRepository<User, String> {
}
