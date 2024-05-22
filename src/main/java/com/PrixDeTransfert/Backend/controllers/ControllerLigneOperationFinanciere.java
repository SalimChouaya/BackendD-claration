package com.PrixDeTransfert.Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsOperationsFinancieresBD;
import com.PrixDeTransfert.Backend.models.InformationsServicesBD;
import com.PrixDeTransfert.Backend.models.LigneOperationFinanciereBD;
import com.PrixDeTransfert.Backend.models.LigneServiceBD;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerLigneOperationFinanciere {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceLigneOperationFinanciere ServiceLigneOperationFinanciere ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsOperations/MontantTransactions/InformationsOperationsFinancieres/ligneOperationFinanciere")
	public LigneOperationFinanciereBD save(@RequestBody LigneOperationFinanciereBD  a,HttpSession session) {
		Long idInformationsOperationsFinancieres=ControllerInformationsOperationsFinancieres.idInformationsOperationsFinancieres;
		
		
		return ServiceLigneOperationFinanciere.save(a, idInformationsOperationsFinancieres);}
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsOperationsFinancieres InterfaceRepositoryInformationsOperationsFinancieres;
	@PutMapping("/MiseAjourLigneOperationFinanciere")
	public ResponseEntity<String> updateLigneOperationFinanciere(@RequestBody List<LigneOperationFinanciereBD> updatedLigneOperationFinanciere,HttpSession session) {

	 Long idInformations=(Long)session.getAttribute("idInformationsOperationsFinancieres");
	 

	 InformationsOperationsFinancieresBD InformationsOperationsFinancieres=InterfaceRepositoryInformationsOperationsFinancieres.findInformationsOperationsFinancieresBDById(idInformations);
	 
	 
	 InformationsOperationsFinancieres.setLigneOperationFinanciere(updatedLigneOperationFinanciere);
	 
	 InterfaceRepositoryInformationsOperationsFinancieres.save(InformationsOperationsFinancieres);
	 return ResponseEntity.ok(" mise à jour avec succès");
	}




}


