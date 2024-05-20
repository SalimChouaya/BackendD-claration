package com.PrixDeTransfert.Backend.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="InformationsSBOSSCP")
public class InformationsSurBiensOuServicesSansContrePartieBD {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	char Affirmation;
	@OneToOne
    @JoinColumn(name = "OperationsSCPOACPNM", referencedColumnName = "id")
    private OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD OperationsSansContrepartieOuAvecContrepartieNonMonetaire;
	@OneToMany(mappedBy ="InformationsSurBiensOuServicesSansContrePartie",cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference
	    private List<LigneBiensOuServicesSansContrePartieBD> LigneBiensOuServicesSansContrePartie;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public char getAffirmation() {
		return Affirmation;
	}
	public void setAffirmation(char affirmation) {
		Affirmation = affirmation;
	}
	
	public List<LigneBiensOuServicesSansContrePartieBD> getLigneBiensOuServicesSansContrePartie() {
		return LigneBiensOuServicesSansContrePartie;
	}
	public void setLigneBiensOuServicesSansContrePartie(
			List<LigneBiensOuServicesSansContrePartieBD> ligneBiensOuServicesSansContrePartie) {
		LigneBiensOuServicesSansContrePartie = ligneBiensOuServicesSansContrePartie;
	}
	public OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD getOperationsSansContrepartieOuAvecContrepartieNonMonetaire() {
		return OperationsSansContrepartieOuAvecContrepartieNonMonetaire;
	}
	public void setOperationsSansContrepartieOuAvecContrepartieNonMonetaire(
			OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD operationsSansContrepartieOuAvecContrepartieNonMonetaire) {
		OperationsSansContrepartieOuAvecContrepartieNonMonetaire = operationsSansContrepartieOuAvecContrepartieNonMonetaire;
	}
	
}
