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
@Table(name="informations_entreprise_declarante")

public class InformationsEntrepriseDeclaranteBD {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	private String AutreQualité;
	
	 @Column(name="description_activites_principales", length = 255)
	private String DescriptionActivitesPrincipales;
	
	 
	 
	 @OneToMany(mappedBy ="InformationsEntrepriseDeclarante",cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference
	    private List<Qualité> Qualité;
	 
	 @OneToOne
	    @JoinColumn(name ="declaration_prix_de_transfert_id", referencedColumnName = "id")
	    private DéclarationPrixDeTransfert DéclarationPrixDeTransfert;
	 
	 @OneToOne(mappedBy = "InformationsEntrepriseDeclarante",cascade = CascadeType.ALL, orphanRemoval = true)
	    private ModificationLiensCapitalAuCoursExerciceBD ModificationLiensCapitalAuCoursExercice;
	 @OneToOne(mappedBy = "InformationsEntrepriseDeclarante",cascade = CascadeType.ALL, orphanRemoval = true)
	    private ChangementsActiviteAucoursExerciceBD ChangementsActiviteAucoursExercice;
	 
	 @OneToMany(mappedBy ="InformationsEntrepriseDeclarante",cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference
	    private List<LigneParticipationLieeBD> ligneParticipationLiee;

	    @OneToMany(mappedBy ="InformationsEntrepriseDeclarante",cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<LigneParticipationDeclaranteBD> ligneParticipationDeclarante;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getAutreQualité() {
			return AutreQualité;
		}

		public void setAutreQualité(String autreQualité) {
			AutreQualité = autreQualité;
		}

		public String getDescriptionActivitesPrincipales() {
			return DescriptionActivitesPrincipales;
		}

		public void setDescriptionActivitesPrincipales(String descriptionActivitesPrincipales) {
			DescriptionActivitesPrincipales = descriptionActivitesPrincipales;
		}

		

		

		public List<Qualité> getQualité() {
			return Qualité;
		}

		public void setQualité(List<Qualité> qualité) {
			Qualité = qualité;
		}

		public DéclarationPrixDeTransfert getDéclarationPrixDeTransfert() {
			return DéclarationPrixDeTransfert;
		}

		public void setDéclarationPrixDeTransfert(DéclarationPrixDeTransfert déclarationPrixDeTransfert) {
			DéclarationPrixDeTransfert = déclarationPrixDeTransfert;
		}

		public ModificationLiensCapitalAuCoursExerciceBD getModificationLiensCapitalAuCoursExercice() {
			return ModificationLiensCapitalAuCoursExercice;
		}

		public void setModificationLiensCapitalAuCoursExercice(
				ModificationLiensCapitalAuCoursExerciceBD modificationLiensCapitalAuCoursExercice) {
			ModificationLiensCapitalAuCoursExercice = modificationLiensCapitalAuCoursExercice;
		}

		public List<LigneParticipationLieeBD> getLigneParticipationLiee() {
			return ligneParticipationLiee;
		}

		public void setLigneParticipationLiee(List<LigneParticipationLieeBD> ligneParticipationLiee) {
			this.ligneParticipationLiee = ligneParticipationLiee;
		}

		public List<LigneParticipationDeclaranteBD> getLigneParticipationDeclarante() {
			return ligneParticipationDeclarante;
		}

		public void setLigneParticipationDeclarante(List<LigneParticipationDeclaranteBD> ligneParticipationDeclarante) {
			this.ligneParticipationDeclarante = ligneParticipationDeclarante;
		}

		public ChangementsActiviteAucoursExerciceBD getChangementsActiviteAucoursExercice() {
			return ChangementsActiviteAucoursExercice;
		}

		public void setChangementsActiviteAucoursExercice(
				ChangementsActiviteAucoursExerciceBD changementsActiviteAucoursExercice) {
			ChangementsActiviteAucoursExercice = changementsActiviteAucoursExercice;
		}

	 
		
}
