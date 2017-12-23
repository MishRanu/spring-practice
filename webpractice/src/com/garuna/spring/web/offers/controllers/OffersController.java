package com.garuna.spring.web.offers.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.garuna.spring.offers.services.OffersService;

@Controller
public class OffersController {
	
	@Autowired
	private OffersService offersService; 
	
	
	@RequestMapping("/offers")
	public String viewAllOffers(Model model, @RequestParam("id") int id) {
		
		model.addAttribute("offers", offersService.getAllOffers()); 
		return "offers"; 
	}
	
	@RequestMapping("/create")
	public String createOffer(Model model) {
		
		model.addAttribute("offers", offersService.getAllOffers()); 
		return "create"; 
	}
	
}