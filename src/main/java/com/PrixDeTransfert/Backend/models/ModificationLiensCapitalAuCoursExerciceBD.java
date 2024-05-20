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
@Table(name="ModificationLiensCapitalAuCoursExercice")
public class ModificationLiensCapitalAuCoursExerciceBD {
	
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

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 @Column
		private char Affirmation;
		 
		 @Column
		private String Description;
		 
		 @OneToOne
		    @JoinColumn(name = "informations_Entreprise_Declarante_id", referencedColumnName = "id")
		    private InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclarante;
		 

}
