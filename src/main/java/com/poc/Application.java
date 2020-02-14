package com.poc;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poc.entity.User;
import com.poc.repository.UserRepository;

@SpringBootApplication
public class Application {	
	@Autowired
	private UserRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@PostConstruct
	public void addUser()
	{
		User user = new User();
		user.setEmail("XYZ@gmail.com");
		user.setName("XYZ");
		User save = repository.save(user);
		System.out.println(save);
		System.out.println(repository.findAll());
	}
}
