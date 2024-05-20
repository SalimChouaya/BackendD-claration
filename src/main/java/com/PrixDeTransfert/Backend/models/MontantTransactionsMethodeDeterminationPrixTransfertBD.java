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
public class MontantTransactionsMethodeDeterminationPrixTransfertBD {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 @OneToOne(mappedBy = "MontantTransactionsMethodeDeterminationPrixTransfert",cascade = CascadeType.ALL, orphanRemoval = true)
	    private InformationsValeursExploitationBD InformationsValeursExploitation;
	 @OneToOne(mappedBy = "MontantTransactionsMethodeDeterminationPrixTransfert",cascade = CascadeType.ALL, orphanRemoval = true)
	    private InformationsServicesBD InformationsServices;
	 @OneToOne(mappedBy = "MontantTransactionsMethodeDeterminationPrixTransfert",cascade = CascadeType.ALL, orphanRemoval = true)
	    private InformationsOperationsFinancieresBD InformationsOperationsFinancieres;
	 @OneToOne(mappedBy = "MontantTransactionsMethodeDeterminationPrixTransfert",cascade = CascadeType.ALL, orphanRemoval = true)
	    private InformationsCessionsAcquisitionsActifsBD InformationsCessionsAcquisitionsActifs;
	 @OneToOne(mappedBy = "MontantTransactionsMethodeDeterminationPrixTransfert",cascade = CascadeType.ALL, orphanRemoval = true)
	    private InformationsAutresOperationsBD InformationsAutresOperations;

	 @OneToOne(mappedBy = "MontantTransactionsMethodeDeterminationPrixTransfert",cascade = CascadeType.ALL, orphanRemoval = true)
	    private InformationsRemunerationsBiensCorporelsIncorporelsBD InformationsRemunerationsBiensCorporelsIncorporels;
	 @OneToOne(mappedBy = "MontantTransactionsMethodeDeterminationPrixTransfert",cascade = CascadeType.ALL, orphanRemoval = true)
	    private DescriptionTransactionsRegimeFiscalPrivilegie DescriptionTransactionsRegimeFiscalPrivilegie;
	    
	    
	    @OneToOne
	    @JoinColumn(name = "Informations_Operations_id", referencedColumnName = "id")
	    private InformationsOperationsBD InformationsOperations;
		
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
		public InformationsValeursExploitationBD getInformationsValeursExploitation() {
			return InformationsValeursExploitation;
		}
		public void setInformationsValeursExploitation(InformationsValeursExploitationBD informationsValeursExploitation) {
			InformationsValeursExploitation = informationsValeursExploitation;
		}
		public InformationsServicesBD getInformationsServices() {
			return InformationsServices;
		}
		public void setInformationsServices(InformationsServicesBD informationsServices) {
			InformationsServices = informationsServices;
		}
		public InformationsOperationsFinancieresBD getInformationsOperationsFinancieres() {
			return InformationsOperationsFinancieres;
		}
		public void setInformationsOperationsFinancieres(
				InformationsOperationsFinancieresBD informationsOperationsFinancieres) {
			InformationsOperationsFinancieres = informationsOperationsFinancieres;
		}
		public InformationsCessionsAcquisitionsActifsBD getInformationsCessionsAcquisitionsActifs() {
			return InformationsCessionsAcquisitionsActifs;
		}
		public void setInformationsCessionsAcquisitionsActifs(
				InformationsCessionsAcquisitionsActifsBD informationsCessionsAcquisitionsActifs) {
			InformationsCessionsAcquisitionsActifs = informationsCessionsAcquisitionsActifs;
		}
		public InformationsAutresOperationsBD getInformationsAutresOperations() {
			return InformationsAutresOperations;
		}
		public void setInformationsAutresOperations(InformationsAutresOperationsBD informationsAutresOperations) {
			InformationsAutresOperations = informationsAutresOperations;
		}
		public InformationsRemunerationsBiensCorporelsIncorporelsBD getInformationsRemunerationsBiensCorporelsIncorporels() {
			return InformationsRemunerationsBiensCorporelsIncorporels;
		}
		public void setInformationsRemunerationsBiensCorporelsIncorporels(
				InformationsRemunerationsBiensCorporelsIncorporelsBD informationsRemunerationsBiensCorporelsIncorporels) {
			InformationsRemunerationsBiensCorporelsIncorporels = informationsRemunerationsBiensCorporelsIncorporels;
		}
		public DescriptionTransactionsRegimeFiscalPrivilegie getDescriptionTransactionsRegimeFiscalPrivilegie() {
			return DescriptionTransactionsRegimeFiscalPrivilegie;
		}
		public void setDescriptionTransactionsRegimeFiscalPrivilegie(
				DescriptionTransactionsRegimeFiscalPrivilegie descriptionTransactionsRegimeFiscalPrivilegie) {
			DescriptionTransactionsRegimeFiscalPrivilegie = descriptionTransactionsRegimeFiscalPrivilegie;
		}
		
}
