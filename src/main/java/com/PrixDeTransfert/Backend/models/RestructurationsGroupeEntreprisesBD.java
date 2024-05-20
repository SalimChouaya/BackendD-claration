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
public class RestructurationsGroupeEntreprisesBD {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	String Affirmation;
	@Column 
	String Description;
	@OneToOne
    @JoinColumn(name ="InformationsGroupeEntreprises_id", referencedColumnName = "id")
    private InformationsGroupeEntreprisesBD InformationsGroupeEntreprises;
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
	public InformationsGroupeEntreprisesBD getInformationsGroupeEntreprises() {
		return InformationsGroupeEntreprises;
	}
	public void setInformationsGroupeEntreprises(InformationsGroupeEntreprisesBD informationsGroupeEntreprises) {
		InformationsGroupeEntreprises = informationsGroupeEntreprises;
	}
	
    
}
