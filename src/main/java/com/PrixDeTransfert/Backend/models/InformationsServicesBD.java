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
public class InformationsServicesBD {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	String TotalAchatsDepensesServices ;
	@Column
	String TotalVentesServices;
	 
	
	
	 public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTotalAchatsDepensesServices() {
		return TotalAchatsDepensesServices;
	}



	public void setTotalAchatsDepensesServices(String totalAchatsDepensesServices) {
		TotalAchatsDepensesServices = totalAchatsDepensesServices;
	}



	public String getTotalVentesServices() {
		return TotalVentesServices;
	}



	public void setTotalVentesServices(String totalVentesServices) {
		TotalVentesServices = totalVentesServices;
	}



	public MontantTransactionsMethodeDeterminationPrixTransfertBD getMontantTransactionsMethodeDeterminationPrixTransfert() {
		return MontantTransactionsMethodeDeterminationPrixTransfert;
	}



	public void setMontantTransactionsMethodeDeterminationPrixTransfert(
			MontantTransactionsMethodeDeterminationPrixTransfertBD montantTransactionsMethodeDeterminationPrixTransfert) {
		MontantTransactionsMethodeDeterminationPrixTransfert = montantTransactionsMethodeDeterminationPrixTransfert;
	}


	@OneToMany(mappedBy ="InformationsServices",cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference
	    private List<LigneServiceBD> LigneService;
	@OneToOne
	    @JoinColumn(name = "MontantTransactionsMethodeDeterminationPrixTransfertid", referencedColumnName = "id")
	    private MontantTransactionsMethodeDeterminationPrixTransfertBD MontantTransactionsMethodeDeterminationPrixTransfert;



	public List<LigneServiceBD> getLigneService() {
		return LigneService;
	}



	public void setLigneService(List<LigneServiceBD> ligneService) {
		LigneService = ligneService;
	}

}
