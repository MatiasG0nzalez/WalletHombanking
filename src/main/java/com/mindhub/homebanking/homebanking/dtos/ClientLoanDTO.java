package com.mindhub.homebanking.homebanking.dtos;


import com.mindhub.homebanking.homebanking.models.ClientLoan;

public class ClientLoanDTO {

    private long id;


    private long loan_id;

    private String name;

    private double amount;

    private Integer payments;


    public ClientLoanDTO(ClientLoan clientLoan){

        this.id = clientLoan.getId();
        this.loan_id = clientLoan.getLoan().getId();
        this.name = clientLoan.getLoan().getName();
        this.amount = clientLoan.getAmount();
        this.payments = clientLoan.getPayments();



    }

    public long getId() {
        return id;
    }


    public long getLoan_id() {
        return loan_id;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public Integer getPayments() {
        return payments;
    }
}
