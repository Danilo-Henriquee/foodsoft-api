package com.henrique.workshopmongo.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.henrique.workshopmongo.domain.enums.RestaurantEnum;

@Document
public class Restaurant implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String email;
	private RestaurantEnum type;
	private String adress;
	
	public Restaurant() {
	}

	public Restaurant(String id, String name, String email, RestaurantEnum type, String adress) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.type = type;
		this.adress = adress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(id, other.id);
	}
	
}
