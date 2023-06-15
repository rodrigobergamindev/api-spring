package com.example.cadastro.address.dto.response;

import com.example.cadastro.doctor.dto.response.DoctorResponseDTO;
import com.example.cadastro.doctor.entities.Doctor;

import jakarta.validation.constraints.Pattern;

public record ResponseAddressDTO(
		
		String logradouro,
		
		
		String bairro,
		
		
		String cep,
		
		
		String cidade,
		
		
		String uf,
		
		String complemento,
		
		
		Integer numero
		
		
		) {

}
