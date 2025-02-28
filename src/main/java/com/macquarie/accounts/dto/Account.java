package com.macquarie.accounts.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "accounts")
@Getter
@Setter
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String accountNumber;
    private String accountName;
    private String accountType;
    private LocalDate balanceDate;
    private String currency;
    private Double openingAvailableBalance;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Transaction> transactions;

    public Account() {
    }

    public Account(Long id, String accountNumber, String accountName, String accountType, LocalDate balanceDate, String currency, Double openingAvailableBalance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balanceDate = balanceDate;
        this.currency = currency;
        this.openingAvailableBalance = openingAvailableBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balanceDate=" + balanceDate +
                ", currency='" + currency + '\'' +
                ", openingAvailableBalance=" + openingAvailableBalance +
                '}';
    }

}
