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
@Table
public class InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	char Affirmation;
	@OneToMany(mappedBy ="InformationsOperationsAccordsPrealablesOuRescritsFiscaux",cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference
	    private List<LigneOperationsAccordsPrealablesOuRescritsFiscauxBD> LigneOperationsAccordsPrealablesOuRescritsFiscaux;
	
	
	
	@OneToOne
    @JoinColumn(name = "Informations_Operations_id", referencedColumnName = "id")
    private InformationsOperationsBD InformationsOperations;




	public List<LigneOperationsAccordsPrealablesOuRescritsFiscauxBD> getLigneOperationsAccordsPrealablesOuRescritsFiscaux() {
		return LigneOperationsAccordsPrealablesOuRescritsFiscaux;
	}




	public void setLigneOperationsAccordsPrealablesOuRescritsFiscaux(
			List<LigneOperationsAccordsPrealablesOuRescritsFiscauxBD> ligneOperationsAccordsPrealablesOuRescritsFiscaux) {
		LigneOperationsAccordsPrealablesOuRescritsFiscaux = ligneOperationsAccordsPrealablesOuRescritsFiscaux;
	}




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




	public InformationsOperationsBD getInformationsOperations() {
		return InformationsOperations;
	}




	public void setInformationsOperations(InformationsOperationsBD informationsOperations) {
		InformationsOperations = informationsOperations;
	}
	
	
}
