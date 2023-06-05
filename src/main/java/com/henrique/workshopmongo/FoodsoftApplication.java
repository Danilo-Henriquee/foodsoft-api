package com.henrique.workshopmongo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.henrique.workshopmongo.Repository.UserRepository;
import com.henrique.workshopmongo.domain.User;

@SpringBootApplication
public class FoodsoftApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(FoodsoftApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User("maria", "123456");
		User u2 = new User("joao", "654321");
		
		repo.saveAll(Arrays.asList(u1, u2));
	}

}
