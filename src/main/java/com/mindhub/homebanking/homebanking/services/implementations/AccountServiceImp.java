package com.mindhub.homebanking.homebanking.services.implementations;

import com.mindhub.homebanking.homebanking.dtos.AccountDTO;
import com.mindhub.homebanking.homebanking.models.Account;
import com.mindhub.homebanking.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.homebanking.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImp implements AccountServices {

    @Autowired
    AccountRepository accountRepository;



    @Override
    public List<AccountDTO> getAccounts() {
        return accountRepository.findAll().stream().map(account -> new AccountDTO(account)).collect(Collectors.toList());
    }

    @Override
    public AccountDTO getTransactions(Long id) {

        return accountRepository.findById(id).map( account -> new AccountDTO(account)).orElse(null);
    }

    @Override
    public void save(Account account1) {
        accountRepository.save(account1);
    }

    @Override
    public Account findByNumber(String originAccountNumber) {
        return accountRepository.findByNumber(originAccountNumber);
    }


}
