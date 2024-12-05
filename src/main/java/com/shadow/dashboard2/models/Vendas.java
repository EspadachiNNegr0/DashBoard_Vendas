package com.shadow.dashboard2.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;

    private int numberBuy;
    private int quantity;
    private Double priceTotal;
    private String description;
    private String typeBuy;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date created;

    private double vendasTotal;


    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "idProduct")
    private Products product;

    public Vendas() {
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public int getNumberBuy() {
        return numberBuy;
    }

    public void setNumberBuy(int numberBuy) {
        this.numberBuy = numberBuy;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeBuy() {
        return typeBuy;
    }

    public void setTypeBuy(String typeBuy) {
        this.typeBuy = typeBuy;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public double getVendasTotal() {
        return vendasTotal;
    }

    public void setVendasTotal(double vendasTotal) {
        this.vendasTotal = vendasTotal;
    }
}
