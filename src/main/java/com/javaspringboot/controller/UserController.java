package com.javaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringboot.entities.UserEntity;
import com.javaspringboot.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public void createUser(@RequestBody UserEntity user) {
		log.info("User Controller ::: createUser {}", user.getUsername());
		userService.createUser(user);
	}
	
	@GetMapping("{userId}")
	public UserEntity getUserById(@PathVariable Long userId) {
		log.info("User Controller ::: getUserById {}", userId);
		return userService.findUserById(userId);
	}
	
	@GetMapping("username/{username}")
	public void getUserByUsername(@PathVariable String username) {
		log.info("User Controller ::: getUserByUsername {}", username);
		//return userService.findUserByUsername(username);
	}
	
	@PutMapping("{userId}")
	public void updateUser(@PathVariable Long userId, @RequestBody  UserEntity user) {
		log.info("User Controller ::: updateUser {} {}", userId, user.getEmail());
		userService.updateUser(userId, user);
	}
	
	@DeleteMapping("{userId}")
	public void deleteUser(@PathVariable Long userId) {
		log.info("User Controller ::: deleteUser {}", userId);
		userService.deleteUser(userId);
	}

}
