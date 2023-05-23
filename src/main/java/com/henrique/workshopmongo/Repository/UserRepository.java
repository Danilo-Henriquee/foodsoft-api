package com.henrique.workshopmongo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.henrique.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
