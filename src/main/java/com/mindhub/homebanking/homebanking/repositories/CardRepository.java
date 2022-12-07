package com.mindhub.homebanking.homebanking.repositories;

import com.mindhub.homebanking.homebanking.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CardRepository extends JpaRepository <Card, Long> {

}
