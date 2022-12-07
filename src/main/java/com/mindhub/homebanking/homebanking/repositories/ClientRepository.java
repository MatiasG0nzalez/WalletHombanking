package com.mindhub.homebanking.homebanking.repositories;


import com.mindhub.homebanking.homebanking.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {

    Client findByEmail(String email);

}
