package com.api.graphql.repository;

import com.api.graphql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, String> {
    User findUserByEmailAddress(String emailAddress);

    List<User> findAll();

}