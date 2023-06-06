package com.example.cadastro.doctor.dto;

import com.example.cadastro.doctor.entities.Doctor;
import com.example.cadastro.doctor.enums.Especialidade;

public record GetAllDoctorsDTO(
		
		  	Long id,

	        String nome,

	        String email,

	        String crm,

	        Especialidade especialidade
		
		) {
		
	
	 public GetAllDoctorsDTO(Doctor doctor){
	        this(
	                doctor.getId(),
	                doctor.getName(),
	                doctor.getEmail(),
	                doctor.getCrm(),
	                doctor.getEspecialidade()
	                );
	    }

}
