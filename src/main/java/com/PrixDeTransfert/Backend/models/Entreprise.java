package com.PrixDeTransfert.Backend.models;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="Entreprise")
public class Entreprise {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	   
    @Column(name = "raison_social")
    private String raisonSocial;
    
    public DéclarationPrixDeTransfert getDéclarationPrixDeTransfert() {
		return DéclarationPrixDeTransfert;
	}

	public void setDéclarationPrixDeTransfert(DéclarationPrixDeTransfert déclarationPrixDeTransfert) {
		DéclarationPrixDeTransfert = déclarationPrixDeTransfert;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "forme_juridique")
    private String formeJuridique;
    @Column(name="nationalité")
    private String nationalite;
    
    @Column(name = "adresse_siege_social_etablissement_tunisie")
    private String adresseSiegeSocialEtablissementTunisie;
    
    @Column(name = "code_postal")
    private String codePostal;
    
    @Column(name = "activite_principale")
    private String activitePrincipale;
    
    @Column(name = "activite_secondaire")
    private String activiteSecondaire;
    
   
    
    @Column(name = "chiffre_affaire_annuel") // Nom de la colonne
    private String chiffreAffaireAnnuel;
    @OneToOne(mappedBy = "entreprise" ,cascade = CascadeType.ALL, orphanRemoval = true)
    private DéclarationPrixDeTransfert DéclarationPrixDeTransfert;
     
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User User;

	

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public String getRaisonSocial() {
		return raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
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

	public void setChiffreAffaireAnnuel(String chiffreAffaireAnnuel) {
		this.chiffreAffaireAnnuel = chiffreAffaireAnnuel;
	}

	


}
