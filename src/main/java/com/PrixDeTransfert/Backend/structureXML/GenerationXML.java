package com.PrixDeTransfert.Backend.structureXML;





import java.util.List;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class GenerationXML {
	
    @JacksonXmlRootElement(localName = "PrixTransfert")
    public static class PrixTransfert {
        @JacksonXmlProperty(isAttribute = true, localName = "VersionDocument")
        private String versionDocument = "1.0";

        @JacksonXmlProperty(isAttribute = true, localName = "noNamespaceSchemaLocation", namespace = "http://www.w3.org/2001/XMLSchema-instance")
        private String schemaLocation = "classpath:/static/FDPT.xsd";
        
        private Entete entete;
        private IdentificationEntrepriseDeclarante identificationEntrepriseDeclarante;
        private InformationsEntrepriseDeclarante informationsEntrepriseDeclarante;
        private InformationsGroupeEntreprises informationsGroupeEntreprises;
        private InformationsOperations InformationsOperations;
        private String AutresInformationsARenseignerSurDeclarationPrixTransfert;
        
        


		public String getAutresInformationsARenseignerSurDeclarationPrixTransfert() {
			return AutresInformationsARenseignerSurDeclarationPrixTransfert;
		}
		public void setAutresInformationsARenseignerSurDeclarationPrixTransfert(
				String autresInformationsARenseignerSurDeclarationPrixTransfert) {
			AutresInformationsARenseignerSurDeclarationPrixTransfert = autresInformationsARenseignerSurDeclarationPrixTransfert;
		}
		public InformationsGroupeEntreprises getInformationsGroupeEntreprises() {
			return informationsGroupeEntreprises;
		}
		public void setInformationsGroupeEntreprises(InformationsGroupeEntreprises informationsGroupeEntreprises) {
			this.informationsGroupeEntreprises = informationsGroupeEntreprises;
		}
		public InformationsOperations getInformationsOperations() {
			return InformationsOperations;
		}
		public void setInformationsOperations(InformationsOperations informationsOperations) {
			InformationsOperations = informationsOperations;
		}
		public String getVersionDocument() {
			return versionDocument;
		}
		public void setVersionDocument(String versionDocument) {
			this.versionDocument = versionDocument;
		}
		public String getSchemaLocation() {
			return schemaLocation;
		}
		public void setSchemaLocation(String schemaLocation) {
			this.schemaLocation = schemaLocation;
		}
		public Entete getEntete() {
			return entete;
		}
		public void setEntete(Entete entete) {
			this.entete = entete;
		}
		public IdentificationEntrepriseDeclarante getIdentificationEntrepriseDeclarante() {
			return identificationEntrepriseDeclarante;
		}
		public void setIdentificationEntrepriseDeclarante(
				IdentificationEntrepriseDeclarante identificationEntrepriseDeclarante) {
			this.identificationEntrepriseDeclarante = identificationEntrepriseDeclarante;
		}
		public InformationsEntrepriseDeclarante getInformationsEntrepriseDeclarante() {
			return informationsEntrepriseDeclarante;
		}
		public void setInformationsEntrepriseDeclarante(InformationsEntrepriseDeclarante informationsEntrepriseDeclarante) {
			this.informationsEntrepriseDeclarante = informationsEntrepriseDeclarante;
		}

      
    }

    public static class Entete {
        private String codeActe;
        private String exercice;
        private String matriculeFiscalDeclarant;
        private String codeTVA;
        private String codeCategorie;
        private String typeDeclaration;
        private String dateDebutExercice;
        private DateFinExercice dateFinExercice;
		public String getCodeActe() {
			return codeActe;
		}
		public void setCodeActe(String codeActe) {
			this.codeActe = codeActe;
		}
		public String getExercice() {
			return exercice;
		}
		public void setExercice(String exercice) {
			this.exercice = exercice;
		}
		public String getMatriculeFiscalDeclarant() {
			return matriculeFiscalDeclarant;
		}
		public void setMatriculeFiscalDeclarant(String matriculeFiscalDeclarant) {
			this.matriculeFiscalDeclarant = matriculeFiscalDeclarant;
		}
		public String getCodeTVA() {
			return codeTVA;
		}
		public void setCodeTVA(String codeTVA) {
			this.codeTVA = codeTVA;
		}
		public String getCodeCategorie() {
			return codeCategorie;
		}
		public void setCodeCategorie(String codeCategorie) {
			this.codeCategorie = codeCategorie;
		}
		public String getTypeDeclaration() {
			return typeDeclaration;
		}
		public void setTypeDeclaration(String typeDeclaration) {
			this.typeDeclaration = typeDeclaration;
		}
		public String getDateDebutExercice() {
			return dateDebutExercice;
		}
		public void setDateDebutExercice(String dateDebutExercice) {
			this.dateDebutExercice = dateDebutExercice;
		}
		public DateFinExercice getDateFinExercice() {
			return dateFinExercice;
		}
		public void setDateFinExercice(DateFinExercice dateFinExercice) {
			this.dateFinExercice = dateFinExercice;
		}
		
        
    }

    public static class DateFinExercice {
        @JacksonXmlProperty(isAttribute = true, localName = "NatureDateFin")
        private int natureDateFin;
        private String value;
		public int getNatureDateFin() {
			return natureDateFin;
		}
		public void setNatureDateFin(int natureDateFin) {
			this.natureDateFin = natureDateFin;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}

        
    }

    public static class IdentificationEntrepriseDeclarante {
        private String raisonSociale;
        private String formeJuridique;
        private String nationalite;
        private String adresseSiegeSocialEtablissementTunisie;
        private String codePostal;
        private String activitePrincipale;
        private String activiteSecondaire;
        private String chiffreAffaireAnnuel;
		public String getRaisonSociale() {
			return raisonSociale;
		}
		public void setRaisonSociale(String raisonSociale) {
			this.raisonSociale = raisonSociale;
		}
		public String getFormeJuridique() {
			return formeJuridique;
		}
		public void setFormeJuridique(String formeJuridique) {
			this.formeJuridique = formeJuridique;
		}
		public String getNationalite() {
			return nationalite;
		}
		public void setNationalite(String nationalite) {
			this.nationalite = nationalite;
		}
		public String getAdresseSiegeSocialEtablissementTunisie() {
			return adresseSiegeSocialEtablissementTunisie;
		}
		public void setAdresseSiegeSocialEtablissementTunisie(String adresseSiegeSocialEtablissementTunisie) {
			this.adresseSiegeSocialEtablissementTunisie = adresseSiegeSocialEtablissementTunisie;
		}
		public String getCodePostal() {
			return codePostal;
		}
		public void setCodePostal(String codePostal) {
			this.codePostal = codePostal;
		}
		public String getActivitePrincipale() {
			return activitePrincipale;
		}
		public void setActivitePrincipale(String activitePrincipale) {
			this.activitePrincipale = activitePrincipale;
		}
		public String getActiviteSecondaire() {
			return activiteSecondaire;
		}
		public void setActiviteSecondaire(String activiteSecondaire) {
			this.activiteSecondaire = activiteSecondaire;
		}
		public String getChiffreAffaireAnnuel() {
			return chiffreAffaireAnnuel;
		}
		public void setChiffreAffaireAnnuel(String string) {
			this.chiffreAffaireAnnuel = string;
		}

        
    }

    public static class InformationsEntrepriseDeclarante {
        private QualiteEntrepriseDeclarante qualiteEntrepriseDeclarante;
        private String descriptionActivitesPrincipales;
        private ChangementsActiviteAuCoursExercice changementsActiviteAuCoursExercice;
        private LiensCapital liensCapital;
		public QualiteEntrepriseDeclarante getQualiteEntrepriseDeclarante() {
			return qualiteEntrepriseDeclarante;
		}
		public void setQualiteEntrepriseDeclarante(QualiteEntrepriseDeclarante qualiteEntrepriseDeclarante) {
			this.qualiteEntrepriseDeclarante = qualiteEntrepriseDeclarante;
		}
		public String getDescriptionActivitesPrincipales() {
			return descriptionActivitesPrincipales;
		}
		public void setDescriptionActivitesPrincipales(String descriptionActivitesPrincipales) {
			this.descriptionActivitesPrincipales = descriptionActivitesPrincipales;
		}
		public ChangementsActiviteAuCoursExercice getChangementsActiviteAuCoursExercice() {
			return changementsActiviteAuCoursExercice;
		}
		public void setChangementsActiviteAuCoursExercice(
				ChangementsActiviteAuCoursExercice changementsActiviteAuCoursExercice) {
			this.changementsActiviteAuCoursExercice = changementsActiviteAuCoursExercice;
		}
		public LiensCapital getLiensCapital() {
			return liensCapital;
		}
		public void setLiensCapital(LiensCapital liensCapital) {
			this.liensCapital = liensCapital;
		}

      
    }

    public static class QualiteEntrepriseDeclarante {
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "Qualite")
        private List<Integer> qualites;
        private String AutreQualite;

		public List<Integer> getQualites() {
			return qualites;
		}

		public void setQualites(List<Integer> qualites) {
			this.qualites = qualites;
		}

		public String getAutreQualite() {
			return AutreQualite;
		}

		public void setAutreQualite(String autreQualite) {
			AutreQualite = autreQualite;
		}

       
    }

    public static class ChangementsActiviteAuCoursExercice {
        private String affirmation;
        private String description;
		public String getAffirmation() {
			return affirmation;
		}
		public void setAffirmation(String string) {
			this.affirmation = string;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

        
    }

    public static class LiensCapital {
    	@JacksonXmlElementWrapper(localName = "ParticipationLiee")
        @JacksonXmlProperty(localName = "LigneParticipationLiee")
        private List<LigneParticipationLiee> participationLiee;
    	@JacksonXmlElementWrapper(localName = "ParticipationsDeclarante")
        @JacksonXmlProperty(localName = "LigneParticipationDeclarante")
        private List<LigneParticipationDeclarante> participationDeclarante;
        private ModificationLiensCapitalAuCoursExercice modificationLiensCapitalAuCoursExercice;
        
		public List<LigneParticipationLiee> getParticipationLiee() {
			return participationLiee;
		}
		public void setParticipationLiee(List<LigneParticipationLiee> participationLiee) {
			this.participationLiee = participationLiee;
		}
		public List<LigneParticipationDeclarante> getParticipationDeclarante() {
			return participationDeclarante;
		}
		public void setParticipationDeclarante(List<LigneParticipationDeclarante> participationDeclarante) {
			this.participationDeclarante = participationDeclarante;
		}
		public ModificationLiensCapitalAuCoursExercice getModificationLiensCapitalAuCoursExercice() {
			return modificationLiensCapitalAuCoursExercice;
		}
		public void setModificationLiensCapitalAuCoursExercice(
				ModificationLiensCapitalAuCoursExercice modificationLiensCapitalAuCoursExercice) {
			this.modificationLiensCapitalAuCoursExercice = modificationLiensCapitalAuCoursExercice;
		}
		
        
    }
    
    public static class LigneParticipationLiee {
        private IdentifiantEntreprise identifiantEntreprise;
        private String raisonSociale;
        private QualiteEntreprise qualiteEntreprise;
        private String pourcentageDetentionCapital;
        private String pourcentageDetentionDroitsVote;
		public IdentifiantEntreprise getIdentifiantEntreprise() {
			return identifiantEntreprise;
		}
		public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
			this.identifiantEntreprise = identifiantEntreprise;
		}
		public String getRaisonSociale() {
			return raisonSociale;
		}
		public void setRaisonSociale(String raisonSociale) {
			this.raisonSociale = raisonSociale;
		}
		public QualiteEntreprise getQualiteEntreprise() {
			return qualiteEntreprise;
		}
		public void setQualiteEntreprise(QualiteEntreprise qualiteEntreprise) {
			this.qualiteEntreprise = qualiteEntreprise;
		}
		public String getPourcentageDetentionCapital() {
			return pourcentageDetentionCapital;
		}
		public void setPourcentageDetentionCapital(String pourcentageDetentionCapital) {
			this.pourcentageDetentionCapital = pourcentageDetentionCapital;
		}
		public String getPourcentageDetentionDroitsVote() {
			return pourcentageDetentionDroitsVote;
		}
		public void setPourcentageDetentionDroitsVote(String pourcentageDetentionDroitsVote) {
			this.pourcentageDetentionDroitsVote = pourcentageDetentionDroitsVote;
		}

        
    }
    
    public static class LigneParticipationDeclarante {
        private IdentifiantEntreprise identifiantEntreprise;
        private String raisonSociale;
        private QualiteEntreprise qualiteEntreprise;
        private String pourcentageDetentionCapital;
        private String pourcentageDetentionDroitsVote;
		public IdentifiantEntreprise getIdentifiantEntreprise() {
			return identifiantEntreprise;
		}
		public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
			this.identifiantEntreprise = identifiantEntreprise;
		}
		public String getRaisonSociale() {
			return raisonSociale;
		}
		public void setRaisonSociale(String raisonSociale) {
			this.raisonSociale = raisonSociale;
		}
		public QualiteEntreprise getQualiteEntreprise() {
			return qualiteEntreprise;
		}
		public void setQualiteEntreprise(QualiteEntreprise qualiteEntreprise) {
			this.qualiteEntreprise = qualiteEntreprise;
		}
		public String getPourcentageDetentionCapital() {
			return pourcentageDetentionCapital;
		}
		public void setPourcentageDetentionCapital(String pourcentageDetentionCapital) {
			this.pourcentageDetentionCapital = pourcentageDetentionCapital;
		}
		public String getPourcentageDetentionDroitsVote() {
			return pourcentageDetentionDroitsVote;
		}
		public void setPourcentageDetentionDroitsVote(String pourcentageDetentionDroitsVote) {
			this.pourcentageDetentionDroitsVote = pourcentageDetentionDroitsVote;
		}

        
    }
    public static class IdentifiantEntreprise {
        private String matriculeFiscal;
        private AutreIdentifiant AutreIdentifiant;

		public AutreIdentifiant getAutreIdentifiant() {
			return AutreIdentifiant;
		}

		public void setAutreIdentifiant(AutreIdentifiant autreIdentifiant) {
			AutreIdentifiant = autreIdentifiant;
		}

		public String getMatriculeFiscal() {
			return matriculeFiscal;
		}

		public void setMatriculeFiscal(String matriculeFiscal) {
			this.matriculeFiscal = matriculeFiscal;
		}

        
    }
    public static class AutreIdentifiant{
    	private String identifiant;
    	private String EtatTerritoire;
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
    	
    }

    public static class QualiteEntreprise {
        @JacksonXmlProperty(localName = "Qualite")
        private Integer qualite;
        @JacksonXmlProperty(localName = "AutreQualite")
        private String autreQualité;

		public Integer getQualite() {
			return qualite;
		}

		public void setQualite(Integer qualite) {
			this.qualite = qualite;
		}

		public String getAutreQualité() {
			return autreQualité;
		}

		public void setAutreQualité(String autreQualité) {
			this.autreQualité = autreQualité;
		}

        
    }

    public static class ModificationLiensCapitalAuCoursExercice {
        private char affirmation;
        private String description;
		public char getAffirmation() {
			return affirmation;
		}
		public void setAffirmation(char affirmation) {
			this.affirmation = affirmation;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

        
    }
    public static class InformationsGroupeEntreprises {
        private InformationsEntiteMereUltime informationsEntiteMereUltime;
        private String descriptionPrincipalesActivites;
        private String descriptionGeneralePolitiquePrixTransfert;
        @JacksonXmlElementWrapper(localName = "ListeActifsIncorporels")
        @JacksonXmlProperty(localName = "LigneActifIncorporel")
        private List<LigneActifIncorporel> listeActifsIncorporels;
        @JacksonXmlElementWrapper(localName = "ListeActifsCorporels")
        @JacksonXmlProperty(localName = "LigneActifCorporel")
        private List<LigneActifCorporel> listeActifsCorporels;
        private RestructurationsGroupeEntreprises restructurationsGroupeEntreprises;
		public InformationsEntiteMereUltime getInformationsEntiteMereUltime() {
			return informationsEntiteMereUltime;
		}
		public void setInformationsEntiteMereUltime(InformationsEntiteMereUltime informationsEntiteMereUltime) {
			this.informationsEntiteMereUltime = informationsEntiteMereUltime;
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
		public List<LigneActifIncorporel> getListeActifsIncorporels() {
			return listeActifsIncorporels;
		}
		public void setListeActifsIncorporels(List<LigneActifIncorporel> listeActifsIncorporels) {
			this.listeActifsIncorporels = listeActifsIncorporels;
		}
		public List<LigneActifCorporel> getListeActifsCorporels() {
			return listeActifsCorporels;
		}
		public void setListeActifsCorporels(List<LigneActifCorporel> listeActifsCorporels) {
			this.listeActifsCorporels = listeActifsCorporels;
		}
		public RestructurationsGroupeEntreprises getRestructurationsGroupeEntreprises() {
			return restructurationsGroupeEntreprises;
		}
		public void setRestructurationsGroupeEntreprises(RestructurationsGroupeEntreprises restructurationsGroupeEntreprises) {
			this.restructurationsGroupeEntreprises = restructurationsGroupeEntreprises;
		}
    
        
    }

    public static class InformationsEntiteMereUltime {
        private IdentifiantEntreprise identifiantEntreprise;
        private String raisonSociale;
        private String adresseSiegeSocial;
		public IdentifiantEntreprise getIdentifiantEntreprise() {
			return identifiantEntreprise;
		}
		public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
			this.identifiantEntreprise = identifiantEntreprise;
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

        
    }

   

    public static class LigneActifIncorporel {
        private ActifIncorporel actifIncorporel;
        private String onereuxGratuit;
        private IdentifiantEntreprise identifiantEntreprise;
        private String raisonSociale;
        private QualiteEntreprise qualiteEntreprise;
        private NatureRelationEntreprise natureRelationEntreprise;
		public ActifIncorporel getActifIncorporel() {
			return actifIncorporel;
		}
		public void setActifIncorporel(ActifIncorporel actifIncorporel) {
			this.actifIncorporel = actifIncorporel;
		}
		public String getOnereuxGratuit() {
			return onereuxGratuit;
		}
		public void setOnereuxGratuit(String onereuxGratuit) {
			this.onereuxGratuit = onereuxGratuit;
		}
		public IdentifiantEntreprise getIdentifiantEntreprise() {
			return identifiantEntreprise;
		}
		public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
			this.identifiantEntreprise = identifiantEntreprise;
		}
		public String getRaisonSociale() {
			return raisonSociale;
		}
		public void setRaisonSociale(String raisonSociale) {
			this.raisonSociale = raisonSociale;
		}
		public QualiteEntreprise getQualiteEntreprise() {
			return qualiteEntreprise;
		}
		public void setQualiteEntreprise(QualiteEntreprise qualiteEntreprise) {
			this.qualiteEntreprise = qualiteEntreprise;
		}
		public NatureRelationEntreprise getNatureRelationEntreprise() {
			return natureRelationEntreprise;
		}
		public void setNatureRelationEntreprise(NatureRelationEntreprise natureRelationEntreprise) {
			this.natureRelationEntreprise = natureRelationEntreprise;
		}

        // Getters and Setters
    }
    public static class ActifIncorporel {
    	private String NatureActifIncorporel ;
    	private String AutreNatureActifIncorporel;
    	
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

    }
   public static class NatureRelationEntreprise{
	   private String NatureRelation ;
	  private String AutreNatureRelation ;
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
	  
   }
    public static class LigneActifCorporel {
    	private Actifcorporel actifcorporel;
        
        private IdentifiantEntreprise identifiantEntreprise;
        private String raisonSociale;
        private QualiteEntreprise qualiteEntreprise;
        private NatureRelationEntreprise natureRelationEntreprise;
		public Actifcorporel getActifcorporel() {
			return actifcorporel;
		}
		public void setActifcorporel(Actifcorporel actifcorporel) {
			this.actifcorporel = actifcorporel;
		}
		public IdentifiantEntreprise getIdentifiantEntreprise() {
			return identifiantEntreprise;
		}
		public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
			this.identifiantEntreprise = identifiantEntreprise;
		}
		public String getRaisonSociale() {
			return raisonSociale;
		}
		public void setRaisonSociale(String raisonSociale) {
			this.raisonSociale = raisonSociale;
		}
		public QualiteEntreprise getQualiteEntreprise() {
			return qualiteEntreprise;
		}
		public void setQualiteEntreprise(QualiteEntreprise qualiteEntreprise) {
			this.qualiteEntreprise = qualiteEntreprise;
		}
		public NatureRelationEntreprise getNatureRelationEntreprise() {
			return natureRelationEntreprise;
		}
		public void setNatureRelationEntreprise(NatureRelationEntreprise natureRelationEntreprise) {
			this.natureRelationEntreprise = natureRelationEntreprise;
		}
        
    }

    public static class Actifcorporel{
    	private String NatureActifcorporel ;
    	private String AutreNatureActifcorporel;
		public String getNatureActifcorporel() {
			return NatureActifcorporel;
		}
		public void setNatureActifcorporel(String natureActifcorporel) {
			NatureActifcorporel = natureActifcorporel;
		}
		public String getAutreNatureActifcorporel() {
			return AutreNatureActifcorporel;
		}
		public void setAutreNatureActifcorporel(String autreNatureActifcorporel) {
			AutreNatureActifcorporel = autreNatureActifcorporel;
		}
    	
    }
    public static class RestructurationsGroupeEntreprises {
        private String affirmation;
        private String description;
		public String getAffirmation() {
			return affirmation;
		}
		public void setAffirmation(String affirmation) {
			this.affirmation = affirmation;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

        
    }
    
    public static class InformationsOperations{
    	private MontantTransactionsMethodeDeterminationPrixTransfert MontantTransactionsMethodeDeterminationPrixTransfert ;
    	private InformationsPretsEmprunts InformationsPretsEmprunts ;
    	private OperationsSansContrepartieOuAvecContrepartieNonMonetaire OperationsSansContrepartieOuAvecContrepartieNonMonetaire;
        private InformationsOperationsAccordsPrealablesOuRescritsFiscaux InformationsOperationsAccordsPrealablesOuRescritsFiscaux;
		public MontantTransactionsMethodeDeterminationPrixTransfert getMontantTransactionsMethodeDeterminationPrixTransfert() {
			return MontantTransactionsMethodeDeterminationPrixTransfert;
		}

		public void setMontantTransactionsMethodeDeterminationPrixTransfert(
				MontantTransactionsMethodeDeterminationPrixTransfert montantTransactionsMethodeDeterminationPrixTransfert) {
			MontantTransactionsMethodeDeterminationPrixTransfert = montantTransactionsMethodeDeterminationPrixTransfert;
		}

		public InformationsPretsEmprunts getInformationsPretsEmprunts() {
			return InformationsPretsEmprunts;
		}

		public void setInformationsPretsEmprunts(InformationsPretsEmprunts informationsPretsEmprunts) {
			InformationsPretsEmprunts = informationsPretsEmprunts;
		}

		public OperationsSansContrepartieOuAvecContrepartieNonMonetaire getOperationsSansContrepartieOuAvecContrepartieNonMonetaire() {
			return OperationsSansContrepartieOuAvecContrepartieNonMonetaire;
		}

		public void setOperationsSansContrepartieOuAvecContrepartieNonMonetaire(
				OperationsSansContrepartieOuAvecContrepartieNonMonetaire operationsSansContrepartieOuAvecContrepartieNonMonetaire) {
			OperationsSansContrepartieOuAvecContrepartieNonMonetaire = operationsSansContrepartieOuAvecContrepartieNonMonetaire;
		}

		public InformationsOperationsAccordsPrealablesOuRescritsFiscaux getInformationsOperationsAccordsPrealablesOuRescritsFiscaux() {
			return InformationsOperationsAccordsPrealablesOuRescritsFiscaux;
		}

		public void setInformationsOperationsAccordsPrealablesOuRescritsFiscaux(
				InformationsOperationsAccordsPrealablesOuRescritsFiscaux informationsOperationsAccordsPrealablesOuRescritsFiscaux) {
			InformationsOperationsAccordsPrealablesOuRescritsFiscaux = informationsOperationsAccordsPrealablesOuRescritsFiscaux;
		}
    	
    }
    
    
    public static class MontantTransactionsMethodeDeterminationPrixTransfert{
    	
    	private InformationsValeursExploitation InformationsValeursExploitation ;
    	private InformationsRemunerationsBiensCorporelsIncorporels InformationsRemunerationsBiensCorporelsIncorporels ;
    	private InformationsServices InformationsServices ;
    	private InformationsOperationsFinancieres InformationsOperationsFinancieres ;
    	private InformationsCessionsAcquisitionsActifs  InformationsCessionsAcquisitionsActifs ;
    	private InformationsAutresOperations InformationsAutresOperations ;
    	private String DescriptionTransactionsRegimeFiscalPrivilegie;
		public InformationsValeursExploitation getInformationsValeursExploitation() {
			return InformationsValeursExploitation;
		}
		public void setInformationsValeursExploitation(InformationsValeursExploitation informationsValeursExploitation) {
			InformationsValeursExploitation = informationsValeursExploitation;
		}
		public InformationsRemunerationsBiensCorporelsIncorporels getInformationsRemunerationsBiensCorporelsIncorporels() {
			return InformationsRemunerationsBiensCorporelsIncorporels;
		}
		public void setInformationsRemunerationsBiensCorporelsIncorporels(
				InformationsRemunerationsBiensCorporelsIncorporels informationsRemunerationsBiensCorporelsIncorporels) {
			InformationsRemunerationsBiensCorporelsIncorporels = informationsRemunerationsBiensCorporelsIncorporels;
		}
		public InformationsServices getInformationsServices() {
			return InformationsServices;
		}
		public void setInformationsServices(InformationsServices informationsServices) {
			InformationsServices = informationsServices;
		}
		public InformationsOperationsFinancieres getInformationsOperationsFinancieres() {
			return InformationsOperationsFinancieres;
		}
		public void setInformationsOperationsFinancieres(InformationsOperationsFinancieres informationsOperationsFinancieres) {
			InformationsOperationsFinancieres = informationsOperationsFinancieres;
		}
		public InformationsCessionsAcquisitionsActifs getInformationsCessionsAcquisitionsActifs() {
			return InformationsCessionsAcquisitionsActifs;
		}
		public void setInformationsCessionsAcquisitionsActifs(
				InformationsCessionsAcquisitionsActifs informationsCessionsAcquisitionsActifs) {
			InformationsCessionsAcquisitionsActifs = informationsCessionsAcquisitionsActifs;
		}
		public InformationsAutresOperations getInformationsAutresOperations() {
			return InformationsAutresOperations;
		}
		public void setInformationsAutresOperations(InformationsAutresOperations informationsAutresOperations) {
			InformationsAutresOperations = informationsAutresOperations;
		}
		public String getDescriptionTransactionsRegimeFiscalPrivilegie() {
			return DescriptionTransactionsRegimeFiscalPrivilegie;
		}
		public void setDescriptionTransactionsRegimeFiscalPrivilegie(String descriptionTransactionsRegimeFiscalPrivilegie) {
			DescriptionTransactionsRegimeFiscalPrivilegie = descriptionTransactionsRegimeFiscalPrivilegie;
		}
    	
    }
    
    public static class InformationsValeursExploitation{
    	@JacksonXmlElementWrapper(localName ="valeursExploitation")
        @JacksonXmlProperty(localName ="LigneValeurExploitation")
    	private List<LigneValeurExploitation> valeursExploitation ;
    	private String TotalAchatsDepensesValeursExploitation ;
    	private String TotalVentesRevenusValeursExploitation ;
    	
    	
    	
    	
		public List<LigneValeurExploitation> getValeursExploitation() {
			return valeursExploitation;
		}
		public void setValeursExploitation(List<LigneValeurExploitation> valeursExploitation) {
			this.valeursExploitation = valeursExploitation;
		}
		public String getTotalAchatsDepensesValeursExploitation() {
			return TotalAchatsDepensesValeursExploitation;
		}
		public void setTotalAchatsDepensesValeursExploitation(String totalAchatsDepensesValeursExploitation) {
			TotalAchatsDepensesValeursExploitation = totalAchatsDepensesValeursExploitation;
		}
		public String getTotalVentesRevenusValeursExploitation() {
			return TotalVentesRevenusValeursExploitation;
		}
		public void setTotalVentesRevenusValeursExploitation(String totalVentesRevenusValeursExploitation) {
			TotalVentesRevenusValeursExploitation = totalVentesRevenusValeursExploitation;
		}	
    	
    }
    
    public static class LigneValeurExploitation{
    	private NatureOperationValeurExploitation NatureOperationValeurExploitation;
    	private String AchatsDepenses ;
    	private String VentesRevenus ;
    	private IdentifiantEntreprise IdentifiantEntreprise ;
    	private String RaisonSociale ;
    	private QualiteEntreprise QualiteEntreprise ;
    	private NatureRelationEntreprise NatureRelationEntreprise;
    	private MethodePrixTransfert  MethodePrixTransfert;
    	private ChangementMethodePrixTransfert ChangementMethodePrixTransfert;
		public NatureOperationValeurExploitation getNatureOperationValeurExploitation() {
			return NatureOperationValeurExploitation;
		}
		public void setNatureOperationValeurExploitation(NatureOperationValeurExploitation natureOperationValeurExploitation) {
			NatureOperationValeurExploitation = natureOperationValeurExploitation;
		}
		public String getAchatsDepenses() {
			return AchatsDepenses;
		}
		public void setAchatsDepenses(String achatsDepenses) {
			AchatsDepenses = achatsDepenses;
		}
		public String getVentesRevenus() {
			return VentesRevenus;
		}
		public void setVentesRevenus(String ventesRevenus) {
			VentesRevenus = ventesRevenus;
		}
		public IdentifiantEntreprise getIdentifiantEntreprise() {
			return IdentifiantEntreprise;
		}
		public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
			IdentifiantEntreprise = identifiantEntreprise;
		}
		public String getRaisonSociale() {
			return RaisonSociale;
		}
		public void setRaisonSociale(String raisonSociale) {
			RaisonSociale = raisonSociale;
		}
		public QualiteEntreprise getQualiteEntreprise() {
			return QualiteEntreprise;
		}
		public void setQualiteEntreprise(QualiteEntreprise qualiteEntreprise) {
			QualiteEntreprise = qualiteEntreprise;
		}
		public NatureRelationEntreprise getNatureRelationEntreprise() {
			return NatureRelationEntreprise;
		}
		public void setNatureRelationEntreprise(NatureRelationEntreprise natureRelationEntreprise) {
			NatureRelationEntreprise = natureRelationEntreprise;
		}
		public MethodePrixTransfert getMethodePrixTransfert() {
			return MethodePrixTransfert;
		}
		public void setMethodePrixTransfert(MethodePrixTransfert methodePrixTransfert) {
			MethodePrixTransfert = methodePrixTransfert;
		}
		public ChangementMethodePrixTransfert getChangementMethodePrixTransfert() {
			return ChangementMethodePrixTransfert;
		}
		public void setChangementMethodePrixTransfert(ChangementMethodePrixTransfert changementMethodePrixTransfert) {
			ChangementMethodePrixTransfert = changementMethodePrixTransfert;
		}
    	
    }
    
    public static class NatureOperationValeurExploitation{
    	String NatureOperation ;
    	String AutreNatureOperation ;
		public String getNatureOperation() {
			return NatureOperation;
		}
		public void setNatureOperation(String natureOperation) {
			NatureOperation = natureOperation;
		}
		public String getAutreNatureOperation() {
			return AutreNatureOperation;
		}
		public void setAutreNatureOperation(String autreNatureOperation) {
			AutreNatureOperation = autreNatureOperation;
		}
    	
    }
    
    public static class MethodePrixTransfert{
    	String MethodeDeterminationPrixTransfert ;
    	String AutreMethodeDeterminationPrixTransfert ;
		public String getMethodeDeterminationPrixTransfert() {
			return MethodeDeterminationPrixTransfert;
		}
		public void setMethodeDeterminationPrixTransfert(String methodeDeterminationPrixTransfert) {
			MethodeDeterminationPrixTransfert = methodeDeterminationPrixTransfert;
		}
		public String getAutreMethodeDeterminationPrixTransfert() {
			return AutreMethodeDeterminationPrixTransfert;
		}
		public void setAutreMethodeDeterminationPrixTransfert(String autreMethodeDeterminationPrixTransfert) {
			AutreMethodeDeterminationPrixTransfert = autreMethodeDeterminationPrixTransfert;
		}
    	
    }
    
   public static class ChangementMethodePrixTransfert{
	   String MethodeDeterminationPrixTransfert ; 
	   String AutreMethodeDeterminationPrixTransfert ;
	   
	public String getMethodeDeterminationPrixTransfert() {
		return MethodeDeterminationPrixTransfert;
	}
	public void setMethodeDeterminationPrixTransfert(String methodeDeterminationPrixTransfert) {
		MethodeDeterminationPrixTransfert = methodeDeterminationPrixTransfert;
	}
	public String getAutreMethodeDeterminationPrixTransfert() {
		return AutreMethodeDeterminationPrixTransfert;
	}
	public void setAutreMethodeDeterminationPrixTransfert(String autreMethodeDeterminationPrixTransfert) {
		AutreMethodeDeterminationPrixTransfert = autreMethodeDeterminationPrixTransfert;
	}
	   
   }
   
   public static class InformationsRemunerationsBiensCorporelsIncorporels {
	   @JacksonXmlElementWrapper(localName = "remunerationsBiensCorporelsIncorporels")
       @JacksonXmlProperty(localName = "LigneRemunerationsBiens")
	   private List<LigneRemunerationsBiens> remunerationsBiensCorporelsIncorporels ;
	   private String TotalAchatsDepensesRemunerationsBiensCorporelsIncorporels ;
	   private String TotalVentesRevenusRemunerationsBiensCorporelsIncorporels ;
	   
	   
	public List<LigneRemunerationsBiens> getRemunerationsBiensCorporelsIncorporels() {
		return remunerationsBiensCorporelsIncorporels;
	}
	public void setRemunerationsBiensCorporelsIncorporels(
			List<LigneRemunerationsBiens> remunerationsBiensCorporelsIncorporels) {
		this.remunerationsBiensCorporelsIncorporels = remunerationsBiensCorporelsIncorporels;
	}
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
	   
   }
    public static class LigneRemunerationsBiens {
    	private NatureOperationRemunerationBiens NatureOperationRemunerationBiens;
    	private String  AchatsDepenses ;
    	private String VentesRevenus ;
    	private IdentifiantEntreprise IdentifiantEntreprise ;
    	private String RaisonSociale ;
    	private QualiteEntreprise QualiteEntreprise ;
    	private NatureRelationEntreprise NatureRelationEntreprise ;
    	private MethodePrixTransfert MethodePrixTransfert ; 
    	private ChangementMethodePrixTransfert ChangementMethodePrixTransfert ;
		public NatureOperationRemunerationBiens getNatureOperationRemunerationBiens() {
			return NatureOperationRemunerationBiens;
		}
		public void setNatureOperationRemunerationBiens(NatureOperationRemunerationBiens natureOperationRemunerationBiens) {
			NatureOperationRemunerationBiens = natureOperationRemunerationBiens;
		}
		public String getAchatsDepenses() {
			return AchatsDepenses;
		}
		public void setAchatsDepenses(String achatsDepenses) {
			AchatsDepenses = achatsDepenses;
		}
		public String getVentesRevenus() {
			return VentesRevenus;
		}
		public void setVentesRevenus(String ventesRevenus) {
			VentesRevenus = ventesRevenus;
		}
		public IdentifiantEntreprise getIdentifiantEntreprise() {
			return IdentifiantEntreprise;
		}
		public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
			IdentifiantEntreprise = identifiantEntreprise;
		}
		public String getRaisonSociale() {
			return RaisonSociale;
		}
		public void setRaisonSociale(String raisonSociale) {
			RaisonSociale = raisonSociale;
		}
		public QualiteEntreprise getQualiteEntreprise() {
			return QualiteEntreprise;
		}
		public void setQualiteEntreprise(QualiteEntreprise qualiteEntreprise) {
			QualiteEntreprise = qualiteEntreprise;
		}
		public NatureRelationEntreprise getNatureRelationEntreprise() {
			return NatureRelationEntreprise;
		}
		public void setNatureRelationEntreprise(NatureRelationEntreprise natureRelationEntreprise) {
			NatureRelationEntreprise = natureRelationEntreprise;
		}
		public MethodePrixTransfert getMethodePrixTransfert() {
			return MethodePrixTransfert;
		}
		public void setMethodePrixTransfert(MethodePrixTransfert methodePrixTransfert) {
			MethodePrixTransfert = methodePrixTransfert;
		}
		public ChangementMethodePrixTransfert getChangementMethodePrixTransfert() {
			return ChangementMethodePrixTransfert;
		}
		public void setChangementMethodePrixTransfert(ChangementMethodePrixTransfert changementMethodePrixTransfert) {
			ChangementMethodePrixTransfert = changementMethodePrixTransfert;
		}
    	
    }
public static class NatureOperationRemunerationBiens{
	private String NatureOperation ;
	private String AutreNatureOperation ;
	public String getNatureOperation() {
		return NatureOperation;
	}
	public void setNatureOperation(String natureOperation) {
		NatureOperation = natureOperation;
	}
	public String getAutreNatureOperation() {
		return AutreNatureOperation;
	}
	public void setAutreNatureOperation(String autreNatureOperation) {
		AutreNatureOperation = autreNatureOperation;
	}
	
	
}
public static class InformationsServices{
	 @JacksonXmlElementWrapper(localName = "services")
     @JacksonXmlProperty(localName = "LigneService")
	private List<LigneService> services ;
	private String TotalAchatsDepensesServices ;
	private String TotalVentesRevenusServices ;
	public List<LigneService> getServices() {
		return services;
	}
	public void setServices(List<LigneService> services) {
		this.services = services;
	}
	public String getTotalAchatsDepensesServices() {
		return TotalAchatsDepensesServices;
	}
	public void setTotalAchatsDepensesServices(String totalAchatsDepensesServices) {
		TotalAchatsDepensesServices = totalAchatsDepensesServices;
	}
	public String getTotalVentesRevenusServices() {
		return TotalVentesRevenusServices;
	}
	public void setTotalVentesRevenusServices(String totalVentesRevenusServices) {
		TotalVentesRevenusServices = totalVentesRevenusServices;
	}
	
}
  public static class LigneService{
	  private NatureOperationService NatureOperationService;
	  private String  AchatsDepenses ;
  	private String VentesRevenus ;
  	private IdentifiantEntreprise IdentifiantEntreprise ;
  	private String RaisonSociale ;
  	private QualiteEntreprise QualiteEntreprise ;
  	private NatureRelationEntreprise NatureRelationEntreprise ;
  	private MethodePrixTransfert MethodePrixTransfert ; 
  	private ChangementMethodePrixTransfert ChangementMethodePrixTransfert ;
	public NatureOperationService getNatureOperationService() {
		return NatureOperationService;
	}
	public void setNatureOperationService(NatureOperationService natureOperationService) {
		NatureOperationService = natureOperationService;
	}
	public String getAchatsDepenses() {
		return AchatsDepenses;
	}
	public void setAchatsDepenses(String achatsDepenses) {
		AchatsDepenses = achatsDepenses;
	}
	public String getVentesRevenus() {
		return VentesRevenus;
	}
	public void setVentesRevenus(String ventesRevenus) {
		VentesRevenus = ventesRevenus;
	}
	public IdentifiantEntreprise getIdentifiantEntreprise() {
		return IdentifiantEntreprise;
	}
	public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
		IdentifiantEntreprise = identifiantEntreprise;
	}
	public String getRaisonSociale() {
		return RaisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		RaisonSociale = raisonSociale;
	}
	public QualiteEntreprise getQualiteEntreprise() {
		return QualiteEntreprise;
	}
	public void setQualiteEntreprise(QualiteEntreprise qualiteEntreprise) {
		QualiteEntreprise = qualiteEntreprise;
	}
	public NatureRelationEntreprise getNatureRelationEntreprise() {
		return NatureRelationEntreprise;
	}
	public void setNatureRelationEntreprise(NatureRelationEntreprise natureRelationEntreprise) {
		NatureRelationEntreprise = natureRelationEntreprise;
	}
	public MethodePrixTransfert getMethodePrixTransfert() {
		return MethodePrixTransfert;
	}
	public void setMethodePrixTransfert(MethodePrixTransfert methodePrixTransfert) {
		MethodePrixTransfert = methodePrixTransfert;
	}
	public ChangementMethodePrixTransfert getChangementMethodePrixTransfert() {
		return ChangementMethodePrixTransfert;
	}
	public void setChangementMethodePrixTransfert(ChangementMethodePrixTransfert changementMethodePrixTransfert) {
		ChangementMethodePrixTransfert = changementMethodePrixTransfert;
	}
  	
}
 public static class NatureOperationService {
	 private String NatureOperation ;
		private String AutreNatureOperation ;
		public String getNatureOperation() {
			return NatureOperation;
		}
		public void setNatureOperation(String natureOperation) {
			NatureOperation = natureOperation;
		}
		public String getAutreNatureOperation() {
			return AutreNatureOperation;
		}
		public void setAutreNatureOperation(String autreNatureOperation) {
			AutreNatureOperation = autreNatureOperation;
		}
		
 }
 public static class InformationsOperationsFinancieres{
	 @JacksonXmlElementWrapper(localName = "operationsFinancieres")
     @JacksonXmlProperty(localName = "LigneOperationFinanciere")
	 private List<LigneOperationFinanciere> operationsFinancieres; 
	 private String TotalAchatsDepensesOperationsFinancieres ;
	 private String TotalVentesRevenusOperationsFinancieres ;
	public List<LigneOperationFinanciere> getOperationsFinancieres() {
		return operationsFinancieres;
	}
	public void setOperationsFinancieres(List<LigneOperationFinanciere> operationsFinancieres) {
		this.operationsFinancieres = operationsFinancieres;
	}
	public String getTotalAchatsDepensesOperationsFinancieres() {
		return TotalAchatsDepensesOperationsFinancieres;
	}
	public void setTotalAchatsDepensesOperationsFinancieres(String totalAchatsDepensesOperationsFinancieres) {
		TotalAchatsDepensesOperationsFinancieres = totalAchatsDepensesOperationsFinancieres;
	}
	public String getTotalVentesRevenusOperationsFinancieres() {
		return TotalVentesRevenusOperationsFinancieres;
	}
	public void setTotalVentesRevenusOperationsFinancieres(String totalVentesRevenusOperationsFinancieres) {
		TotalVentesRevenusOperationsFinancieres = totalVentesRevenusOperationsFinancieres;
	}
	 
	 
 }
 public static class LigneOperationFinanciere{
	private NatureOperationFinanciere NatureOperationFinanciere ;
	private String  AchatsDepenses ;
  	private String VentesRevenus ;
  	private IdentifiantEntreprise IdentifiantEntreprise ;
  	private String RaisonSociale ;
  	private QualiteEntreprise QualiteEntreprise ;
  	private NatureRelationEntreprise NatureRelationEntreprise ;
  	private MethodePrixTransfert MethodePrixTransfert ; 
  	private ChangementMethodePrixTransfert ChangementMethodePrixTransfert ;
	public NatureOperationFinanciere getNatureOperationFinanciere() {
		return NatureOperationFinanciere;
	}
	public void setNatureOperationFinanciere(NatureOperationFinanciere natureOperationFinanciere) {
		NatureOperationFinanciere = natureOperationFinanciere;
	}
	public String getAchatsDepenses() {
		return AchatsDepenses;
	}
	public void setAchatsDepenses(String achatsDepenses) {
		AchatsDepenses = achatsDepenses;
	}
	public String getVentesRevenus() {
		return VentesRevenus;
	}
	public void setVentesRevenus(String ventesRevenus) {
		VentesRevenus = ventesRevenus;
	}
	public IdentifiantEntreprise getIdentifiantEntreprise() {
		return IdentifiantEntreprise;
	}
	public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
		IdentifiantEntreprise = identifiantEntreprise;
	}
	public String getRaisonSociale() {
		return RaisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		RaisonSociale = raisonSociale;
	}
	public QualiteEntreprise getQualiteEntreprise() {
		return QualiteEntreprise;
	}
	public void setQualiteEntreprise(QualiteEntreprise qualiteEntreprise) {
		QualiteEntreprise = qualiteEntreprise;
	}
	public NatureRelationEntreprise getNatureRelationEntreprise() {
		return NatureRelationEntreprise;
	}
	public void setNatureRelationEntreprise(NatureRelationEntreprise natureRelationEntreprise) {
		NatureRelationEntreprise = natureRelationEntreprise;
	}
	public MethodePrixTransfert getMethodePrixTransfert() {
		return MethodePrixTransfert;
	}
	public void setMethodePrixTransfert(MethodePrixTransfert methodePrixTransfert) {
		MethodePrixTransfert = methodePrixTransfert;
	}
	public ChangementMethodePrixTransfert getChangementMethodePrixTransfert() {
		return ChangementMethodePrixTransfert;
	}
	public void setChangementMethodePrixTransfert(ChangementMethodePrixTransfert changementMethodePrixTransfert) {
		ChangementMethodePrixTransfert = changementMethodePrixTransfert;
	}
  	
 }
 public static class NatureOperationFinanciere{
	 private String NatureOperation ;
		private String AutreNatureOperation ;
		public String getNatureOperation() {
			return NatureOperation;
		}
		public void setNatureOperation(String natureOperation) {
			NatureOperation = natureOperation;
		}
		public String getAutreNatureOperation() {
			return AutreNatureOperation;
		}
		public void setAutreNatureOperation(String autreNatureOperation) {
			AutreNatureOperation = autreNatureOperation;
		}
		
 }
 public static class InformationsCessionsAcquisitionsActifs{
	 @JacksonXmlElementWrapper(localName = "cessionsAcquisitionsActifs")
     @JacksonXmlProperty(localName = "LigneCessionAcquisitionActif")
	private List<LigneCessionAcquisitionActif> cessionsAcquisitionsActifs ;
	 private String TotalAchatsDepensesCessionsAcquisitionsActifs ;
	 private String TotalVentesRevenusCessionsAcquisitionsActifs ;
	public List<LigneCessionAcquisitionActif> getCessionsAcquisitionsActifs() {
		return cessionsAcquisitionsActifs;
	}
	public void setCessionsAcquisitionsActifs(List<LigneCessionAcquisitionActif> cessionsAcquisitionsActifs) {
		this.cessionsAcquisitionsActifs = cessionsAcquisitionsActifs;
	}
	public String getTotalAchatsDepensesCessionsAcquisitionsActifs() {
		return TotalAchatsDepensesCessionsAcquisitionsActifs;
	}
	public void setTotalAchatsDepensesCessionsAcquisitionsActifs(String totalAchatsDepensesCessionsAcquisitionsActifs) {
		TotalAchatsDepensesCessionsAcquisitionsActifs = totalAchatsDepensesCessionsAcquisitionsActifs;
	}
	public String getTotalVentesRevenusCessionsAcquisitionsActifs() {
		return TotalVentesRevenusCessionsAcquisitionsActifs;
	}
	public void setTotalVentesRevenusCessionsAcquisitionsActifs(String totalVentesRevenusCessionsAcquisitionsActifs) {
		TotalVentesRevenusCessionsAcquisitionsActifs = totalVentesRevenusCessionsAcquisitionsActifs;
	}
	 
 }
 public static class LigneCessionAcquisitionActif{
	 private NatureOperationCessionAcquisitionActif NatureOperationCessionAcquisitionActif ;
		private String  AchatsDepenses ;
	  	private String VentesRevenus ;
	  	private IdentifiantEntreprise IdentifiantEntreprise ;
	  	private String RaisonSociale ;
	  	private QualiteEntreprise QualiteEntreprise ;
	  	private NatureRelationEntreprise NatureRelationEntreprise ;
	  	private MethodePrixTransfert MethodePrixTransfert ; 
	  	private ChangementMethodePrixTransfert ChangementMethodePrixTransfert ;
		public NatureOperationCessionAcquisitionActif getNatureOperationCessionAcquisitionActif() {
			return NatureOperationCessionAcquisitionActif;
		}
		public void setNatureOperationCessionAcquisitionActif(
				NatureOperationCessionAcquisitionActif natureOperationCessionAcquisitionActif) {
			NatureOperationCessionAcquisitionActif = natureOperationCessionAcquisitionActif;
		}
		public String getAchatsDepenses() {
			return AchatsDepenses;
		}
		public void setAchatsDepenses(String achatsDepenses) {
			AchatsDepenses = achatsDepenses;
		}
		public String getVentesRevenus() {
			return VentesRevenus;
		}
		public void setVentesRevenus(String ventesRevenus) {
			VentesRevenus = ventesRevenus;
		}
		public IdentifiantEntreprise getIdentifiantEntreprise() {
			return IdentifiantEntreprise;
		}
		public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
			IdentifiantEntreprise = identifiantEntreprise;
		}
		public String getRaisonSociale() {
			return RaisonSociale;
		}
		public void setRaisonSociale(String raisonSociale) {
			RaisonSociale = raisonSociale;
		}
		public QualiteEntreprise getQualiteEntreprise() {
			return QualiteEntreprise;
		}
		public void setQualiteEntreprise(QualiteEntreprise qualiteEntreprise) {
			QualiteEntreprise = qualiteEntreprise;
		}
		public NatureRelationEntreprise getNatureRelationEntreprise() {
			return NatureRelationEntreprise;
		}
		public void setNatureRelationEntreprise(NatureRelationEntreprise natureRelationEntreprise) {
			NatureRelationEntreprise = natureRelationEntreprise;
		}
		public MethodePrixTransfert getMethodePrixTransfert() {
			return MethodePrixTransfert;
		}
		public void setMethodePrixTransfert(MethodePrixTransfert methodePrixTransfert) {
			MethodePrixTransfert = methodePrixTransfert;
		}
		public ChangementMethodePrixTransfert getChangementMethodePrixTransfert() {
			return ChangementMethodePrixTransfert;
		}
		public void setChangementMethodePrixTransfert(ChangementMethodePrixTransfert changementMethodePrixTransfert) {
			ChangementMethodePrixTransfert = changementMethodePrixTransfert;
		}
	  	
	 
 }
 public static class NatureOperationCessionAcquisitionActif {
	 private String NatureOperation ;
		private String AutreNatureOperation ;
		public String getNatureOperation() {
			return NatureOperation;
		}
		public void setNatureOperation(String natureOperation) {
			NatureOperation = natureOperation;
		}
		public String getAutreNatureOperation() {
			return AutreNatureOperation;
		}
		public void setAutreNatureOperation(String autreNatureOperation) {
			AutreNatureOperation = autreNatureOperation;
		}
		
 }
 public static class InformationsAutresOperations{
	 @JacksonXmlElementWrapper(localName = "autresOperations")
     @JacksonXmlProperty(localName = "LigneAutreOperation")
	private List<LigneAutreOperation> autresOperations ;
	private String  TotalAchatsDepensesAutresOperations ;
	 private String TotalVentesRevenusAutresOperations ;
	public List<LigneAutreOperation> getAutresOperations() {
		return autresOperations;
	}
	public void setAutresOperations(List<LigneAutreOperation> autresOperations) {
		this.autresOperations = autresOperations;
	}
	public String getTotalAchatsDepensesAutresOperations() {
		return TotalAchatsDepensesAutresOperations;
	}
	public void setTotalAchatsDepensesAutresOperations(String totalAchatsDepensesAutresOperations) {
		TotalAchatsDepensesAutresOperations = totalAchatsDepensesAutresOperations;
	}
	public String getTotalVentesRevenusAutresOperations() {
		return TotalVentesRevenusAutresOperations;
	}
	public void setTotalVentesRevenusAutresOperations(String totalVentesRevenusAutresOperations) {
		TotalVentesRevenusAutresOperations = totalVentesRevenusAutresOperations;
	}
	 
 }
 public static class LigneAutreOperation{
	 private String NatureAutreOperation ;
		private String  AchatsDepenses ;
	  	private String VentesRevenus ;
	  	private IdentifiantEntreprise IdentifiantEntreprise ;
	  	private String RaisonSociale ;
	  	private QualiteEntreprise QualiteEntreprise ;
	  	private NatureRelationEntreprise NatureRelationEntreprise ;
	  	private MethodePrixTransfert MethodePrixTransfert ; 
	  	private ChangementMethodePrixTransfert ChangementMethodePrixTransfert ;
		
		
		public String getNatureAutreOperation() {
			return NatureAutreOperation;
		}
		public void setNatureAutreOperation(String natureAutreOperation) {
			NatureAutreOperation = natureAutreOperation;
		}
		public String getAchatsDepenses() {
			return AchatsDepenses;
		}
		public void setAchatsDepenses(String achatsDepenses) {
			AchatsDepenses = achatsDepenses;
		}
		public String getVentesRevenus() {
			return VentesRevenus;
		}
		public void setVentesRevenus(String ventesRevenus) {
			VentesRevenus = ventesRevenus;
		}
		public IdentifiantEntreprise getIdentifiantEntreprise() {
			return IdentifiantEntreprise;
		}
		public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
			IdentifiantEntreprise = identifiantEntreprise;
		}
		public String getRaisonSociale() {
			return RaisonSociale;
		}
		public void setRaisonSociale(String raisonSociale) {
			RaisonSociale = raisonSociale;
		}
		public QualiteEntreprise getQualiteEntreprise() {
			return QualiteEntreprise;
		}
		public void setQualiteEntreprise(QualiteEntreprise qualiteEntreprise) {
			QualiteEntreprise = qualiteEntreprise;
		}
		public NatureRelationEntreprise getNatureRelationEntreprise() {
			return NatureRelationEntreprise;
		}
		public void setNatureRelationEntreprise(NatureRelationEntreprise natureRelationEntreprise) {
			NatureRelationEntreprise = natureRelationEntreprise;
		}
		public MethodePrixTransfert getMethodePrixTransfert() {
			return MethodePrixTransfert;
		}
		public void setMethodePrixTransfert(MethodePrixTransfert methodePrixTransfert) {
			MethodePrixTransfert = methodePrixTransfert;
		}
		public ChangementMethodePrixTransfert getChangementMethodePrixTransfert() {
			return ChangementMethodePrixTransfert;
		}
		public void setChangementMethodePrixTransfert(ChangementMethodePrixTransfert changementMethodePrixTransfert) {
			ChangementMethodePrixTransfert = changementMethodePrixTransfert;
		}
	 
 }

 public static class InformationsPretsEmprunts {
	 @JacksonXmlElementWrapper(localName = "pretsAccordes")
     @JacksonXmlProperty(localName = "LignePretAccorde")
	private List<LignePretAccorde> pretsAccordes ;
	 @JacksonXmlElementWrapper(localName = "empruntsContractes")
     @JacksonXmlProperty(localName = "LigneEmpruntContracte")
	 private List<LigneEmpruntContracte> empruntsContractes ;
	public List<LignePretAccorde> getPretsAccordes() {
		return pretsAccordes;
	}
	public void setPretsAccordes(List<LignePretAccorde> pretsAccordes) {
		this.pretsAccordes = pretsAccordes;
	}
	public List<LigneEmpruntContracte> getEmpruntsContractes() {
		return empruntsContractes;
	}
	public void setEmpruntsContractes(List<LigneEmpruntContracte> empruntsContractes) {
		this.empruntsContractes = empruntsContractes;
	}
	 
 }
 
 public static class LignePretAccorde{
	private IdentifiantEntreprise IdentifiantEntreprise ;
	 private String RaisonSociale ;
	private QualiteEntreprise QualiteEntreprise ;
	 private NatureRelationEntreprise NatureRelationEntreprise ;
	private String SoldeOuverture ;
	 private String Devise ;
	private String  MouvementsAugmentations ;
	 private String MouvementsDiminutions ;
	private String SoldeCloture ;
	private String PretsInterets ;
	 private String TauxInteret;
	public IdentifiantEntreprise getIdentifiantEntreprise() {
		return IdentifiantEntreprise;
	}
	public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
		IdentifiantEntreprise = identifiantEntreprise;
	}
	public String getRaisonSociale() {
		return RaisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		RaisonSociale = raisonSociale;
	}
	public QualiteEntreprise getQualiteEntreprise() {
		return QualiteEntreprise;
	}
	public void setQualiteEntreprise(QualiteEntreprise qualiteEntreprise) {
		QualiteEntreprise = qualiteEntreprise;
	}
	public NatureRelationEntreprise getNatureRelationEntreprise() {
		return NatureRelationEntreprise;
	}
	public void setNatureRelationEntreprise(NatureRelationEntreprise natureRelationEntreprise) {
		NatureRelationEntreprise = natureRelationEntreprise;
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
	public String getTauxInteret() {
		return TauxInteret;
	}
	public void setTauxInteret(String tauxInteret) {
		TauxInteret = tauxInteret;
	}
	 
 }
 public static class LigneEmpruntContracte{
	 private IdentifiantEntreprise IdentifiantEntreprise ;
	 private String RaisonSociale ;
	private QualiteEntreprise QualiteEntreprise ;
	 private NatureRelationEntreprise NatureRelationEntreprise ;
	private String SoldeOuverture ;
	 private String Devise ;
	private String  MouvementsAugmentations ;
	 private String MouvementsDiminutions ;
	private String SoldeCloture ;
	
	 private String TauxInteret;
	public IdentifiantEntreprise getIdentifiantEntreprise() {
		return IdentifiantEntreprise;
	}
	public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
		IdentifiantEntreprise = identifiantEntreprise;
	}
	public String getRaisonSociale() {
		return RaisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		RaisonSociale = raisonSociale;
	}
	public QualiteEntreprise getQualiteEntreprise() {
		return QualiteEntreprise;
	}
	public void setQualiteEntreprise(QualiteEntreprise qualiteEntreprise) {
		QualiteEntreprise = qualiteEntreprise;
	}
	public NatureRelationEntreprise getNatureRelationEntreprise() {
		return NatureRelationEntreprise;
	}
	public void setNatureRelationEntreprise(NatureRelationEntreprise natureRelationEntreprise) {
		NatureRelationEntreprise = natureRelationEntreprise;
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
	
	public String getTauxInteret() {
		return TauxInteret;
	}
	public void setTauxInteret(String tauxInteret) {
		TauxInteret = tauxInteret;
	}
	 
 }
 public static class OperationsSansContrepartieOuAvecContrepartieNonMonetaire {
	 private InformationsSurBiensOuServicesSansContrePartie InformationsSurBiensOuServicesSansContrePartie ;
	 private InformationsSurContrepartieNonMonetairePourBiensOuServices InformationsSurContrepartieNonMonetairePourBiensOuServices ;
	public InformationsSurBiensOuServicesSansContrePartie getInformationsSurBiensOuServicesSansContrePartie() {
		return InformationsSurBiensOuServicesSansContrePartie;
	}
	public void setInformationsSurBiensOuServicesSansContrePartie(
			InformationsSurBiensOuServicesSansContrePartie informationsSurBiensOuServicesSansContrePartie) {
		InformationsSurBiensOuServicesSansContrePartie = informationsSurBiensOuServicesSansContrePartie;
	}
	public InformationsSurContrepartieNonMonetairePourBiensOuServices getInformationsSurContrepartieNonMonetairePourBiensOuServices() {
		return InformationsSurContrepartieNonMonetairePourBiensOuServices;
	}
	public void setInformationsSurContrepartieNonMonetairePourBiensOuServices(
			InformationsSurContrepartieNonMonetairePourBiensOuServices informationsSurContrepartieNonMonetairePourBiensOuServices) {
		InformationsSurContrepartieNonMonetairePourBiensOuServices = informationsSurContrepartieNonMonetairePourBiensOuServices;
	}
	 
 }
 public static class InformationsSurBiensOuServicesSansContrePartie{
	 private char Affirmation;
	 @JacksonXmlElementWrapper(localName = "BiensOuServicesSansContrePartie")
     @JacksonXmlProperty(localName = "LigneBiensOuServicesSansContrePartie")
	 private List<LigneBiensOuServicesSansContrePartie> biensOuServicesSansContrePartie;
	public char getAffirmation() {
		return Affirmation;
	}
	public void setAffirmation(char affirmation) {
		Affirmation = affirmation;
	}
	public List<LigneBiensOuServicesSansContrePartie> getBiensOuServicesSansContrePartie() {
		return biensOuServicesSansContrePartie;
	}
	public void setBiensOuServicesSansContrePartie(
			List<LigneBiensOuServicesSansContrePartie> biensOuServicesSansContrePartie) {
		this.biensOuServicesSansContrePartie = biensOuServicesSansContrePartie;
	}
	 
 }
public static class LigneBiensOuServicesSansContrePartie {
	private IdentifiantEntreprise IdentifiantEntreprise ;
	private String RaisonSociale ;
	private QualiteEntreprise QualiteEntreprise ;
	private NatureRelationEntreprise NatureRelationEntreprise ;
	private String NatureBiensOuService ;
	private String NatureContrepartie ;
	public IdentifiantEntreprise getIdentifiantEntreprise() {
		return IdentifiantEntreprise;
	}
	public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
		IdentifiantEntreprise = identifiantEntreprise;
	}
	public String getRaisonSociale() {
		return RaisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		RaisonSociale = raisonSociale;
	}
	public QualiteEntreprise getQualiteEntreprise() {
		return QualiteEntreprise;
	}
	public void setQualiteEntreprise(QualiteEntreprise qualiteEntreprise) {
		QualiteEntreprise = qualiteEntreprise;
	}
	public NatureRelationEntreprise getNatureRelationEntreprise() {
		return NatureRelationEntreprise;
	}
	public void setNatureRelationEntreprise(NatureRelationEntreprise natureRelationEntreprise) {
		NatureRelationEntreprise = natureRelationEntreprise;
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
	
}
public static class InformationsSurContrepartieNonMonetairePourBiensOuServices {
	private char Affirmation;
	 @JacksonXmlElementWrapper(localName = "ContrepartieNonMonetairePourBiensOuServices")
    @JacksonXmlProperty(localName = "LigneContrepartieNonMonetairePourBiensOuServices")
	 private List<LigneContrepartieNonMonetairePourBiensOuServices> contrepartieNonMonetairePourBiensOuServices;
	public char getAffirmation() {
		return Affirmation;
	}
	public void setAffirmation(char affirmation) {
		Affirmation = affirmation;
	}
	public List<LigneContrepartieNonMonetairePourBiensOuServices> getContrepartieNonMonetairePourBiensOuServices() {
		return contrepartieNonMonetairePourBiensOuServices;
	}
	public void setContrepartieNonMonetairePourBiensOuServices(
			List<LigneContrepartieNonMonetairePourBiensOuServices> contrepartieNonMonetairePourBiensOuServices) {
		this.contrepartieNonMonetairePourBiensOuServices = contrepartieNonMonetairePourBiensOuServices;
	}
	 
}
public static class LigneContrepartieNonMonetairePourBiensOuServices {
	private IdentifiantEntreprise IdentifiantEntreprise ;
	private String RaisonSociale ;
	private QualiteEntreprise QualiteEntreprise ;
	private NatureRelationEntreprise NatureRelationEntreprise ;
	private String NatureBiensOuService ;
	private String NatureContrepartie ;
	public IdentifiantEntreprise getIdentifiantEntreprise() {
		return IdentifiantEntreprise;
	}
	public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
		IdentifiantEntreprise = identifiantEntreprise;
	}
	public String getRaisonSociale() {
		return RaisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		RaisonSociale = raisonSociale;
	}
	public QualiteEntreprise getQualiteEntreprise() {
		return QualiteEntreprise;
	}
	public void setQualiteEntreprise(QualiteEntreprise qualiteEntreprise) {
		QualiteEntreprise = qualiteEntreprise;
	}
	public NatureRelationEntreprise getNatureRelationEntreprise() {
		return NatureRelationEntreprise;
	}
	public void setNatureRelationEntreprise(NatureRelationEntreprise natureRelationEntreprise) {
		NatureRelationEntreprise = natureRelationEntreprise;
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
	
}
public static class InformationsOperationsAccordsPrealablesOuRescritsFiscaux {
	private char Affirmation ;
	@JacksonXmlElementWrapper(localName ="OperationsAccordsPrealablesOuRescritsFiscaux")
    @JacksonXmlProperty(localName = "LigneOperationsAccordsPrealablesOuRescritsFiscaux")
	private List<LigneOperationsAccordsPrealablesOuRescritsFiscaux> operationsAccordsPrealablesOuRescritsFiscaux ;
	
	public char getAffirmation() {
		return Affirmation;
	}
	public void setAffirmation(char affirmation) {
		Affirmation = affirmation;
	}
	public List<LigneOperationsAccordsPrealablesOuRescritsFiscaux> getOperationsAccordsPrealablesOuRescritsFiscaux() {
		return operationsAccordsPrealablesOuRescritsFiscaux;
	}
	public void setOperationsAccordsPrealablesOuRescritsFiscaux(
			List<LigneOperationsAccordsPrealablesOuRescritsFiscaux> operationsAccordsPrealablesOuRescritsFiscaux) {
		this.operationsAccordsPrealablesOuRescritsFiscaux = operationsAccordsPrealablesOuRescritsFiscaux;
	}
	
}
public static class LigneOperationsAccordsPrealablesOuRescritsFiscaux{
	private IdentifiantEntreprise IdentifiantEntreprise ;
	private String RaisonSociale ;
	private QualiteEntreprise QualiteEntreprise ;
	private NatureRelationEntreprise NatureRelationEntreprise ;
	private String NatureOperation ; 
	private String ExerciceDebut ;
	private String ExerciceFin ;
	public IdentifiantEntreprise getIdentifiantEntreprise() {
		return IdentifiantEntreprise;
	}
	public void setIdentifiantEntreprise(IdentifiantEntreprise identifiantEntreprise) {
		IdentifiantEntreprise = identifiantEntreprise;
	}
	public String getRaisonSociale() {
		return RaisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		RaisonSociale = raisonSociale;
	}
	public QualiteEntreprise getQualiteEntreprise() {
		return QualiteEntreprise;
	}
	public void setQualiteEntreprise(QualiteEntreprise qualiteEntreprise) {
		QualiteEntreprise = qualiteEntreprise;
	}
	public NatureRelationEntreprise getNatureRelationEntreprise() {
		return NatureRelationEntreprise;
	}
	public void setNatureRelationEntreprise(NatureRelationEntreprise natureRelationEntreprise) {
		NatureRelationEntreprise = natureRelationEntreprise;
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
	
}

}