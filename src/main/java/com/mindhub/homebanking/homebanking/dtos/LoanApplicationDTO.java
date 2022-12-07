package com.mindhub.homebanking.homebanking.dtos;


import com.mindhub.homebanking.homebanking.models.Client;
import com.mindhub.homebanking.homebanking.models.ClientLoan;
import com.mindhub.homebanking.homebanking.models.Loan;

public class LoanApplicationDTO {



    private long loan_id;

    private Double amount;

    private Integer payments;

    private String destinationAccount;

    public LoanApplicationDTO(long loan_id, double amount, Integer payments, String destinationAccount) {
        this.loan_id = loan_id;
        this.amount = amount;
        this.payments = payments;
        this.destinationAccount = destinationAccount;
    }

    public long getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(long loan_id) {
        this.loan_id = loan_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Integer getPayments() {
        return payments;
    }

    public void setPayments(Integer payments) {
        this.payments = payments;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String  destinationAccount) {

        this.destinationAccount = destinationAccount;
    }

}