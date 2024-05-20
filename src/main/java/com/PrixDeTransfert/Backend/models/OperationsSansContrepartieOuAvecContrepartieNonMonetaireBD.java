package com.PrixDeTransfert.Backend.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="operations_sans_contrepartie_ou_avec_contrepartie_non_monetaire")

public class OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@OneToOne
    @JoinColumn(name = "Informations_Operations_id", referencedColumnName = "id")
    private InformationsOperationsBD InformationsOperations;
	 @OneToOne(mappedBy = "OperationsSansContrepartieOuAvecContrepartieNonMonetaire",cascade = CascadeType.ALL, orphanRemoval = true)
	    private  InformationsSurContrepartieNonMonetairePourBiensOuServicesBD InformationsSurContrepartieNonMonetairePourBiensOuServices;
	 @OneToOne(mappedBy = "OperationsSansContrepartieOuAvecContrepartieNonMonetaire",cascade = CascadeType.ALL, orphanRemoval = true)
	    private  InformationsSurBiensOuServicesSansContrePartieBD InformationsSurBiensOuServicesSansContrePartie;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public InformationsOperationsBD getInformationsOperations() {
		return InformationsOperations;
	}
	public void setInformationsOperations(InformationsOperationsBD informationsOperations) {
		InformationsOperations = informationsOperations;
	}
	public InformationsSurContrepartieNonMonetairePourBiensOuServicesBD getInformationsSurContrepartieNonMonetairePourBiensOuServices() {
		return InformationsSurContrepartieNonMonetairePourBiensOuServices;
	}
	public void setInformationsSurContrepartieNonMonetairePourBiensOuServices(
			InformationsSurContrepartieNonMonetairePourBiensOuServicesBD informationsSurContrepartieNonMonetairePourBiensOuServices) {
		InformationsSurContrepartieNonMonetairePourBiensOuServices = informationsSurContrepartieNonMonetairePourBiensOuServices;
	}
	public InformationsSurBiensOuServicesSansContrePartieBD getInformationsSurBiensOuServicesSansContrePartie() {
		return InformationsSurBiensOuServicesSansContrePartie;
	}
	public void setInformationsSurBiensOuServicesSansContrePartie(
			InformationsSurBiensOuServicesSansContrePartieBD informationsSurBiensOuServicesSansContrePartie) {
		InformationsSurBiensOuServicesSansContrePartie = informationsSurBiensOuServicesSansContrePartie;
	}
	
}
