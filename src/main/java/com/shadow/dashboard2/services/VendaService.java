package com.shadow.dashboard2.services;

import com.shadow.dashboard2.models.Products;
import com.shadow.dashboard2.models.Vendas;
import org.springframework.stereotype.Service;

@Service
public class VendaService {


    public double calculatePriceTotal(Vendas venda) {
        if (venda.getProduct() != null) {
            return venda.getProduct().getPrice() * venda.getQuantity();
        }
        return 0.0;
    }
}
