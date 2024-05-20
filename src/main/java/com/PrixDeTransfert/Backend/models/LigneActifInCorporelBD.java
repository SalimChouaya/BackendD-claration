package com.PrixDeTransfert.Backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ligne_actif_incorporel")
public class LigneActifInCorporelBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String NatureActifIncorporel ;
    @Column
    private String AutreNatureActifIncorporel;

    
    @Column(name = "onreux_gratuit", length = 255)
    private String OnreuxGratuit;
    

    @Column
    private String identifiant;
    @Column
    private String MatriculeFiscal;

    @Column(name = "etat_territoire", length = 50)
    private String etatTerritoire;

    @Column(name = "raison_sociale", length = 255)
    private String raisonSociale;

    @Column
    private String qualite;
    @Column
    private String Autrequalité ;

    @Column
    private String natureRelation;
    @Column 
    private String AutreNatureRelation;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "informations_groupe_entreprises_id", referencedColumnName = "id")
    private InformationsGroupeEntreprisesBD InformationsGroupeEntreprises;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNatureActifIncorporel() {
		return NatureActifIncorporel;
	}
	public void setNatureActifIncorporel(String natureActifIncorporel) {
		NatureActifIncorporel = natureActifIncorporel;
	}
	public String getAutreNatureActifIncorporel() {
		return AutreNatureActifIncorporel;
	}
	public void setAutreNatureActifIncorporel(String autreNatureActifIncorporel) {
		AutreNatureActifIncorporel = autreNatureActifIncorporel;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getMatriculeFiscal() {
		return MatriculeFiscal;
	}
	public void setMatriculeFiscal(String matriculeFiscal) {
		MatriculeFiscal = matriculeFiscal;
	}
	public String getQualite() {
		return qualite;
	}
	public void setQualite(String qualite) {
		this.qualite = qualite;
	}
	public String getAutrequalité() {
		return Autrequalité;
	}
	public void setAutrequalité(String autrequalité) {
		Autrequalité = autrequalité;
	}
	public String getNatureRelation() {
		return natureRelation;
	}
	public void setNatureRelation(String natureRelation) {
		this.natureRelation = natureRelation;
	}
	public String getAutreNatureRelation() {
		return AutreNatureRelation;
	}
	public void setAutreNatureRelation(String autreNatureRelation) {
		AutreNatureRelation = autreNatureRelation;
	}
	public String getOnreuxGratuit() {
		return OnreuxGratuit;
	}
	public void setOnreuxGratuit(String onreuxGratuit) {
		OnreuxGratuit = onreuxGratuit;
	}
	
	
	public String getEtatTerritoire() {
		return etatTerritoire;
	}
	public void setEtatTerritoire(String etatTerritoire) {
		this.etatTerritoire = etatTerritoire;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	
	public InformationsGroupeEntreprisesBD getInformationsGroupeEntreprises() {
		return InformationsGroupeEntreprises;
	}
	public void setInformationsGroupeEntreprises(InformationsGroupeEntreprisesBD informationsGroupeEntreprises) {
		InformationsGroupeEntreprises = informationsGroupeEntreprises;
	}
    
    
    
    
    
    
    
    
}