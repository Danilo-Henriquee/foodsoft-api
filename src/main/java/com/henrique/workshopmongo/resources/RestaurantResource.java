package com.henrique.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henrique.workshopmongo.domain.Restaurant;
import com.henrique.workshopmongo.domain.enums.RestaurantEnum;
import com.henrique.workshopmongo.services.RestaurantService;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantResource {

	@Autowired
	private RestaurantService service;
	
	@GetMapping
	private ResponseEntity<List<Restaurant>> findAll() {
		List<Restaurant> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	private ResponseEntity<Restaurant> findById(@PathVariable String id) {
		Restaurant rest = service.findById(id);
		
		return ResponseEntity.ok().body(rest);
	}
	
	@GetMapping(value = "/type/{type}")
	private ResponseEntity<List<Restaurant>> findAllByType(@PathVariable String type) {
		List<Restaurant> list = service.findAllByType(RestaurantEnum.fromString(type));
		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	private ResponseEntity<Restaurant> insert(@RequestBody Restaurant rest) {
		service.insert(rest);
		
		return ResponseEntity.noContent().build();
	}
}
