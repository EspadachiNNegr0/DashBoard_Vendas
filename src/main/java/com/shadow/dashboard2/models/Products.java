package com.shadow.dashboard2.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Index;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @Column(name = "nameProduct", nullable = false)
    @Index(name = "idx_name_product") // Cria um índice para o campo nameProduct
    private String nameProduct;

    private Double price;
    private String description;
    private int quantity;

    // Construtor padrão (sem parâmetros)
    public Products() {
    }


    public Products(String nameProduct, Double price) {
    }

    // Getters e Setters
    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
