package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.ClientLoan;
import com.mindhub.homebanking.models.Transaction;

import java.util.stream.Collectors;

public class ClientLoanDTO {

    private Long id;
    private Double amount;
    private Integer payments;



    public ClientLoanDTO(ClientLoanDTO clientLoanDTO){
        id=clientLoanDTO.getId();
        amount=clientLoanDTO.getAmount();
        payments=clientLoanDTO.getPayments();
        //clientLoanDTO=
        //transactions= account.getTransactions().stream().map(element -> new TransactionDTO(element)).collect(Collectors.toSet());

    }
    /*public TransactionDTO(Transaction transaction) {
        id=transaction.getId();
        amount=transaction.getAmount();
        description=transaction.getDescription();
        date=transaction.getDate();
        type=transaction.getType();
    }*/


    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getPayments() {
        return payments;
    }


}
