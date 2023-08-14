package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.ClientLoan;

public class ClientLoanDTO {

    private Long id;
    private Double amount;
    private Integer payments;

    //private Client client;


    private Long loan_id;
    private Long client_id;




    public ClientLoanDTO(ClientLoan clientLoanDTO){
        id=clientLoanDTO.getId();
        amount=clientLoanDTO.getAmount();
        payments=clientLoanDTO.getPayments();
        loan_id=clientLoanDTO.getClient().getId();
        client_id= clientLoanDTO.getLoan().getId();



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

    public Long getLoan_id() {
        return loan_id;
    }

    public Long getClient_id() {
        return client_id;
    }
}
