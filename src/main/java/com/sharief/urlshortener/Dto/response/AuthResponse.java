package com.sharief.urlshortener.Dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AuthResponse {
	
	private String token;
	private String email;
	private String role;
	private long expiredIn;

}
