package com.mindhub.homebanking.homebanking;


import com.mindhub.homebanking.homebanking.models.Loan;
import com.mindhub.homebanking.homebanking.repositories.LoanRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = NONE)
//public class RepositoriesTest {
//
//    @Autowired
//    private LoanRepository loanRepository;
//
//    @Test
//
//    public void existLoans(){
//
//        List<Loan> loans = loanRepository.findAll();
//
//        assertThat(loans,is(not(empty())));
//
//    }
//
//
//
//    @Test
//
//    public void existPersonalLoan(){
//
//        List<Loan> loans = loanRepository.findAll();
//
//        assertThat(loans, hasItem(hasProperty("name", is("Personal"))));
//
//    }
//}
