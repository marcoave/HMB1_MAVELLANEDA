package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository,TransactionRepository transactionRepository){
		return args -> {
			//Crear Cliente
			Client client = new Client ("Melba","Morel","MM@gmail.com");
			Client client2 = new Client ("Oreo","Moran","OM@gmail.com");
			System.out.println(client);
			//Guardar en la base de datos el cliente
			clientRepository.save(client);
			clientRepository.save(client2);
			System.out.println(client);
			System.out.println(client2);


			//Crear la cuenta
			Account account1=new Account();
			account1.setNumber("VIN001");
			account1.setCreationDate(LocalDate.now());
			account1.setBalance(5000.0);


			Account account2=new Account();
			account2.setNumber("VIN002");
			account2.setCreationDate(LocalDate.now().plusDays(1));
			account2.setBalance(7500.0);

			//Agrega la cuenta al cliente

			client.addAccount(account1);
			client.addAccount(account2);

			//Guardar la cuenta en la base de datos
			accountRepository.save(account1);
			accountRepository.save(account2);


			//Crear la transaccion
			Transaction transaction1=new Transaction();
			transaction1.setType(TransactionType.DEBITO);
			transaction1.setAmount(-100.00);
			transaction1.setAccount(account1);
			transaction1.setDate(LocalDateTime.now());
			transaction1.setDescription("McDonald's");

			//Agregar la transaccion
			account1.addTransaction(transaction1);

			//Guardar la transaction en la base de datos

			transactionRepository.save(transaction1);

		};
	}
}
