package com.example.cadastro.doctor.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.doctor.dto.request.CreateDoctorDTO;
import com.example.cadastro.doctor.dto.response.DoctorResponseDTO;
import com.example.cadastro.doctor.dto.response.GetAllDoctorsDTO;
import com.example.cadastro.doctor.entities.Doctor;
import com.example.cadastro.doctor.repository.DoctorRepository;
import com.example.cadastro.doctor.service.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("doctors")

public class DoctorController {
	
	@Autowired
	private DoctorService service;
	
	
	@PostMapping
	@Transactional
	public void create(@RequestBody @Valid CreateDoctorDTO data) {
		//service.save(new Doctor(data));
		
	}
	
	
	@GetMapping
	@Transactional(readOnly = true)
	@ResponseBody
    public Page<GetAllDoctorsDTO> findAll(Pageable pagination){

        return service.findAll(pagination);
    }

	@GetMapping("/{id}")
	@Transactional(readOnly = true)
	@ResponseBody
	public DoctorResponseDTO findById(@PathVariable Long id) {
		return service.findById(id);
		
	}
}
