package com.mindhub.homebanking.homebanking.services;

import com.mindhub.homebanking.homebanking.models.ClientLoan;
import com.mindhub.homebanking.homebanking.repositories.ClientLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface ClientLoanServices {


    void save(ClientLoan clientLoan3);
}
