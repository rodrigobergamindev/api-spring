package com.example.cadastro.doctor.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.example.cadastro.doctor.entities.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor,Long> {
	
	
}
