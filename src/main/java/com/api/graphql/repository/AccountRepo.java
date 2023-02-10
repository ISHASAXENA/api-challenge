package com.api.graphql.repository;

import com.api.graphql.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, String> {
    Account findAccountByUserId(String userId);

    List<Account> findAll();

}