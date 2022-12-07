package com.mindhub.homebanking.homebanking.controllers;

import com.mindhub.homebanking.homebanking.dtos.AccountDTO;
import com.mindhub.homebanking.homebanking.dtos.CardDTO;
import com.mindhub.homebanking.homebanking.models.Account;
import com.mindhub.homebanking.homebanking.models.Card;
import com.mindhub.homebanking.homebanking.models.CardColor;
import com.mindhub.homebanking.homebanking.models.CardType;
import com.mindhub.homebanking.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.homebanking.repositories.CardRepository;
import com.mindhub.homebanking.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.homebanking.services.CardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CardController {

    @Autowired
    private CardServices cardServices;






    @RequestMapping("/cards")

    public List<CardDTO> getCards() {

     return cardServices.getCards();

    };


    @PostMapping("/clients/current/cards")

    public ResponseEntity<Object> createCard(Authentication authentication, @RequestParam CardType type, @RequestParam CardColor color){

       return cardServices.createCard(authentication,type,color);


    }



}


