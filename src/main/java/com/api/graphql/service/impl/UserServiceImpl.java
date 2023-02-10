package com.api.graphql.service.impl;

import com.api.graphql.entity.User;
import com.api.graphql.repository.UserRepo;
import com.api.graphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User create(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public Boolean existsByEmail(String emailAddress) {
//        ExampleMatcher emailMatcher = ExampleMatcher.matching()
//                .withIgnorePaths("name", "monthlySalary", "monthlyExpenses")
//                .withMatcher("emailAddress", ignoreCase()
//                );
//
//        User probe = new User();
//        probe.setEmailAddress(emailAddress);
//        Example<User> example = Example.of(probe, emailMatcher);
//        System.out.println("parwinder example - " +example);
        User user = this.userRepo.findUserByEmailAddress(emailAddress);
        return user != null;
    }

    @Override
    public Optional<User> get(String emailAddress) {
//        ExampleMatcher emailMatcher = ExampleMatcher.matching()
//                .withIgnorePaths("name", "monthlySalary", "monthlyExpenses")
//                .withMatcher("emailAddress", ignoreCase());
//
//        User probe = new User();
//        probe.setEmailAddress(emailAddress);
//        Example<User> example = Example.of(probe, emailMatcher);
        return Optional.of(this.userRepo.findUserByEmailAddress(emailAddress));
    }

    @Override
    public List<User> getAll() {
        return this.userRepo.findAll();
    }
}
