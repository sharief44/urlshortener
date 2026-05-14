package com.sharief.urlshortener.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="click_events")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClickEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="url_id",nullable = false)
	private UrlMapping urlMapping;
	
	@Column(nullable = false)
	private LocalDateTime clickedAt;
	
	private String ipAdress;
	
	@Column(columnDefinition = "TEXT")
	private String userAgent;
	
	@PrePersist
	protected void onCreate() {	
		this.clickedAt=LocalDateTime.now();
	}

}
