package com.api.graphql.controller;

import com.api.graphql.entity.Account;
import com.api.graphql.entity.User;
import com.api.graphql.exceptions.AccountAlreadyExistsException;
import com.api.graphql.exceptions.AccountNotFoundException;
import com.api.graphql.exceptions.NotEligibleForAccountCreationException;
import com.api.graphql.exceptions.UserNotFoundException;
import com.api.graphql.service.AccountService;
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
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @MutationMapping("createAccount")
    public Account create(@Argument(name="account") AccountInput accountInput) {
        Optional<User> userResult = userService.get(accountInput.getUserId().toLowerCase());
        if (userResult.isEmpty()) {
            throw new UserNotFoundException("User doesn't exists!");
        }

        Optional<Account> accountResult = accountService.get(accountInput.getUserId());

        if (accountResult.isPresent()) {
            throw new AccountAlreadyExistsException("Account already exists for this user.");
        }

        User user = userResult.get();
        if(user.getMonthlySalary() - user.getMonthlyExpenses() > 999) {
            Account account = new Account();
            account.setAccountType(accountInput.getAccountType());
            account.setUserId(accountInput.getUserId().toLowerCase());
            return this.accountService.create(account);
        } else {
            throw new NotEligibleForAccountCreationException("User not eligible for account creation!");
        }
    }

    @QueryMapping("allAccounts")
    public List<Account> getAll() {
        return this.accountService.getAll();
    }

    @QueryMapping("getAccount")
    public Account get(@Argument String userId) {
        Optional<Account> account = this.accountService.get(userId);
        if (account.isEmpty()) {
            throw new AccountNotFoundException("Account Doesn't exists for the given userId!");
        }
        return account.get();
    }


}

@Getter
@Setter
class AccountInput {
    private String accountType;
    private String userId;
}