package com.henrique.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henrique.workshopmongo.domain.Restaurant;
import com.henrique.workshopmongo.domain.dto.RestaurantDTO;
import com.henrique.workshopmongo.domain.enums.RestaurantEnum;
import com.henrique.workshopmongo.services.RestaurantService;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantResource {

	@Autowired
	private RestaurantService service;
	
	@GetMapping
	private ResponseEntity<List<RestaurantDTO>> findAll() {
		List<Restaurant> list = service.findAll();
		
		List<RestaurantDTO> listDTO = list.stream().map(rest -> new RestaurantDTO(rest)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	private ResponseEntity<RestaurantDTO> findById(@PathVariable String id) {
		Restaurant rest = service.findById(id);
		
		return ResponseEntity.ok().body(new RestaurantDTO(rest));
	}
	
	@GetMapping(value = "/type/{type}")
	private ResponseEntity<List<RestaurantDTO>> findAllByType(@PathVariable String type) {
		List<Restaurant> list = service.findAllByType(RestaurantEnum.fromString(type));
		List<RestaurantDTO> listDTO = list.stream().map(rest -> new RestaurantDTO(rest)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	private ResponseEntity<RestaurantDTO> insert(@RequestBody Restaurant rest) {
		service.insert(rest);
		
		RestaurantDTO restDTO = new RestaurantDTO(rest);
		
		return ResponseEntity.ok().body(restDTO);
	}
}
