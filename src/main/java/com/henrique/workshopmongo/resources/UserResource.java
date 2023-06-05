package com.henrique.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henrique.workshopmongo.config.security.TokenService;
import com.henrique.workshopmongo.domain.TokenDTO;
import com.henrique.workshopmongo.domain.User;
import com.henrique.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping(value = "/login")
	private ResponseEntity<TokenDTO> login(@RequestBody User user) {
		
		var auth = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
		
		manager.authenticate(auth);
		
		String token = tokenService.jwtTokenProvider(user);
		
		return ResponseEntity.ok().body(new TokenDTO(token));
	}
	
	
	@GetMapping
	private ResponseEntity<List<User>> findAll() {
		List<User> users = service.findAll();
		
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(value = "/{id}")
	private ResponseEntity<Void> findById(@PathVariable String id) {
		service.findById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	private ResponseEntity<User> insert(@RequestBody User obj) {
		service.Insert(obj);
		
		return ResponseEntity.ok().body(obj);
	}
}
