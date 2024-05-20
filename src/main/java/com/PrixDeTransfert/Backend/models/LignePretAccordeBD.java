package com.PrixDeTransfert.Backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class LignePretAccordeBD {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	String Identifiant ;
	@Column
	String MatriculeFiscal;
	@Column
	String EtatTerritoire;
	@Column
	String AutreQualité;
	@Column
	String RaisonSociale ;
	@Column
	String Qualite ;
	@Column
	String NatureRelation ;
	@Column
	String AutreNatureRelation;
	@Column
	String SoldeOuverture ;
	@Column
	String Devise ;
	@Column
	String MouvementsAugmentations ;
	@Column
	String MouvementsDiminutions ;
	@Column
	String SoldeCloture ;
	@Column
	String PretsInterets ;
	@Column 
	String TauxInterets;
	 @ManyToOne
	    @JsonBackReference
	    @JoinColumn(name ="InformationsPretsEmpruntsid", referencedColumnName = "id")
	    private InformationsPretsEmpruntsBD InformationsPretsEmprunts;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIdentifiant() {
		return Identifiant;
	}
	public void setIdentifiant(String identifiant) {
		Identifiant = identifiant;
	}
	public String getMatriculeFiscal() {
		return MatriculeFiscal;
	}
	public void setMatriculeFiscal(String matriculeFiscal) {
		MatriculeFiscal = matriculeFiscal;
	}
	public String getEtatTerritoire() {
		return EtatTerritoire;
	}
	public void setEtatTerritoire(String etatTerritoire) {
		EtatTerritoire = etatTerritoire;
	}
	public String getAutreQualité() {
		return AutreQualité;
	}
	public void setAutreQualité(String autreQualité) {
		AutreQualité = autreQualité;
	}
	public String getRaisonSociale() {
		return RaisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		RaisonSociale = raisonSociale;
	}
	public String getQualite() {
		return Qualite;
	}
	public void setQualite(String qualite) {
		Qualite = qualite;
	}
	public String getNatureRelation() {
		return NatureRelation;
	}
	public void setNatureRelation(String natureRelation) {
		NatureRelation = natureRelation;
	}
	public String getAutreNatureRelation() {
		return AutreNatureRelation;
	}
	public void setAutreNatureRelation(String autreNatureRelation) {
		AutreNatureRelation = autreNatureRelation;
	}
	public String getSoldeOuverture() {
		return SoldeOuverture;
	}
	public void setSoldeOuverture(String soldeOuverture) {
		SoldeOuverture = soldeOuverture;
	}
	public String getDevise() {
		return Devise;
	}
	public void setDevise(String devise) {
		Devise = devise;
	}
	public String getMouvementsAugmentations() {
		return MouvementsAugmentations;
	}
	public void setMouvementsAugmentations(String mouvementsAugmentations) {
		MouvementsAugmentations = mouvementsAugmentations;
	}
	public String getMouvementsDiminutions() {
		return MouvementsDiminutions;
	}
	public void setMouvementsDiminutions(String mouvementsDiminutions) {
		MouvementsDiminutions = mouvementsDiminutions;
	}
	public String getSoldeCloture() {
		return SoldeCloture;
	}
	public void setSoldeCloture(String soldeCloture) {
		SoldeCloture = soldeCloture;
	}
	public String getPretsInterets() {
		return PretsInterets;
	}
	public void setPretsInterets(String pretsInterets) {
		PretsInterets = pretsInterets;
	}
	public String getTauxInterets() {
		return TauxInterets;
	}
	public void setTauxInterets(String tauxInterets) {
		TauxInterets = tauxInterets;
	}
	public InformationsPretsEmpruntsBD getInformationsPretsEmprunts() {
		return InformationsPretsEmprunts;
	}
	public void setInformationsPretsEmprunts(InformationsPretsEmpruntsBD informationsPretsEmprunts) {
		InformationsPretsEmprunts = informationsPretsEmprunts;
	}
	 

}
