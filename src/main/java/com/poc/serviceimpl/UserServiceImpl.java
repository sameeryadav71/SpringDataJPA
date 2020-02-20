package com.poc.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.entity.User;
import com.poc.repository.UserRepository;
import com.poc.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User addUser(User user) {
		List<User> findAll = userRepository.findAll();
		List<User> collect = findAll.stream().filter(e -> e.getName().equals(user.getName())).collect(Collectors.toList());
		if (collect.isEmpty()) {
			return userRepository.save(user);
		}
		return null;
	}

	@Override
	public User deleteUserByEmail(String email) {
		Optional<User> findById = userRepository.findByEmail(email);
		if (findById.isPresent()) {
			userRepository.deleteById(findById.get().getId());
			return findById.get();
		}
		return null;
	}

	@Override
	public User updateUser(Long id,User user) {
		user.setId(id);	
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		
		Optional<User> findById = userRepository.findById(id);
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}
}
