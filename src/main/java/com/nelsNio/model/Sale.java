package com.nelsNio.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSale;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    @ManyToOne()
    @NotNull
    private Client client;

    public Client getClient() {
        System.out.println("entro get"+ client.toString());
        return client;
    }
    public Sale client(Client client){
        System.out.println("entro cliet"+ client.toString());
        this.client=client;
        return  this;
    }
    public void setClient(Client client) {
        System.out.println("entro set"+ client.toString());
        this.client = client;
    }
    public Long getIdSale() {
        return idSale;
    }
    public void setIdSale(Long idSale) {
        this.idSale = idSale;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
