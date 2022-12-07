package com.mindhub.homebanking.homebanking.services;

import com.mindhub.homebanking.homebanking.dtos.TransactionDTO;
import com.mindhub.homebanking.homebanking.models.Account;
import com.mindhub.homebanking.homebanking.models.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TransactionServices {

    public List<TransactionDTO> getTransactions();

    void save(Transaction transaction1);


}
