package com.javaspringboot.service;

import java.util.Comparator;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringboot.entities.UserEntity;
import com.javaspringboot.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	UserRepository userRepository;

	public void createUser(UserEntity user) {
		log.info("UserService ::: createUser {} {}", user.toString());
		userRepository.save(user);
		log.info("UserService ::: user saved successfully");
	}

	public List<UserEntity> featchAllUsers() {
		log.info("UserService ::: featchAllUsers");
		List<UserEntity> usersList = userRepository.findAll();
		usersList.stream().sorted(Comparator.comparing(UserEntity::getUsername)).toList();
		return usersList;
	}

	public UserEntity findUserById(Long userId) {
		log.info("UserService ::: findUserById {}", userId);
		return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
	}

	public UserEntity findUserByUsername(String username) {
		log.info("UserService ::: findUserByUsername {}", username);
		return userRepository.getUserByUsername(username);
	}
	
	public void updateUser(Long userId, UserEntity inputUserDetails) {
		log.info("UserService ::: updateUser {}", userId);
		UserEntity dbUser = findUserById(userId);
		dbUser.setUsername(inputUserDetails.getUsername());
		dbUser.setPassword(inputUserDetails.getPassword());
		dbUser.setEmail(inputUserDetails.getEmail());
		userRepository.save(dbUser);
		log.info("Updated successfully");
	}

	public void deleteUser(Long userId) {
		log.info("UserService ::: deleteUser {}", userId);
		if (userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
			log.info("Deleted successfully");
		} else {
			log.info("User not found");
			throw new RuntimeException("User not found");

		}
	}
	
	public void deleteUser_another(Long userId) {
		log.info("UserService ::: deleteUser_another {}", userId);
		UserEntity user = findUserById(userId);
		userRepository.delete(user);
		log.info("Deleted successfully");
	}

}
