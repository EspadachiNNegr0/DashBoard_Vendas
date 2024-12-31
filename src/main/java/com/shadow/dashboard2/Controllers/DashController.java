package com.shadow.dashboard2.Controllers;

import com.shadow.dashboard2.models.Despesa;
import com.shadow.dashboard2.models.Products;
import com.shadow.dashboard2.models.Vendas;
import com.shadow.dashboard2.repositors.DespesaRepository;
import com.shadow.dashboard2.repositors.ProductRepository;
import com.shadow.dashboard2.repositors.VendasRepository;
import com.shadow.dashboard2.services.ProductService;
import com.shadow.dashboard2.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/")
public class DashController {

    @Autowired
    private VendasRepository vendasRepository;

    @Autowired
    private VendaService vendaService;

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @RequestMapping("/Dash")
    public ModelAndView listarEventos() {
        ModelAndView mv = new ModelAndView("index"); // Carrega o arquivo index.html
        List<Vendas> vendas = vendasRepository.findAll(); // Retorna todas as vendas
        List<Despesa> desps = despesaRepository.findAll();
        List<Products> prod = productRepository.findAll();

        // Limita a lista de vendas a 5 elementos
        if (vendas.size() > 5) {
            vendas = vendas.subList(0, 5); // Pega apenas os primeiros 5 elementos
        }

        Double somaDespes = despesaRepository.obterSomaTotalPrice();
        Double somaVendasTotal = vendaService.obterSomaVendasTotal();
        Double receitaT = prod.stream()
                .mapToDouble(productService::receitaTotal)
                .sum();

        mv.addObject("somaVendasTotal", somaVendasTotal); // Adiciona o total ao modelo
        mv.addObject("somaDespes", somaDespes);
        mv.addObject("vendas", vendas); // Passa as vendas para o template
        mv.addObject("receitaT", receitaT);
        return mv;
    }

    @RequestMapping("/{numberBuyID}")
    public ModelAndView detalhesVendas(@PathVariable("numberBuyID") long numberBuyID) {
        Vendas venda = vendasRepository.findById(numberBuyID).orElse(null);
        ModelAndView mv = new ModelAndView("detalhes/DetalhesVendas");
        mv.addObject("venda", venda);
        return mv;
    }
}
