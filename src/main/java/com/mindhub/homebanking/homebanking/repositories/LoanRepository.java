package com.mindhub.homebanking.homebanking.repositories;

import com.mindhub.homebanking.homebanking.models.Client;
import com.mindhub.homebanking.homebanking.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LoanRepository extends JpaRepository <Loan, Long> {

    Loan findById(long id);

}
