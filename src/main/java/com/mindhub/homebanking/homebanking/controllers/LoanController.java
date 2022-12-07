package com.mindhub.homebanking.homebanking.controllers;

import com.mindhub.homebanking.homebanking.dtos.*;
import com.mindhub.homebanking.homebanking.models.*;
import com.mindhub.homebanking.homebanking.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class LoanController {

    @Autowired
    private LoanServices loanServices;

    @Autowired
    private ClientServices clientServices;

    @Autowired
    private AccountServices accountServices;

    @Autowired
    private TransactionServices transactionServices;

    @Autowired
    private ClientLoanServices clientLoanServices;

    @RequestMapping("/loans")
    public List<LoanDTO> getLoansDTO() {

        return loanServices.getLoansDTO();

    }

    @Transactional
    @PostMapping("/loans")
    public ResponseEntity<Object> createLoan (Authentication authentication, @RequestBody LoanApplicationDTO loan){


        Client authenticatedClient = clientServices.findByEmail(authentication.getName());
        Account accountDestination = accountServices.findByNumber(loan.getDestinationAccount());
        Loan loan1 = loanServices.findById(loan.getLoan_id());

        Set<ClientLoan> clientLoan = authenticatedClient.getClientLoans().stream().filter(clientLoan1 -> clientLoan1.getLoan().getName().equals(loan1.getName())).collect(Collectors.toSet());

        if (loan == null){

            return new ResponseEntity<>("The selected loan is not available", HttpStatus.FORBIDDEN);

        }

        if (loan.getPayments() <= 0){

            return new ResponseEntity<>("The selected quotas are not valid", HttpStatus.FORBIDDEN);

        }

        if (loan.getAmount().isNaN() || loan.getAmount() <= 0){

            return new ResponseEntity<>("The amount entered is not valid", HttpStatus.FORBIDDEN);

        }

        if (loan1 == null){

            return new ResponseEntity<>("The selected loan is not available", HttpStatus.FORBIDDEN);

        }

        if (loan1.getMaxAmount() <= loan.getAmount()){

            return new ResponseEntity<>("The amount requested exceeds the maximum amount available", HttpStatus.FORBIDDEN);

        }


        if (!loan1.getPayments().contains(loan.getPayments())){

            return new ResponseEntity<>("The requested installments are not available in the selected loan.", HttpStatus.FORBIDDEN);

        }

        if (accountDestination == null){

            return new ResponseEntity<>("Target account does not exist", HttpStatus.FORBIDDEN);

        }

        if (!authenticatedClient.getAccounts().contains(accountDestination)){

            return new ResponseEntity<>("The account does not belong to the authenticated user.", HttpStatus.FORBIDDEN);

        }

        if (clientLoan.size() >0 ){

            return new ResponseEntity<>("You already have a loan of this type.", HttpStatus.FORBIDDEN);
        }

        if(loan1.getName().equals("Mortgage")){

            ClientLoan clientLoan3 = new ClientLoan(loan.getAmount() *1.2,loan.getPayments(),authenticatedClient,loan1);
            clientLoanServices.save(clientLoan3);
        }

        if(loan1.getName().equals("Personal")){

            ClientLoan clientLoan4 = new ClientLoan(loan.getAmount() *1.4,loan.getPayments(),authenticatedClient,loan1);
            clientLoanServices.save(clientLoan4);
        }

        if(loan1.getName().equals("Automotive")){

            ClientLoan clientLoan5 = new ClientLoan(loan.getAmount() *1.6,loan.getPayments(),authenticatedClient,loan1);
            clientLoanServices.save(clientLoan5);

        }

        Transaction transaction = new Transaction(TransactionType.CREDIT,loan.getAmount(), loan1.getName() + " "+ "loan approved", LocalDateTime.now());
        accountServices.findByNumber(loan.getDestinationAccount()).addTransaction(transaction);
        accountServices.findByNumber(loan.getDestinationAccount()).setBalance(accountDestination.getBalance() + loan.getAmount());



        transactionServices.save(transaction);

        return new ResponseEntity<>("Prestamo otorgado" , HttpStatus.CREATED);

    }



}
