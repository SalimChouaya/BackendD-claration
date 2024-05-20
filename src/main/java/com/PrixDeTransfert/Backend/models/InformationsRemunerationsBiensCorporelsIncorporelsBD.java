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
public class InformationsRemunerationsBiensCorporelsIncorporelsBD {

	
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		@Column
		String TotalAchatsDepensesRemunerationsBiensCorporelsIncorporels ;
		@Column
		String TotalVentesRevenusRemunerationsBiensCorporelsIncorporels;
		 public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		@OneToMany(mappedBy ="InformationsRemunerationsBiensCorporelsIncorporels",cascade = CascadeType.ALL, orphanRemoval = true)
		 @JsonManagedReference
		    private List<LigneRemunerationBiensBD> LigneRemunerationBiens;
		
		 public List<LigneRemunerationBiensBD> getLigneRemunerationBiens() {
			return LigneRemunerationBiens;
		}
		public void setLigneRemunerationBiens(List<LigneRemunerationBiensBD> ligneRemunerationBiens) {
			LigneRemunerationBiens = ligneRemunerationBiens;
		}
		@OneToOne
		    @JoinColumn(name = "MontantTransactionsMethodeDeterminationPrixTransfertid", referencedColumnName = "id")
		    private MontantTransactionsMethodeDeterminationPrixTransfertBD MontantTransactionsMethodeDeterminationPrixTransfert;
		public String getTotalAchatsDepensesRemunerationsBiensCorporelsIncorporels() {
			return TotalAchatsDepensesRemunerationsBiensCorporelsIncorporels;
		}
		public void setTotalAchatsDepensesRemunerationsBiensCorporelsIncorporels(
				String totalAchatsDepensesRemunerationsBiensCorporelsIncorporels) {
			TotalAchatsDepensesRemunerationsBiensCorporelsIncorporels = totalAchatsDepensesRemunerationsBiensCorporelsIncorporels;
		}
		public String getTotalVentesRevenusRemunerationsBiensCorporelsIncorporels() {
			return TotalVentesRevenusRemunerationsBiensCorporelsIncorporels;
		}
		public void setTotalVentesRevenusRemunerationsBiensCorporelsIncorporels(
				String totalVentesRevenusRemunerationsBiensCorporelsIncorporels) {
			TotalVentesRevenusRemunerationsBiensCorporelsIncorporels = totalVentesRevenusRemunerationsBiensCorporelsIncorporels;
		}
		public MontantTransactionsMethodeDeterminationPrixTransfertBD getMontantTransactionsMethodeDeterminationPrixTransfert() {
			return MontantTransactionsMethodeDeterminationPrixTransfert;
		}
		public void setMontantTransactionsMethodeDeterminationPrixTransfert(
				MontantTransactionsMethodeDeterminationPrixTransfertBD montantTransactionsMethodeDeterminationPrixTransfert) {
			MontantTransactionsMethodeDeterminationPrixTransfert = montantTransactionsMethodeDeterminationPrixTransfert;
		}
			
		
	}

