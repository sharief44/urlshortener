package com.sharief.urlshortener.Dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
	
	@NotBlank(message = "Email is requried")
	@Email(message="must be a vaild email address")
	private String email;
	
	@NotBlank(message = "password required")
	@Size(min = 8,message = "password must be atleast 8 characters")
	private String password;

}
