package com.poc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.poc.entity.User;
import com.poc.service.UserService;
import com.poc.society.dto.Building;

@RestController
// @CrossOrigin(origins = "http://localhost:4200") // to use with angular
@CrossOrigin(origins = "*") // to use with angular
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public User addUser(@RequestBody User user) {

		return userService.addUser(user);
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {

		return userService.getUsers();
	}

	@DeleteMapping("/users/{email}")
	public User deleteUserByEmail(@PathVariable String email) {
		return userService.deleteUserByEmail(email);
	}

	@PutMapping("/users/{id}")
	public User UpdateUser(@PathVariable("id") Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	@GetMapping("users/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}



}
