package com.macquarie.accounts.service;

import com.macquarie.accounts.controller.TransactionController;
import com.macquarie.accounts.dto.Transaction;
import com.macquarie.accounts.exception.NoTransactionsFoundException;
import com.macquarie.accounts.repository.TransactionRepository;
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
public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    public void testGetTransactionsByAccountId_Success() {
        Long accountId = 10L;
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1L, "1000000001", "SGSavings001", LocalDate.now(), null, 10.0, "Credit", null),
                new Transaction(2L, "1000000002", "SGSavings002", LocalDate.now(), 300.0, null, "Debit", null)
        );

        when(transactionRepository.findByAccountId(accountId)).thenReturn(transactions);

        List<Transaction> response = transactionService.getTransactionsByAccountId(accountId);
        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals("SGSavings001", response.get(0).getAccountName());
    }
}
