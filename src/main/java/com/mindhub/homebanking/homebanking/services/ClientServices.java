package com.mindhub.homebanking.homebanking.services;

import com.mindhub.homebanking.homebanking.dtos.ClientCurrentDTO;
import com.mindhub.homebanking.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.homebanking.models.Client;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface ClientServices {

    public List<ClientDTO> getClients();

    public ClientDTO getClient(Long id);

    public ClientCurrentDTO getCurrentClient(Authentication authentication);

    Client findByEmail(String email);

    void save(Client client1);
}
