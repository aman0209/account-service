package com.macquarie.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class NoTransactionsFoundException extends RuntimeException {
    public NoTransactionsFoundException(String accountId) {
        super("No transactions found for account " + accountId);
    }
}
