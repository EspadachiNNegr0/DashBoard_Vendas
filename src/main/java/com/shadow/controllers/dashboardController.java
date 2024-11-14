package com.shadow.controllers;

import com.shadow.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class dashboardController {
    
    @Autowired
    private EventoRepository eventoRepository;

    @RequestMapping(value = "/Dashboard", method = RequestMethod.GET)
    public String dash() {
        return "dashboard/Dashboard";
    }

    @RequestMapping("/Dash")
    public ModelAndView listardadosT() {
        ModelAndView mv = new ModelAndView("dashboard/Dashboard");
        mv.addObject("Dash", eventoRepository.findAll());
        return mv;
    }
}
