package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.AutresInformationsARenseignerSurDeclarationPrixTransfert;
import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerAutresInformationsARenseignerSurDeclarationPrixTransfert {
	
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceAutresInformationsARenseignerSurDeclarationPrixTransfert ServiceAutresInformationsARenseignerSurDeclarationPrixTransfert;
	@Autowired
	private com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert; 
	@PostMapping("/AutresInformationsARenseignerSurDeclarationPrixTransfert")
	public com.PrixDeTransfert.Backend.models.AutresInformationsARenseignerSurDeclarationPrixTransfert save(@RequestBody com.PrixDeTransfert.Backend.models.AutresInformationsARenseignerSurDeclarationPrixTransfert a, HttpSession session) {
		
        Long iddeclaration =ControlleurDéclarationPrixDeTransfert.Déclarationid;
        
		return ServiceAutresInformationsARenseignerSurDeclarationPrixTransfert.save(a, iddeclaration);
		
	}
	
	
	@PutMapping("/miseAJourAutresInformationsARenseignerSurDeclarationPrixTransfert")
	public ResponseEntity<String> updateAutresInformationsARenseignerSurDeclarationPrixTransfert(@RequestBody AutresInformationsARenseignerSurDeclarationPrixTransfert updatedAutresInformationsARenseignerSurDeclarationPrixTransfert,HttpSession session) {
		Long idDéclaration=(Long) session.getAttribute("idDéclaration");
		
		DéclarationPrixDeTransfert DéclarationPrixDeTransfert=InterfaceRepositoryDéclarationPrixDeTransfert.findDéclarationPrixDeTransfertById(idDéclaration);
		
		AutresInformationsARenseignerSurDeclarationPrixTransfert ExistingAutresInformationsARenseignerSurDeclarationPrixTransfert=DéclarationPrixDeTransfert.getAutresInformationsARenseignerSurDeclarationPrixTransfert();
		ExistingAutresInformationsARenseignerSurDeclarationPrixTransfert.setAutresInformationsARenseignerSurDeclarationPrixTransfert(updatedAutresInformationsARenseignerSurDeclarationPrixTransfert.getAutresInformationsARenseignerSurDeclarationPrixTransfert());
		return ResponseEntity.ok("mise à jour avec succès");
	}
	
	
	

}
