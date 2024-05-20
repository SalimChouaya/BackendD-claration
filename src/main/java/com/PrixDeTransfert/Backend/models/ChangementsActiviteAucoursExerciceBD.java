package com.PrixDeTransfert.Backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table

public class ChangementsActiviteAucoursExerciceBD {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	String Affirmation;
	@Column 
	String Description;
	@OneToOne
    @JoinColumn(name ="InformationsEntrepriseDeclarante_id", referencedColumnName = "id")
    private InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclarante;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAffirmation() {
		return Affirmation;
	}
	public void setAffirmation(String affirmation) {
		Affirmation = affirmation;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public InformationsEntrepriseDeclaranteBD getInformationsEntrepriseDeclarante() {
		return InformationsEntrepriseDeclarante;
	}
	public void setInformationsEntrepriseDeclarante(InformationsEntrepriseDeclaranteBD informationsEntrepriseDeclarante) {
		InformationsEntrepriseDeclarante = informationsEntrepriseDeclarante;
	}

}
