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
public class LigneBiensOuServicesSansContrePartieBD {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	String Identifiant ;
	@Column
	String EtatTerritoire;
	@Column
	String MatriculeFiscal;
	@Column
	String RaisonSociale ;
	@Column
	String Qualite;
	@Column
	String AutreQualité;
	
	@Column
	String NatureRelation ;
	@Column
	String AutreNatureRelation;
	@Column
	String NatureBiensOuService ;
	@Column
	String NatureContrepartie ;
	 @ManyToOne
	    @JsonBackReference
	    @JoinColumn(name ="InformationsSurBiensOuServicesSansContrePartieid", referencedColumnName = "id")
	    private InformationsSurBiensOuServicesSansContrePartieBD InformationsSurBiensOuServicesSansContrePartie;
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
	public String getEtatTerritoire() {
		return EtatTerritoire;
	}
	public void setEtatTerritoire(String etatTerritoire) {
		EtatTerritoire = etatTerritoire;
	}
	public String getMatriculeFiscal() {
		return MatriculeFiscal;
	}
	public void setMatriculeFiscal(String matriculeFiscal) {
		MatriculeFiscal = matriculeFiscal;
	}
	public String getQualite() {
		return Qualite;
	}
	public void setQualite(String qualite) {
		Qualite = qualite;
	}
	public String getAutreQualité() {
		return AutreQualité;
	}
	public void setAutreQualité(String autreQualité) {
		AutreQualité = autreQualité;
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
	public String getRaisonSociale() {
		return RaisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		RaisonSociale = raisonSociale;
	}
	
	public String getNatureBiensOuService() {
		return NatureBiensOuService;
	}
	public void setNatureBiensOuService(String natureBiensOuService) {
		NatureBiensOuService = natureBiensOuService;
	}
	public String getNatureContrepartie() {
		return NatureContrepartie;
	}
	public void setNatureContrepartie(String natureContrepartie) {
		NatureContrepartie = natureContrepartie;
	}
	public InformationsSurBiensOuServicesSansContrePartieBD getInformationsSurBiensOuServicesSansContrePartie() {
		return InformationsSurBiensOuServicesSansContrePartie;
	}
	public void setInformationsSurBiensOuServicesSansContrePartie(
			InformationsSurBiensOuServicesSansContrePartieBD informationsSurBiensOuServicesSansContrePartie) {
		InformationsSurBiensOuServicesSansContrePartie = informationsSurBiensOuServicesSansContrePartie;
	}
	 
}
