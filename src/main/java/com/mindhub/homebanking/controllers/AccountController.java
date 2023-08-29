package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.dtos.AccountDTO;
import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")

public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    private ClientDTO clientDTO;
    private ClientRepository clientRepository;

    @RequestMapping ("/accounts")

    public List<AccountDTO>getAccountDTO(){

        return accountRepository.findAll().stream().map(account -> new AccountDTO(account)).collect(Collectors.toList());
    }
    @RequestMapping ("/accounts/{id}")
    public AccountDTO getAccount(@PathVariable Long id){
        return new AccountDTO(accountRepository.findById(id).orElse(null));
    }
//----------
    @RequestMapping(path = "/clients/current/accounts", method = RequestMethod.POST)

//----
    public ResponseEntity<Object> createAccount (Authentication authentication){
        Client clientDTO= clientRepository.findByEmail(authentication.getName());

if (clientDTO.getAccounts().size() >=3) {
    return new ResponseEntity<>("Faltan Datos", HttpStatus.FORBIDDEN);
}
        // Generar un número de cuenta aleatorio
        String accountNumber = generateAccountNumber();

        // Crear la nueva cuenta
        Account newAccount = new Account();
        newAccount.setNumber(accountNumber);
        newAccount.setBalance(0.0);
        newAccount.setCreationDate(LocalDate.now());
        newAccount.setClient(clientDTO);


        // Guardar la cuenta en el repositorio
        accountRepository.save(newAccount);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
        // Generar número de cuenta aleatorio
    /*private String generateAccountNumber() {
        Random random = new Random();
        int accountSuffix = random.nextInt(99999999); // Máximo 8 dígitos
        return "VIN-" + String.format("%08d", accountSuffix);
    }*/

    private String generateAccountNumber(){
        return "VIN-"+ String.format("%80d",getRandomNumber(1,99999999));


    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);

    }


}
