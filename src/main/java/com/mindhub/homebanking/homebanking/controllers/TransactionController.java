package com.mindhub.homebanking.homebanking.controllers;

import com.mindhub.homebanking.homebanking.dtos.TransactionDTO;
import com.mindhub.homebanking.homebanking.models.Account;
import com.mindhub.homebanking.homebanking.models.Client;
import com.mindhub.homebanking.homebanking.models.Transaction;
import com.mindhub.homebanking.homebanking.models.TransactionType;
import com.mindhub.homebanking.homebanking.services.AccountServices;
import com.mindhub.homebanking.homebanking.services.ClientServices;
import com.mindhub.homebanking.homebanking.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionServices transactionServices;

    @Autowired
    private ClientServices clientServices;

    @Autowired
    private AccountServices accountServices;

    @RequestMapping("/transactions")
    public List<TransactionDTO> getTransactions() {

      return transactionServices.getTransactions();

    }

    @Transactional
    @PostMapping("/transactions")
    public ResponseEntity<Object> createTransaction(Authentication authentication, @RequestParam Double amount,@RequestParam String description, @RequestParam String originAccountNumber, @RequestParam String destinationAccountNumber) {


        Client authenticatedClient = clientServices.findByEmail(authentication.getName());
        Account originAccount = accountServices.findByNumber(originAccountNumber);
        Account destinationAccount = accountServices.findByNumber(destinationAccountNumber);


        if (amount.isNaN() || amount <= 0 || amount == null){

            return new ResponseEntity<>("The amount entered is not valid", HttpStatus.FORBIDDEN);

        }
        System.out.println(amount);

        if (description.isEmpty()){

            return new ResponseEntity<>("Please, enter a description", HttpStatus.FORBIDDEN);
        }

        if (originAccountNumber.isEmpty()){

            return new ResponseEntity<>("Source account not selected or invalid", HttpStatus.FORBIDDEN);
        }

        if (destinationAccountNumber.isEmpty()){

            return new ResponseEntity<>("Destination account not chosen or invalid", HttpStatus.FORBIDDEN);
        }

        if (originAccountNumber.equals(destinationAccountNumber)){

            return new ResponseEntity<>("The source and destination account numbers are the same.", HttpStatus.FORBIDDEN);

        }

        if (originAccount == null){

            return new ResponseEntity<>("The source account does not exist.", HttpStatus.FORBIDDEN);

        }


        if (!authenticatedClient.getAccounts().contains(originAccount)){

            return new ResponseEntity<>("The source account does not belong to an authenticated customer.", HttpStatus.FORBIDDEN);
        }

        if (destinationAccount == null){

            return new ResponseEntity<>("The destinaiton account does not exist.", HttpStatus.FORBIDDEN);

        }

        if (originAccount.getBalance() < amount){

            return new ResponseEntity<>("Account balance insufficient for transaction", HttpStatus.FORBIDDEN);

        }


        Transaction transaction1 = new Transaction(TransactionType.CREDIT,amount,description + " "+originAccountNumber, LocalDateTime.now());
        Transaction transaction2 = new Transaction(TransactionType.DEBIT,amount,description+" "+destinationAccountNumber,LocalDateTime.now());

        originAccount.addTransaction(transaction2);
        originAccount.setBalance(originAccount.getBalance()-amount);

        destinationAccount.addTransaction(transaction1);
        destinationAccount.setBalance(destinationAccount.getBalance()+amount);

        transactionServices.save(transaction1);
        transactionServices.save(transaction2);

        return new ResponseEntity<>("Transaction succes" , HttpStatus.CREATED);
    }


}
