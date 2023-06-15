package com.example.cadastro.address;

import com.example.cadastro.doctor.entities.Doctor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "address")
@Entity(name = "Address")
@Embeddable
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Address {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
    private String logradouro;
	
	@Column(nullable = false)
    private String bairro;
	
	@Column(nullable = false)
    private String cep;
	
	@Column(nullable = false)
    private Integer numero;

    private String complemento;

    
    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String uf;
    
    
    @ManyToOne()
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    



//    public void update(CreateAddressDTO data) {
//
//        if(data.logradouro() != null){
//            this.logradouro = data.logradouro();
//        }
//
//        if(data.cep() != null){
//            this.cep = data.cep();
//        }
//
//        if(data.numero() != null){
//            this.numero = data.numero();
//        }
//
//        if(data.cidade() != null){
//            this.cidade = data.cidade();
//        }
//
//        if(data.bairro() != null){
//            this.bairro = data.bairro();
//        }
//
//        if(data.complemento() != null){
//            this.complemento = data.complemento();
//        }
//
//        if(data.uf() != null){
//            this.uf = data.uf();
//        }
//
//
//    }
}
