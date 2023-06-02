package com.mindhub.homebanking.homebanking.services;

import com.mindhub.homebanking.homebanking.repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AccountServicesTest {
    @Autowired
    private AccountServices accountServices;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    void getAccounts() {

    }

    @Test
    void getActiveAccounts() {
    }

    @Test
    void getTransactions() {
    }

    @Test
    void findByNumber() {
    }
}