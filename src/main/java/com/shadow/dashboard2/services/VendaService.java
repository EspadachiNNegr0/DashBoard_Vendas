package com.shadow.dashboard2.services;

import com.shadow.dashboard2.repositors.VendasRepository;
import com.shadow.dashboard2.models.Vendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendasRepository vendasRepository;

    public VendaService(VendasRepository vendasRepository) {
        this.vendasRepository = vendasRepository;
    }

    // Método para calcular o preço total de uma venda
    public double calculatePriceTotal(Vendas venda) {
        if (venda.getProduct() != null) {
            return venda.getProduct().getPrice() * venda.getQuantity();
        }
        return 0.0;
    }

    // Método para obter a soma de vendasTotal
    public Double obterSomaVendasTotal() {
        Double soma = vendasRepository.calcularSomaVendasTotal();
        return soma != null ? soma : 0.0; // Retorna 0.0 se a soma for nula
    }

    public Vendas findById(long numberBuyID) {
        Optional<Vendas> venda = vendasRepository.findById(numberBuyID);
        return venda.orElse(null);  // Retorna null se a venda não for encontrada
    }
}


