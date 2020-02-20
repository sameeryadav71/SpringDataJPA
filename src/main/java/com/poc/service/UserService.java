package com.poc.service;

import java.util.List;

import com.poc.entity.User;

public interface UserService {
	 public List<User> getUsers();
	 public User addUser(User user);
	 public User deleteUserByEmail(String name);
	 public User updateUser(Long id,User user);
	 public User getUserById(Long id);
}
