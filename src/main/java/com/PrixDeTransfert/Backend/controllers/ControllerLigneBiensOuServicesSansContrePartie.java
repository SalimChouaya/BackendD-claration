package com.PrixDeTransfert.Backend.controllers;

import java.util.List;

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
import com.PrixDeTransfert.Backend.models.LigneBiensOuServicesSansContrePartieBD;
import com.PrixDeTransfert.Backend.services.ServiceLigneBiensOuServicesSansContrePartie;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerLigneBiensOuServicesSansContrePartie {
	@Autowired
	private ServiceLigneBiensOuServicesSansContrePartie LigneBiensOuServicesSansContrePartie ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsOperations/OperationsSansContrepartieOuAvecContrepartieNonMonetaire/InformationsSurBiensOuServicesSansContrePartie/LigneBiensOuServicesSansContrePartie ")
	public LigneBiensOuServicesSansContrePartieBD save(@RequestBody LigneBiensOuServicesSansContrePartieBD  a,HttpSession session) {
		Long idInformationsSurBiensOuServicesSansContrePartie=(Long) session.getAttribute("idInformationsSurBiensOuServicesSansContrePartie");
		return LigneBiensOuServicesSansContrePartie.save(a, idInformationsSurBiensOuServicesSansContrePartie);}
	
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsSurBiensOuServicesSansContrePartie InterfaceRepositoryInformationsSurBiensOuServicesSansContrePartie;
		@Autowired
		com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert;
			@PutMapping("/MiseAjourLigneBiensOuServicesSansContrePartie")
			public ResponseEntity<String> updateLigneBiensOuServicesSansContrePartie(@RequestBody List<LigneBiensOuServicesSansContrePartieBD> updatedLigneBiensOuServicesSansContrePartie,HttpSession session) {
			
				Long iddeclaration =(Long) session.getAttribute("Déclarationid");
				DéclarationPrixDeTransfert DéclarationPrixDeTransfert =InterfaceRepositoryDéclarationPrixDeTransfert.findDéclarationPrixDeTransfertById(iddeclaration);
				InformationsOperationsBD InformationsOperations=DéclarationPrixDeTransfert.getInformationsOperations();
				
				InformationsSurBiensOuServicesSansContrePartieBD InformationsSurBiensOuServicesSansContrePartie=InformationsOperations.getOperationsSansContrepartieOuAvecContrepartieNonMonetaire().getInformationsSurBiensOuServicesSansContrePartie();
				
				InformationsSurBiensOuServicesSansContrePartie.setLigneBiensOuServicesSansContrePartie(updatedLigneBiensOuServicesSansContrePartie);
				
				InterfaceRepositoryInformationsSurBiensOuServicesSansContrePartie.save(InformationsSurBiensOuServicesSansContrePartie);
				
				return ResponseEntity.ok(" mise à jour avec succès");
		
		
		
			}
	
	
	
	
	
	
	

}
