package com.PrixDeTransfert.Backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Qualité {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	Integer qualité;
	@ManyToOne
    @JsonBackReference
    @JoinColumn(name ="InformationsEntrepriseDeclaranteid", referencedColumnName = "id")
    private InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclarante;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQualité() {
		return qualité;
	}
	public void setQualité(Integer qualité) {
		this.qualité = qualité;
	}
	public InformationsEntrepriseDeclaranteBD getInformationsEntrepriseDeclarante() {
		return InformationsEntrepriseDeclarante;
	}
	public void setInformationsEntrepriseDeclarante(InformationsEntrepriseDeclaranteBD informationsEntrepriseDeclarante) {
		InformationsEntrepriseDeclarante = informationsEntrepriseDeclarante;
	}
	

}
