package com.example.cadastro.doctor.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.cadastro.doctor.entities.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor,Long> {
	
	
}
