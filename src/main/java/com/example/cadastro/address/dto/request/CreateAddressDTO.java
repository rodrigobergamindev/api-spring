package com.example.cadastro.address.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateAddressDTO (
		
		@NotBlank(message = "{logradouro.notempty}")
		String logradouro,
		
		@NotBlank(message = "{bairro.notempty}")
		String bairro,
		
		@NotBlank(message = "{cep.notempty}")
		@Pattern(regexp= "\\d{8}")
		String cep,
		
		@NotBlank(message = "{cidade.notempty}")
		String cidade,
		
		@NotBlank(message = "{uf.notempty}")
		String uf,
		
		String complemento,
		
		@NotNull(message = "{numero.notempty}")
		Integer numero
		) {
	
	
}
