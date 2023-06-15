package com.example.cadastro.doctor.dto.request;


import java.util.ArrayList;
import java.util.List;

import com.example.cadastro.address.dto.request.CreateAddressDTO;
import com.example.cadastro.doctor.entities.Doctor;
import com.example.cadastro.doctor.enums.Especialidade;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;



public record CreateDoctorDTO (
		@NotBlank(message = "{name.notempty}")
		String name,
		
		@NotEmpty(message = "{email.notempty}")
		@Email
		String email,
		
		@NotBlank(message = "{phone.notempty}")
		String phone,
		
		@NotBlank(message = "{crm.notempty}")
		@Pattern(regexp = "\\d{4,6}")
		String crm,
		
		@NotNull
		Especialidade especialidade,
		
		@NotNull(message = "{address.notempty}")
		@Valid
		List<CreateAddressDTO> address
		) {

	
	

	

}
