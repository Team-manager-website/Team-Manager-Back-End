package com.example.teammanagerapi.dal.interfacesjpa;

import com.example.teammanagerapi.dal.jpa.Team;
import com.example.teammanagerapi.dal.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository  extends JpaRepository<User, String> {
    @Query(value = "SELECT name FROM user WHERE id = :id ORDER BY id DESC LIMIT 1", nativeQuery=true)
    String findByName(@Param("id") String id);
}
