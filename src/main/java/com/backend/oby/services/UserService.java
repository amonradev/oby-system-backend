package com.backend.oby.services;

import java.util.List;

import com.backend.oby.entity.User;
import com.backend.oby.exception.ResourceNotFoundException;
import com.backend.oby.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	public User getUserById(long userId) {
		return this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
	}

	public User createUser(User user) {
		return this.userRepository.save(user);
	}

	public User updateUser(User user) {
		return this.userRepository.save(user);
	}

	public void deleteUser(long userId) {
		User existingUser = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
		this.userRepository.delete(existingUser);
	}

	public String verifyLogin(User user) {
		User emailUser = userRepository.findByEmail(user.getEmail());

		if (emailUser.getPassword().equals(user.getPassword())) {
			return "1";
		} else {
			return "0";
		}
	}
}
