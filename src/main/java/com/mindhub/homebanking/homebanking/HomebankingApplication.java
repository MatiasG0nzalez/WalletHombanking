package com.mindhub.homebanking.homebanking;

import com.mindhub.homebanking.homebanking.dtos.LoanApplicationDTO;
import com.mindhub.homebanking.homebanking.models.*;

import com.mindhub.homebanking.homebanking.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@SpringBootApplication
public class HomebankingApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;




	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);






	}


	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionsRepository transactionsRepository, LoanRepository loanRepository, ClientLoanRepository clientLoanRepository,CardRepository cardRepository){

	return args -> {


		//Clients
//
//		Client client1 = new Client("Matias","Gonzalez","matiasgonzalez@gmail.com", passwordEncoder.encode("Contraseña1234"));
//		Client client2 = new Client("Melba","Morel","melba@mindhub.com", passwordEncoder.encode("melba"));
//
//
//
//		//Accounts
//
//		Account cuenta1 = new Account("VIN001", LocalDateTime.now(),5000);
//		Account cuenta2 = new Account("VIN002",LocalDateTime.now().plusDays(1), 7500);
//
//
//
//		client2.addAccount(cuenta1);
//		client2.addAccount(cuenta2);
//
//		//Transactions
//
//
//		Transaction transaction1 = new Transaction( TransactionType.CREDIT, 5000, "NETFLIX SUSCRIPTION",LocalDateTime.now());
//		Transaction transaction2 = new Transaction( TransactionType.CREDIT, 5000, "SPOTIFY SUSCRIPTION",LocalDateTime.now());
//		Transaction transaction3 = new Transaction( TransactionType.DEBIT, -55000, "MINDHUB FEES",LocalDateTime.now());
//
//		Transaction transaction4 = new Transaction( TransactionType.CREDIT, 5000, "HBO SUSCRIPTION",LocalDateTime.now());
//		Transaction transaction5 = new Transaction( TransactionType.CREDIT, 5000, "SPOTIFY SUSCRIPTION",LocalDateTime.now());
//		Transaction transaction6 = new Transaction( TransactionType.DEBIT, -55000, "MINDHUB FEES",LocalDateTime.now());
//
//		cuenta1.addTransaction(transaction1);
//		cuenta1.addTransaction(transaction2);
//		cuenta1.addTransaction(transaction3);
//
//		cuenta2.addTransaction(transaction4);
//		cuenta2.addTransaction(transaction5);
//		cuenta2.addTransaction(transaction6);
//
//		//Loans
//
//
//		Loan loan1 = new Loan("Mortgage", 500000,List.of(12,24,36,48,60));
//		Loan loan2 = new Loan("Personal", 100000,List.of(6,12,24));
//		Loan loan3 = new Loan("Automotive", 300000,List.of(6,12,24,36));
//
//		//ClientLoans
//
//
//		ClientLoan clientLoan1 = new ClientLoan(400000,60,client2,loan1);
//		ClientLoan clientLoan2 = new ClientLoan(50000,12,client2,loan2);
//		ClientLoan clientLoan3 = new ClientLoan(100000,24,client1,loan2);
//		ClientLoan clientLoan4 = new ClientLoan(200000,36,client1,loan3);
//
//		//Cards
//
//
//		Card card1 = new Card(client2, CardType.DEBIT,CardColor.GOLD,"1234 1242 1243 4444",433, LocalDate.now(),LocalDate.now().plusYears(5));
//
//		Card card2 = new Card(client2, CardType.CREDIT,CardColor.TITANIUM,"1234 1244 5555 5123",435, LocalDate.now(),LocalDate.now().plusYears(5));
//
//		Card card3 = new Card(client1, CardType.CREDIT,CardColor.SILVER,"4141 1244 1414 2233",152, LocalDate.now(),LocalDate.now().plusYears(5));
//
//
//		LoanApplicationDTO xd = new LoanApplicationDTO(1,200,12,"VIN001");
//		System.out.println(xd);
//
//
//		//REPOSITORIES
//
//		clientRepository.save(client1);
//		clientRepository.save(client2);
//
//		accountRepository.save(cuenta1);
//		accountRepository.save(cuenta2);
//
//		transactionsRepository.save(transaction1);
//		transactionsRepository.save(transaction2);
//		transactionsRepository.save(transaction3);
//		transactionsRepository.save(transaction4);
//		transactionsRepository.save(transaction5);
//		transactionsRepository.save(transaction6);
//
//		loanRepository.save(loan1);
//		loanRepository.save(loan2);
//		loanRepository.save(loan3);
//
//		clientLoanRepository.save(clientLoan1);
//		clientLoanRepository.save(clientLoan2);
//		clientLoanRepository.save(clientLoan3);
//		clientLoanRepository.save(clientLoan4);
//
//		cardRepository.save(card1);
//		cardRepository.save(card2);
//		cardRepository.save(card3);

	};
	}







}
