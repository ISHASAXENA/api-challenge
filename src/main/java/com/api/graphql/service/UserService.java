package com.api.graphql.service;

import com.api.graphql.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //create a user
    User create(User user);

    //get a user
    Boolean existsByEmail(String emailAddress);

    Optional<User> get(String emailAddress);

    //get all users
    List<User> getAll();
}
