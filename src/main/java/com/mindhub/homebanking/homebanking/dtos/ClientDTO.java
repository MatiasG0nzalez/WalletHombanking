package com.mindhub.homebanking.homebanking.dtos;

import com.mindhub.homebanking.homebanking.models.Client;

import java.util.Set;
import java.util.stream.Collectors;




public class ClientDTO {


    private long id;
    private String firstName;
    private String lastName;
    private String email;

    private String password;
    private Set<AccountDTO> accounts;

    private Set<ClientLoanDTO> loans;

    private Set<CardDTO> cards;

    public ClientDTO() {
    }

    public ClientDTO(Client client ) {

        this.id = client.getId();

        this.firstName = client.getFirstName();

        this.lastName = client.getLastName();

        this.email = client.getEmail();

        this.password = client.getPassword();

        this.accounts = client.getAccounts().stream().map(account -> new AccountDTO(account)).collect(Collectors.toSet());

        this.loans = client.getClientLoans().stream().map(loan -> new ClientLoanDTO(loan)).collect(Collectors.toSet());

        this.cards = client.getCards().stream().map(card -> new CardDTO(card)).collect(Collectors.toSet());

    }


    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<AccountDTO> getAccounts() {
        return accounts;
    }

    public Set<ClientLoanDTO> getLoans() {
        return loans;
    }

    public Set<CardDTO> getCards() {
        return cards;
    }

}
