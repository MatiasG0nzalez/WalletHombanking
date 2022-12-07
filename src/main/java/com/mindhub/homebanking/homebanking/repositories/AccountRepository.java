package com.mindhub.homebanking.homebanking.repositories;

import com.mindhub.homebanking.homebanking.models.Account;
import com.mindhub.homebanking.homebanking.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByNumber(String number);
}
