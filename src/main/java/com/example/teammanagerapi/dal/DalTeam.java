package com.example.teammanagerapi.dal;

import com.example.teammanagerapi.dal.interfaces.IDALTeamCollection;
//import com.example.teammanagerapi.dal.interfacesjpa.ITeamRepository;
//import com.example.teammanagerapi.dal.jpa.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DalTeam implements IDALTeamCollection {
//    @Autowired
//    private ITeamRepository teamRepository;
    @Override
    public void createTeam(String teamName) {
//        Team team = new Team(1, teamName);
//        teamRepository.save(team);
    }
}
