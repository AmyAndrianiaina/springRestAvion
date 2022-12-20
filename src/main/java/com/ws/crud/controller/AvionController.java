package com.ws.crud.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.crud.exception.ResourceNotFoundException;
import com.ws.crud.model.Avion;
import com.ws.crud.repository.AvionRepository;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/rest/")
public class AvionController {

	@Autowired
	private AvionRepository avionRepository;
	
	

	public Date toDate(Date assurance) {
		return assurance;
	}

	// get avions

	@GetMapping("avions")
	public List<Avion> getAllAvion() {
		return this.avionRepository.findAll();
	}

	// get avion by id

	@GetMapping("/avions/{id}")
	public ResponseEntity<Avion> getAvionById(@PathVariable(value = "id") Long avionId)
			throws ResourceNotFoundException {
		Avion avion = avionRepository.findById(avionId)
				.orElseThrow(() -> new ResourceNotFoundException("Avion not found for this id :: " + avionId));
		return ResponseEntity.ok().body(avion);
	}

	// get avion by assurance 1 mois

	@GetMapping("/avions/assurance/1mois")
	public List<Avion> getAvionByAssurence1Mois()
			throws ResourceNotFoundException {
		java.util.Date javaDate = new java.util.Date();
		long javaTime = javaDate.getTime();
		Date assurance1 = new Date(javaTime);
		System.out.println(assurance1);
		LocalDate date = LocalDate.parse(assurance1.toString());
		LocalDate newDate = date.plusMonths(1);
		java.util.Date dates = java.util.Date.from(newDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		long javaTimes = dates.getTime();
		Date assurance2 = new Date(javaTimes);
		System.out.println(assurance2);
		return this.avionRepository.findByAssuranceGreaterThanAndAssuranceLessThan(assurance1, assurance2);
	}
	
	// get avion by assurance 3 mois

		@GetMapping("/avions/assurance/3mois")
		public List<Avion> getAvionByAssurence3Mois()
				throws ResourceNotFoundException {
			java.util.Date javaDate = new java.util.Date();
			long javaTime = javaDate.getTime();
			Date assurance1 = new Date(javaTime);
			System.out.println(assurance1);
			LocalDate date = LocalDate.parse(assurance1.toString());
			LocalDate newDate = date.plusMonths(3);
			java.util.Date dates = java.util.Date.from(newDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			long javaTimes = dates.getTime();
			Date assurance2 = new Date(javaTimes);
			System.out.println(assurance2);
			return this.avionRepository.findByAssuranceGreaterThanAndAssuranceLessThan(assurance1, assurance2);
		}

	// save avion

	@PostMapping("/avions")
	public Avion createAvion(@RequestBody Avion avion) {
		return avionRepository.save(avion);
	}

	// update avion

	@PutMapping("/avions/{id}")
	public ResponseEntity<Avion> updateAvion(@PathVariable(value = "id") Long avionId, @RequestBody Avion avionDetails)
			throws ResourceNotFoundException {
		Avion avion = avionRepository.findById(avionId)
				.orElseThrow(() -> new ResourceNotFoundException("Avion not found for this id :: " + avionId));

		avion.setAssurance(avionDetails.getAssurance());
		avion.setdateEntretien(avionDetails.getdateEntretien());
		avion.setKm(avionDetails.getKm());
		final Avion updatedAvion = avionRepository.save(avion);
		return ResponseEntity.ok(updatedAvion);
	}

	// delete avion

	@DeleteMapping("/avions/{id}")
	public Map<String, Boolean> deleteAvion(@PathVariable(value = "id") Long avionId) throws ResourceNotFoundException {
		Avion avion = avionRepository.findById(avionId)
				.orElseThrow(() -> new ResourceNotFoundException("Avion not found for this id :: " + avionId));

		avionRepository.delete(avion);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
