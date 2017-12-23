package com.garuna.spring.offers.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;

@Component("offersDAO")
public class OffersDAO {
	
	private NamedParameterJdbcTemplate jdbcTemplate; 
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	public List<Offer> getAllOffers(){
		
		return jdbcTemplate.query("SELECT * FROM Offers", new RowMapper<Offer>() {

			public Offer mapRow(ResultSet arg0, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				
				Offer offer = new Offer(); 
				offer.setId(arg0.getInt("id"));
				offer.setEmail(arg0.getString("email"));
				offer.setName(arg0.getString("name"));
				offer.setText(arg0.getString("text"));
				return offer;
			}
		}); 
		
	}
	
	public Offer getOfferByName(String name) {
		MapSqlParameterSource query = new MapSqlParameterSource(); 
		query.addValue("name", name);
		
		return jdbcTemplate.queryForObject("SELECT * FROM Offers WHERE name=:name", query, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet arg0, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				
				Offer offer = new Offer(); 
				offer.setId(arg0.getInt("id"));
				offer.setEmail(arg0.getString("email"));
				offer.setName(arg0.getString("name"));
				offer.setText(arg0.getString("text"));
				return offer;
			}
		}); 
	}

	
	public boolean addOffer(Offer offer) {
		BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(offer); 
		
		return jdbcTemplate.update("INSERT INTO Offers (email, name, text) VALUES(:email, :name, :text)", parameterSource)==1;  
	}
	
	public int[] addAllOffers(List<Offer> offers) {
		
		SqlParameterSource[] parameterSource= SqlParameterSourceUtils.createBatch(offers.toArray()); 
		
		return jdbcTemplate.batchUpdate("INSERT INTO Offers (email, name, text) VALUES (:email, :name, :text)", parameterSource); 
	}
	
	
	public boolean updateOffer(Offer offer) {
		BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(offer); 
		
		return jdbcTemplate.update("UPDATE Offers SET email=:email, name=:name, text=:text WHERE id=:id", parameterSource)==1;  
	}
	
	public boolean deleteOffer(int id) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource("id", id); 
		
		return jdbcTemplate.update("DELETE FROM Offers WHERE id=:id", parameterSource)==1;  
	}
	
}
