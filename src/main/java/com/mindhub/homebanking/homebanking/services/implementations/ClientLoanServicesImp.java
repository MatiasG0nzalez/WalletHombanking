package com.mindhub.homebanking.homebanking.services.implementations;

import com.mindhub.homebanking.homebanking.models.ClientLoan;
import com.mindhub.homebanking.homebanking.repositories.ClientLoanRepository;
import com.mindhub.homebanking.homebanking.services.ClientLoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientLoanServicesImp implements ClientLoanServices {

    @Autowired
    private ClientLoanRepository clientLoanRepository;


    @Override
    public void save(ClientLoan clientLoan3) {
        clientLoanRepository.save(clientLoan3);
    }
}
