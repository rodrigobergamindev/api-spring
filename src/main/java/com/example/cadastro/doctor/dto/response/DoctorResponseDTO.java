package com.example.cadastro.doctor.dto.response;

import java.util.List;

import com.example.cadastro.address.dto.response.ResponseAddressDTO;
import com.example.cadastro.doctor.entities.Doctor;
import com.example.cadastro.doctor.enums.Especialidade;

public record DoctorResponseDTO(
		Long id,

        String name,

        String email,

        String crm,
        
        String phone,
        
        Especialidade especialidade,
        
        List<ResponseAddressDTO> address
		) {
	

	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	public String getCrm() {
		// TODO Auto-generated method stub
		return this.crm;
	}
	
	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}
	
	public String getPhone() {
		// TODO Auto-generated method stub
		return this.phone;
	}
	
	public Especialidade getEspecialidade() {
		return this.especialidade;
	}
}
