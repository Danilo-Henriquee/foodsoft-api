package com.henrique.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henrique.workshopmongo.Repository.UserRepository;
import com.henrique.workshopmongo.domain.User;
import com.henrique.workshopmongo.services.exception.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		
		String msg = "Object not found with id " + id;
		
		return user.orElseThrow(() -> new ResourceNotFoundException(msg));
	}
	
	public void Insert(User obj) {
		repository.save(obj);
	}
}
