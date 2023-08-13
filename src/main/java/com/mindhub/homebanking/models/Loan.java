package com.mindhub.homebanking.models;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.core.SpringVersion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Loan {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;
    private String name;
    private Double maxAmount;


    @ElementCollection
    private List<Integer> payments=new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "loan")
    private List<ClientLoan> clientLoans=new ArrayList<>();

    //Constructors
    public Loan() {
    }

    public Loan(Long id, String name, Double maxAmount, List<Integer> payments) {
        this.id = id;
        this.name = name;
        this.maxAmount = maxAmount;
        this.payments = payments;
    }

    //Métodos

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public List<Integer> getPayments() {
        return payments;
    }

    public void setPayments(List<Integer> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxAmount=" + maxAmount +
                ", payments=" + payments +
                '}';
    }

    public List<ClientLoan> getClientLoans() {
        return clientLoans;
    }
}
