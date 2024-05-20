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
public class InformationsOperationsFinancieresBD {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	String TotalAchatsDepensesOperationsFinancieres;
	@Column
	String TotalVentesRevenusOperationsFinancieres;
	 public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTotalAchatsDepensesOperationsFinancieres() {
		return TotalAchatsDepensesOperationsFinancieres;
	}
	public void setTotalAchatsDepensesOperationsFinancieres(String totalAchatsDepensesOperationsFinancieres) {
		TotalAchatsDepensesOperationsFinancieres = totalAchatsDepensesOperationsFinancieres;
	}
	public String getTotalVentesRevenusOperationsFinancieres() {
		return TotalVentesRevenusOperationsFinancieres;
	}
	public List<LigneOperationFinanciereBD> getLigneOperationFinanciere() {
		return LigneOperationFinanciere;
	}
	public void setLigneOperationFinanciere(List<LigneOperationFinanciereBD> ligneOperationFinanciere) {
		LigneOperationFinanciere = ligneOperationFinanciere;
	}
	public void setTotalVentesRevenusOperationsFinancieres(String totalVentesRevenusOperationsFinancieres) {
		TotalVentesRevenusOperationsFinancieres = totalVentesRevenusOperationsFinancieres;
	}
	public MontantTransactionsMethodeDeterminationPrixTransfertBD getMontantTransactionsMethodeDeterminationPrixTransfert() {
		return MontantTransactionsMethodeDeterminationPrixTransfert;
	}
	public void setMontantTransactionsMethodeDeterminationPrixTransfert(
			MontantTransactionsMethodeDeterminationPrixTransfertBD montantTransactionsMethodeDeterminationPrixTransfert) {
		MontantTransactionsMethodeDeterminationPrixTransfert = montantTransactionsMethodeDeterminationPrixTransfert;
	}
	@OneToMany(mappedBy ="InformationsOperationsFinancieres",cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference
	    private List<LigneOperationFinanciereBD> LigneOperationFinanciere;
	@OneToOne
	    @JoinColumn(name = "MontantTransactionsMethodeDeterminationPrixTransfertid", referencedColumnName = "id")
	    private MontantTransactionsMethodeDeterminationPrixTransfertBD MontantTransactionsMethodeDeterminationPrixTransfert;
}
