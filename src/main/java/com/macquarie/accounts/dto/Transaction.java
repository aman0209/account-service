package com.macquarie.accounts.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "transactions")
@NoArgsConstructor
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private String accountName;

    private LocalDate valueDate;

    private Double debitAmount;
    private Double creditAmount;

    private String transactionType;

    private String transactionNarrative;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    @JsonIgnore
    private Account account;

    public Transaction(Long id, String accountNumber, String accountName, LocalDate valueDate, Double debitAmount, Double creditAmount, String transactionType, String transactionNarrative) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.valueDate = valueDate;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.transactionType = transactionType;
        this.transactionNarrative = transactionNarrative;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    public Double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(Double debitAmount) {
        this.debitAmount = debitAmount;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionNarrative() {
        return transactionNarrative;
    }

    public void setTransactionNarrative(String transactionNarrative) {
        this.transactionNarrative = transactionNarrative;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", valueDate=" + valueDate +
                ", debitAmount=" + debitAmount +
                ", creditAmount=" + creditAmount +
                ", transactionType='" + transactionType + '\'' +
                ", transactionNarrative='" + transactionNarrative + '\'' +
                '}';
    }

}
