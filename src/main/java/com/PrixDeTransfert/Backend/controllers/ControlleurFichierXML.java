package com.PrixDeTransfert.Backend.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.AutresInformationsARenseignerSurDeclarationPrixTransfert;
import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;
import com.PrixDeTransfert.Backend.models.Entreprise;
import com.PrixDeTransfert.Backend.models.InformationsAutresOperationsBD;
import com.PrixDeTransfert.Backend.models.InformationsCessionsAcquisitionsActifsBD;
import com.PrixDeTransfert.Backend.models.InformationsEntrepriseDeclaranteBD;
import com.PrixDeTransfert.Backend.models.InformationsGroupeEntreprisesBD;
import com.PrixDeTransfert.Backend.models.InformationsMereEntiteUltimeBD;
import com.PrixDeTransfert.Backend.models.InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD;
import com.PrixDeTransfert.Backend.models.InformationsOperationsBD;
import com.PrixDeTransfert.Backend.models.InformationsOperationsFinancieresBD;
import com.PrixDeTransfert.Backend.models.InformationsPretsEmpruntsBD;
import com.PrixDeTransfert.Backend.models.InformationsRemunerationsBiensCorporelsIncorporelsBD;
import com.PrixDeTransfert.Backend.models.InformationsServicesBD;
import com.PrixDeTransfert.Backend.models.InformationsSurBiensOuServicesSansContrePartieBD;
import com.PrixDeTransfert.Backend.models.InformationsSurContrepartieNonMonetairePourBiensOuServicesBD;
import com.PrixDeTransfert.Backend.models.InformationsValeursExploitationBD;
import com.PrixDeTransfert.Backend.models.LigneActifCorporelBD;
import com.PrixDeTransfert.Backend.models.LigneActifInCorporelBD;
import com.PrixDeTransfert.Backend.models.LigneAutreOperationBD;
import com.PrixDeTransfert.Backend.models.LigneBiensOuServicesSansContrePartieBD;
import com.PrixDeTransfert.Backend.models.LigneCessionAcquisitionActifBD;
import com.PrixDeTransfert.Backend.models.LigneContrepartieNonMonetairePourBiensOuServicesBD;
import com.PrixDeTransfert.Backend.models.LigneEmpruntContracteBD;
import com.PrixDeTransfert.Backend.models.LigneOperationFinanciereBD;
import com.PrixDeTransfert.Backend.models.LigneOperationsAccordsPrealablesOuRescritsFiscauxBD;
import com.PrixDeTransfert.Backend.models.LigneParticipationDeclaranteBD;
import com.PrixDeTransfert.Backend.models.LigneParticipationLieeBD;
import com.PrixDeTransfert.Backend.models.LignePretAccordeBD;
import com.PrixDeTransfert.Backend.models.LigneRemunerationBiensBD;
import com.PrixDeTransfert.Backend.models.LigneServiceBD;
import com.PrixDeTransfert.Backend.models.LigneValeurExploitationBD;
import com.PrixDeTransfert.Backend.models.ModificationLiensCapitalAuCoursExerciceBD;
import com.PrixDeTransfert.Backend.models.MontantTransactionsMethodeDeterminationPrixTransfertBD;
import com.PrixDeTransfert.Backend.models.OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD;
import com.PrixDeTransfert.Backend.models.Qualité;
import com.PrixDeTransfert.Backend.models.User;
import com.PrixDeTransfert.Backend.models.XMLDocument;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.ActifIncorporel;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.Actifcorporel;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.AutreIdentifiant;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.ChangementMethodePrixTransfert;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.ChangementsActiviteAuCoursExercice;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.DateFinExercice;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.Entete;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.IdentifiantEntreprise;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.IdentificationEntrepriseDeclarante;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsAutresOperations;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsCessionsAcquisitionsActifs;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsEntiteMereUltime;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsEntrepriseDeclarante;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsGroupeEntreprises;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsOperations;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsOperationsAccordsPrealablesOuRescritsFiscaux;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsOperationsFinancieres;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsPretsEmprunts;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsRemunerationsBiensCorporelsIncorporels;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsServices;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsSurBiensOuServicesSansContrePartie;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsSurContrepartieNonMonetairePourBiensOuServices;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.InformationsValeursExploitation;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LiensCapital;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneActifCorporel;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneActifIncorporel;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneAutreOperation;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneBiensOuServicesSansContrePartie;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneCessionAcquisitionActif;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneContrepartieNonMonetairePourBiensOuServices;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneEmpruntContracte;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneOperationFinanciere;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneOperationsAccordsPrealablesOuRescritsFiscaux;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneParticipationDeclarante;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneParticipationLiee;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LignePretAccorde;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneRemunerationsBiens;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneService;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.LigneValeurExploitation;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.MethodePrixTransfert;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.ModificationLiensCapitalAuCoursExercice;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.MontantTransactionsMethodeDeterminationPrixTransfert;

import com.PrixDeTransfert.Backend.structureXML.GenerationXML.NatureOperationCessionAcquisitionActif;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.NatureOperationFinanciere;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.NatureOperationRemunerationBiens;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.NatureOperationService;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.NatureOperationValeurExploitation;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.NatureRelationEntreprise;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.OperationsSansContrepartieOuAvecContrepartieNonMonetaire;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.PrixTransfert;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.QualiteEntreprise;
import com.PrixDeTransfert.Backend.structureXML.GenerationXML.QualiteEntrepriseDeclarante;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import jakarta.servlet.http.HttpSession;
@RestController
public class ControlleurFichierXML {
	
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryCreerCompte InterfaceRepositoryCreerCompte;
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsEntrepriseDeclarante InterfaceRepositoryInformationsEntrepriseDeclarante;
	@Autowired
	private com.PrixDeTransfert.Backend.repositories.userRepository InterfaceRepositoryUser ;
	@GetMapping("/download/xml")
    public ResponseEntity<String> downloadXml(  HttpSession session) {
        try {
        	Long id =userController.iduser;
        	User user=InterfaceRepositoryUser.findUserById(id);
        	DéclarationPrixDeTransfert Déclaration=user.getEntreprise().getDéclarationPrixDeTransfert();
        	XMLDocument XMLDocument =Déclaration.getXMLDocument();
        	if(XMLDocument==null) {
        		
        		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("vous n'avez pas une déclaration");
        		
        	}
        	String xmlContent = XMLDocument.getXMLContent();
			/*
			 * return ResponseEntity.ok() .header(HttpHeaders.CONTENT_DISPOSITION,
			 * "attachment; filename=\"prix_transfert.xml\"")
			 * .contentType(MediaType.APPLICATION_XML) .body(xmlContent);
			 * com.PrixDeTransfert.Backend.structureXML.GenerationXML.PrixTransfert
			 * prixTransfert = createPrixTransfert(id); // Méthode à définir pour créer et
			 * remplir l'objet XmlMapper xmlMapper = new XmlMapper();
			 * xmlMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
			 * xmlMapper.setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE
			 * ); StringWriter writer = new StringWriter(); xmlMapper.writeValue(writer,
			 * prixTransfert);
			 * 
			 * String xmlContent = writer.toString();
			 */
            return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"prix_transfert.xml\"")
                .contentType(MediaType.APPLICATION_XML)
                .body(xmlContent);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error generating XML: " + e.getMessage());
        }
    
	    }
	 @PostMapping("/update/xml")
	    public ResponseEntity<String> updateXml(@RequestBody XMLDocument xmlDocument, HttpSession session) {
	        try {
	        	Long id =userController.iduser;
	        	User user=InterfaceRepositoryUser.findUserById(id);
	        	DéclarationPrixDeTransfert Déclaration=user.getEntreprise().getDéclarationPrixDeTransfert();
	        	XMLDocument XMLDocument =Déclaration.getXMLDocument();
	        	if(XMLDocument==null) {
	        		
	        		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("vous n'avez pas une déclaration");
	        		
	        	}

	            
	            XMLDocument.setXMLContent(xmlDocument.getXMLContent());
	            user.getEntreprise().getDéclarationPrixDeTransfert().setXMLDocument(XMLDocument);
                 
                 InterfaceRepositoryUser.save(user);

	            return ResponseEntity.ok("Le contenu XML a été mis à jour avec succès");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la mise à jour du XML : " + e.getMessage());
	        }
	    }
	 @GetMapping("/view")
	    public ResponseEntity<String> viewXml(HttpSession session) {
		 Long id =userController.iduser;
     	User user=InterfaceRepositoryUser.findUserById(id);
     	DéclarationPrixDeTransfert Déclaration=user.getEntreprise().getDéclarationPrixDeTransfert();
     	XMLDocument XMLDocument =Déclaration.getXMLDocument();
     	
	            return ResponseEntity.ok(XMLDocument.getXMLContent());
	 }
	 
	 @GetMapping("/generate")
	    public ResponseEntity<String> generateXml(HttpSession session) {
	        try {
	            Long id = userController.iduser;
	            User user = InterfaceRepositoryUser.findUserById(id);
	           

	            
	            PrixTransfert prixTransfert = createPrixTransfert(id);

	            
	            XmlMapper xmlMapper = new XmlMapper();
	            xmlMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
	            xmlMapper.setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE);
	            StringWriter writer = new StringWriter();
	            xmlMapper.writeValue(writer, prixTransfert);
	            String xmlContent = writer.toString();

	            
	            DéclarationPrixDeTransfert declaration = user.getEntreprise().getDéclarationPrixDeTransfert();
	            
	            declaration.setXMLDocument(new XMLDocument());
	            
	            declaration.getXMLDocument().setXMLContent(xmlContent);
	            
	            
	            InterfaceRepositoryUser.save(user);

	            return ResponseEntity.ok("Le fichier XML a été généré avec succès et enregistré dans l'objet XMLDocument associé à l'utilisateur.");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la génération et de l'enregistrement du fichier XML : " + e.getMessage());
	        }
	    }
	


	    private PrixTransfert createPrixTransfert(Long id) {
	    	
	    	PrixTransfert prixTransfert = new PrixTransfert();
	    	Entreprise Entreprise=InterfaceRepositoryCreerCompte.findEntrepriseById(id);
	    	DéclarationPrixDeTransfert DéclarationPrixDeTransfert=Entreprise.getDéclarationPrixDeTransfert();
	        prixTransfert.setEntete(new Entete());
	        prixTransfert.getEntete().setCodeActe(DéclarationPrixDeTransfert.getCodeActe());
	        prixTransfert.getEntete().setExercice(DéclarationPrixDeTransfert.getExercice());
	        prixTransfert.getEntete().setMatriculeFiscalDeclarant(DéclarationPrixDeTransfert.getMatriculeFiscalDeclarant());
	        prixTransfert.getEntete().setCodeTVA(DéclarationPrixDeTransfert.getCodeTva());
	        prixTransfert.getEntete().setCodeCategorie(DéclarationPrixDeTransfert.getCodeCatégorie());
	        prixTransfert.getEntete().setTypeDeclaration(DéclarationPrixDeTransfert.getTypeDéclaration());
	        prixTransfert.getEntete().setDateDebutExercice(DéclarationPrixDeTransfert.getDateDébutExercice());
	        prixTransfert.getEntete().setDateFinExercice(new DateFinExercice());
	        prixTransfert.getEntete().getDateFinExercice().setNatureDateFin(1);
	        prixTransfert.getEntete().getDateFinExercice().setValue(DéclarationPrixDeTransfert.getDateFinExercice());
	       
	        IdentificationEntrepriseDeclarante ident = new IdentificationEntrepriseDeclarante();
	        ident.setRaisonSociale(Entreprise.getRaisonSocial());
	        ident.setFormeJuridique(Entreprise.getFormeJuridique());
	        ident.setNationalite(Entreprise.getNationalite());
	        ident.setAdresseSiegeSocialEtablissementTunisie(Entreprise.getAdresseSiegeSocialEtablissementTunisie());
	        ident.setCodePostal(Entreprise.getCodePostal());
	        ident.setActivitePrincipale(Entreprise.getActivitePrincipale());
	        ident.setActiviteSecondaire(Entreprise.getActiviteSecondaire());
	        ident.setChiffreAffaireAnnuel(Entreprise.getChiffreAffaireAnnuel());

	        prixTransfert.setIdentificationEntrepriseDeclarante(ident);
	        
	        
	        InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclaranteBD= DéclarationPrixDeTransfert.getInformationsEntrepriseDeclarante();
	        InformationsEntrepriseDeclarante infos = new InformationsEntrepriseDeclarante();
	        QualiteEntrepriseDeclarante qualite = new QualiteEntrepriseDeclarante();
	        List<Qualité> qualitésInformations = InformationsEntrepriseDeclaranteBD.getQualité();
	        List<Integer> qualites = new ArrayList<>();
	        if (qualitésInformations !=null && !qualitésInformations.isEmpty() ) {
	        for (int i = 0; i < qualitésInformations.size(); i++) {
	            
	            Qualité qualité = qualitésInformations.get(i); 
	            qualites.add(qualité.getQualité()); 
	            
	        }
	        infos.setQualiteEntrepriseDeclarante(qualite);
	        infos.getQualiteEntrepriseDeclarante().setQualites(qualites);
	        }else {infos.setQualiteEntrepriseDeclarante(qualite);
	        	infos.getQualiteEntrepriseDeclarante().setAutreQualite(InformationsEntrepriseDeclaranteBD.getAutreQualité());
	        }
	        infos.setDescriptionActivitesPrincipales(InformationsEntrepriseDeclaranteBD.getDescriptionActivitesPrincipales());
	        
	        infos.setChangementsActiviteAuCoursExercice(new ChangementsActiviteAuCoursExercice());
	        infos.getChangementsActiviteAuCoursExercice().setAffirmation(InformationsEntrepriseDeclaranteBD.getChangementsActiviteAucoursExercice().getAffirmation());
	        infos.getChangementsActiviteAuCoursExercice().setDescription(InformationsEntrepriseDeclaranteBD.getChangementsActiviteAucoursExercice().getDescription());
	        
	        LiensCapital liensCapital = new LiensCapital();
	       
	        List<LigneParticipationLieeBD> LigneParticipationLieeBD=InformationsEntrepriseDeclaranteBD.getLigneParticipationLiee();
	        List<LigneParticipationLiee> Liste =new ArrayList<>();
	        for (int i=0; i < LigneParticipationLieeBD.size();i++) {
	        	LigneParticipationLiee LigneparticipationLiee = new LigneParticipationLiee();
		        IdentifiantEntreprise identifiant = new IdentifiantEntreprise();
		        QualiteEntreprise qualitee = new QualiteEntreprise();
	        if(LigneParticipationLieeBD.get(i).getMatriculeFiscal()!=null  && !LigneParticipationLieeBD.get(i).getMatriculeFiscal().isEmpty()) {
	        identifiant.setMatriculeFiscal(LigneParticipationLieeBD.get(i).getMatriculeFiscal());
	        }
	        else  {identifiant.setAutreIdentifiant(new AutreIdentifiant());
	        	identifiant.getAutreIdentifiant().setEtatTerritoire(LigneParticipationLieeBD.get(i).getEtatTerritoire());
	        identifiant.getAutreIdentifiant().setIdentifiant(LigneParticipationLieeBD.get(i).getIdentifiant());
	        }
	        LigneparticipationLiee.setIdentifiantEntreprise(identifiant);
	        LigneparticipationLiee.setRaisonSociale(LigneParticipationLieeBD.get(i).getRaisonSociale());
	        if (LigneParticipationLieeBD.get(i).getQualité()!=null &&  !LigneParticipationLieeBD.get(i).getQualité().isEmpty()) {
	        	qualitee.setQualite(Integer.parseInt(LigneParticipationLieeBD.get(i).getQualité()));
	        	
	        }
	        else {
	        	qualitee.setAutreQualité(LigneParticipationLieeBD.get(i).getAutreQualité());
	        } 
	        LigneparticipationLiee.setQualiteEntreprise(qualitee);
	        LigneparticipationLiee.setPourcentageDetentionCapital(LigneParticipationLieeBD.get(i).getPourcentageDetentionCapital());
	        LigneparticipationLiee.setPourcentageDetentionDroitsVote(LigneParticipationLieeBD.get(i).getPourcentageDetentionDroitsVote());
	        Liste.add(LigneparticipationLiee);
	        }
	        liensCapital.setParticipationLiee(Liste);
	        
	        List<LigneParticipationDeclaranteBD> LigneParticipationDeclaranteBD=InformationsEntrepriseDeclaranteBD.getLigneParticipationDeclarante();
	        List<LigneParticipationDeclarante> ListeDeclarante =new ArrayList<>();
	        for (int i=0; i <LigneParticipationDeclaranteBD.size();i++) {
	        	LigneParticipationDeclarante LigneparticipationDeclarante = new LigneParticipationDeclarante();
		        IdentifiantEntreprise identifiantDeclarant = new IdentifiantEntreprise();
		        QualiteEntreprise qualiteDeclarante = new QualiteEntreprise();
		        if(LigneParticipationDeclaranteBD.get(i).getMatriculeFiscal()!=null && !LigneParticipationDeclaranteBD.get(i).getMatriculeFiscal().isEmpty()) {
			        identifiantDeclarant.setMatriculeFiscal(LigneParticipationDeclaranteBD.get(i).getMatriculeFiscal());
			        }
			        else  {identifiantDeclarant.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantDeclarant.getAutreIdentifiant().setEtatTerritoire(LigneParticipationDeclaranteBD.get(i).getEtatTerritoire());
			        identifiantDeclarant.getAutreIdentifiant().setIdentifiant(LigneParticipationDeclaranteBD.get(i).getIdentifiant());
			        }
	        
		        LigneparticipationDeclarante.setIdentifiantEntreprise(identifiantDeclarant);
		        LigneparticipationDeclarante.setRaisonSociale(LigneParticipationDeclaranteBD.get(i).getRaisonSociale());
	        
		        if (LigneParticipationDeclaranteBD.get(i).getQualité()!=null &&  !LigneParticipationDeclaranteBD.get(i).getQualité().isEmpty()) {
		        	qualiteDeclarante.setQualite(Integer.parseInt(LigneParticipationDeclaranteBD.get(i).getQualité()));
		        	
		        }
		        else {
		        	qualiteDeclarante.setAutreQualité(LigneParticipationDeclaranteBD.get(i).getAutreQualité());
		        }
	        LigneparticipationDeclarante.setQualiteEntreprise(qualiteDeclarante);
	        LigneparticipationDeclarante.setPourcentageDetentionCapital(LigneParticipationDeclaranteBD.get(i).getPourcentageDetentionCapital());
	        LigneparticipationDeclarante.setPourcentageDetentionDroitsVote(LigneParticipationDeclaranteBD.get(i).getPourcentageDetentionDroitsVote());
	        
	        ListeDeclarante.add(LigneparticipationDeclarante);
	        }
	        liensCapital.setParticipationDeclarante(ListeDeclarante);
	        ModificationLiensCapitalAuCoursExerciceBD ModificationLiensCapitalAuCoursExerciceBD=InformationsEntrepriseDeclaranteBD.getModificationLiensCapitalAuCoursExercice();
	        ModificationLiensCapitalAuCoursExercice ModificationLiensCapitalAuCoursExercice=new ModificationLiensCapitalAuCoursExercice();
	        ModificationLiensCapitalAuCoursExercice.setAffirmation(ModificationLiensCapitalAuCoursExerciceBD.getAffirmation());
	        ModificationLiensCapitalAuCoursExercice.setDescription(ModificationLiensCapitalAuCoursExerciceBD.getDescription());
	        liensCapital.setModificationLiensCapitalAuCoursExercice(ModificationLiensCapitalAuCoursExercice);
	        
	        infos.setLiensCapital(liensCapital);
	        prixTransfert.setInformationsEntrepriseDeclarante(infos);
             InformationsGroupeEntreprisesBD InformationsGroupeEntreprisesBD =DéclarationPrixDeTransfert.getInformationsGroupeEntreprises();
             InformationsMereEntiteUltimeBD InformationsMereEntiteUltimeBD=InformationsGroupeEntreprisesBD.getInformationsMereEntiteUltime();
	        InformationsGroupeEntreprises InformationsGroupeEntreprises =new InformationsGroupeEntreprises();
	        InformationsEntiteMereUltime InformationsEntiteMereUltime =new InformationsEntiteMereUltime();
	        IdentifiantEntreprise IdentifiantEntreprise =new IdentifiantEntreprise();
	        if(InformationsMereEntiteUltimeBD.getMatriculeFiscal()!=null && !InformationsMereEntiteUltimeBD.getMatriculeFiscal().isEmpty()) {
	        	IdentifiantEntreprise.setMatriculeFiscal(InformationsMereEntiteUltimeBD.getMatriculeFiscal());
	        	}else {
	        		IdentifiantEntreprise.setAutreIdentifiant(new AutreIdentifiant());
	        		IdentifiantEntreprise.getAutreIdentifiant().setEtatTerritoire(InformationsMereEntiteUltimeBD.getEtatTerritoire());;
	        		IdentifiantEntreprise.getAutreIdentifiant().setIdentifiant(InformationsMereEntiteUltimeBD.getIdentifiant());
	        	}
	        InformationsEntiteMereUltime.setIdentifiantEntreprise(IdentifiantEntreprise);
	        InformationsEntiteMereUltime.setAdresseSiegeSocial(InformationsMereEntiteUltimeBD.getAdresseSiegeSocial());
	        InformationsEntiteMereUltime.setRaisonSociale(InformationsMereEntiteUltimeBD.getRaisonSociale());
	        InformationsGroupeEntreprises.setInformationsEntiteMereUltime(InformationsEntiteMereUltime);
	        InformationsGroupeEntreprises.setDescriptionPrincipalesActivites(InformationsGroupeEntreprisesBD.getDescriptionPrincipalesActivites());
	       InformationsGroupeEntreprises.setDescriptionGeneralePolitiquePrixTransfert(InformationsGroupeEntreprisesBD.getDescriptionGeneralePolitiquePrixTransfert());
	       
	       
	       
	       
	       
	       
	       List<LigneActifInCorporelBD> LigneActifIncorporelBD=InformationsGroupeEntreprisesBD.getLigneActifInCorporel();
	        List<LigneActifIncorporel> ListeIncorporel =new ArrayList<>();
	        for (int i=0; i <LigneActifIncorporelBD.size();i++) {
	        	LigneActifIncorporel LigneActifIncorporel = new LigneActifIncorporel();
		        IdentifiantEntreprise identifiantIncorporel = new IdentifiantEntreprise();
		        QualiteEntreprise qualiteIncorporel = new QualiteEntreprise();
		        if(LigneActifIncorporelBD.get(i).getMatriculeFiscal()!=null && !LigneActifIncorporelBD.get(i).getMatriculeFiscal().isEmpty()) {
			        identifiantIncorporel.setMatriculeFiscal(LigneActifIncorporelBD.get(i).getMatriculeFiscal());
			        }
			        else  {identifiantIncorporel.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantIncorporel.getAutreIdentifiant().setEtatTerritoire(LigneActifIncorporelBD.get(i).getEtatTerritoire());
			        identifiantIncorporel.getAutreIdentifiant().setIdentifiant(LigneActifIncorporelBD.get(i).getIdentifiant());
			        }
	        
		        LigneActifIncorporel.setIdentifiantEntreprise(identifiantIncorporel);
		        LigneActifIncorporel.setRaisonSociale(LigneActifIncorporelBD.get(i).getRaisonSociale());
	        
		        if (LigneActifIncorporelBD.get(i).getQualite()!=null &&  !LigneActifIncorporelBD.get(i).getQualite().isEmpty()) {
		        	qualiteIncorporel.setQualite(Integer.parseInt(LigneActifIncorporelBD.get(i).getQualite()));
		        	
		        }
		        else {
		        	qualiteIncorporel.setAutreQualité(LigneActifIncorporelBD.get(i).getAutrequalité());
		        }
	        LigneActifIncorporel.setQualiteEntreprise(qualiteIncorporel);
	        
	        LigneActifIncorporel.setActifIncorporel(new ActifIncorporel());
	        if(LigneActifIncorporelBD.get(i).getNatureActifIncorporel() != null && !LigneActifIncorporelBD.get(i).getNatureActifIncorporel().isEmpty()) {
	        LigneActifIncorporel.getActifIncorporel().setNatureActifIncorporel(LigneActifIncorporelBD.get(i).getNatureActifIncorporel());}else {
	        	LigneActifIncorporel.getActifIncorporel().setAutreNatureActifIncorporel(LigneActifIncorporelBD.get(i).getAutreNatureActifIncorporel());
	        }
	       
	        LigneActifIncorporel.setOnereuxGratuit(LigneActifIncorporelBD.get(i).getOnreuxGratuit());
	        LigneActifIncorporel.setNatureRelationEntreprise(new NatureRelationEntreprise());
	        if (LigneActifIncorporelBD.get(i).getNatureRelation() !=null && !LigneActifIncorporelBD.get(i).getNatureRelation().isEmpty()){
	        	LigneActifIncorporel.getNatureRelationEntreprise().setNatureRelation(LigneActifIncorporelBD.get(i).getNatureRelation());
	        }else {
	        LigneActifIncorporel.getNatureRelationEntreprise().setAutreNatureRelation(LigneActifIncorporelBD.get(i).getAutreNatureRelation());}
	        ListeIncorporel.add(LigneActifIncorporel);
	        }
	       
	       InformationsGroupeEntreprises.setListeActifsIncorporels(ListeIncorporel);
	       
	       List<LigneActifCorporelBD> LigneActifcorporelBD=InformationsGroupeEntreprisesBD.getLigneActifCorporel();
	        List<LigneActifCorporel> Listecorporel =new ArrayList<>();
	        for (int i=0; i <LigneActifcorporelBD.size();i++) {
	        	LigneActifCorporel LigneActifCorporel = new LigneActifCorporel();
		        IdentifiantEntreprise identifiantcorporel = new IdentifiantEntreprise();
		        QualiteEntreprise qualitecorporel = new QualiteEntreprise();
		        if(LigneActifcorporelBD.get(i).getMatriculeFiscal()!=null) {
			        identifiantcorporel.setMatriculeFiscal(LigneActifcorporelBD.get(i).getMatriculeFiscal());
			        }
			        else  {identifiantcorporel.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantcorporel.getAutreIdentifiant().setEtatTerritoire(LigneActifcorporelBD.get(i).getEtatTerritoire());
			        identifiantcorporel.getAutreIdentifiant().setIdentifiant(LigneActifcorporelBD.get(i).getIdentifiant());
			        }
	        
		        LigneActifCorporel.setIdentifiantEntreprise(identifiantcorporel);
		        LigneActifCorporel.setRaisonSociale(LigneActifcorporelBD.get(i).getRaisonSociale());
	        
		        if (LigneActifcorporelBD.get(i).getQualite()!=null &&  !LigneActifcorporelBD.get(i).getQualite().isEmpty()) {
		        	qualitecorporel.setQualite(Integer.parseInt(LigneActifcorporelBD.get(i).getQualite()));
		        	
		        }
		        else {
		        	qualitecorporel.setAutreQualité(LigneActifcorporelBD.get(i).getAutrequalité());
		        }
	        LigneActifCorporel.setQualiteEntreprise(qualitecorporel);
	        
	        LigneActifCorporel.setActifcorporel(new Actifcorporel());
	        if(LigneActifcorporelBD.get(i).getNatureActifcorporel()!=null && !LigneActifcorporelBD.get(i).getNatureActifcorporel().isEmpty()) {
	        LigneActifCorporel.getActifcorporel().setNatureActifcorporel(LigneActifcorporelBD.get(i).getNatureActifcorporel());}
	        else {
	        LigneActifCorporel.getActifcorporel().setAutreNatureActifcorporel(LigneActifcorporelBD.get(i).getAutreNatureActifcorporel());}
	        
	        LigneActifCorporel.setNatureRelationEntreprise(new NatureRelationEntreprise());
	        if(LigneActifcorporelBD.get(i).getNatureRelation() != null && !LigneActifcorporelBD.get(i).getNatureRelation().isEmpty()) {
	        	LigneActifCorporel.getNatureRelationEntreprise().setNatureRelation(LigneActifcorporelBD.get(i).getNatureRelation());
	        }else {
	        LigneActifCorporel.getNatureRelationEntreprise().setAutreNatureRelation(LigneActifcorporelBD.get(i).getAutreNatureRelation());
	        }
	        Listecorporel.add(LigneActifCorporel);
	        }
	       
	       InformationsGroupeEntreprises.setListeActifsCorporels(Listecorporel);;
	       prixTransfert.setInformationsGroupeEntreprises(InformationsGroupeEntreprises);
	       
	        
	       InformationsOperationsBD InformationsOperationsBD=DéclarationPrixDeTransfert.getInformationsOperations();
	       InformationsOperations InformationsOperations=new InformationsOperations();
	       MontantTransactionsMethodeDeterminationPrixTransfertBD MontantTransactionsMethodeDeterminationPrixTransfertBD=InformationsOperationsBD.getMontantTransactionsMethodeDeterminationPrixTransfert();
	       MontantTransactionsMethodeDeterminationPrixTransfert MontantTransactionsMethodeDeterminationPrixTransfert=new MontantTransactionsMethodeDeterminationPrixTransfert();
	       InformationsValeursExploitationBD InformationsValeursExploitationBD=MontantTransactionsMethodeDeterminationPrixTransfertBD.getInformationsValeursExploitation();
	       InformationsValeursExploitation  InformationsValeursExploitation =new InformationsValeursExploitation() ;
	       InformationsRemunerationsBiensCorporelsIncorporels InformationsRemunerationsBiensCorporelsIncorporels =new InformationsRemunerationsBiensCorporelsIncorporels() ;
	       
	       List <LigneValeurExploitationBD> LigneValeurExploitationBD =InformationsValeursExploitationBD.getLigneValeurExploitation();
	       List<LigneValeurExploitation> ListeValeur =new ArrayList<>();
	       for (int j=0;j<LigneValeurExploitationBD.size();j++) {
	    	   LigneValeurExploitation LigneValeurExploitation=new LigneValeurExploitation();
	    	   
		        IdentifiantEntreprise identifiantValeur = new IdentifiantEntreprise();
		        QualiteEntreprise qualiteValeur = new QualiteEntreprise();
		        if(LigneValeurExploitationBD.get(j).getMatriculeFiscal()!=null && !LigneValeurExploitationBD.get(j).getMatriculeFiscal().isEmpty()) {
			        identifiantValeur.setMatriculeFiscal(LigneValeurExploitationBD.get(j).getMatriculeFiscal());
			        }
			        else  {identifiantValeur.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantValeur.getAutreIdentifiant().setEtatTerritoire(LigneValeurExploitationBD.get(j).getEtatTerritoire());
			        identifiantValeur.getAutreIdentifiant().setIdentifiant(LigneValeurExploitationBD.get(j).getIdentifiant());
			        }
		        LigneValeurExploitation.setIdentifiantEntreprise(identifiantValeur);
		        if (LigneValeurExploitationBD.get(j).getQualite()!=null &&  !LigneValeurExploitationBD.get(j).getQualite().isEmpty()) {
		        	qualiteValeur.setQualite(Integer.parseInt(LigneValeurExploitationBD.get(j).getQualite()));
		        	
		        }
		        else {
		        	qualiteValeur.setAutreQualité(LigneValeurExploitationBD.get(j).getAutreQualite());
		        }
		        LigneValeurExploitation.setQualiteEntreprise(qualiteValeur);
		        LigneValeurExploitation.setNatureOperationValeurExploitation(new NatureOperationValeurExploitation());
		        if (LigneValeurExploitationBD.get(j).getNatureOperation()!=null && !LigneValeurExploitationBD.get(j).getNatureOperation().isEmpty()){
		        LigneValeurExploitation.getNatureOperationValeurExploitation().setNatureOperation(LigneValeurExploitationBD.get(j).getNatureOperation());}
		        else {
		        LigneValeurExploitation.getNatureOperationValeurExploitation().setAutreNatureOperation(LigneValeurExploitationBD.get(j).getAutreNatureOperation());
		        }
		        LigneValeurExploitation.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        if(LigneValeurExploitationBD.get(j).getNatureRelation()!=null && !LigneValeurExploitationBD.get(j).getNatureRelation().isEmpty()) {
		        LigneValeurExploitation.getNatureRelationEntreprise().setNatureRelation(LigneValeurExploitationBD.get(j).getNatureRelation());}
		        else {
		        LigneValeurExploitation.getNatureRelationEntreprise().setAutreNatureRelation(LigneValeurExploitationBD.get(j).getAutreNatureRelation());}
		        
		        LigneValeurExploitation.setAchatsDepenses(LigneValeurExploitationBD.get(j).getAchatsDepenses());
		        LigneValeurExploitation.setRaisonSociale(LigneValeurExploitationBD.get(j).getRaisonSociale());
		        LigneValeurExploitation.setVentesRevenus(LigneValeurExploitationBD.get(j).getVentesRevenus());
		        LigneValeurExploitation.setMethodePrixTransfert(new MethodePrixTransfert());
		        if(LigneValeurExploitationBD.get(j).getMethodeDeterminationPrixTransfert()!=null && !LigneValeurExploitationBD.get(j).getMethodeDeterminationPrixTransfert().isEmpty()) {
		        LigneValeurExploitation.getMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneValeurExploitationBD.get(j).getMethodeDeterminationPrixTransfert());}
		        else {
		        LigneValeurExploitation.getMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneValeurExploitationBD.get(j).getAutreMethodeDeterminationPrixTransfert());}
		        
		        LigneValeurExploitation.setChangementMethodePrixTransfert(new ChangementMethodePrixTransfert() );
		        if(LigneValeurExploitationBD.get(j).getChangementMethodeDeterminationPrixTransfert()!=null && !LigneValeurExploitationBD.get(j).getChangementMethodeDeterminationPrixTransfert().isEmpty()) {
		        LigneValeurExploitation.getChangementMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneValeurExploitationBD.get(j).getChangementMethodeDeterminationPrixTransfert());}
		        else {
		        LigneValeurExploitation.getChangementMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneValeurExploitationBD.get(j).getChnagementAutreMethodeDeterminationPrixTransfert());;
		        
		        
		        }
		        
		        ListeValeur.add(LigneValeurExploitation);
	       }
	       
	       InformationsValeursExploitation.setValeursExploitation(ListeValeur);
	       InformationsValeursExploitation.setTotalAchatsDepensesValeursExploitation(InformationsValeursExploitationBD.getTotalAchatsDepensesValeursExploitation());
	       InformationsValeursExploitation.setTotalVentesRevenusValeursExploitation(InformationsValeursExploitationBD.getTotalVentesRevenusValeursExploitation());
	       
	       
	       
	       
	       
	       InformationsRemunerationsBiensCorporelsIncorporelsBD InformationsRemunerationsBiensCorporelsIncorporelsBD=MontantTransactionsMethodeDeterminationPrixTransfertBD.getInformationsRemunerationsBiensCorporelsIncorporels();
	      
	       List<LigneRemunerationBiensBD> LigneRemunerationBiensBD=InformationsRemunerationsBiensCorporelsIncorporelsBD.getLigneRemunerationBiens();
	       List<LigneRemunerationsBiens> ListeRemunerations =new ArrayList<>();
	       
	       
	       for(int k=0 ;k<LigneRemunerationBiensBD.size();k++) {
	    	   LigneRemunerationsBiens LigneRemunerationBiens=new LigneRemunerationsBiens();
	    	   IdentifiantEntreprise identifiantRemunerations = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteRemunerations = new QualiteEntreprise();
		        if(LigneRemunerationBiensBD.get(k).getMatriculeFiscal()!=null && !LigneRemunerationBiensBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantRemunerations.setMatriculeFiscal(LigneRemunerationBiensBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantRemunerations.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantRemunerations.getAutreIdentifiant().setEtatTerritoire(LigneRemunerationBiensBD.get(k).getEtatTerritoire());
			        identifiantRemunerations.getAutreIdentifiant().setIdentifiant(LigneRemunerationBiensBD.get(k).getIdentifiant());
			        }
		        LigneRemunerationBiens.setIdentifiantEntreprise(identifiantRemunerations);
		        if (LigneRemunerationBiensBD.get(k).getQualite()!=null &&  !LigneRemunerationBiensBD.get(k).getQualite().isEmpty()) {
		        	qualiteRemunerations.setQualite(Integer.parseInt(LigneRemunerationBiensBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteRemunerations.setAutreQualité(LigneRemunerationBiensBD.get(k).getAutreQualite());
		        }
		        LigneRemunerationBiens.setQualiteEntreprise(qualiteRemunerations);
		        LigneRemunerationBiens.setNatureOperationRemunerationBiens(new NatureOperationRemunerationBiens());
		        if(LigneRemunerationBiensBD.get(k).getNatureOperation()!=null && !LigneRemunerationBiensBD.get(k).getNatureOperation().isEmpty()) {
		        LigneRemunerationBiens.getNatureOperationRemunerationBiens().setNatureOperation(LigneRemunerationBiensBD.get(k).getNatureOperation());}
		        else {
		        LigneRemunerationBiens.getNatureOperationRemunerationBiens().setAutreNatureOperation(LigneRemunerationBiensBD.get(k).getAutreNatureOperation());}
		        
		        LigneRemunerationBiens.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        if (LigneRemunerationBiensBD.get(k).getNatureRelation()!=null && !LigneRemunerationBiensBD.get(k).getNatureRelation().isEmpty()) {
		        LigneRemunerationBiens.getNatureRelationEntreprise().setNatureRelation(LigneRemunerationBiensBD.get(k).getNatureRelation());}
		        else {
		        LigneRemunerationBiens.getNatureRelationEntreprise().setAutreNatureRelation(LigneRemunerationBiensBD.get(k).getAutreNatureRelation());}
		        
		        LigneRemunerationBiens.setAchatsDepenses(LigneRemunerationBiensBD.get(k).getAchatsDepenses());
		        LigneRemunerationBiens.setRaisonSociale(LigneRemunerationBiensBD.get(k).getRaisonSociale());
		        LigneRemunerationBiens.setVentesRevenus(LigneRemunerationBiensBD.get(k).getVentesRevenus());
		        LigneRemunerationBiens.setMethodePrixTransfert(new MethodePrixTransfert());
		        if(LigneRemunerationBiensBD.get(k).getMethodeDeterminationPrixTransfert()!=null && !LigneRemunerationBiensBD.get(k).getMethodeDeterminationPrixTransfert().isEmpty()) {
		        LigneRemunerationBiens.getMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneRemunerationBiensBD.get(k).getMethodeDeterminationPrixTransfert());}
		        else {
		        LigneRemunerationBiens.getMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneRemunerationBiensBD.get(k).getAutreMethodeDeterminationPrixTransfert());}
		       
		        LigneRemunerationBiens.setChangementMethodePrixTransfert(new ChangementMethodePrixTransfert() );
		        if(LigneRemunerationBiensBD.get(k).getChangementMethodeDeterminationPrixTransfert() !=null && !LigneRemunerationBiensBD.get(k).getChangementMethodeDeterminationPrixTransfert().isEmpty()) {
		        LigneRemunerationBiens.getChangementMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneRemunerationBiensBD.get(k).getChangementMethodeDeterminationPrixTransfert());}
		        else {
		        LigneRemunerationBiens.getChangementMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneRemunerationBiensBD.get(k).getChnagementAutreMethodeDeterminationPrixTransfert());}
		        
		        
		        
		        
		        ListeRemunerations.add(LigneRemunerationBiens);
	       
	       }
	       
	       InformationsRemunerationsBiensCorporelsIncorporels.setRemunerationsBiensCorporelsIncorporels(ListeRemunerations);
	       InformationsRemunerationsBiensCorporelsIncorporels.setTotalAchatsDepensesRemunerationsBiensCorporelsIncorporels(InformationsRemunerationsBiensCorporelsIncorporelsBD.getTotalAchatsDepensesRemunerationsBiensCorporelsIncorporels());
	       InformationsRemunerationsBiensCorporelsIncorporels.setTotalVentesRevenusRemunerationsBiensCorporelsIncorporels(InformationsRemunerationsBiensCorporelsIncorporelsBD.getTotalVentesRevenusRemunerationsBiensCorporelsIncorporels());
	       MontantTransactionsMethodeDeterminationPrixTransfert.setInformationsRemunerationsBiensCorporelsIncorporels(InformationsRemunerationsBiensCorporelsIncorporels);
	       MontantTransactionsMethodeDeterminationPrixTransfert.setInformationsValeursExploitation(InformationsValeursExploitation);
	       InformationsOperations.setMontantTransactionsMethodeDeterminationPrixTransfert(MontantTransactionsMethodeDeterminationPrixTransfert);
	       
	       prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       
	       InformationsServices InformationsServices =new InformationsServices();
	       InformationsServicesBD InformationsServicesBD=MontantTransactionsMethodeDeterminationPrixTransfertBD.getInformationsServices();
	       InformationsServices.setTotalAchatsDepensesServices(InformationsServicesBD.getTotalAchatsDepensesServices());
	       InformationsServices.setTotalVentesRevenusServices(InformationsServicesBD.getTotalAchatsDepensesServices());
	       List<LigneServiceBD> LigneServiceBD=InformationsServicesBD.getLigneService();
	       List<LigneService> ListeService =new ArrayList<>();
	       for(int k=0;k<LigneServiceBD.size();k++) {
	    	   LigneService LigneService =new LigneService();
	    	   IdentifiantEntreprise identifiantService = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteService = new QualiteEntreprise();
		        if(LigneServiceBD.get(k).getMatriculeFiscal()!=null && !LigneServiceBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantService.setMatriculeFiscal(LigneServiceBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantService.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantService.getAutreIdentifiant().setEtatTerritoire(LigneServiceBD.get(k).getEtatTerritoire());
			        identifiantService.getAutreIdentifiant().setIdentifiant(LigneServiceBD.get(k).getIdentifiant());
			        }
		        LigneService.setIdentifiantEntreprise(identifiantService);
		        if (LigneServiceBD.get(k).getQualite()!=null &&  !LigneServiceBD.get(k).getQualite().isEmpty()) {
		        	qualiteService.setQualite(Integer.parseInt(LigneServiceBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteService.setAutreQualité(LigneServiceBD.get(k).getAutreQualite());
		        }
		        LigneService.setQualiteEntreprise(qualiteService);
		        LigneService.setNatureOperationService(new NatureOperationService());
		        if(LigneServiceBD.get(k).getNatureOperation() !=null && !LigneServiceBD.get(k).getNatureOperation().isEmpty()) {
		        LigneService.getNatureOperationService().setNatureOperation(LigneServiceBD.get(k).getNatureOperation());}
		        else {
		        LigneService.getNatureOperationService().setAutreNatureOperation(LigneServiceBD.get(k).getAutreNatureOperation());}
		        
		        LigneService.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        if(LigneServiceBD.get(k).getNatureRelation() !=null && !LigneServiceBD.get(k).getNatureRelation().isEmpty()) {
		        LigneService.getNatureRelationEntreprise().setNatureRelation(LigneServiceBD.get(k).getNatureRelation());}
		        else {
		        LigneService.getNatureRelationEntreprise().setAutreNatureRelation(LigneServiceBD.get(k).getAutreNatureRelation());}
		       
		        LigneService.setAchatsDepenses(LigneServiceBD.get(k).getAchatsDepenses());
		        LigneService.setRaisonSociale(LigneServiceBD.get(k).getRaisonSociale());
		        LigneService.setVentesRevenus(LigneServiceBD.get(k).getVentesRevenus());
		        LigneService.setMethodePrixTransfert(new MethodePrixTransfert());
		        if(LigneServiceBD.get(k).getMethodeDeterminationPrixTransfert() !=null && !LigneServiceBD.get(k).getMethodeDeterminationPrixTransfert().isEmpty()) {
		        LigneService.getMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneServiceBD.get(k).getMethodeDeterminationPrixTransfert());}
		        else {
		        LigneService.getMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneServiceBD.get(k).getAutreMethodeDeterminationPrixTransfert());}
		        
		        LigneService.setChangementMethodePrixTransfert(new ChangementMethodePrixTransfert() );
		        if(LigneServiceBD.get(k).getChangementMethodeDeterminationPrixTransfert() !=null && !LigneServiceBD.get(k).getChangementMethodeDeterminationPrixTransfert().isEmpty()) {
		        LigneService.getChangementMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneServiceBD.get(k).getChangementMethodeDeterminationPrixTransfert());}
		        else {
		        LigneService.getChangementMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneServiceBD.get(k).getChnagementAutreMethodeDeterminationPrixTransfert());;
		        
		        
		        }
		        
	    	   ListeService.add(LigneService);
	       }
	       
	       InformationsServices.setServices(ListeService);
	       MontantTransactionsMethodeDeterminationPrixTransfert.setInformationsServices(InformationsServices);
	       InformationsOperations.setMontantTransactionsMethodeDeterminationPrixTransfert(MontantTransactionsMethodeDeterminationPrixTransfert);
	       prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       
	       
	       InformationsOperationsFinancieres InformationsOperationsFinancieres=new InformationsOperationsFinancieres();
	       InformationsOperationsFinancieresBD InformationsOperationsFinancieresBD=MontantTransactionsMethodeDeterminationPrixTransfertBD.getInformationsOperationsFinancieres();
	       InformationsOperationsFinancieres.setTotalAchatsDepensesOperationsFinancieres(InformationsOperationsFinancieresBD.getTotalAchatsDepensesOperationsFinancieres());
	       InformationsOperationsFinancieres.setTotalVentesRevenusOperationsFinancieres(InformationsOperationsFinancieresBD.getTotalVentesRevenusOperationsFinancieres());
	       List<LigneOperationFinanciereBD> LigneOperationFinanciereBD = InformationsOperationsFinancieresBD.getLigneOperationFinanciere();
	       List<LigneOperationFinanciere> ListeOperationF =new ArrayList<>();
	       
	        
	       for(int k=0;k<LigneOperationFinanciereBD.size();k++) {
	    	   LigneOperationFinanciere LigneOperationFinanciere =new LigneOperationFinanciere();
	    	   IdentifiantEntreprise identifiantOperationF = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteOperationF = new QualiteEntreprise();
		        if(LigneOperationFinanciereBD.get(k).getMatriculeFiscal()!=null && !LigneOperationFinanciereBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantOperationF.setMatriculeFiscal(LigneOperationFinanciereBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantOperationF.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantOperationF.getAutreIdentifiant().setEtatTerritoire(LigneOperationFinanciereBD.get(k).getEtatTerritoire());
			        identifiantOperationF.getAutreIdentifiant().setIdentifiant(LigneOperationFinanciereBD.get(k).getIdentifiant());
			        }
		        LigneOperationFinanciere.setIdentifiantEntreprise(identifiantOperationF);
		        if (LigneOperationFinanciereBD.get(k).getQualite()!=null &&  !LigneOperationFinanciereBD.get(k).getQualite().isEmpty()) {
		        	qualiteOperationF.setQualite(Integer.parseInt(LigneOperationFinanciereBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteOperationF.setAutreQualité(LigneOperationFinanciereBD.get(k).getAutreQualite());
		        }
		        LigneOperationFinanciere.setQualiteEntreprise(qualiteOperationF);
		        LigneOperationFinanciere.setNatureOperationFinanciere(new NatureOperationFinanciere());
		        if(LigneOperationFinanciereBD.get(k).getNatureOperation()!=null && !LigneOperationFinanciereBD.get(k).getNatureOperation().isEmpty()) {
		        LigneOperationFinanciere.getNatureOperationFinanciere().setNatureOperation(LigneOperationFinanciereBD.get(k).getNatureOperation());}
		        else {
		        LigneOperationFinanciere.getNatureOperationFinanciere().setAutreNatureOperation(LigneOperationFinanciereBD.get(k).getAutreNatureOperation());}
		        
		        LigneOperationFinanciere.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        if(LigneOperationFinanciereBD.get(k).getNatureRelation()!=null && !LigneOperationFinanciereBD.get(k).getNatureRelation().isEmpty()) {
		        LigneOperationFinanciere.getNatureRelationEntreprise().setNatureRelation(LigneOperationFinanciereBD.get(k).getNatureRelation());}
		        else {
		        LigneOperationFinanciere.getNatureRelationEntreprise().setAutreNatureRelation(LigneOperationFinanciereBD.get(k).getAutreNatureRelation());}
		      
		        LigneOperationFinanciere.setAchatsDepenses(LigneOperationFinanciereBD.get(k).getAchatsDepenses());
		        LigneOperationFinanciere.setRaisonSociale(LigneOperationFinanciereBD.get(k).getRaisonSociale());
		        LigneOperationFinanciere.setVentesRevenus(LigneOperationFinanciereBD.get(k).getVentesRevenus());
		        LigneOperationFinanciere.setMethodePrixTransfert(new MethodePrixTransfert());
		        if(LigneOperationFinanciereBD.get(k).getMethodeDeterminationPrixTransfert()!=null && !LigneOperationFinanciereBD.get(k).getMethodeDeterminationPrixTransfert().isEmpty()) {
		        LigneOperationFinanciere.getMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneOperationFinanciereBD.get(k).getMethodeDeterminationPrixTransfert());}
		        else {
		        LigneOperationFinanciere.getMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneOperationFinanciereBD.get(k).getAutreMethodeDeterminationPrixTransfert());}
		        
		        LigneOperationFinanciere.setChangementMethodePrixTransfert(new ChangementMethodePrixTransfert() );
		        if(LigneOperationFinanciereBD.get(k).getChangementMethodeDeterminationPrixTransfert()!=null && !LigneOperationFinanciereBD.get(k).getChangementMethodeDeterminationPrixTransfert().isEmpty()) {
		        LigneOperationFinanciere.getChangementMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneOperationFinanciereBD.get(k).getChangementMethodeDeterminationPrixTransfert());}
		        else {
		        LigneOperationFinanciere.getChangementMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneOperationFinanciereBD.get(k).getChnagementAutreMethodeDeterminationPrixTransfert());}
		        
		        
		        
		        
	    	   ListeOperationF.add(LigneOperationFinanciere);}
	       
	       InformationsOperationsFinancieres.setOperationsFinancieres(ListeOperationF);
	       MontantTransactionsMethodeDeterminationPrixTransfert.setInformationsOperationsFinancieres(InformationsOperationsFinancieres);
	       InformationsOperations.setMontantTransactionsMethodeDeterminationPrixTransfert(MontantTransactionsMethodeDeterminationPrixTransfert);
	       prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       
	       
	       
	       
	       
	       InformationsCessionsAcquisitionsActifs InformationsCessionsAcquisitionsActifs=new InformationsCessionsAcquisitionsActifs();
	       InformationsCessionsAcquisitionsActifsBD InformationsCessionsAcquisitionsActifsBD=MontantTransactionsMethodeDeterminationPrixTransfertBD.getInformationsCessionsAcquisitionsActifs();
	       InformationsCessionsAcquisitionsActifs.setTotalAchatsDepensesCessionsAcquisitionsActifs(InformationsCessionsAcquisitionsActifsBD.getTotalAchatsDepensesCessionsAcquisitionsActifs());
	       InformationsCessionsAcquisitionsActifs.setTotalVentesRevenusCessionsAcquisitionsActifs(InformationsCessionsAcquisitionsActifsBD.getTotalVentesRevenusCessionsAcquisitionsActifs()); 
	       List<LigneCessionAcquisitionActifBD> LigneCessionAcquisitionActifBD =InformationsCessionsAcquisitionsActifsBD.getLigneCessionAcquisitionActif();
	       List<LigneCessionAcquisitionActif> ListeCession =new ArrayList<>();
	       
	       for(int k=0;k<LigneCessionAcquisitionActifBD.size();k++) {
	    	   LigneCessionAcquisitionActif LigneCessionAcquisitionActif =new LigneCessionAcquisitionActif();
	    	   IdentifiantEntreprise identifiantCession = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteCession= new QualiteEntreprise();
		        if(LigneCessionAcquisitionActifBD.get(k).getMatriculeFiscal()!=null && !LigneCessionAcquisitionActifBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantCession.setMatriculeFiscal(LigneCessionAcquisitionActifBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantCession.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantCession.getAutreIdentifiant().setEtatTerritoire(LigneCessionAcquisitionActifBD.get(k).getEtatTerritoire());
			        identifiantCession.getAutreIdentifiant().setIdentifiant(LigneCessionAcquisitionActifBD.get(k).getIdentifiant());
			        }
		        LigneCessionAcquisitionActif.setIdentifiantEntreprise(identifiantCession);
		        if (LigneCessionAcquisitionActifBD.get(k).getQualite()!=null &&  !LigneCessionAcquisitionActifBD.get(k).getQualite().isEmpty()) {
		        	qualiteCession.setQualite(Integer.parseInt(LigneCessionAcquisitionActifBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteCession.setAutreQualité(LigneCessionAcquisitionActifBD.get(k).getAutreQualite());
		        }
		        LigneCessionAcquisitionActif.setQualiteEntreprise(qualiteCession);
		        LigneCessionAcquisitionActif.setNatureOperationCessionAcquisitionActif (new NatureOperationCessionAcquisitionActif ());
		        if(LigneCessionAcquisitionActifBD.get(k).getNatureOperation()!=null && !LigneCessionAcquisitionActifBD.get(k).getNatureOperation().isEmpty()) {
		        LigneCessionAcquisitionActif.getNatureOperationCessionAcquisitionActif ().setNatureOperation(LigneCessionAcquisitionActifBD.get(k).getNatureOperation());}
		        else {
		        LigneCessionAcquisitionActif.getNatureOperationCessionAcquisitionActif ().setAutreNatureOperation(LigneCessionAcquisitionActifBD.get(k).getAutreNatureOperation());}
		        
		        LigneCessionAcquisitionActif.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        if( LigneCessionAcquisitionActifBD.get(k).getNatureRelation()!=null && ! LigneCessionAcquisitionActifBD.get(k).getNatureRelation().isEmpty()) {
		        LigneCessionAcquisitionActif.getNatureRelationEntreprise().setNatureRelation( LigneCessionAcquisitionActifBD.get(k).getNatureRelation());}
		        else {
		        LigneCessionAcquisitionActif.getNatureRelationEntreprise().setAutreNatureRelation(LigneCessionAcquisitionActifBD.get(k).getAutreNatureRelation());}
		        
		        LigneCessionAcquisitionActif.setAchatsDepenses(LigneCessionAcquisitionActifBD.get(k).getAchatsDepenses());
		        LigneCessionAcquisitionActif.setRaisonSociale(LigneCessionAcquisitionActifBD.get(k).getRaisonSociale());
		        LigneCessionAcquisitionActif.setVentesRevenus(LigneCessionAcquisitionActifBD.get(k).getVentesRevenus());
		        LigneCessionAcquisitionActif.setMethodePrixTransfert(new MethodePrixTransfert());
		        if(LigneCessionAcquisitionActifBD.get(k).getMethodeDeterminationPrixTransfert()!=null && !LigneCessionAcquisitionActifBD.get(k).getMethodeDeterminationPrixTransfert().isEmpty()) {
		        LigneCessionAcquisitionActif.getMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneCessionAcquisitionActifBD.get(k).getMethodeDeterminationPrixTransfert());}
		        else {
		        LigneCessionAcquisitionActif.getMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneCessionAcquisitionActifBD.get(k).getAutreMethodeDeterminationPrixTransfert());}
		        
		        LigneCessionAcquisitionActif.setChangementMethodePrixTransfert(new ChangementMethodePrixTransfert() );
		        if(LigneCessionAcquisitionActifBD.get(k).getChangementMethodeDeterminationPrixTransfert()!=null && !LigneCessionAcquisitionActifBD.get(k).getChangementMethodeDeterminationPrixTransfert().isEmpty()) {
		        LigneCessionAcquisitionActif.getChangementMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneCessionAcquisitionActifBD.get(k).getChangementMethodeDeterminationPrixTransfert());}
		        else {
		        LigneCessionAcquisitionActif.getChangementMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneCessionAcquisitionActifBD.get(k).getChnagementAutreMethodeDeterminationPrixTransfert());}
		        
		        
		        
		        
	    	   ListeCession.add(LigneCessionAcquisitionActif);}
	       
	       InformationsCessionsAcquisitionsActifs.setCessionsAcquisitionsActifs(ListeCession);
	       
	       MontantTransactionsMethodeDeterminationPrixTransfert.setInformationsCessionsAcquisitionsActifs(InformationsCessionsAcquisitionsActifs);
	       InformationsOperations.setMontantTransactionsMethodeDeterminationPrixTransfert(MontantTransactionsMethodeDeterminationPrixTransfert);
	       prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       
	       
	       
	       
	       InformationsAutresOperations InformationsAutresOperations=new InformationsAutresOperations();
	       InformationsAutresOperationsBD InformationsAutresOperationsBD=MontantTransactionsMethodeDeterminationPrixTransfertBD.getInformationsAutresOperations();
	       InformationsAutresOperations.setTotalAchatsDepensesAutresOperations(InformationsAutresOperationsBD.getTotalAchatsDepensesAutresOperations());
	       InformationsAutresOperations.setTotalVentesRevenusAutresOperations(InformationsAutresOperationsBD.getTotalVentesRevenusAutresOperations()); 
	       List<LigneAutreOperationBD> LigneAutreOperationBD =InformationsAutresOperationsBD.getLigneAutreOperation();
	       List<LigneAutreOperation> ListeAutreOperation =new ArrayList<>();
	       
	       for(int k=0;k<LigneAutreOperationBD.size();k++) {
	    	   LigneAutreOperation LigneAutreOperation =new LigneAutreOperation();
	    	   IdentifiantEntreprise identifiantAutreOperation = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteAutreOperation= new QualiteEntreprise();
		        if(LigneAutreOperationBD.get(k).getMatriculeFiscal()!=null && !LigneAutreOperationBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantAutreOperation.setMatriculeFiscal(LigneAutreOperationBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantAutreOperation.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantAutreOperation.getAutreIdentifiant().setEtatTerritoire(LigneAutreOperationBD.get(k).getEtatTerritoire());
			        identifiantAutreOperation.getAutreIdentifiant().setIdentifiant(LigneAutreOperationBD.get(k).getIdentifiant());
			        }
		        LigneAutreOperation.setIdentifiantEntreprise(identifiantAutreOperation);
		        if (LigneAutreOperationBD.get(k).getQualite()!=null &&  !LigneAutreOperationBD.get(k).getQualite().isEmpty()) {
		        	qualiteAutreOperation.setQualite(Integer.parseInt(LigneAutreOperationBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteAutreOperation.setAutreQualité(LigneAutreOperationBD.get(k).getAutreQualite());
		        }
		        LigneAutreOperation.setQualiteEntreprise(qualiteAutreOperation);
		        
		        
		        LigneAutreOperation.setNatureAutreOperation(LigneAutreOperationBD.get(k).getNatureAutreOperation());
		        
		        LigneAutreOperation.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        
		        if(LigneAutreOperationBD.get(k).getNatureRelation()!=null && !LigneAutreOperationBD.get(k).getNatureRelation().isEmpty()) {
		        LigneAutreOperation.getNatureRelationEntreprise().setNatureRelation(LigneAutreOperationBD.get(k).getNatureRelation());}
		        else {
		        LigneAutreOperation.getNatureRelationEntreprise().setAutreNatureRelation(LigneAutreOperationBD.get(k).getAutreNatureRelation());}
		       
		        LigneAutreOperation.setAchatsDepenses(LigneAutreOperationBD.get(k).getAchatsDepenses());
		        LigneAutreOperation.setRaisonSociale(LigneAutreOperationBD.get(k).getRaisonSociale());
		        LigneAutreOperation.setVentesRevenus(LigneAutreOperationBD.get(k).getVentesRevenus());
		        LigneAutreOperation.setMethodePrixTransfert(new MethodePrixTransfert());
		        if(LigneAutreOperationBD.get(k).getMethodeDeterminationPrixTransfert()!=null && !LigneAutreOperationBD.get(k).getMethodeDeterminationPrixTransfert().isEmpty()) {
		        LigneAutreOperation.getMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneAutreOperationBD.get(k).getMethodeDeterminationPrixTransfert());}
		        else {
		        LigneAutreOperation.getMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneAutreOperationBD.get(k).getAutreMethodeDeterminationPrixTransfert());
		        }
		        LigneAutreOperation.setChangementMethodePrixTransfert(new ChangementMethodePrixTransfert() );
		        if(LigneAutreOperationBD.get(k).getChangementMethodeDeterminationPrixTransfert()!=null && !LigneAutreOperationBD.get(k).getChangementMethodeDeterminationPrixTransfert().isEmpty()) {
		        LigneAutreOperation.getChangementMethodePrixTransfert().setMethodeDeterminationPrixTransfert(LigneAutreOperationBD.get(k).getChangementMethodeDeterminationPrixTransfert());}
		        else {
		        LigneAutreOperation.getChangementMethodePrixTransfert().setAutreMethodeDeterminationPrixTransfert(LigneAutreOperationBD.get(k).getChnagementAutreMethodeDeterminationPrixTransfert());;
		        }  
		        
		        
		        
	    	   ListeAutreOperation.add(LigneAutreOperation);}
	       
	       InformationsAutresOperations.setAutresOperations(ListeAutreOperation);
	       
	       MontantTransactionsMethodeDeterminationPrixTransfert.setInformationsAutresOperations(InformationsAutresOperations);
	       InformationsOperations.setMontantTransactionsMethodeDeterminationPrixTransfert(MontantTransactionsMethodeDeterminationPrixTransfert);
	       prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       
	       InformationsPretsEmprunts InformationsPretsEmprunts =new InformationsPretsEmprunts ();
	       InformationsPretsEmpruntsBD InformationsPretsEmpruntsBD =InformationsOperationsBD.getInformationsPretsEmprunts();
	       List<LignePretAccordeBD> LignePretAccordeBD = InformationsPretsEmpruntsBD.getLignePretAccorde();
	       List<LignePretAccorde> ListePretAccorde =new ArrayList<>();
	       
	       for(int k=0;k<LignePretAccordeBD.size();k++) {
	    	   LignePretAccorde LignePretAccorde =new LignePretAccorde();
	    	   IdentifiantEntreprise identifiantPretAccorde = new IdentifiantEntreprise();
		       QualiteEntreprise qualitePretAccorde= new QualiteEntreprise();
		        if(LignePretAccordeBD.get(k).getMatriculeFiscal()!=null && !LignePretAccordeBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantPretAccorde.setMatriculeFiscal(LignePretAccordeBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantPretAccorde.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantPretAccorde.getAutreIdentifiant().setEtatTerritoire(LignePretAccordeBD.get(k).getEtatTerritoire());
			        identifiantPretAccorde.getAutreIdentifiant().setIdentifiant(LignePretAccordeBD.get(k).getIdentifiant());
			        }
		        LignePretAccorde.setIdentifiantEntreprise(identifiantPretAccorde);
		        if (LignePretAccordeBD.get(k).getQualite()!=null &&  !LignePretAccordeBD.get(k).getQualite().isEmpty()) {
		        	qualitePretAccorde.setQualite(Integer.parseInt(LignePretAccordeBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualitePretAccorde.setAutreQualité(LignePretAccordeBD.get(k).getAutreQualité());
		        }
	            LignePretAccorde.setQualiteEntreprise(qualitePretAccorde);
	            LignePretAccorde.setDevise(LignePretAccordeBD.get(k).getDevise());
	            LignePretAccorde.setMouvementsAugmentations(LignePretAccordeBD.get(k).getMouvementsAugmentations());
	            LignePretAccorde.setMouvementsDiminutions(LignePretAccordeBD.get(k).getMouvementsDiminutions());
	            LignePretAccorde.setNatureRelationEntreprise(new NatureRelationEntreprise());
	            if(LignePretAccordeBD.get(k).getNatureRelation()!=null && !LignePretAccordeBD.get(k).getNatureRelation().isEmpty()) {
	            LignePretAccorde.getNatureRelationEntreprise().setNatureRelation(LignePretAccordeBD.get(k).getNatureRelation());}
	            else {
	            LignePretAccorde.getNatureRelationEntreprise().setAutreNatureRelation(LignePretAccordeBD.get(k).getAutreNatureRelation());}
	            
	            LignePretAccorde.setPretsInterets(LignePretAccordeBD.get(k).getPretsInterets());
	            LignePretAccorde.setRaisonSociale(LignePretAccordeBD.get(k).getRaisonSociale());
	            LignePretAccorde.setSoldeCloture(LignePretAccordeBD.get(k).getSoldeCloture());
	            LignePretAccorde.setSoldeOuverture(LignePretAccordeBD.get(k).getSoldeOuverture());
	            LignePretAccorde.setTauxInteret(LignePretAccordeBD.get(k).getTauxInterets());
	       
	          ListePretAccorde.add(LignePretAccorde);}
	       
	       InformationsPretsEmprunts.setPretsAccordes(ListePretAccorde);
	       InformationsOperations.setInformationsPretsEmprunts(InformationsPretsEmprunts);
	       prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       
	       
	       List<LigneEmpruntContracteBD> LigneEmpruntContracteBD = InformationsPretsEmpruntsBD.getLigneEmpruntContracte();
	       List<LigneEmpruntContracte> ListeEmpruntContracte =new ArrayList<>();
	       
	       for(int k=0;k<LigneEmpruntContracteBD.size();k++) {
	    	   LigneEmpruntContracte LigneEmpruntContracte =new LigneEmpruntContracte();
	    	   IdentifiantEntreprise identifiantEmpruntContracte = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteEmpruntContracte= new QualiteEntreprise();
		        if(LigneEmpruntContracteBD.get(k).getMatriculeFiscal()!=null && !LigneEmpruntContracteBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantEmpruntContracte.setMatriculeFiscal(LigneEmpruntContracteBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantEmpruntContracte.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantEmpruntContracte.getAutreIdentifiant().setEtatTerritoire(LigneEmpruntContracteBD.get(k).getEtatTerritoire());
			        identifiantEmpruntContracte.getAutreIdentifiant().setIdentifiant(LigneEmpruntContracteBD.get(k).getIdentifiant());
			        }
		        LigneEmpruntContracte.setIdentifiantEntreprise(identifiantEmpruntContracte);
		        if (LigneEmpruntContracteBD.get(k).getQualite()!=null &&  !LigneEmpruntContracteBD.get(k).getQualite().isEmpty()) {
		        	qualiteEmpruntContracte.setQualite(Integer.parseInt(LigneEmpruntContracteBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteEmpruntContracte.setAutreQualité(LigneEmpruntContracteBD.get(k).getAutreQualité());
		        }
		        LigneEmpruntContracte.setQualiteEntreprise(qualiteEmpruntContracte);
		        LigneEmpruntContracte.setDevise(LigneEmpruntContracteBD.get(k).getDevise());
		        LigneEmpruntContracte.setMouvementsAugmentations(LigneEmpruntContracteBD.get(k).getMouvementsAugmentations());
		        LigneEmpruntContracte.setMouvementsDiminutions(LigneEmpruntContracteBD.get(k).getMouvementsDiminutions());
		        LigneEmpruntContracte.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        if(LigneEmpruntContracteBD.get(k).getNatureRelation()!=null && !LigneEmpruntContracteBD.get(k).getNatureRelation().isEmpty()) {
		        LigneEmpruntContracte.getNatureRelationEntreprise().setNatureRelation(LigneEmpruntContracteBD.get(k).getNatureRelation());}
		        else {
		        LigneEmpruntContracte.getNatureRelationEntreprise().setAutreNatureRelation(LigneEmpruntContracteBD.get(k).getAutreNatureRelation());
		        }
		        
		        LigneEmpruntContracte.setRaisonSociale(LigneEmpruntContracteBD.get(k).getRaisonSociale());
		        LigneEmpruntContracte.setSoldeCloture(LigneEmpruntContracteBD.get(k).getSoldeCloture());
		        LigneEmpruntContracte.setSoldeOuverture(LigneEmpruntContracteBD.get(k).getSoldeOuverture());
		        LigneEmpruntContracte.setTauxInteret(LigneEmpruntContracteBD.get(k).getTauxInterets());
	       
	          ListeEmpruntContracte.add(LigneEmpruntContracte);}
	       
	       InformationsPretsEmprunts.setEmpruntsContractes(ListeEmpruntContracte);
	       InformationsOperations.setInformationsPretsEmprunts(InformationsPretsEmprunts);
	       prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       OperationsSansContrepartieOuAvecContrepartieNonMonetaire OperationsSansContrepartieOuAvecContrepartieNonMonetaire=new OperationsSansContrepartieOuAvecContrepartieNonMonetaire();
	       OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD =InformationsOperationsBD.getOperationsSansContrepartieOuAvecContrepartieNonMonetaire();
	       InformationsSurBiensOuServicesSansContrePartieBD InformationsSurBiensOuServicesSansContrePartieBD=OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD.getInformationsSurBiensOuServicesSansContrePartie();
	       InformationsSurBiensOuServicesSansContrePartie InformationsSurBiensOuServicesSansContrePartie =new InformationsSurBiensOuServicesSansContrePartie();
	       InformationsSurBiensOuServicesSansContrePartie.setAffirmation(InformationsSurBiensOuServicesSansContrePartieBD.getAffirmation());
	       List<LigneBiensOuServicesSansContrePartieBD> LigneBiensOuServicesSansContrePartieBD=InformationsSurBiensOuServicesSansContrePartieBD.getLigneBiensOuServicesSansContrePartie();
	       List<LigneBiensOuServicesSansContrePartie> ListeBiensOuServices =new ArrayList<>();
	       
	       for(int k=0;k<LigneBiensOuServicesSansContrePartieBD.size();k++) {
	    	   LigneBiensOuServicesSansContrePartie LigneBiensOuServicesSansContrePartie =new LigneBiensOuServicesSansContrePartie();
	    	   IdentifiantEntreprise identifiantBiensOuServices = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteBiensOuServices = new QualiteEntreprise();
		        if(LigneBiensOuServicesSansContrePartieBD.get(k).getMatriculeFiscal()!=null && !LigneBiensOuServicesSansContrePartieBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantBiensOuServices .setMatriculeFiscal(LigneBiensOuServicesSansContrePartieBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantBiensOuServices.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantBiensOuServices.getAutreIdentifiant().setEtatTerritoire(LigneBiensOuServicesSansContrePartieBD.get(k).getEtatTerritoire());
			        identifiantBiensOuServices.getAutreIdentifiant().setIdentifiant(LigneBiensOuServicesSansContrePartieBD.get(k).getIdentifiant());
			        }
		        LigneBiensOuServicesSansContrePartie.setIdentifiantEntreprise(identifiantBiensOuServices );
		        if (LigneBiensOuServicesSansContrePartieBD.get(k).getQualite()!=null &&  !LigneBiensOuServicesSansContrePartieBD.get(k).getQualite().isEmpty()) {
		        	qualiteBiensOuServices.setQualite(Integer.parseInt(LigneBiensOuServicesSansContrePartieBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteBiensOuServices.setAutreQualité(LigneBiensOuServicesSansContrePartieBD.get(k).getAutreQualité());
		        }
		        
		        LigneBiensOuServicesSansContrePartie.setQualiteEntreprise(qualiteBiensOuServices);
		        
		        LigneBiensOuServicesSansContrePartie.setNatureBiensOuService(LigneBiensOuServicesSansContrePartieBD.get(k).getNatureBiensOuService());
		        LigneBiensOuServicesSansContrePartie.setNatureContrepartie(LigneBiensOuServicesSansContrePartieBD.get(k).getNatureContrepartie());
		        LigneBiensOuServicesSansContrePartie.setRaisonSociale(LigneBiensOuServicesSansContrePartieBD.get(k).getRaisonSociale());
		        ListeBiensOuServices.add(LigneBiensOuServicesSansContrePartie);}
	         
	       InformationsSurBiensOuServicesSansContrePartie.setBiensOuServicesSansContrePartie(ListeBiensOuServices);
	       OperationsSansContrepartieOuAvecContrepartieNonMonetaire.setInformationsSurBiensOuServicesSansContrePartie(InformationsSurBiensOuServicesSansContrePartie);
	       InformationsOperations.setOperationsSansContrepartieOuAvecContrepartieNonMonetaire(OperationsSansContrepartieOuAvecContrepartieNonMonetaire);
	       prixTransfert.setInformationsOperations(InformationsOperations);
		        
	       InformationsSurContrepartieNonMonetairePourBiensOuServicesBD InformationsSurContrepartieNonMonetairePourBiensOuServicesBD=OperationsSansContrepartieOuAvecContrepartieNonMonetaireBD.getInformationsSurContrepartieNonMonetairePourBiensOuServices();
	       InformationsSurContrepartieNonMonetairePourBiensOuServices InformationsSurContrepartieNonMonetairePourBiensOuServices =new InformationsSurContrepartieNonMonetairePourBiensOuServices();
	       InformationsSurContrepartieNonMonetairePourBiensOuServices.setAffirmation(InformationsSurContrepartieNonMonetairePourBiensOuServicesBD.getAffirmation());
	       List<LigneContrepartieNonMonetairePourBiensOuServicesBD> LigneContrepartieNonMonetairePourBiensOuServicesBD=InformationsSurContrepartieNonMonetairePourBiensOuServicesBD.getLigneContrepartieNonMonetairePourBiensOuServices();
	       List<LigneContrepartieNonMonetairePourBiensOuServices> ListeContrePartie =new ArrayList<>();
	       
	       for(int k=0;k<LigneContrepartieNonMonetairePourBiensOuServicesBD.size();k++) {
	    	   LigneContrepartieNonMonetairePourBiensOuServices LigneContrepartieNonMonetairePourBiensOuServices =new LigneContrepartieNonMonetairePourBiensOuServices();
	    	   IdentifiantEntreprise identifiantContrePartie = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteContrePartie = new QualiteEntreprise();
		        if(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getMatriculeFiscal()!=null && !LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getMatriculeFiscal().isEmpty()) {
			        identifiantContrePartie .setMatriculeFiscal(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantContrePartie.setAutreIdentifiant(new AutreIdentifiant());
			        	identifiantContrePartie.getAutreIdentifiant().setEtatTerritoire(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getEtatTerritoire());
			        identifiantContrePartie.getAutreIdentifiant().setIdentifiant(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getIdentifiant());
			        }
		        LigneContrepartieNonMonetairePourBiensOuServices.setIdentifiantEntreprise(identifiantContrePartie );
		        if (LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getQualite()!=null &&  !LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getQualite().isEmpty()) {
		        	qualiteContrePartie.setQualite(Integer.parseInt(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	qualiteContrePartie.setAutreQualité(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getAutreQualité());
		        }
		        
		        
		        
		        LigneContrepartieNonMonetairePourBiensOuServices.setQualiteEntreprise(qualiteContrePartie);
		        
		        LigneContrepartieNonMonetairePourBiensOuServices.setNatureBiensOuService(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getNatureBiensOuService());
		        LigneContrepartieNonMonetairePourBiensOuServices.setNatureContrepartie(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getNatureContrepartie());
		        LigneContrepartieNonMonetairePourBiensOuServices.setRaisonSociale(LigneContrepartieNonMonetairePourBiensOuServicesBD.get(k).getRaisonSociale());
		        ListeContrePartie.add(LigneContrepartieNonMonetairePourBiensOuServices);}
	         
	       InformationsSurContrepartieNonMonetairePourBiensOuServices.setContrepartieNonMonetairePourBiensOuServices(ListeContrePartie);
	       OperationsSansContrepartieOuAvecContrepartieNonMonetaire.setInformationsSurContrepartieNonMonetairePourBiensOuServices(InformationsSurContrepartieNonMonetairePourBiensOuServices);
	       InformationsOperations.setOperationsSansContrepartieOuAvecContrepartieNonMonetaire(OperationsSansContrepartieOuAvecContrepartieNonMonetaire);
	       prixTransfert.setInformationsOperations(InformationsOperations);
		        
	       
	       
	       
	       
	       
	       InformationsOperationsAccordsPrealablesOuRescritsFiscaux InformationsOperationsAccordsPrealablesOuRescritsFiscaux =new InformationsOperationsAccordsPrealablesOuRescritsFiscaux();
	       InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD=InformationsOperationsBD.getInformationsOperationsAccordsPrealablesOuRescritsFiscaux();
	       InformationsOperationsAccordsPrealablesOuRescritsFiscaux.setAffirmation(InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD.getAffirmation());
	       List<LigneOperationsAccordsPrealablesOuRescritsFiscauxBD> LigneOperationsAccordsPrealablesOuRescritsFiscauxBD=InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD.getLigneOperationsAccordsPrealablesOuRescritsFiscaux();
           List<LigneOperationsAccordsPrealablesOuRescritsFiscaux> ListeOperationsAccords =new ArrayList<>();
           
           for(int k=0;k<LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.size();k++) {
        	   LigneOperationsAccordsPrealablesOuRescritsFiscaux LigneOperationsAccordsPrealablesOuRescritsFiscaux =new LigneOperationsAccordsPrealablesOuRescritsFiscaux();
	    	   IdentifiantEntreprise identifiantOperationsAccords = new IdentifiantEntreprise();
		       QualiteEntreprise qualiteOperationsAccords= new QualiteEntreprise();
		        if(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getMatriculeFiscal()!=null && !LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getMatriculeFiscal().isEmpty()) {
		        	identifiantOperationsAccords.setMatriculeFiscal(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getMatriculeFiscal());
			        }
			        else  {identifiantOperationsAccords.setAutreIdentifiant(new AutreIdentifiant());
			        identifiantOperationsAccords.getAutreIdentifiant().setEtatTerritoire(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getEtatTerritoire());
			        identifiantOperationsAccords.getAutreIdentifiant().setIdentifiant(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getIdentifiant());
			        }
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.setIdentifiantEntreprise(identifiantOperationsAccords );
		        
		        if (LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getQualite()!=null &&  !LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getQualite().isEmpty()) {
		        	qualiteOperationsAccords.setQualite(Integer.parseInt(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getQualite()));
		        	
		        }
		        else {
		        	 qualiteOperationsAccords.setAutreQualité(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getAutreQualité());
		        }
		        
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.setQualiteEntreprise(qualiteOperationsAccords);
		        
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.setNatureRelationEntreprise(new NatureRelationEntreprise());
		        if(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getNatureRelation()!=null && !LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getNatureRelation().isEmpty()) {
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.getNatureRelationEntreprise().setNatureRelation(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getNatureRelation());}
		        else {
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.getNatureRelationEntreprise().setAutreNatureRelation(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getAutreNatureOperation());}
		        
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.setExerciceDebut(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getExerciceDebut());
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.setExerciceFin(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getExerciceFin());
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.setRaisonSociale(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getRaisonSociale());
		        LigneOperationsAccordsPrealablesOuRescritsFiscaux.setNatureOperation(LigneOperationsAccordsPrealablesOuRescritsFiscauxBD.get(k).getNatureOperation());

	       
		        ListeOperationsAccords.add(LigneOperationsAccordsPrealablesOuRescritsFiscaux);}
           
              
           InformationsOperationsAccordsPrealablesOuRescritsFiscaux.setOperationsAccordsPrealablesOuRescritsFiscaux(ListeOperationsAccords);
           InformationsOperations.setInformationsOperationsAccordsPrealablesOuRescritsFiscaux(InformationsOperationsAccordsPrealablesOuRescritsFiscaux);
           prixTransfert.setInformationsOperations(InformationsOperations);
	       
	       
	       
           AutresInformationsARenseignerSurDeclarationPrixTransfert AutresInformationsARenseignerSurDeclarationPrixTransfert=DéclarationPrixDeTransfert.getAutresInformationsARenseignerSurDeclarationPrixTransfert();
           prixTransfert.setAutresInformationsARenseignerSurDeclarationPrixTransfert(AutresInformationsARenseignerSurDeclarationPrixTransfert.getAutresInformationsARenseignerSurDeclarationPrixTransfert());
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	        return prixTransfert;
	    }
	}


