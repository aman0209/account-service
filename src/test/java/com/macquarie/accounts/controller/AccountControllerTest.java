package com.macquarie.accounts.controller;

import com.macquarie.accounts.dto.Account;
import com.macquarie.accounts.service.AccountService;
import com.macquarie.accounts.exception.NoAccountsFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @Test
    public void testGetAccountsByUserId_Success() {
        Long userId = 1L;
        List<Account> accounts = Arrays.asList(
                new Account(1L, "1000000001", "SGSavings001", "Savings", LocalDate.now(), "SGD", 1000.0),
                new Account(2L, "1000000001", "SGSavings002", "Savings", LocalDate.now(), "SGD", 2000.0)
        );
        when(accountService.getAccountsByUserId(userId)).thenReturn(accounts);
        ResponseEntity<List<Account>> response = accountController.getAccountsByUserId(userId);
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetAccountsByUserId_NoAccounts() {
        Long userId = 1L;
        when(accountService.getAccountsByUserId(userId)).thenReturn(Arrays.asList());
        assertThrows(NoAccountsFoundException.class, () -> {
            accountController.getAccountsByUserId(userId);
        });
    }
}
