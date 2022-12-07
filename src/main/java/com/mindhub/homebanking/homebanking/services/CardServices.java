package com.mindhub.homebanking.homebanking.services;

import com.mindhub.homebanking.homebanking.dtos.CardDTO;
import com.mindhub.homebanking.homebanking.models.CardColor;
import com.mindhub.homebanking.homebanking.models.CardType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CardServices {

    public List<CardDTO> getCards();

    public ResponseEntity<Object> createCard(Authentication authentication, CardType type, CardColor color);


}
