package com.macquarie.accounts.service;

import com.macquarie.accounts.controller.AccountController;
import com.macquarie.accounts.dto.Account;
import com.macquarie.accounts.exception.NoAccountsFoundException;
import com.macquarie.accounts.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void testGetAccountsByUserId_Success() {
        Long userId = 1L;
        List<Account> accounts = Arrays.asList(
                new Account(1L, "1000000001", "SGSavings001", "Savings", LocalDate.now(), "SGD", 1000.0),
                new Account(2L, "1000000001", "SGSavings002", "Savings", LocalDate.now(), "SGD", 2000.0)
        );
        when(accountService.getAccountsByUserId(userId)).thenReturn(accounts);
        List<Account> response = accountRepository.findByUserId(userId);
        assertNotNull(response);
        assertEquals(2, response.size());
    }
}
