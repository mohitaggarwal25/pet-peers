package com.petpeers.controller;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.petpeers.entities.User;
import com.petpeers.repositroy.DataNotFoundException;
import com.petpeers.repositroy.PetRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class PetController {

	@Autowired
	private PetRepository petRepository;

	@GetMapping("/pets")
	public List<User> retrieveAllpets() {
		return petRepository.findAll();
	}

	@GetMapping("/pets/{id}")
	@ApiOperation(value = "Find student by id",
    notes = "Also returns a link to retrieve all pets with rel - all-pets")
	public User retrieveStudent(@PathVariable long id) {
		Optional<User> pet = petRepository.findById(id);

		if (!pet.isPresent())
			throw new DataNotFoundException("id-" + id);

		User resource = new User();

		return resource;
	}

	@DeleteMapping("/pets/{id}")
	public void deleteStudent(@PathVariable long id) {
		petRepository.deleteById(id);
	}

	@PostMapping("/pets")
	public ResponseEntity<Object> createStudent(@RequestBody User student) {
		User savedStudent = petRepository.save(student);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/pets/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody User student, @PathVariable long id) {

		Optional<User> studentOptional = petRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setId(id);
		
		petRepository.save(student);

		return ResponseEntity.noContent().build();
	}
}
