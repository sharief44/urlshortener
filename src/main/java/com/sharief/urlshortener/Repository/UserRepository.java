package com.sharief.urlshortener.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sharief.urlshortener.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	
	boolean existByEmail(String email);
}
