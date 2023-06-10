package com.example.cadastro.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import com.example.cadastro.doctor.entities.Doctor;

import com.example.cadastro.doctor.dto.request.CreateDoctorDTO;
import com.example.cadastro.doctor.dto.response.DoctorResponseDTO;
import com.example.cadastro.doctor.entities.Doctor;

public class MockDoctor {


    public Doctor mockDoctor() {
        return mockDoctor(0);
    }
    
    
    public List<Doctor> mockEntityList() {
        List<Doctor> doctors = new ArrayList<Doctor>();
        for (int i = 0; i < 14; i++) {
            doctors.add(mockDoctor(i));
        }
        return doctors;
    }


    
    public Doctor mockDoctor(Integer number) {
        Doctor doctor = new Doctor();
        doctor.setId(Long.valueOf(number));
        doctor.setName("Name Test" + number);
        doctor.setEmail("Email Test" + number);
        doctor.setPhone("Phone Test" + number);
        doctor.setCrm("CRM Test" + number);
        doctor.setEspecialidade(null);
        return doctor;
    }



}
