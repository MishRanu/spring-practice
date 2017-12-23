package com.garuna.spring.offers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garuna.spring.offers.dao.Offer;
import com.garuna.spring.offers.dao.OffersDAO;

@Service
public class OffersService {
	
	
	@Autowired
	private OffersDAO offersDAO;

	public void setOffersDAO(OffersDAO offersDAO) {
		this.offersDAO = offersDAO;
	} 
	
	public List<Offer> getAllOffers(){
		return offersDAO.getAllOffers(); 
	}
	
}
