package com.example.cadastro.doctor.dto.request;


import java.util.List;

import com.example.cadastro.doctor.enums.Especialidade;
import com.example.cadastro.endereco.CreateAddressDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateDoctorDTO (
		@NotBlank
		String name,
		
		@NotEmpty(message = "{email.notempty}")
		@Email
		String email,
		
		@NotBlank
		String phone,
		
		@NotBlank
		@Pattern(regexp = "\\d{4,6}")
		String crm,
		
		@NotNull
		Especialidade especialidade
		
		//@NotNull
		//@Valid
		//List<CreateAddressDTO> address 
		) {


	
	

}
