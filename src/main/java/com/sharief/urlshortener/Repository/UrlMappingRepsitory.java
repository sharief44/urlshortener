package com.sharief.urlshortener.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sharief.urlshortener.Entity.UrlMapping;

public interface UrlMappingRepsitory extends JpaRepository<UrlMapping, Long> {

	
	Optional<UrlMapping> findByShortCode(String shortCode);
	
	boolean existByShortCode(String shortCode);
}
