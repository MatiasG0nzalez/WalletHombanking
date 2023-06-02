package com.mindhub.homebanking.homebanking.controllers;


import com.mindhub.homebanking.homebanking.dtos.AccountDTO;
import com.mindhub.homebanking.homebanking.models.Account;
import com.mindhub.homebanking.homebanking.services.AccountServices;
import com.mindhub.homebanking.homebanking.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;



@RestController
@RequestMapping("/api")
public class AccountController {


    @Autowired
    private AccountServices accountServices;

    @Autowired
    private ClientServices clientServices;

    @GetMapping("/accounts")

    public List<AccountDTO> getAccounts() {

       return accountServices.getAccounts();

    };

    @GetMapping("/active/accounts")
    public List<AccountDTO> getActiveAccounts(){
        return accountServices.getActiveAccounts();
    }


    @GetMapping("/accounts/{id}")

    public AccountDTO getTransactions(@PathVariable Long id){

       return accountServices.getTransactions(id);


    }

    @PostMapping("/clients/current/accounts")
    public ResponseEntity<Object> createAccounts(Authentication authentication){

        if ( clientServices.findByEmail(authentication.getName()).getAccounts().size() > 2 ){

            return new ResponseEntity<>("Client already has 3 accounts", HttpStatus.FORBIDDEN);

        }



        int random = (int)(Math.random()*100000000);
        Integer random1 = random;


        Account account1 = new Account(("VIN" + random1.toString()) , LocalDateTime.now(),0);
        clientServices.findByEmail(authentication.getName()).addAccount(account1);
        accountServices.save(account1);


        return new ResponseEntity<>(HttpStatus.CREATED);

    }


        @DeleteMapping("/accounts/delete")
        public ResponseEntity<Object> deleteAccount (@RequestParam String account_number){

         accountServices.delete(account_number);
         return new ResponseEntity<>("Cuenta Eliminada" , HttpStatus.ACCEPTED);


        }

    @PutMapping("/accounts/accountActivation")
    public ResponseEntity<Object> accountActivation (@RequestParam String account_number, boolean active){

       Account account = accountServices.findByNumber(account_number);
       account.setActive(active);
       accountServices.save(account);


       return new ResponseEntity<>( active ? "Account enabled" : "Account disabled" , HttpStatus.ACCEPTED);


    }




}
