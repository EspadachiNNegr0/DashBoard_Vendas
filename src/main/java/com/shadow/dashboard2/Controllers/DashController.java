package com.shadow.dashboard2.Controllers;

import com.shadow.dashboard2.repositors.VendasRepository;
import com.shadow.dashboard2.models.Vendas;
import com.shadow.dashboard2.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/")
public class DashController {

    @Autowired
    private VendasRepository VendasRepository;

    @Autowired
    private VendaService vendaService;

    @RequestMapping("/dash")
    public ModelAndView listarEventos() {
        ModelAndView mv = new ModelAndView("index"); // Carrega o arquivo index.html
        List<Vendas> vendas = VendasRepository.findAll(); // Retorna todas as vendas

        // Limita a lista de vendas a 5 elementos
        if (vendas.size() > 5) {
            vendas = vendas.subList(0, 4); // Pega apenas os primeiros 5 elementos
        }

        // Calcula o priceTotal para cada venda
        for (Vendas venda : vendas) {
            double total = vendaService.calculatePriceTotal(venda);
            venda.setPriceTotal(total);
        }

        mv.addObject("vendas", vendas); // Passa as vendas para o template
        return mv;
    }

}
