package com.mindhub.homebanking.homebanking.services;

import com.mindhub.homebanking.homebanking.dtos.AccountDTO;
import com.mindhub.homebanking.homebanking.models.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface AccountServices {
    public List<AccountDTO> getAccounts();

    public AccountDTO getTransactions(Long id);

    void save(Account account1);


    Account findByNumber(String originAccountNumber);
}
