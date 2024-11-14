package com.shadow.controllers;

import com.shadow.models.Evento;
import com.shadow.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository eventoRepository;

	@RequestMapping(value="/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	@RequestMapping(value="/cadastrarEvento", method = RequestMethod.POST)
	public String form(Evento evento) {
		eventoRepository.save(evento);
		return "redirect:/cadastrarEvento";
	}
	@RequestMapping("/eventos")
	public ModelAndView listarEventos() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("eventos", eventoRepository.findAll());
		return mv;
	}
}
