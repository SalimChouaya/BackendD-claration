package com.PrixDeTransfert.Backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "informations_mere_entite_ultime")
public class InformationsMereEntiteUltimeBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String identifiant;
    @Column
    private String EtatTerritoire;
    @Column 
    private String MatriculeFiscal;
    

    public Long getId() {
		return id;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
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
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	public String getAdresseSiegeSocial() {
		return adresseSiegeSocial;
	}
	public void setAdresseSiegeSocial(String adresseSiegeSocial) {
		this.adresseSiegeSocial = adresseSiegeSocial;
	}
	public InformationsGroupeEntreprisesBD getInformationsGroupeEntreprises() {
		return InformationsGroupeEntreprises;
	}
	public void setInformationsGroupeEntreprises(InformationsGroupeEntreprisesBD informationsGroupeEntreprises) {
		InformationsGroupeEntreprises = informationsGroupeEntreprises;
	}
	@Column(name = "raison_sociale", length = 255)
    private String raisonSociale;

    @Column(name = "adresse_siege_social", length = 255)
    private String adresseSiegeSocial;
    @OneToOne
    @JoinColumn(name = "informations_groupe_entreprises_id", referencedColumnName = "id")
    private InformationsGroupeEntreprisesBD InformationsGroupeEntreprises;
}
