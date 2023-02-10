package com.api.graphql.service.impl;

import com.api.graphql.entity.Account;
import com.api.graphql.repository.AccountRepo;
import com.api.graphql.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public Account create(Account account) {
        return this.accountRepo.save(account);
    }

    @Override
    public Optional<Account> get(String userId) {
        Account account = this.accountRepo.findAccountByUserId(userId);
        return account == null ? Optional.empty() : Optional.of(account);
    }

    @Override
    public List<Account> getAll() {
        return this.accountRepo.findAll();
    }

    @Override
    public Boolean existsByUserId(String userId) {
        Account account = this.accountRepo.findAccountByUserId(userId);
        return account != null;
    }
}
