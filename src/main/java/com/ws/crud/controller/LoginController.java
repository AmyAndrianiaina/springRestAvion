package com.ws.crud.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ws.crud.exception.ResourceNotFoundException;
import com.ws.crud.model.Login;
import com.ws.crud.model.User;
import com.ws.crud.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class LoginController {
	
	 @Autowired
		private UserRepository userRepository;

	@PostMapping("user")
	public User login(@RequestBody Login login)
		throws ResourceNotFoundException {
		String email = login.getEmail();
		String password = login.getPassword();
			userRepository.findByEmail(email)
					.orElseThrow(() -> new ResourceNotFoundException("User" + email + " Not Found"));
			userRepository.findByPassword(password)
					.orElseThrow(() -> new ResourceNotFoundException("Wrong Password"));
		String token = getJWTToken(email);
		User user = new User();
		user.setEmail(email);
		user.setToken(token);		
		return user;
		
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}