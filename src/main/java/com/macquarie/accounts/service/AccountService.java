package com.macquarie.accounts.service;

import com.macquarie.accounts.dto.Account;
import com.macquarie.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccountsByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

}
