package com.example.cadastro.address.repository;





import org.springframework.data.jpa.repository.JpaRepository;


import com.example.cadastro.address.Address;


public interface AddressRepository extends JpaRepository<Address,Long> {

	
}
