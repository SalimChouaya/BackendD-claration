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
@Table(name="Ligne_Participation_Liee")
public class LigneParticipationLieeBD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String Identifiant;
    @Column
    private String MatriculeFiscal;
    @Column
    private String Qualité;
    public String getQualité() {
		return Qualité;
	}

	public void setQualité(String qualité) {
		Qualité = qualité;
	}

	public String getAutreQualité() {
		return AutreQualité;
	}

	public void setAutreQualité(String autreQualité) {
		AutreQualité = autreQualité;
	}

	@Column
    private String AutreQualité ;
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getEtatTerritoire() {
		return EtatTerritoire;
	}

	public void setEtatTerritoire(String etatTerritoire) {
		EtatTerritoire = etatTerritoire;
	}

	public String getRaisonSociale() {
		return RaisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		RaisonSociale = raisonSociale;
	}

	

	public String getPourcentageDetentionCapital() {
		return PourcentageDetentionCapital;
	}

	public void setPourcentageDetentionCapital(String pourcentageDetentionCapital) {
		PourcentageDetentionCapital = pourcentageDetentionCapital;
	}

	public String getPourcentageDetentionDroitsVote() {
		return PourcentageDetentionDroitsVote;
	}

	public void setPourcentageDetentionDroitsVote(String pourcentageDetentionDroitsVote) {
		PourcentageDetentionDroitsVote = pourcentageDetentionDroitsVote;
	}

	public InformationsEntrepriseDeclaranteBD getInformationsEntrepriseDeclarante() {
		return InformationsEntrepriseDeclarante;
	}

	public void setInformationsEntrepriseDeclarante(InformationsEntrepriseDeclaranteBD informationsEntrepriseDeclarante) {
		InformationsEntrepriseDeclarante = informationsEntrepriseDeclarante;
	}

	@Column(name ="etat_territoire")
    private String EtatTerritoire;

    @Column(name ="raison_sociale")
    private String RaisonSociale;

   

    @Column(name ="pourcentage_detention_capital")
    private String PourcentageDetentionCapital;

    @Column(name ="pourcentage_detention_droits_vote")
    private String PourcentageDetentionDroitsVote;
    
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

	@ManyToOne
    @JsonBackReference
    @JoinColumn(name ="informations_entreprise_declarante_id", referencedColumnName = "id")
    private InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclarante;

}