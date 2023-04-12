package com.example.teammanagerapi.dal.interfacesjpa;

import com.example.teammanagerapi.dal.jpa.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Integer> {
}
