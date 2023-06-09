package com.example.cadastro.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.doctor.dto.CreateDoctorDTO;
import com.example.cadastro.doctor.entities.Doctor;
import com.example.cadastro.doctor.repository.DoctorRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("doctors")

public class DoctorController {
	
	@Autowired
	private DoctorRepository repository;
	
	
	@PostMapping
	@Transactional
	public void create(@RequestBody @Valid CreateDoctorDTO data) {
		repository.save(new Doctor(data));
	}

}
