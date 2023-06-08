package com.example.cadastro.doctor.dto.request;

import java.util.List;

import com.example.cadastro.doctor.enums.Especialidade;
import com.example.cadastro.endereco.CreateAddressDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdateDoctorDTO(
		
		@NotBlank
        String name,
        
        @NotBlank
        String phone,
        
        @NotEmpty(message = "{email.notempty}")
		@Email
        String email,
        
        @NotBlank
		@Pattern(regexp = "\\d{4,6}")
		String crm,
		
		@NotNull
		Especialidade especialidade

        //List<CreateAddressDTO> address
) {
}
