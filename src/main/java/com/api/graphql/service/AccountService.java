package com.api.graphql.service;

import com.api.graphql.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    //create an account
    Account create(Account account);

    //get an account
    Optional<Account> get(String userId);

    //get all accounts
    List<Account> getAll();

    Boolean existsByUserId(String userId);
}
