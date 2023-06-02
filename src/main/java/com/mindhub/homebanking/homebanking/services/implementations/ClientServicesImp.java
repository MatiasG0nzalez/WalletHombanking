package com.mindhub.homebanking.homebanking.services.implementations;

import com.mindhub.homebanking.homebanking.dtos.ClientCurrentDTO;
import com.mindhub.homebanking.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.homebanking.models.Client;
import com.mindhub.homebanking.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.homebanking.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServicesImp implements ClientServices {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountRepository accountRepository;



    @Override
    public List<ClientDTO> getClients() {
        return clientRepository.findAll().stream().map(client -> new ClientDTO(client) ).collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClient(Long id) {
        return clientRepository.findById(id).map(client -> new ClientDTO(client)).orElse(null);
    }



    @Override
    public ClientCurrentDTO getCurrentClient(Authentication authentication) {

        return new ClientCurrentDTO(clientRepository.findByEmail(authentication.getName()));

    }

    @Override
    public Client findByEmail(String email) {

        return clientRepository.findByEmail(email);
    }

    @Override
    public void save(Client client1) {
        clientRepository.save(client1);
    }
}
