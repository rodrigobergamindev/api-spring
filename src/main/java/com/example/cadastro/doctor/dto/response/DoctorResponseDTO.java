package com.example.cadastro.doctor.dto.response;

import com.example.cadastro.doctor.entities.Doctor;
import com.example.cadastro.doctor.enums.Especialidade;

public record DoctorResponseDTO(
		Long id,

        String nome,

        String email,

        String crm,

        Especialidade especialidade
		) {
	
	 public DoctorResponseDTO(Doctor doctor){
	        this(
	                doctor.getId(),
	                doctor.getName(),
	                doctor.getEmail(),
	                doctor.getCrm(),
	                doctor.getEspecialidade()
	                );
	    }
}
