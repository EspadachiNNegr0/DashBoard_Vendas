package com.shadow.dashboard2.Controllers;

import com.shadow.dashboard2.models.Products;
import com.shadow.dashboard2.models.Vendas;
import com.shadow.dashboard2.repositors.ProductRepository;
import com.shadow.dashboard2.repositors.VendasRepository;
import com.shadow.dashboard2.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/venda")
    public ModelAndView GetVendas() {
        ModelAndView mvs = new ModelAndView("vendas/venda");
        List<Vendas> vendas = vendasRepository.findAll();

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

        List<Products> productsList = productRepository.findAll();
        modelAndView.addObject("productsList", productsList);

        return modelAndView;
    }

    @PostMapping("/vendas/add")
    public String saveVenda(@ModelAttribute Vendas venda, @RequestParam String nameProduct) {
        Products product = productRepository.findByNameProduct(nameProduct);

        if (product == null) {
            return "redirect:/vendas/add?error=productNotFound";
        }

        venda.setProduct(product);
        venda.setPriceTotal(product.getPrice() * venda.getQuantity());

        vendasRepository.save(venda);

        return "redirect:/venda"; // Redirecionamento após salvar
    }

    @GetMapping("/venda/{numberBuyID}")
    public String detalhesVenda(@PathVariable("numberBuyID") long numberBuyID, Model model) {
        // Recupera os dados da venda usando o serviço
        Vendas venda = vendaService.findById(numberBuyID);

        if (venda != null) {
            model.addAttribute("venda", venda);
            return "detalhes/detalhesVendas";  // Nome da página de detalhes da venda
        } else {
            return "redirect:/venda";  // Caso a venda não exista, redireciona para a lista
        }
    }
}



