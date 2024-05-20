package com.PrixDeTransfert.Backend.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Informations_Operations")
public class InformationsOperationsBD {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 @OneToOne
	    @JoinColumn(name = "declaration_prix_de_transfert_id", referencedColumnName = "id")
	    private DéclarationPrixDeTransfert DéclarationPrixDeTransfert;
	 @OneToOne(mappedBy = "InformationsOperations",cascade = CascadeType.ALL, orphanRemoval = true)
	    private MontantTransactionsMethodeDeterminationPrixTransfertBD MontantTransactionsMethodeDeterminationPrixTransfert;
	 @OneToOne(mappedBy = "InformationsOperations",cascade = CascadeType.ALL, orphanRemoval = true)
	    private InformationsPretsEmpruntsBD InformationsPretsEmprunts;
	 @OneToOne(mappedBy = "InformationsOperations",cascade = CascadeType.ALL, orphanRemoval = true)
	    private OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD OperationsSansContrepartieOuAvecContrepartieNonMonetaire;
	 @OneToOne(mappedBy = "InformationsOperations",cascade = CascadeType.ALL, orphanRemoval = true)
	    private InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD InformationsOperationsAccordsPrealablesOuRescritsFiscaux;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public DéclarationPrixDeTransfert getDéclarationPrixDeTransfert() {
		return DéclarationPrixDeTransfert;
	}
	public void setDéclarationPrixDeTransfert(DéclarationPrixDeTransfert déclarationPrixDeTransfert) {
		DéclarationPrixDeTransfert = déclarationPrixDeTransfert;
	}
	public MontantTransactionsMethodeDeterminationPrixTransfertBD getMontantTransactionsMethodeDeterminationPrixTransfert() {
		return MontantTransactionsMethodeDeterminationPrixTransfert;
	}
	public void setMontantTransactionsMethodeDeterminationPrixTransfert(
			MontantTransactionsMethodeDeterminationPrixTransfertBD montantTransactionsMethodeDeterminationPrixTransfert) {
		MontantTransactionsMethodeDeterminationPrixTransfert = montantTransactionsMethodeDeterminationPrixTransfert;
	}
	public InformationsPretsEmpruntsBD getInformationsPretsEmprunts() {
		return InformationsPretsEmprunts;
	}
	public void setInformationsPretsEmprunts(InformationsPretsEmpruntsBD informationsPretsEmprunts) {
		InformationsPretsEmprunts = informationsPretsEmprunts;
	}
	public OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD getOperationsSansContrepartieOuAvecContrepartieNonMonetaire() {
		return OperationsSansContrepartieOuAvecContrepartieNonMonetaire;
	}
	public void setOperationsSansContrepartieOuAvecContrepartieNonMonetaire(
			OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD operationsSansContrepartieOuAvecContrepartieNonMonetaire) {
		OperationsSansContrepartieOuAvecContrepartieNonMonetaire = operationsSansContrepartieOuAvecContrepartieNonMonetaire;
	}
	public InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD getInformationsOperationsAccordsPrealablesOuRescritsFiscaux() {
		return InformationsOperationsAccordsPrealablesOuRescritsFiscaux;
	}
	public void setInformationsOperationsAccordsPrealablesOuRescritsFiscaux(
			InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD informationsOperationsAccordsPrealablesOuRescritsFiscaux) {
		InformationsOperationsAccordsPrealablesOuRescritsFiscaux = informationsOperationsAccordsPrealablesOuRescritsFiscaux;
	}
	 
	
}
