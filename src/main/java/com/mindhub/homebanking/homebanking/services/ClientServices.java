package com.mindhub.homebanking.homebanking.services;

import com.mindhub.homebanking.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.homebanking.models.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ClientServices {

    public List<ClientDTO> getClients();

    public ClientDTO getClient(Long id);

    public ClientDTO getCurrentClient(Authentication authentication);

    Client findByEmail(String email);

    void save(Client client1);
}
