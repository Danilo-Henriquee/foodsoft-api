package com.henrique.workshopmongo.domain.dto;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.henrique.workshopmongo.domain.Restaurant;
import com.henrique.workshopmongo.domain.enums.RestaurantEnum;

@Document
public class RestaurantDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private RestaurantEnum type;
	private String adress;
	
	public RestaurantDTO() {
	}

	public RestaurantDTO(Restaurant rest) {
		this.name = rest.getName();
		this.email = rest.getEmail();
		this.type = rest.getType();
		this.adress = rest.getAdress();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RestaurantEnum getType() {
		return type;
	}

	public void setType(RestaurantEnum type) {
		this.type = type;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
}
