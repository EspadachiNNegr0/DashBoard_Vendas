package com.shadow.dashboard2.services;

import com.shadow.dashboard2.models.Products;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public double receitaTotal(Products p) {
        if (p != null) {
            return p.getPrice() * p.getQuantity();
        } else {
            return 0.0;
        }
    }
}

