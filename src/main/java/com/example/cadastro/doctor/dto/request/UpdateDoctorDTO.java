package com.example.cadastro.doctor.dto.request;

import java.util.List;

import com.example.cadastro.endereco.CreateAddressDTO;

import jakarta.validation.constraints.NotNull;

public record UpdateDoctorDTO(

        @NotNull
        Long id,

        String name,

        String phone,

        String email,

        List<CreateAddressDTO> address
) {
}
