package com.PrixDeTransfert.Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.ChangementsActiviteAucoursExerciceBD;
import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;
import com.PrixDeTransfert.Backend.models.InformationsEntrepriseDeclaranteBD;
import com.PrixDeTransfert.Backend.models.ModificationLiensCapitalAuCoursExerciceBD;
import com.PrixDeTransfert.Backend.models.Qualité;

import jakarta.servlet.http.HttpSession;
@RestController
public class ControlleurInformationsEntrepriseDeclarante {
	
	
		@Autowired
		private com.PrixDeTransfert.Backend.services.ServiceInformationsEntrepriseDeclarante ServiceInformationsEntrepriseDeclarante;
		@Autowired
		com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert;
		@PostMapping("/DéclarationPrixDeTransfert/InformationsEntrepriseDeclarante")
		public InformationsEntrepriseDeclaranteBD save(@RequestBody InformationsEntrepriseDeclaranteBD  a,HttpSession session) {
			Long declarationid =(Long) session.getAttribute("Déclarationid");
			InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclaranteBD=ServiceInformationsEntrepriseDeclarante.save(a, declarationid);
			session.setAttribute("InformationsEntrepriseDeclaranteid",InformationsEntrepriseDeclaranteBD.getId() );
			return InformationsEntrepriseDeclaranteBD ;
			
		}
		
		@Autowired
		private com.PrixDeTransfert.Backend.services.ServiceQualité ServiceQualité;
		@PostMapping("/DéclarationPrixDeTransfert/InformationsEntrepriseDeclarante/qualité")
		public Qualité save(@RequestBody Qualité  a,HttpSession session) {
			Long InformationsEntrepriseDeclaranteid=(Long) session.getAttribute("InformationsEntrepriseDeclaranteid");
			
			return ServiceQualité.save(a, InformationsEntrepriseDeclaranteid);
			
		}
		com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsEntrepriseDeclarante InterfaceRepositoryInformationsEntrepriseDeclarante;
		@PutMapping("/miseAJourQualitéEntrepriseDeclarante")
		public ResponseEntity<String> updateQualité(@RequestBody List<Qualité> updatedQualities,HttpSession session) {
			Long idInformationsEntrepriseDeclarante =(Long) session.getAttribute("idInformationsEntrepriseDeclarante");
			InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclarante=InterfaceRepositoryInformationsEntrepriseDeclarante.findInformationsEntrepriseDeclaranteBDById(idInformationsEntrepriseDeclarante);
			InformationsEntrepriseDeclarante.setQualité(updatedQualities);
			
			return ResponseEntity.ok(" mise à jour avec succès");
			
			
			
		}
		@Autowired
		private com.PrixDeTransfert.Backend.services.ServiceChangementsActiviteAucoursExercice ServiceChangementsActiviteAucoursExercice;
		
		@PostMapping("/DéclarationPrixDeTransfert/InformationsEntrepriseDeclarante/ChangementsActiviteAucoursExercice")
		public ChangementsActiviteAucoursExerciceBD save(@RequestBody ChangementsActiviteAucoursExerciceBD  a,HttpSession session) {
			Long InformationsEntrepriseDeclaranteid=(Long) session.getAttribute("InformationsEntrepriseDeclaranteid");
			return ServiceChangementsActiviteAucoursExercice.save(a, InformationsEntrepriseDeclaranteid);
		
		}
		@Autowired
		com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryChangementsActiviteAucoursExercice InterfaceRepositoryChangementsActiviteAucoursExercice;
		@PutMapping("/miseAJourChangementsActiviteAucoursExercice")
		public ResponseEntity<String> updateChangementsActiviteAucoursExercice(@RequestBody ChangementsActiviteAucoursExerciceBD updatedChangementsActiviteAucoursExercice,HttpSession session) {
		
		
			Long idInformationsEntrepriseDeclarante =(Long) session.getAttribute("idInformationsEntrepriseDeclarante");
			InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclarante=InterfaceRepositoryInformationsEntrepriseDeclarante.findInformationsEntrepriseDeclaranteBDById(idInformationsEntrepriseDeclarante);
			ChangementsActiviteAucoursExerciceBD existingChangementsActiviteAucoursExercice=InformationsEntrepriseDeclarante.getChangementsActiviteAucoursExercice();
			existingChangementsActiviteAucoursExercice.setAffirmation(updatedChangementsActiviteAucoursExercice.getAffirmation());
			existingChangementsActiviteAucoursExercice.setDescription(updatedChangementsActiviteAucoursExercice.getDescription());
			
			
			InterfaceRepositoryChangementsActiviteAucoursExercice.save(existingChangementsActiviteAucoursExercice);
		
			return ResponseEntity.ok(" mise à jour avec succès");
			
		
		}
		
		
		
		@Autowired
		private com.PrixDeTransfert.Backend.services.ServiceModificationLiensCapitalAuCoursExercice ServiceModificationLiensCapitalAuCoursExercice;
		
		@PostMapping("/DéclarationPrixDeTransfert/InformationsEntrepriseDeclarante/ModificationLiensCapitalAuCoursExercice")
		public ModificationLiensCapitalAuCoursExerciceBD save(@RequestBody ModificationLiensCapitalAuCoursExerciceBD  a,HttpSession session) {
			Long InformationsEntrepriseDeclaranteid=(Long) session.getAttribute("InformationsEntrepriseDeclaranteid");
			return ServiceModificationLiensCapitalAuCoursExercice.save(a, InformationsEntrepriseDeclaranteid);
		
		}
		@Autowired
		com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryModificationLiensCapitalAuCoursExercice InterfaceRepositoryModificationLiensCapitalAuCoursExercice ;
		@PutMapping("/miseAJourModificationLiensCapitalAuCoursExercice")
		public ResponseEntity<String> updateModificationLiensCapitalAuCoursExercice(@RequestBody ModificationLiensCapitalAuCoursExerciceBD updatedModificationLiensCapitalAuCoursExercice,HttpSession session) {
			
			Long idInformationsEntrepriseDeclarante =(Long) session.getAttribute("idInformationsEntrepriseDeclarante");
			InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclarante=InterfaceRepositoryInformationsEntrepriseDeclarante.findInformationsEntrepriseDeclaranteBDById(idInformationsEntrepriseDeclarante);
			ModificationLiensCapitalAuCoursExerciceBD existingModificationLiensCapitalAuCoursExercice=InformationsEntrepriseDeclarante.getModificationLiensCapitalAuCoursExercice();
			existingModificationLiensCapitalAuCoursExercice.setAffirmation(updatedModificationLiensCapitalAuCoursExercice.getAffirmation());
			existingModificationLiensCapitalAuCoursExercice.setDescription(updatedModificationLiensCapitalAuCoursExercice.getDescription());
			
			
			InterfaceRepositoryModificationLiensCapitalAuCoursExercice.save(existingModificationLiensCapitalAuCoursExercice);
		
			return ResponseEntity.ok(" mise à jour avec succès");
			
			
		}
		@PutMapping("/miseAJourInformationsEntrepriseDeclarante")
		public ResponseEntity<String> updateInformationsEntrepriseDeclarante(@RequestBody InformationsEntrepriseDeclaranteBD updatedInformationsEntreprise,HttpSession session) {
			Long iddéclaration =(Long) session.getAttribute("idDéclaration");
			DéclarationPrixDeTransfert DéclarationPrixDeTransfert=InterfaceRepositoryDéclarationPrixDeTransfert.findDéclarationPrixDeTransfertById(iddéclaration);
			InformationsEntrepriseDeclaranteBD existingInformationsEntrepriseDeclaranteBD=DéclarationPrixDeTransfert.getInformationsEntrepriseDeclarante();
			session.setAttribute("idInformationsEntrepriseDeclarante", existingInformationsEntrepriseDeclaranteBD);
			if(updatedInformationsEntreprise.getAutreQualité()!=null) {
			existingInformationsEntrepriseDeclaranteBD.setAutreQualité(updatedInformationsEntreprise.getAutreQualité());}
			if(updatedInformationsEntreprise.getDescriptionActivitesPrincipales()!=null) {
			existingInformationsEntrepriseDeclaranteBD.setDescriptionActivitesPrincipales(updatedInformationsEntreprise.getDescriptionActivitesPrincipales());
			
		}
		
		
			return ResponseEntity.ok(" mise à jour avec succès");
		
		
		
		
		}
}
