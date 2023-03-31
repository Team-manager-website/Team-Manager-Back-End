package com.example.teammanagerapi;

import com.example.teammanagerapi.controller.TeamController;
import com.example.teammanagerapi.logic.TeamCollection;
import com.example.teammanagerapi.logic.interfaces.ITeamCollection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ITeamCollection teamCollectionSetup() {
        return new TeamCollection();
    }
//
//    @Bean
//    public TeamController teamControllerSetupBean(ITeamCollection teamCollection) {
//        return new TeamController(teamCollection);
//    }
}
