package com.PrixDeTransfert.Backend.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
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
public class InformationsPretsEmpruntsBD {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@OneToOne
    @JoinColumn(name = "Informations_Operations_id", referencedColumnName = "id")
    private InformationsOperationsBD InformationsOperations;
	@OneToMany(mappedBy ="InformationsPretsEmprunts",cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference
	    private List<LignePretAccordeBD> LignePretAccorde;
	@OneToMany(mappedBy ="InformationsPretsEmprunts",cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference
	    private List<LigneEmpruntContracteBD> LigneEmpruntContracte;
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
	public List<LignePretAccordeBD> getLignePretAccorde() {
		return LignePretAccorde;
	}
	public void setLignePretAccorde(List<LignePretAccordeBD> lignePretAccorde) {
		LignePretAccorde = lignePretAccorde;
	}
	public List<LigneEmpruntContracteBD> getLigneEmpruntContracte() {
		return LigneEmpruntContracte;
	}
	public void setLigneEmpruntContracte(List<LigneEmpruntContracteBD> ligneEmpruntContracte) {
		LigneEmpruntContracte = ligneEmpruntContracte;
	}
	
	
}
