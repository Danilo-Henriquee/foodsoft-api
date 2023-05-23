package com.henrique.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henrique.workshopmongo.Repository.RestaurantRepository;
import com.henrique.workshopmongo.domain.Restaurant;
import com.henrique.workshopmongo.domain.enums.RestaurantEnum;
import com.henrique.workshopmongo.services.exception.ResourceNotFoundException;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository repository;
	
	public List<Restaurant> findAll() {
		return repository.findAll();
	}
	
	public Restaurant findById(String id) {
		Optional<Restaurant> restaurant = repository.findById(id);
		
		String msg = "Object not found with id " + id;
		
		return restaurant.orElseThrow(() -> new ResourceNotFoundException(msg));
	}
	
	public Restaurant insert(Restaurant obj) {
		return repository.save(obj);
	}
	
	public List<Restaurant> findAllByType(RestaurantEnum type) {
		List<Restaurant> list = repository.findAllByType(type);
		
		return list;
	}
}
