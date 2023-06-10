package com.example.cadastro.doctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.cadastro.MainApplication;
import com.example.cadastro.doctor.dto.request.CreateDoctorDTO;
import com.example.cadastro.doctor.dto.request.UpdateDoctorDTO;
import com.example.cadastro.doctor.dto.response.DoctorResponseDTO;

import com.example.cadastro.doctor.entities.Doctor;
import com.example.cadastro.doctor.repository.DoctorRepository;
import com.example.cadastro.exceptions.NoDataFoundException;
import com.example.cadastro.exceptions.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class DoctorService {
	
	
	
	@Autowired
	private DoctorRepository repository;
	
	
	public Page<DoctorResponseDTO> findAll(Pageable pagination){
			
		log.info("Getting all doctors");
     
    	   Page<DoctorResponseDTO> doctorList = repository.findAll(pagination).map(DoctorResponseDTO::new);
    	   
    	   if(doctorList.isEmpty()) {
    		   throw new NoDataFoundException("No data found!");
    	   }
    	   
    	   return doctorList;
       
    }
	
	
	public DoctorResponseDTO findById(Long id) {
		log.info("Finding the doctor with id {}", id);
		
		return new DoctorResponseDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id")));
	
	}
	
	public void create(CreateDoctorDTO data) {
		log.info("Creating a doctor!");
		repository.save(new Doctor(data));
	}
	
	public void update(UpdateDoctorDTO data, Long id) {
		
		log.info("Updating the doctor with {}", id);
		
		Doctor doctor = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		
		doctor.setCrm(data.crm());
		doctor.setEmail(data.email());
		doctor.setEspecialidade(data.especialidade());
		doctor.setPhone(data.phone());
		doctor.setName(data.name());
		
		repository.save(doctor);
	}
	
	public void delete(Long id) {
		
		log.info("Delete the doctor with id {}", id);
		
		repository.deleteById(id);
		
		
	}
	

}
