package com.sharief.urlshortener.Service;

import org.springframework.security.authentication.AuthenticationManager;import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sharief.urlshortener.Dto.request.LoginRequest;
import com.sharief.urlshortener.Dto.request.RegisterRequest;
import com.sharief.urlshortener.Dto.response.AuthResponse;
import com.sharief.urlshortener.Entity.User;
import com.sharief.urlshortener.Repository.UserRepository;
import com.sharief.urlshortener.Security.JwtUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;
	
	
	//Register service
	public AuthResponse register(RegisterRequest request) {
		
		if(userRepository.existsByEmail(request.getEmail())) {
			throw new RuntimeException("Email already Registered");
		}
		
		User user = User.builder()
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role("ROLE_USER")
				.isActive(true)
				.build();
		
		userRepository.save(user);
		
		log.info("new user Registered",user.getEmail());
				

		String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
		
		return AuthResponse.builder()
				 .token(token)
				 .email(user.getEmail())
				 .role(user.getRole())
				 .expiredIn(86400000L)
				 .build();
		
	}
	
	//login service
	
	public AuthResponse login(LoginRequest request) {
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		
		User user = userRepository.findByEmail(request.getEmail()).orElseThrow(()-> new RuntimeException("user not found"));
		
		String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
		
		log.info("User logged in"+ user.getEmail());
	
		
		return AuthResponse.builder()
				.token(token)
				.email(user.getEmail())
				.role(user.getRole())
				.expiredIn(86400000L)
				.build();
		
	}


}
