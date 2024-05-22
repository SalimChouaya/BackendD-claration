package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;
import com.PrixDeTransfert.Backend.models.InformationsOperationsBD;
import com.PrixDeTransfert.Backend.models.InformationsSurBiensOuServicesSansContrePartieBD;
import com.PrixDeTransfert.Backend.models.InformationsSurContrepartieNonMonetairePourBiensOuServicesBD;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerInformationsSurBiensOuServicesSansContrePartie {
	@Autowired
	com.PrixDeTransfert.Backend.services.ServiceInformationsSurBiensOuServicesSansContrePartie ServiceInformationsSurBiensOuServicesSansContrePartie;
	public static Long idInformationsSurBiensOuServicesSansContrePartie;
	public static Long IdOperationsSansContrepartieOuAvecContrepartieNonMonetaire;
	@PostMapping("/DéclarationPrixDeTransfert/InformationsOperations/OperationsSansContrepartieOuAvecContrepartieNonMonetaire/InformationsSurBiensOuServicesSansContrePartie")
	public InformationsSurBiensOuServicesSansContrePartieBD save(@RequestBody InformationsSurBiensOuServicesSansContrePartieBD  a,HttpSession session) {
		Long idInformationsOperations=ControlleurInformationsValeursExploitation.idInformationsOperations;
		InformationsSurBiensOuServicesSansContrePartieBD InformationsSurBiensOuServicesSansContrePartieBD=ServiceInformationsSurBiensOuServicesSansContrePartie.save(a, idInformationsOperations);
		idInformationsSurBiensOuServicesSansContrePartie= InformationsSurBiensOuServicesSansContrePartieBD.getId();
		IdOperationsSansContrepartieOuAvecContrepartieNonMonetaire=InformationsSurBiensOuServicesSansContrePartieBD.getOperationsSansContrepartieOuAvecContrepartieNonMonetaire().getId();
		return InformationsSurBiensOuServicesSansContrePartieBD;}
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsSurBiensOuServicesSansContrePartie InterfaceRepositoryInformationsSurBiensOuServicesSansContrePartie;
		@Autowired
		com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert;
			@PutMapping("/MiseAjourInformationsSurBiensOuServicesSansContrePartie")
			public ResponseEntity<String> updateInformationsSurBiensOuServicesSansContrePartie(@RequestBody InformationsSurBiensOuServicesSansContrePartieBD updatedInformationsSurBiensOuServicesSansContrePartie,HttpSession session) {
			
				Long iddeclaration =(Long) session.getAttribute("Déclarationid");
				DéclarationPrixDeTransfert DéclarationPrixDeTransfert =InterfaceRepositoryDéclarationPrixDeTransfert.findDéclarationPrixDeTransfertById(iddeclaration);
				InformationsOperationsBD InformationsOperations=DéclarationPrixDeTransfert.getInformationsOperations();
				
				InformationsSurBiensOuServicesSansContrePartieBD InformationsSurBiensOuServicesSansContrePartie=InformationsOperations.getOperationsSansContrepartieOuAvecContrepartieNonMonetaire().getInformationsSurBiensOuServicesSansContrePartie();
				
				InformationsSurBiensOuServicesSansContrePartie.setAffirmation(updatedInformationsSurBiensOuServicesSansContrePartie.getAffirmation());
				
				InterfaceRepositoryInformationsSurBiensOuServicesSansContrePartie.save(InformationsSurBiensOuServicesSansContrePartie);
				session.setAttribute("idInformationsSurBiensOuServicesSansContrePartie", InformationsSurBiensOuServicesSansContrePartie.getId());
				return ResponseEntity.ok(" mise à jour avec succès");
		
		
		
		
		
		
		
		
	}
}
