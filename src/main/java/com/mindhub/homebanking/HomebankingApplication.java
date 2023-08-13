package com.mindhub.homebanking;

import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository,TransactionRepository transactionRepository, LoanRepository loanRepository, ClientLoanRepository clientLoanRepository){
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
			client2.addAccount(account1);
			client2.addAccount(account2);

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

			Transaction transaction2=new Transaction();
			transaction2.setType(TransactionType.CREDITO);
			transaction2.setAmount(150.00);
			transaction2.setAccount(account1);
			transaction2.setDate(LocalDateTime.now());
			transaction2.setDescription("Carrefour");

			Transaction transaction3=new Transaction();
			transaction3.setType(TransactionType.CREDITO);
			transaction3.setAmount(150.00);
			transaction3.setAccount(account2);
			transaction3.setDate(LocalDateTime.now());
			transaction3.setDescription("easy");

			//Agregar la transaccion
			account1.addTransaction(transaction1);
			account1.addTransaction(transaction2);
			account2.addTransaction(transaction3);

			//Guardar la transaction en la base de datos

			transactionRepository.save(transaction1);
			transactionRepository.save(transaction2);
			transactionRepository.save(transaction3);


			//Crear el prestamo

			Loan Loan1= new Loan();
			Loan1.setName("Hipotecario");
			Loan1.setPayments(List.of(12,24,36,48,60));
			Loan1.setMaxAmount(500000.00);

			Loan Loan2= new Loan();
			Loan2.setName("Personal");
			Loan2.setPayments(List.of(6,12,24));
			Loan2.setMaxAmount(100000.00);

			Loan Loan3= new Loan();
			Loan3.setName("Automotriz");
			Loan3.setPayments(List.of(6,12,24,36));
			Loan3.setMaxAmount(300000.00);

			//Agregar el prestamo


			//Guardar prestamos

			loanRepository.save(Loan1);
			loanRepository.save(Loan2);
			loanRepository.save(Loan3);

			//Crear
			ClientLoan ClientLoan1=new ClientLoan();
			ClientLoan1.setClient(client);
			ClientLoan1.setLoan(Loan1);
			ClientLoan1.setAmount(400000.00);
			ClientLoan1.setPayments(60);

			ClientLoan ClientLoan2=new ClientLoan();
			ClientLoan2.setClient(client);
			ClientLoan2.setLoan(Loan2);
			ClientLoan2.setAmount(50000.00);
			ClientLoan2.setPayments(12);

			ClientLoan ClientLoan3=new ClientLoan();
			ClientLoan3.setClient(client2);
			ClientLoan3.setLoan(Loan2);
			ClientLoan3.setAmount(100000.00);
			ClientLoan3.setPayments(24);

			ClientLoan ClientLoan4=new ClientLoan();
			ClientLoan4.setClient(client2);
			ClientLoan4.setLoan(Loan3);
			ClientLoan4.setAmount(20000.00);
			ClientLoan4.setPayments(36);

			//Guardar

			clientLoanRepository.save(ClientLoan1);
			clientLoanRepository.save(ClientLoan2);
			clientLoanRepository.save(ClientLoan3);
			clientLoanRepository.save(ClientLoan4);



		};
	}
}
