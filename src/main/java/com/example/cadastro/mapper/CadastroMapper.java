package com.example.cadastro.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.cadastro.doctor.dto.request.CreateDoctorDTO;
import com.example.cadastro.doctor.dto.response.DoctorResponseDTO;
import com.example.cadastro.doctor.entities.Doctor;

@Mapper
public interface CadastroMapper {

	CadastroMapper mapper = Mappers.getMapper(CadastroMapper.class);
	
	
	DoctorResponseDTO doctorToDoctorDTO(Doctor doctor);
	Doctor doctorDTOToDoctor(CreateDoctorDTO dto);
	

}
