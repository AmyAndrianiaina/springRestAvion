package com.ws.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ws.crud.exception.ResourceNotFoundException;
import com.ws.crud.model.User;
import com.ws.crud.repository.UserRepository;

@CrossOrigin(origins = { "http://localhost", "http://localhost:3000", "https://springrestavion-production.up.railway.app" })
@RestController
@RequestMapping("/rest/")
public class UtilisateurController {

    @Autowired
	private UserRepository userRepository;

	//get user

	@GetMapping("users")
	public List<User> getAllVehicule(){
		return this.userRepository.findAll();
	}
	

    // Login

    @PostMapping("/login")
	public ResponseEntity<String> loadUserByUsername(@RequestBody User userDetails)
			throws ResourceNotFoundException {
		userRepository.findByEmail(userDetails.getEmail())
				.orElseThrow(() -> new ResourceNotFoundException("User" + userDetails.getEmail() + "Not Found"));
		userRepository.findByPassword(userDetails.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Wrong Password"));
		return ResponseEntity.ok().body("User signed-in successfully!");
	}
    
}
