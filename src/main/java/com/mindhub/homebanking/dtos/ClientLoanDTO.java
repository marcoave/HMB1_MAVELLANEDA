package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.ClientLoan;

public class ClientLoanDTO {

    private Long id;
    private Double amount;
    private Integer payments;

    private String name;
     private Long loanid;
    //private Long client_id;

    public ClientLoanDTO(ClientLoan clientLoan) {
        this.id = clientLoan.getId();
        this.amount = clientLoan.getAmount();
        this.payments = clientLoan.getPayments();
        this.name = clientLoan.getLoan().getName();
        this.loanid = clientLoan.getLoan().getId();
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getPayments() {
        return payments;
    }

    public String getName() {
        return name;
    }

    public Long getLoanid() {
        return loanid;
    }
/* public ClientLoanDTO(ClientLoan clientLoan){
        id=clientLoanDTO.getId();
        name=clientLoan.getLoan().getName();
        amount=clientLoanDTO.getAmount();
        payments=clientLoanDTO.getPayments();

        loan_id=clientLoanDTO.getClient().getId();
        client_id= clientLoanDTO.getLoan().getId();*/






}
