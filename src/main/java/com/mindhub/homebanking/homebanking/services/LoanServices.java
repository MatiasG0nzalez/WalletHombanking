package com.mindhub.homebanking.homebanking.services;

import com.mindhub.homebanking.homebanking.dtos.LoanApplicationDTO;
import com.mindhub.homebanking.homebanking.dtos.LoanDTO;
import com.mindhub.homebanking.homebanking.models.Loan;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface LoanServices {

    public List<LoanDTO> getLoansDTO();


    Loan findById(long loan_id);
}
