package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;
import com.PrixDeTransfert.Backend.models.InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD;
import com.PrixDeTransfert.Backend.models.InformationsOperationsBD;
import com.PrixDeTransfert.Backend.models.InformationsSurContrepartieNonMonetairePourBiensOuServicesBD;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerInformationsOperationsAccordsPrealablesOuRescritsFiscaux {

	@Autowired
	com.PrixDeTransfert.Backend.services.ServiceInformationsOperationsAccordsPrealablesOuRescritsFiscaux ServiceInformationsOperationsAccordsPrealablesOuRescritsFiscaux;
	
	public static Long idInformationsOperationsAccordsPrealablesOuRescritsFiscauxBD;
	@PostMapping("/DéclarationPrixDeTransfert/InformationsOperations/InformationsOperationsAccordsPrealablesOuRescritsFiscaux")
	public InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD save(@RequestBody InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD  a) {
		Long idInformationsOperations=ControlleurInformationsValeursExploitation.idInformationsOperations;
		
		InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD=ServiceInformationsOperationsAccordsPrealablesOuRescritsFiscaux.save(a, idInformationsOperations);
		idInformationsOperationsAccordsPrealablesOuRescritsFiscauxBD=InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD.getId();
		
		return InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD;}

	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsOperationsAccordsPrealablesOuRescritsFiscaux InterfaceRepositoryInformationsOperationsAccordsPrealablesOuRescritsFiscaux;
		@Autowired
		com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert;
			@PutMapping("/MiseAjourInformationsOperationsAccordsPrealablesOuRescritsFiscaux")
			public ResponseEntity<String> updateInformationsOperationsAccordsPrealablesOuRescritsFiscaux(@RequestBody InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD updatedInformationsOperationsAccordsPrealablesOuRescritsFiscaux,HttpSession session) {
			
				Long iddeclaration =(Long) session.getAttribute("Déclarationid");
				DéclarationPrixDeTransfert DéclarationPrixDeTransfert =InterfaceRepositoryDéclarationPrixDeTransfert.findDéclarationPrixDeTransfertById(iddeclaration);
				InformationsOperationsBD InformationsOperations=DéclarationPrixDeTransfert.getInformationsOperations();
				InformationsOperationsAccordsPrealablesOuRescritsFiscauxBD InformationsOperationsAccordsPrealablesOuRescritsFiscaux=InformationsOperations.getInformationsOperationsAccordsPrealablesOuRescritsFiscaux();
				InformationsOperationsAccordsPrealablesOuRescritsFiscaux.setAffirmation(updatedInformationsOperationsAccordsPrealablesOuRescritsFiscaux.getAffirmation());
				InterfaceRepositoryInformationsOperationsAccordsPrealablesOuRescritsFiscaux.save(InformationsOperationsAccordsPrealablesOuRescritsFiscaux);
				return ResponseEntity.ok(" mise à jour avec succès");
	
	
	
	
	
	
	
	
	
	
			}
	
	
	
	
	
	
	
}
