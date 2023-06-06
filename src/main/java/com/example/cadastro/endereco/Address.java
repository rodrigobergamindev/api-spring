package com.example.cadastro.endereco;

import com.example.cadastro.doctor.entities.Doctor;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "address")
@Entity(name = "Address")
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Address {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;

    private String complemento;

    private String cidade;

    private String uf;
    

    public Address(CreateAddressDTO data){
        this.logradouro = data.logradouro();
        this.cep = data.cep();
        this.numero = data.numero();
        this.cidade = data.cidade();
        this.bairro = data.bairro();
        this.complemento = data.complemento();
        this.uf = data.uf();
    }

    public void update(CreateAddressDTO data) {

        if(data.logradouro() != null){
            this.logradouro = data.logradouro();
        }

        if(data.cep() != null){
            this.cep = data.cep();
        }

        if(data.numero() != null){
            this.numero = data.numero();
        }

        if(data.cidade() != null){
            this.cidade = data.cidade();
        }

        if(data.bairro() != null){
            this.bairro = data.bairro();
        }

        if(data.complemento() != null){
            this.complemento = data.complemento();
        }

        if(data.uf() != null){
            this.uf = data.uf();
        }


    }
}
