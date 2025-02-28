package com.macquarie.accounts.controller;

import com.macquarie.accounts.dto.Account;
import com.macquarie.accounts.exception.NoAccountsFoundException;
import com.macquarie.accounts.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Account>> getAccountsByUserId(@PathVariable Long userId) {
        logger.info("AccountController::getAccountsByUserId, Fetching accounts for user id {}", userId);
        List<Account> accounts = accountService.getAccountsByUserId(userId);
        if (accounts.isEmpty()) {
            logger.error("AccountController::getAccountsByUserId, No accounts found for user id {}", userId);
            throw new NoAccountsFoundException(String.valueOf(userId));
        }
        return ResponseEntity.ok(accounts);
    }
}
