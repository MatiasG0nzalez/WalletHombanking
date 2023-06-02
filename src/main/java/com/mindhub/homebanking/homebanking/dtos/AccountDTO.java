package com.mindhub.homebanking.homebanking.dtos;

import com.mindhub.homebanking.homebanking.models.Account;
import com.mindhub.homebanking.homebanking.models.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountDTO {

    private long id;

    private String number;

    private LocalDateTime creationDate;

    private double balance;

    private boolean active;

     private Set<TransactionDTO> transactions;



    public AccountDTO() {
    }

    public AccountDTO(Account account) {

        this.id = account.getId();

        this.number = account.getNumber();

        this.creationDate = account.getCreationDate();

        this.balance = account.getBalance();

        this.active = account.isActive();

        this.transactions = account.getTransactions().stream().map(transaction -> new TransactionDTO(transaction)).collect(Collectors.toSet());

    }





    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public double getBalance() {
        return balance;
    }

    public Set<TransactionDTO> getTransactions() {
        return transactions;
    }

    public boolean isActive() {
        return active;
    }
}
