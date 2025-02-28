package com.macquarie.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoAccountsFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoAccountsFoundException(NoAccountsFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse("No accounts found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoTransactionsFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoTransactionsFoundException(NoTransactionsFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse("No transaction found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("Internal server error", "An internal error occurred.");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
