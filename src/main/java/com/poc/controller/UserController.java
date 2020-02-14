package com.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.entity.User;
import com.poc.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/users")
	public User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userService.getUsers();
	}
	@DeleteMapping("/users/{name}")
	public User deleteUserById(@PathVariable String name)
	{
		return userService.deleteUserByName(name);
	}
}
