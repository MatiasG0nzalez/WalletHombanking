package com.mindhub.homebanking.homebanking.services.implementations;

import com.mindhub.homebanking.homebanking.dtos.TransactionDTO;
import com.mindhub.homebanking.homebanking.models.Account;
import com.mindhub.homebanking.homebanking.models.Client;
import com.mindhub.homebanking.homebanking.models.Transaction;
import com.mindhub.homebanking.homebanking.models.TransactionType;
import com.mindhub.homebanking.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.homebanking.repositories.CardRepository;
import com.mindhub.homebanking.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.homebanking.repositories.TransactionsRepository;
import com.mindhub.homebanking.homebanking.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServicesImp implements TransactionServices {


    @Autowired
    private TransactionsRepository transactionsRepository;

    @Override
    public List<TransactionDTO> getTransactions() {
        return transactionsRepository.findAll().stream().map(transaction -> new TransactionDTO(transaction) ).collect(Collectors.toList());
    }



    @Override
    public void save(Transaction transaction1) {
        transactionsRepository.save(transaction1);
    }


}
