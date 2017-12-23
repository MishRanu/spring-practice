package com.garuna.springpractice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		ApplicationContext context = new ClassPathXmlApplicationContext("com/garuna/springpractice/beans/beans.xml"); 
    		Person person = (Person)context.getBean("person");
    		Address address = (Address)context.getBean("address1"); 
    		PersonLocation personLocation = (PersonLocation)context.getBean("personlocation"); 
    		NewAddress newAddress = (NewAddress)context.getBean("newAddress"); 
    		System.out.println(personLocation);
//    		Logger logger = (Logger)context.getBean("logger"); 
//    		logger.writeConsole("heya vikramjeet");
    		
    		OffersDAO offersDAO = (OffersDAO)context.getBean("offersDAO"); 
    		try {
    			
//    			if(offersDAO.addOffer(new Offer("Frankie", "frankie@yoyo.com", "Busy This is bullshit")))
//    				System.out.println("New offer added successfully"); 
//    			else 
//    				System.out.println("new offer could not be added");
//    			
//    			if(offersDAO.updateOffer(new Offer(4, "Axl", "axl@yoyo.com", "Axl you are out"))) 
//    				System.out.println("Offer updated successfully");
//    			else 
//    				System.out.println("Offer could not be updated");
// 
//    			System.out.println(offersDAO.getOfferByName("axl"));  
//    			
    			
    			List<Offer> offers = new ArrayList<Offer>(); 
    			offers.add(new Offer("Anurag", "anurag@iitk.ac.in", "I am the best")); 
    			offers.add(new Offer("Garuna", "garuna#iitk.ac.in", "FC Garuna is the best")); 
    			
    			offersDAO.addAllOffers(offers); 
	    		for(Offer offer: offersDAO.getAllOffers()) {
	    			System.out.println(offer);
	    		}
	    		offersDAO.deleteOffer(1); 
    			for(Offer offer2: offersDAO.getAllOffers()) {
	    			System.out.println(offer2);
	    		
    		}
    		}
    		catch(DataAccessException ex) {
    			System.out.println(ex.getMessage());
    			System.out.println(ex.getClass().getName());
    		}
    		
        ((ClassPathXmlApplicationContext)context).close();
    }
}
