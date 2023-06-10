package com.example.teammanagerapi.dal.interfacesjpa;

import com.example.teammanagerapi.dal.jpa.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Integer> {
    @Query(value = "SELECT team_name FROM team WHERE team_name = :name ORDER BY id DESC LIMIT 1", nativeQuery=true)
    String findByTeamName(@Param("name") String name);
}
