package com.mindhub.homebanking.homebanking.controllers;

import com.mindhub.homebanking.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.homebanking.models.Account;
import com.mindhub.homebanking.homebanking.models.CardColor;
import com.mindhub.homebanking.homebanking.models.CardType;
import com.mindhub.homebanking.homebanking.models.Client;
import com.mindhub.homebanking.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.homebanking.services.AccountServices;
import com.mindhub.homebanking.homebanking.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;




@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientServices clientServices;

    @Autowired
    AccountServices accountServices;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @RequestMapping("/clients")
    public List<ClientDTO> getClients(){
        return clientServices.getClients();
    }

    @RequestMapping("/clients/{id}")

    public ClientDTO getClient(@PathVariable Long id){

        return clientServices.getClient(id);
    }


    @RequestMapping(path = "/clients" , method = RequestMethod.POST)
    public ResponseEntity<Object> register(

            @RequestParam String firstName, @RequestParam String lastName,

            @RequestParam String email, @RequestParam String password) {




        if (firstName.isEmpty()) {

            return new ResponseEntity<>("Missing first name", HttpStatus.FORBIDDEN);

        } else if (lastName.isEmpty()) {
            return new ResponseEntity<>("Missing last name", HttpStatus.FORBIDDEN);
        }
        else if (email.isEmpty()) {
            return new ResponseEntity<>("Missing email", HttpStatus.FORBIDDEN);
        }
        else if (password.isEmpty()) {
            return new ResponseEntity<>("Missing password", HttpStatus.FORBIDDEN);
        }




        if (clientServices.findByEmail(email) != null) {

            return new ResponseEntity<>("Email already in use", HttpStatus.FORBIDDEN);

        }


        Client client1 = new Client(firstName, lastName, email, passwordEncoder.encode(password));

        int random = (int)(Math.random()*100000000);
        Integer random1 = random;

        Account account1 = new Account(("VIN" + random1.toString()) , LocalDateTime.now(),0);
        client1.addAccount(account1);

        clientServices.save(client1);
        accountServices.save(account1);

        return new ResponseEntity<>("Client registered" , HttpStatus.CREATED);

    }




    @GetMapping("/clients/current")

    public ClientDTO getCurrentClient(Authentication authentication) {

    return clientServices.getCurrentClient(authentication);



    }






}

