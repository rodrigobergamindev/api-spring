package com.example.cadastro.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.cadastro.doctor.dto.request.CreateDoctorDTO;
import com.example.cadastro.doctor.dto.request.UpdateDoctorDTO;
import com.example.cadastro.doctor.dto.response.DoctorResponseDTO;
import com.example.cadastro.doctor.entities.Doctor;
import com.example.cadastro.doctor.repository.DoctorRepository;

import com.example.cadastro.exceptions.NoDataFoundException;
import com.example.cadastro.exceptions.ResourceNotFoundException;
import com.example.cadastro.mapper.CadastroMapper;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class DoctorService {
	
	
	
	@Autowired
	private DoctorRepository repository;
	
	@Autowired
	private CadastroMapper mapper;
	
	
	public Page<DoctorResponseDTO> findAll(Pageable pagination){
			
		log.info("Getting all doctors");
     
    	   List<DoctorResponseDTO> doctorsList = mapper.doctorsToAllDoctorsDTO(repository.findAll());
    	   
    	   if(doctorsList.isEmpty()) {
    		   throw new NoDataFoundException("No data found!");
    	   }
    	   
    	   Page<DoctorResponseDTO> doctorsPage = new PageImpl<DoctorResponseDTO>(doctorsList);
    	   return doctorsPage;
       
    }
	
	
	public DoctorResponseDTO findById(Long id) {
		log.info("Finding the doctor with id {}", id);
		
		return mapper.doctorToDoctorDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id")));
	
	}
	
	public void create(CreateDoctorDTO data) {
		log.info("Creating a doctor!");
		repository.save(mapper.doctorDTOToDoctor(data));
	}
	
	public void update(@Valid UpdateDoctorDTO data, Long id) {
		
		log.info("Updating the doctor with {}", id);
		
		Doctor doctor = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		
		mapper.updateDoctorFromDTO(data, repository.save(doctor));
	}
	
	public void delete(Long id) {
		
		log.info("Delete the doctor with id {}", id);
		
		repository.deleteById(id);
		
		
	}
	

}
