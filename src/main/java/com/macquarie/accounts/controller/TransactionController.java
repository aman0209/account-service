package com.macquarie.accounts.controller;

import com.macquarie.accounts.dto.Transaction;
import com.macquarie.accounts.exception.NoTransactionsFoundException;
import com.macquarie.accounts.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/transactions")
@Slf4j
public class TransactionController {

    Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactionsByAccountId(@PathVariable Long accountId) {
        logger.info("TransactionController::getTransactionsByAccountId, Fetching transaction for account id {}", accountId);
        List<Transaction> transactions = transactionService.getTransactionsByAccountId(accountId);
        if (transactions.isEmpty()) {
            logger.info("TransactionController::getTransactionsByAccountId, No transactions found for account id {}", accountId);
            throw new NoTransactionsFoundException(String.valueOf(accountId));
        }
        return ResponseEntity.ok(transactions);
    }
}
