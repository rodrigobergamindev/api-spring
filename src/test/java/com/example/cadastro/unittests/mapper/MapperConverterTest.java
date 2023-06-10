package com.example.cadastro.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;

import com.example.cadastro.doctor.dto.request.CreateDoctorDTO;
import com.example.cadastro.doctor.dto.response.DoctorResponseDTO;
import com.example.cadastro.mapper.CadastroMapperImpl;
import com.example.cadastro.doctor.entities.Doctor;
import com.example.cadastro.unittests.mapper.mocks.MockDoctor;

public class MapperConverterTest {
    
    MockDoctor inputObject;
    CadastroMapperImpl mapper;

    @BeforeEach
    public void setUp() {
        inputObject = new MockDoctor();
        mapper = new CadastroMapperImpl();
    }

    @Test
    public void parseEntityToDTOTest() {
    	
        DoctorResponseDTO output = mapper.doctorToDoctorDTO(inputObject.mockDoctor());
        
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Name Test0", output.getName());
        assertEquals("CRM Test0", output.getCrm());
        assertEquals("Email Test0", output.getEmail());
        assertEquals("Phone Test0", output.getPhone());
        assertEquals(null, output.getEspecialidade());
    }
    
    
    
    @Test
    public void parseEntityListToDTOListTest() {
    	
    	List<DoctorResponseDTO> outputList = new ArrayList<DoctorResponseDTO>();
    	
    	for(Doctor doctor: inputObject.mockEntityList()) {
			outputList.add(mapper.doctorToDoctorDTO(doctor));
		}
    	
        DoctorResponseDTO outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Name Test0", outputZero.getName());
        assertEquals("CRM Test0", outputZero.getCrm());
        assertEquals("Email Test0", outputZero.getEmail());
        assertEquals("Phone Test0", outputZero.getPhone());
        assertEquals(null, outputZero.getEspecialidade());
        
        DoctorResponseDTO outputSeven = outputList.get(7);
        
    
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Name Test7", outputSeven.getName());
        assertEquals("CRM Test7", outputSeven.getCrm());
        assertEquals("Email Test7", outputSeven.getEmail());
        assertEquals("Phone Test7", outputSeven.getPhone());
        assertEquals(null, outputSeven.getEspecialidade());
        
        DoctorResponseDTO outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Name Test12", outputTwelve.getName());
        assertEquals("CRM Test12", outputTwelve.getCrm());
        assertEquals("Email Test12", outputTwelve.getEmail());
        assertEquals("Phone Test12", outputTwelve.getPhone());
        assertEquals(null, outputTwelve.getEspecialidade());
        
        
    }
	
    
    /*
    @Test
    public void parseVOToEntityTest() {
        Person output = DozerMapper.parseObject(inputObject.mockVO(), Person.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Addres Test0", output.getAddress());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = DozerMapper.parseListObjects(inputObject.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Addres Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
        
        Person outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Addres Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());
        
        Person outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Addres Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
    }
    
    */
}
