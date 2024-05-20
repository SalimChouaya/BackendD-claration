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
public class InformationsAutresOperationsBD {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTotalAchatsDepensesAutresOperations() {
		return TotalAchatsDepensesAutresOperations;
	}
	public void setTotalAchatsDepensesAutresOperations(String totalAchatsDepensesAutresOperations) {
		TotalAchatsDepensesAutresOperations = totalAchatsDepensesAutresOperations;
	}
	public String getTotalVentesRevenusAutresOperations() {
		return TotalVentesRevenusAutresOperations;
	}
	public void setTotalVentesRevenusAutresOperations(String totalVentesRevenusAutresOperations) {
		TotalVentesRevenusAutresOperations = totalVentesRevenusAutresOperations;
	}
	public MontantTransactionsMethodeDeterminationPrixTransfertBD getMontantTransactionsMethodeDeterminationPrixTransfert() {
		return MontantTransactionsMethodeDeterminationPrixTransfert;
	}
	public void setMontantTransactionsMethodeDeterminationPrixTransfert(
			MontantTransactionsMethodeDeterminationPrixTransfertBD montantTransactionsMethodeDeterminationPrixTransfert) {
		MontantTransactionsMethodeDeterminationPrixTransfert = montantTransactionsMethodeDeterminationPrixTransfert;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	String TotalAchatsDepensesAutresOperations ;
	@Column
	String TotalVentesRevenusAutresOperations;
	@OneToOne
    @JoinColumn(name = "MontantTransactionsMethodeDeterminationPrixTransfertid", referencedColumnName = "id")
    private MontantTransactionsMethodeDeterminationPrixTransfertBD MontantTransactionsMethodeDeterminationPrixTransfert;
	@OneToMany(mappedBy ="InformationsAutresOperations", cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference
	    private List<LigneAutreOperationBD> LigneAutreOperation;
	public List<LigneAutreOperationBD> getLigneAutreOperation() {
		return LigneAutreOperation;
	}
	public void setLigneAutreOperation(List<LigneAutreOperationBD> ligneAutreOperation) {
		LigneAutreOperation = ligneAutreOperation;
	}
	
}
