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
public class LigneOperationsAccordsPrealablesOuRescritsFiscauxBD {

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
	String AutreNatureOperation;
	@Column
	String NatureOperation ;
	@Column
	String ExerciceDebut;
	@Column
	String ExerciceFin;
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}







	public void setId(Long id) {
		this.id = id;
	}

















	public String getRaisonSociale() {
		return RaisonSociale;
	}







	public void setRaisonSociale(String raisonSociale) {
		RaisonSociale = raisonSociale;
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







	public String getAutreNatureOperation() {
		return AutreNatureOperation;
	}







	public void setAutreNatureOperation(String autreNatureOperation) {
		AutreNatureOperation = autreNatureOperation;
	}







	public String getNatureOperation() {
		return NatureOperation;
	}







	public void setNatureOperation(String natureOperation) {
		NatureOperation = natureOperation;
	}







	public String getExerciceDebut() {
		return ExerciceDebut;
	}







	public void setExerciceDebut(String exerciceDebut) {
		ExerciceDebut = exerciceDebut;
	}







	public String getExerciceFin() {
		return ExerciceFin;
	}







	public void setExerciceFin(String exerciceFin) {
		ExerciceFin = exerciceFin;
	}







	public InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD getInformationsOperationsAccordsPrealablesOuRescritsFiscaux() {
		return InformationsOperationsAccordsPrealablesOuRescritsFiscaux;
	}







	public void setInformationsOperationsAccordsPrealablesOuRescritsFiscaux(
			InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD informationsOperationsAccordsPrealablesOuRescritsFiscaux) {
		InformationsOperationsAccordsPrealablesOuRescritsFiscaux = informationsOperationsAccordsPrealablesOuRescritsFiscaux;
	}







	@ManyToOne
    @JsonBackReference
    @JoinColumn(name ="InformationsOperationsAccordsPrealablesOuRescritsFiscauxid", referencedColumnName = "id")
    private InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD InformationsOperationsAccordsPrealablesOuRescritsFiscaux;
}
