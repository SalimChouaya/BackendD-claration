package com.PrixDeTransfert.Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsAutresOperationsBD;
import com.PrixDeTransfert.Backend.models.InformationsCessionsAcquisitionsActifsBD;
import com.PrixDeTransfert.Backend.models.LigneAutreOperationBD;
import com.PrixDeTransfert.Backend.models.LigneCessionAcquisitionActifBD;
import com.PrixDeTransfert.Backend.services.ServiceDescriptionTransactionsRegimeFiscalPrivilegie;
import com.PrixDeTransfert.Backend.services.ServiceLigneAutreOperation;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControlleurLigneAutreOperation {
	@Autowired
	private ServiceLigneAutreOperation LigneAutreOperation ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsAutresOperations/LigneAutreOperation")
	public LigneAutreOperationBD save(@RequestBody LigneAutreOperationBD  a) {
		Long idInformationsAutresOperations =ControllerInformationsAutresOperations.idInformationsAutresOperations;
		return LigneAutreOperation.save(a, idInformationsAutresOperations);}
	@Autowired 
	private ServiceDescriptionTransactionsRegimeFiscalPrivilegie DescriptionTransactionsRegimeFiscalPrivilegie;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/DescriptionTransactionsRegimeFiscalPrivilegie")
	public com.PrixDeTransfert.Backend.models.DescriptionTransactionsRegimeFiscalPrivilegie save(@RequestBody com.PrixDeTransfert.Backend.models.DescriptionTransactionsRegimeFiscalPrivilegie  a) {
		Long idMontantTransaction=ControlleurInformationsValeursExploitation.idMontantTransactions;
		return DescriptionTransactionsRegimeFiscalPrivilegie.save(a, idMontantTransaction);}
	
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsAutresOperations InterfaceRepositoryInformationsAutresOperations;
	@PutMapping("/MiseAjourLigneAutreOperation")
	public ResponseEntity<String> updateLigneCessionAcquisitionActif(@RequestBody List<LigneAutreOperationBD> updatedLigneAutreOperation,HttpSession session) {

	 Long idInformations=(Long)session.getAttribute("idInformationsAutresOperations");
	 

	 InformationsAutresOperationsBD InformationsAutresOperations=InterfaceRepositoryInformationsAutresOperations.findInformationsAutresOperationsBDById(idInformations);
	 
	 InformationsAutresOperations.setLigneAutreOperation(updatedLigneAutreOperation);
	 
	 InterfaceRepositoryInformationsAutresOperations.save(InformationsAutresOperations);
	 return ResponseEntity.ok(" mise à jour avec succès");
	}

	
	
	
	
	
}
