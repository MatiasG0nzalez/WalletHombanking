package com.mindhub.homebanking.homebanking.services.implementations;

import com.mindhub.homebanking.homebanking.dtos.CardDTO;
import com.mindhub.homebanking.homebanking.models.Card;
import com.mindhub.homebanking.homebanking.models.CardColor;
import com.mindhub.homebanking.homebanking.models.CardType;
import com.mindhub.homebanking.homebanking.models.Client;
import com.mindhub.homebanking.homebanking.repositories.CardRepository;
import com.mindhub.homebanking.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.homebanking.services.CardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServicesImp implements CardServices {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ClientRepository clientRepository;

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    @Override
    public List<CardDTO> getCards() {

        return cardRepository.findAll().stream().map(card -> new CardDTO(card)).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Object> createCard(Authentication authentication, CardType type, CardColor color) {

        if (type.toString().equals("null")){
            return new ResponseEntity<>("Missing type of card info", HttpStatus.FORBIDDEN);

        }
        if (color.toString().equals("null")){
            return new ResponseEntity<>("Missing color of card info", HttpStatus.FORBIDDEN);

        }

        if ( clientRepository.findByEmail(authentication.getName()).getCards().stream().filter(card -> card.getType() == type).collect(Collectors.toSet()).size() > 2){

            return new ResponseEntity<>("You already have as many " + type.toString().toLowerCase() + " cards as possible.", HttpStatus.FORBIDDEN);

        }




        Card card1 = new Card(clientRepository.findByEmail(authentication.getName()),type,color,((Integer)getRandomNumber(1000,9999)).toString() + " "+ ((Integer)getRandomNumber(1000,9999)).toString() + " "+((Integer)getRandomNumber(1000,9999)).toString() + " "+((Integer)getRandomNumber(1000,9999)).toString(),getRandomNumber(100,300), LocalDate.now(),LocalDate.now().plusYears(5));
        cardRepository.save(card1);

        return new ResponseEntity<>("Card created",HttpStatus.CREATED);
    }
}
