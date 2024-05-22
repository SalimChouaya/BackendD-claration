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
@Table(name="declaration_prix_de_transfert") // Nom de la table
public class DéclarationPrixDeTransfert {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_acte") // Nom de la colonne
    private String codeActe;

    @Column(name = "exercice") // Nom de la colonne
    private String exercice;

    @Column(name = "matricule_fiscal_declarant", unique = true)
    
    private String matriculeFiscalDeclarant; 

    @Column(name = "code_tva") // Nom de la colonne
    private String codeTva;

    @Column(name = "code_categorie") // Nom de la colonne
    private String codeCatégorie;

    @Column(name = "type_declaration") // Nom de la colonne
    private String typeDéclaration;

    @Column(name = "date_debut_exercice") // Nom de la colonne
    private String dateDébutExercice;

    @Column(name = "date_fin_exercice") // Nom de la colonne
    private String dateFinExercice;
    @OneToOne
    @JoinColumn(name = "entreprise_id", referencedColumnName = "id")
    private Entreprise entreprise;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getCodeTva() {
		return codeTva;
	}
	public void setCodeTva(String codeTva) {
		this.codeTva = codeTva;
	}
	public String getCodeCatégorie() {
		return codeCatégorie;
	}
	public void setCodeCatégorie(String codeCatégorie) {
		this.codeCatégorie = codeCatégorie;
	}
	public String getTypeDéclaration() {
		return typeDéclaration;
	}
	public void setTypeDéclaration(String typeDéclaration) {
		this.typeDéclaration = typeDéclaration;
	}
	public String getDateDébutExercice() {
		return dateDébutExercice;
	}
	public void setDateDébutExercice(String dateDébutExercice) {
		this.dateDébutExercice = dateDébutExercice;
	}
	public String getDateFinExercice() {
		return dateFinExercice;
	}
	public void setDateFinExercice(String dateFinExercice) {
		this.dateFinExercice = dateFinExercice;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public InformationsEntrepriseDeclaranteBD getInformationsEntrepriseDeclarante() {
		return InformationsEntrepriseDeclarante;
	}
	public void setInformationsEntrepriseDeclarante(InformationsEntrepriseDeclaranteBD informationsEntrepriseDeclarante) {
		InformationsEntrepriseDeclarante = informationsEntrepriseDeclarante;
	}
	public InformationsGroupeEntreprisesBD getInformationsGroupeEntreprises() {
		return InformationsGroupeEntreprises;
	}
	public void setInformationsGroupeEntreprises(InformationsGroupeEntreprisesBD informationsGroupeEntreprises) {
		InformationsGroupeEntreprises = informationsGroupeEntreprises;
	}
	@OneToOne(mappedBy = "DéclarationPrixDeTransfert" ,cascade = CascadeType.ALL, orphanRemoval = true)
    private InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclarante;
    @OneToOne(mappedBy = "DéclarationPrixDeTransfert",cascade = CascadeType.ALL, orphanRemoval = true)
    private InformationsGroupeEntreprisesBD InformationsGroupeEntreprises;
    @OneToOne(mappedBy = "DéclarationPrixDeTransfert",cascade = CascadeType.ALL, orphanRemoval = true)
    private InformationsOperationsBD InformationsOperations;
    @OneToOne(mappedBy = "DéclarationPrixDeTransfert",cascade = CascadeType.ALL, orphanRemoval = true)
    private AutresInformationsARenseignerSurDeclarationPrixTransfert AutresInformationsARenseignerSurDeclarationPrixTransfert;
    
    @OneToOne(mappedBy = "DéclarationPrixDeTransfert",cascade = CascadeType.ALL, orphanRemoval = true)
    private XMLDocument XMLDocument;

	public InformationsOperationsBD getInformationsOperations() {
		return InformationsOperations;
	}
	public void setInformationsOperations(InformationsOperationsBD informationsOperations) {
		InformationsOperations = informationsOperations;
	}
	public AutresInformationsARenseignerSurDeclarationPrixTransfert getAutresInformationsARenseignerSurDeclarationPrixTransfert() {
		return AutresInformationsARenseignerSurDeclarationPrixTransfert;
	}
	public void setAutresInformationsARenseignerSurDeclarationPrixTransfert(
			AutresInformationsARenseignerSurDeclarationPrixTransfert autresInformationsARenseignerSurDeclarationPrixTransfert) {
		AutresInformationsARenseignerSurDeclarationPrixTransfert = autresInformationsARenseignerSurDeclarationPrixTransfert;
	}
	public XMLDocument getXMLDocument() {
		return XMLDocument;
	}
	public void setXMLDocument(XMLDocument xMLDocument) {
		XMLDocument = xMLDocument;
	}
	

}
