package com.mindhub.homebanking.homebanking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

@Entity
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;


    @OneToMany(mappedBy="client", fetch=FetchType.EAGER)
    private Set<Account> accounts = new HashSet<>();


    @OneToMany(mappedBy="client", fetch=FetchType.EAGER)
    private Set<ClientLoan> clientLoans = new HashSet<>();

    @OneToMany(mappedBy="client", fetch=FetchType.EAGER)
    private Set<Card> cards = new HashSet<>();

    public Client() {
    }

    public Client(String FirstName, String lastName, String email, String password) {

        this.firstName = FirstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

    }


    public long getId() {

        return id;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public Set<Account> getActiveAccounts() {
        return accounts.stream().filter(account -> account.isActive()).collect(Collectors.toSet());
    }

    public Set<ClientLoan> getClientLoans() {
        return clientLoans;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public void addAccount(Account account) {

        account.setClient(this);

        accounts.add(account);

    }

    @Override
    public String toString() {

        return "Client{" +
                "id=" + id +
                ", nombre='" + firstName + '\'' +
                ", apellido='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
