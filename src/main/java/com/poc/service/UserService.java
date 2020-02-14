package com.poc.service;

import java.util.List;

import com.poc.entity.User;

public interface UserService {
	 public List<User> getUsers();
	 public User addUser(User user);
	 public User deleteUserByName(String emailid);
}
