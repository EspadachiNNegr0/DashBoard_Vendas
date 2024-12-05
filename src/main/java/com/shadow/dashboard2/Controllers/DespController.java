package com.shadow.dashboard2.Controllers;

import com.shadow.dashboard2.repositors.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DespController {

    @Autowired
    private DespesaRepository despesaRepository;

    @GetMapping("/desp")
    public ModelAndView Getdesp() {
        ModelAndView mav = new ModelAndView("despesa/despesas");
        mav.addObject("despesas", despesaRepository.findAll());
        return mav;
    }


}
