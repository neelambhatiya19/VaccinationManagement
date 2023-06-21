package com.demo.project.CitizenService.controller;

import com.demo.project.CitizenService.entity.Citizen;
import com.demo.project.CitizenService.repository.CitizenRepository;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	@Autowired
	private CitizenRepository citizenRepository;

	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("Hello", HttpStatus.OK);

	}

	@GetMapping("/id/{id}")
	public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id) {
		List<Citizen> listOfCitizen = citizenRepository.findByVaccinationCenterId(id);
		return new ResponseEntity<>(listOfCitizen, HttpStatus.OK);// new ResponseEntity<>("Hello", HttpStatus.OK);

	}

	@GetMapping("/all")
	public ResponseEntity<List<Citizen>> getAllCitizen() {
		List<Citizen> listOfCitizen = citizenRepository.findAll();
		return new ResponseEntity<>(listOfCitizen, HttpStatus.OK);// new ResponseEntity<>("Hello", HttpStatus.OK);

	}

	@PostMapping(path = "/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newcitizen) {
		Citizen citizen = citizenRepository.save(newcitizen);
		return new ResponseEntity<>(citizen, HttpStatus.OK);

	}

	@PutMapping(path = "/update/{id}")
	public Citizen updateCitizen(@PathVariable Integer id, @RequestBody Citizen newcitizen) {

		Citizen citizen = citizenRepository.findById(id).get();

		if (Objects.nonNull(newcitizen.getName()) && !"".equalsIgnoreCase(newcitizen.getName())) {
			citizen.setName(newcitizen.getName());
		}

		if (Objects.nonNull(newcitizen.getVaccinationCenterId())) {
			citizen.setVaccinationCenterId(newcitizen.getVaccinationCenterId());
		}

		return citizenRepository.save(citizen);

	}

	@DeleteMapping(path = "/remove/{id}")
	public ResponseEntity<String> removeCitizen(@PathVariable Integer id) {
		citizenRepository.deleteById(id);
		return new ResponseEntity<>("Citizen with id " + id + " deleted", HttpStatus.OK);

	}

}
