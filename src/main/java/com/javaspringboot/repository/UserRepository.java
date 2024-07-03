package com.javaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspringboot.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public UserEntity getUserByUsername(String username);
}
