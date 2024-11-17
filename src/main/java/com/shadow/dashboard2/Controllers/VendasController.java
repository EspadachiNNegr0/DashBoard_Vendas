package com.shadow.dashboard2.Controllers;

import com.shadow.dashboard2.models.Products;
import com.shadow.dashboard2.models.Vendas;
import com.shadow.dashboard2.repositors.ProductRepository;
import com.shadow.dashboard2.repositors.VendasRepository;
import com.shadow.dashboard2.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class VendasController {

    @Autowired
    private VendasRepository vendasRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private VendaService vendaService;

    // Método para exibir as vendas
    @GetMapping("/venda")
    public ModelAndView GetVendas() {
        ModelAndView mvs = new ModelAndView("vendas/venda"); // Nome do template corrigido
        List<Vendas> vendas = vendasRepository.findAll();  // Correção aqui

        // Calculando o preço total de cada venda
        for (Vendas venda : vendas) {
            double total = vendaService.calculatePriceTotal(venda);
            venda.setPriceTotal(total);
        }

        mvs.addObject("vendas", vendas);
        return mvs;
    }

    @GetMapping("/vendas/add")
    public ModelAndView AddVenda() {
        ModelAndView modelAndView = new ModelAndView("vendas/addVenda");

        // Obtenha todos os produtos do banco de dados
        List<Products> productsList = productRepository.findAll();

        // Adiciona a lista de produtos ao modelo para ser usada na view
        modelAndView.addObject("productsList", productsList);

        return modelAndView;
    }


    @PostMapping("/vendas/add")
    public String saveVenda(@ModelAttribute Vendas venda, @RequestParam String nameProduct) {
        // Recuperando o produto pelo nome
        Products product = productRepository.findByNameProduct(nameProduct);

        if (product == null) {
            return "redirect:/vendas/add?error=productNotFound";
        }

        // Calculando o preço total
        venda.setProduct(product);
        venda.setPriceTotal(product.getPrice() * venda.getQuantity());

        // Salvando a venda
        vendasRepository.save(venda);

        return "redirect:/venda"; // Redirecionamento após salvar
    }



}



