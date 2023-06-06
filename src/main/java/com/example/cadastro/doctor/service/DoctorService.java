package com.example.cadastro.doctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.cadastro.doctor.dto.response.DoctorResponseDTO;
import com.example.cadastro.doctor.dto.response.GetAllDoctorsDTO;
import com.example.cadastro.doctor.repository.DoctorRepository;
import com.example.cadastro.exceptions.ResourceNotFoundException;

@Service
public class DoctorService {
	
	
	
	@Autowired
	private DoctorRepository repository;
	
	
	public Page<GetAllDoctorsDTO> findAll(Pageable pagination){

        return repository.findAll(pagination).map(GetAllDoctorsDTO::new);
    }
	
	
	public DoctorResponseDTO findById(Long id) {
		DoctorResponseDTO doctorResponseById = new DoctorResponseDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id")));
		return doctorResponseById;	
	}

}
