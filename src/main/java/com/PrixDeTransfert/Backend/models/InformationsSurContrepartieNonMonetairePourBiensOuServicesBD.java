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
@Table(name="InformationsSCPNMPBOS")
public class InformationsSurContrepartieNonMonetairePourBiensOuServicesBD {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	char Affirmation;
	@OneToOne
    @JoinColumn(name = "OperationsSCPOACPNM", referencedColumnName = "id")
    private OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD OperationsSansContrepartieOuAvecContrepartieNonMonetaire;
	@OneToMany(mappedBy ="InformationsSurContrepartieNonMonetairePourBiensOuServices",cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference
	    private List<LigneContrepartieNonMonetairePourBiensOuServicesBD> LigneContrepartieNonMonetairePourBiensOuServices;
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
	public OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD getOperationsSansContrepartieOuAvecContrepartieNonMonetaire() {
		return OperationsSansContrepartieOuAvecContrepartieNonMonetaire;
	}
	public void setOperationsSansContrepartieOuAvecContrepartieNonMonetaire(
			OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD operationsSansContrepartieOuAvecContrepartieNonMonetaire) {
		OperationsSansContrepartieOuAvecContrepartieNonMonetaire = operationsSansContrepartieOuAvecContrepartieNonMonetaire;
	}
	public List<LigneContrepartieNonMonetairePourBiensOuServicesBD> getLigneContrepartieNonMonetairePourBiensOuServices() {
		return LigneContrepartieNonMonetairePourBiensOuServices;
	}
	public void setLigneContrepartieNonMonetairePourBiensOuServices(
			List<LigneContrepartieNonMonetairePourBiensOuServicesBD> ligneContrepartieNonMonetairePourBiensOuServices) {
		LigneContrepartieNonMonetairePourBiensOuServices = ligneContrepartieNonMonetairePourBiensOuServices;
	}
	
}
