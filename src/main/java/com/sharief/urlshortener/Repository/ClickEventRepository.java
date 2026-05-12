package com.sharief.urlshortener.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sharief.urlshortener.Entity.ClickEvent;

public interface ClickEventRepository extends JpaRepository<ClickEvent, Long> {

	
	long countByUrlMappingId(long urlId);
	
	List<ClickEvent> findByUrlMappingIdAndClickedAtBetween(
			Long urlId,
			LocalDateTime from,
			LocalDateTime to);
}
