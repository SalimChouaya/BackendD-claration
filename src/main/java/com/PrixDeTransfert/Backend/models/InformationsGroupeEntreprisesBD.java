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
@Table(name = "informations_groupe_entreprises")
public class InformationsGroupeEntreprisesBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description_principales_activites", length = 255)
    private String descriptionPrincipalesActivites;

    @Column(name = "description_generale_politique_prix_transfert", length = 255)
    private String descriptionGeneralePolitiquePrixTransfert;

    @OneToOne(mappedBy = "InformationsGroupeEntreprises", cascade = CascadeType.ALL, orphanRemoval = true)
    private RestructurationsGroupeEntreprisesBD RestructurationsGroupeEntreprises;

    
    
    public RestructurationsGroupeEntreprisesBD getRestructurationsGroupeEntreprises() {
		return RestructurationsGroupeEntreprises;
	}
	public void setRestructurationsGroupeEntreprises(RestructurationsGroupeEntreprisesBD restructurationsGroupeEntreprises) {
		RestructurationsGroupeEntreprises = restructurationsGroupeEntreprises;
	}
	@OneToOne
    @JoinColumn(name = "declaration_prix_de_transfert_id", referencedColumnName = "id")
    private DéclarationPrixDeTransfert DéclarationPrixDeTransfert;
    @OneToOne(mappedBy = "InformationsGroupeEntreprises" ,cascade = CascadeType.ALL, orphanRemoval = true)
    private InformationsMereEntiteUltimeBD InformationsMereEntiteUltime;
   
    
    public List<LigneActifCorporelBD> getLigneActifCorporel() {
		return LigneActifCorporel;
	}
	public void setLigneActifCorporel(List<LigneActifCorporelBD> ligneActifCorporel) {
		LigneActifCorporel = ligneActifCorporel;
	}
	public List<LigneActifInCorporelBD> getLigneActifInCorporel() {
		return LigneActifInCorporel;
	}
	public void setLigneActifInCorporel(List<LigneActifInCorporelBD> ligneActifInCorporel) {
		LigneActifInCorporel = ligneActifInCorporel;
	}
	@OneToMany(mappedBy ="InformationsGroupeEntreprises", cascade = CascadeType.ALL ,orphanRemoval = true)
	 @JsonManagedReference
	    private List<LigneActifCorporelBD> LigneActifCorporel;
    @OneToMany(mappedBy ="InformationsGroupeEntreprises", cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference
	    private List<LigneActifInCorporelBD> LigneActifInCorporel;
   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescriptionPrincipalesActivites() {
		return descriptionPrincipalesActivites;
	}
	public void setDescriptionPrincipalesActivites(String descriptionPrincipalesActivites) {
		this.descriptionPrincipalesActivites = descriptionPrincipalesActivites;
	}
	public String getDescriptionGeneralePolitiquePrixTransfert() {
		return descriptionGeneralePolitiquePrixTransfert;
	}
	public void setDescriptionGeneralePolitiquePrixTransfert(String descriptionGeneralePolitiquePrixTransfert) {
		this.descriptionGeneralePolitiquePrixTransfert = descriptionGeneralePolitiquePrixTransfert;
	}
	
	public DéclarationPrixDeTransfert getDéclarationPrixDeTransfert() {
		return DéclarationPrixDeTransfert;
	}
	public void setDéclarationPrixDeTransfert(DéclarationPrixDeTransfert déclarationPrixDeTransfert) {
		DéclarationPrixDeTransfert = déclarationPrixDeTransfert;
	}
	public InformationsMereEntiteUltimeBD getInformationsMereEntiteUltime() {
		return InformationsMereEntiteUltime;
	}
	public void setInformationsMereEntiteUltime(InformationsMereEntiteUltimeBD informationsMereEntiteUltime) {
		InformationsMereEntiteUltime = informationsMereEntiteUltime;
	}
	

}



