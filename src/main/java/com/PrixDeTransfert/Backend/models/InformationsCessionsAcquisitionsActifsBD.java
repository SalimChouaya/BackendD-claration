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
public class InformationsCessionsAcquisitionsActifsBD {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	String TotalAchatsDepensesCessionsAcquisitionsActifs ;
	@Column
	String TotalVentesRevenusCessionsAcquisitionsActifs;
	@OneToOne
    @JoinColumn(name = "MontantTransactionsMethodeDeterminationPrixTransfertid", referencedColumnName = "id")
    private MontantTransactionsMethodeDeterminationPrixTransfertBD MontantTransactionsMethodeDeterminationPrixTransfert;
	@OneToMany(mappedBy ="InformationsCessionsAcquisitionsActifs", cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference
	    private List<LigneCessionAcquisitionActifBD> LigneCessionAcquisitionActif;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTotalAchatsDepensesCessionsAcquisitionsActifs() {
		return TotalAchatsDepensesCessionsAcquisitionsActifs;
	}
	public void setTotalAchatsDepensesCessionsAcquisitionsActifs(String totalAchatsDepensesCessionsAcquisitionsActifs) {
		TotalAchatsDepensesCessionsAcquisitionsActifs = totalAchatsDepensesCessionsAcquisitionsActifs;
	}
	public String getTotalVentesRevenusCessionsAcquisitionsActifs() {
		return TotalVentesRevenusCessionsAcquisitionsActifs;
	}
	public void setTotalVentesRevenusCessionsAcquisitionsActifs(String totalVentesRevenusCessionsAcquisitionsActifs) {
		TotalVentesRevenusCessionsAcquisitionsActifs = totalVentesRevenusCessionsAcquisitionsActifs;
	}
	public MontantTransactionsMethodeDeterminationPrixTransfertBD getMontantTransactionsMethodeDeterminationPrixTransfert() {
		return MontantTransactionsMethodeDeterminationPrixTransfert;
	}
	public void setMontantTransactionsMethodeDeterminationPrixTransfert(
			MontantTransactionsMethodeDeterminationPrixTransfertBD montantTransactionsMethodeDeterminationPrixTransfert) {
		MontantTransactionsMethodeDeterminationPrixTransfert = montantTransactionsMethodeDeterminationPrixTransfert;
	}
	public List<LigneCessionAcquisitionActifBD> getLigneCessionAcquisitionActif() {
		return LigneCessionAcquisitionActif;
	}
	public void setLigneCessionAcquisitionActif(List<LigneCessionAcquisitionActifBD> ligneCessionAcquisitionActif) {
		LigneCessionAcquisitionActif = ligneCessionAcquisitionActif;
	}
	

}
