package com.mindhub.homebanking.homebanking.services;

import com.mindhub.homebanking.homebanking.dtos.AccountDTO;
import com.mindhub.homebanking.homebanking.models.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface AccountServices {
    public List<AccountDTO> getAccounts();
    public  List<AccountDTO> getActiveAccounts();

    public AccountDTO getTransactions(Long id);

    public void save(Account account1);

    public Account findById(long id);
    public void delete(String originAccountNumber);
    public Account findByNumber(String originAccountNumber);
}
