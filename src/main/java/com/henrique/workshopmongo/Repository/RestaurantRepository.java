package com.henrique.workshopmongo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.henrique.workshopmongo.domain.Restaurant;
import com.henrique.workshopmongo.domain.enums.RestaurantEnum;

public interface RestaurantRepository extends MongoRepository<Restaurant, String>{
	List<Restaurant> findAllByType(RestaurantEnum type);
}
