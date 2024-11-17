package com.shadow.dashboard2.Controllers;

import com.shadow.dashboard2.models.Products;
import com.shadow.dashboard2.repositors.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/pro")
    public ModelAndView GetProduct() {
        ModelAndView mvs = new ModelAndView("product/products");
        mvs.addObject("products", repository.findAll());
        return mvs;
    }

    @GetMapping("/pro/add")
    public ModelAndView AddProduct() {
        return new ModelAndView("product/addProduct");
    }

    @PostMapping("/pro/add")
    public String SaveProduct(@ModelAttribute Products product) {
        repository.save(product);
        return "redirect:/pro"; // Redireciona para a lista de produtos após salvar
    }
}
