package com.mindhub.homebanking.homebanking.controllers;


import com.mindhub.homebanking.homebanking.dtos.AccountDTO;
import com.mindhub.homebanking.homebanking.dtos.TransactionDTO;
import com.mindhub.homebanking.homebanking.models.Account;
import com.mindhub.homebanking.homebanking.repositories.AccountRepository;

import com.mindhub.homebanking.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.homebanking.repositories.TransactionsRepository;
import com.mindhub.homebanking.homebanking.services.AccountServices;
import com.mindhub.homebanking.homebanking.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.util.List;



@RestController
@RequestMapping("/api")
public class AccountController {


    @Autowired
    private AccountServices accountServices;

    @Autowired
    private ClientServices clientServices;

    @RequestMapping("/accounts")

    public List<AccountDTO> getAccounts() {

       return accountServices.getAccounts();

    };

    @RequestMapping("/accounts/{id}")

    public AccountDTO getTransactions(@PathVariable Long id){

       return accountServices.getTransactions(id);


    }

    @PostMapping("/clients/current/accounts")
    public ResponseEntity<Object> createAccounts(Authentication authentication){

        if ( clientServices.findByEmail(authentication.getName()).getAccounts().size() > 2 ){

            return new ResponseEntity<>("Client already has 3 accounts", HttpStatus.FORBIDDEN);

        }



        int random = (int)(Math.random()*100000000);
        Integer random1 = random;
        Account account1 = new Account(("VIN" + random1.toString()) , LocalDateTime.now(),0);
        clientServices.findByEmail(authentication.getName()).addAccount(account1);
        accountServices.save(account1);


        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
