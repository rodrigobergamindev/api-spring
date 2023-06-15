package com.example.cadastro.doctor.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.cadastro.address.Address;
import com.example.cadastro.address.dto.request.CreateAddressDTO;
import com.example.cadastro.doctor.dto.request.CreateDoctorDTO;
import com.example.cadastro.doctor.dto.request.UpdateDoctorDTO;
import com.example.cadastro.doctor.enums.Especialidade;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "doctor")
@Entity(name = "Doctor")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Doctor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="doctor_name", nullable = false, length = 120)
	private String name;
	
	private String email;
	
	private String phone;
	
	@Column(nullable = false, length = 120, unique=true)
	private String crm;
	
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	
	
	@OneToMany(mappedBy="doctor", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Address> address = new ArrayList<>();


	
	public void update(UpdateDoctorDTO data) {

        if(data.name() != null){
            this.name = data.name();
        }

        if(data.phone() != null){
            this.phone = data.phone();
        }

  
    }
	
	
}
