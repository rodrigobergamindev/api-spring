package com.example.cadastro.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.example.cadastro.address.Address;
import com.example.cadastro.address.dto.request.CreateAddressDTO;
import com.example.cadastro.address.dto.response.ResponseAddressDTO;
import com.example.cadastro.doctor.dto.request.CreateDoctorDTO;
import com.example.cadastro.doctor.dto.request.UpdateDoctorDTO;
import com.example.cadastro.doctor.dto.response.DoctorResponseDTO;
import com.example.cadastro.doctor.entities.Doctor;

@Mapper(componentModel = "spring")
public interface CadastroMapper {

	CadastroMapper mapper = Mappers.getMapper(CadastroMapper.class);
	
	
	DoctorResponseDTO doctorToDoctorDTO(Doctor doctor);
	Doctor doctorDTOToDoctor(CreateDoctorDTO dto);
	Address addressDTOToAddress(CreateAddressDTO dto);
	ResponseAddressDTO addressToAddressDTO(Address address);
	
	List<Address> multipleAddressDTOtoAddress(List<CreateAddressDTO> addresses);
	
	List<DoctorResponseDTO> doctorsToAllDoctorsDTO(List<Doctor> doctor);
	
	
	void updateDoctorFromDTO(UpdateDoctorDTO updateDoctorDTO, @MappingTarget Doctor doctor);

}
