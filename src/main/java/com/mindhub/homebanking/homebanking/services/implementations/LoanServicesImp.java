package com.mindhub.homebanking.homebanking.services.implementations;

import com.mindhub.homebanking.homebanking.dtos.LoanApplicationDTO;
import com.mindhub.homebanking.homebanking.dtos.LoanDTO;
import com.mindhub.homebanking.homebanking.models.*;
import com.mindhub.homebanking.homebanking.repositories.*;
import com.mindhub.homebanking.homebanking.services.LoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServicesImp implements LoanServices {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientLoanRepository clientLoanRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;


    @Override
    public List<LoanDTO> getLoansDTO() {

        return loanRepository.findAll().stream().map(loan -> new LoanDTO(loan) ).collect(Collectors.toList());
    }

    @Override
    public Loan findById(long loan_id) {
        return loanRepository.findById(loan_id);
    }


}
