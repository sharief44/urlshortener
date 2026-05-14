package com.sharief.urlshortener.Dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Builder
@Getter
@AllArgsConstructor
public class AuthResponse {
	
	private String token;
	private String email;
	private String role;
	private long expiredIn;

}
