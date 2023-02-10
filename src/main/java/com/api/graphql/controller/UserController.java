package com.api.graphql.controller;

import com.api.graphql.entity.User;
import com.api.graphql.exceptions.UserAlreadyExistsException;
import com.api.graphql.exceptions.UserNotFoundException;
import com.api.graphql.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //create user
    @MutationMapping("createUser")
    public User create(@Argument(name = "user") UserInput userInput) {
        if (this.userService.existsByEmail(userInput.getEmailAddress().toLowerCase())) {
            throw new UserAlreadyExistsException("User already exists with the given email address!");
        }
        User user = new User();
        user.setName(userInput.getName());
        user.setEmailAddress(userInput.getEmailAddress().toLowerCase());
        user.setMonthlySalary(userInput.getMonthlySalary());
        user.setMonthlyExpenses(userInput.getMonthlyExpenses());
        return this.userService.create(user);
    }

    //get user
    @QueryMapping("getUser")
    public User get(@Argument String emailAddress) {
        Optional<User> user =  this.userService.get(emailAddress.toLowerCase());
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found!");
        }
        return user.get();
    }

    //list all users
    @QueryMapping("allUsers")
    public List<User> getAll() {
        return this.userService.getAll();
    }

}

@Getter
@Setter
class UserInput {
    private String name;
    private String emailAddress;
    private double monthlySalary;
    private double monthlyExpenses;
}