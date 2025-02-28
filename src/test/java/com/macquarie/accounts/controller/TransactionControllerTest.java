package com.macquarie.accounts.controller;

import com.macquarie.accounts.dto.Transaction;
import com.macquarie.accounts.service.TransactionService;
import com.macquarie.accounts.exception.NoTransactionsFoundException;
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
public class TransactionControllerTest {

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    @Test
    public void testGetTransactionsByAccountId_Success() {
        Long accountId = 10L;
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1L, "1000000001", "SGSavings001", LocalDate.now(), null, 10.0, "Credit", null),
                new Transaction(2L, "1000000002", "SGSavings002", LocalDate.now(), 300.0, null, "Debit", null)
        );

        when(transactionService.getTransactionsByAccountId(accountId)).thenReturn(transactions);

        ResponseEntity<List<Transaction>> response = transactionController.getTransactionsByAccountId(accountId);
        assertNotNull(response);
        assertEquals(2, response.getBody().size());
        assertEquals("SGSavings001", response.getBody().get(0).getAccountName());
    }

    @Test
    public void testGetTransactionsByAccountId_NoTransactions() {
        Long accountId = 10L;
        when(transactionService.getTransactionsByAccountId(accountId)).thenReturn(Arrays.asList());
        assertThrows(NoTransactionsFoundException.class, () -> {
            transactionController.getTransactionsByAccountId(accountId);
        });
    }
}
