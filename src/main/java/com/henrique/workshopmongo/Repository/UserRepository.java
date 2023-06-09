package com.henrique.workshopmongo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.henrique.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	User findByUsername(@Param("username") String username);
}
