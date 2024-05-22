package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;
import com.PrixDeTransfert.Backend.models.InformationsAutresOperationsBD;
import com.PrixDeTransfert.Backend.models.InformationsCessionsAcquisitionsActifsBD;
import com.PrixDeTransfert.Backend.models.InformationsOperationsBD;
import com.PrixDeTransfert.Backend.models.MontantTransactionsMethodeDeterminationPrixTransfertBD;
import com.PrixDeTransfert.Backend.services.ServiceInformationsAutresOperations;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerInformationsAutresOperations {
	@Autowired
	private ServiceInformationsAutresOperations InformationsAutresOperations ;
	public static Long idInformationsAutresOperations;
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsAutresOperations")// lid nekhdho m return mta InformationsValeursExploitation.save(a, idDéclaration)(khatr montantTransaction o informationsOperations yetsan3o mara kahw
	public InformationsAutresOperationsBD save(@RequestBody InformationsAutresOperationsBD a) {
		Long idMontantTransaction=ControlleurInformationsValeursExploitation.idMontantTransactions;
		InformationsAutresOperationsBD InformationsAutresOperationsBD=InformationsAutresOperations.save(a, idMontantTransaction);
		idInformationsAutresOperations=InformationsAutresOperationsBD.getId();
		return InformationsAutresOperationsBD;}

	
	
	
	
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert;
	@Autowired
    com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsAutresOperations InterfaceRepositoryInformationsAutresOperations;
	@PutMapping("/MiseAjourInformationsAutresOperations")
	public ResponseEntity<String> updateInformationsAutresOperations(@RequestBody InformationsAutresOperationsBD updatedInformationsAutresOperations,HttpSession session) {
	
		Long iddeclaration =(Long) session.getAttribute("Déclarationid");
		DéclarationPrixDeTransfert DéclarationPrixDeTransfert =InterfaceRepositoryDéclarationPrixDeTransfert.findDéclarationPrixDeTransfertById(iddeclaration);
		InformationsOperationsBD InformationsOperations=DéclarationPrixDeTransfert.getInformationsOperations();
		MontantTransactionsMethodeDeterminationPrixTransfertBD MontantTransactionsMethodeDeterminationPrixTransfert=InformationsOperations.getMontantTransactionsMethodeDeterminationPrixTransfert();
		
		InformationsAutresOperationsBD InformationsAutresOperations=MontantTransactionsMethodeDeterminationPrixTransfert.getInformationsAutresOperations();
	
		InformationsAutresOperations.setTotalAchatsDepensesAutresOperations(updatedInformationsAutresOperations.getTotalAchatsDepensesAutresOperations());
		InformationsAutresOperations.setTotalVentesRevenusAutresOperations(updatedInformationsAutresOperations.getTotalVentesRevenusAutresOperations());
	session.setAttribute("idInformationsAutresOperations",InformationsAutresOperations.getId());
	InterfaceRepositoryInformationsAutresOperations.save(InformationsAutresOperations);
	return ResponseEntity.ok(" mise à jour avec succès");}
}
