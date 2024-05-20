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
import com.PrixDeTransfert.Backend.models.InformationsOperationsFinancieresBD;
import com.PrixDeTransfert.Backend.models.InformationsServicesBD;
import com.PrixDeTransfert.Backend.models.MontantTransactionsMethodeDeterminationPrixTransfertBD;
import com.PrixDeTransfert.Backend.services.ServiceInformationsOperationsFinancieres;

import jakarta.servlet.http.HttpSession;
@RestController
public class ControllerInformationsOperationsFinancieres {
	@Autowired
	private ServiceInformationsOperationsFinancieres InformationsOperationsFinancieres ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsOperationsFinancieres")// lid nekhdho m return mta InformationsValeursExploitation.save(a, idDéclaration)(khatr montantTransaction o informationsOperations yetsan3o mara kahw
	public InformationsOperationsFinancieresBD save(@RequestBody InformationsOperationsFinancieresBD  a,HttpSession session) {
		Long idMontantTransaction=(Long) session.getAttribute("idMontantTransactions");
		InformationsOperationsFinancieresBD InformationsOperationsFinancieresBD=InformationsOperationsFinancieres.save(a, idMontantTransaction);
		session.setAttribute("idInformationsOperationsFinancieres",InformationsOperationsFinancieresBD.getId() );
		
		return InformationsOperationsFinancieresBD;}

    @Autowired
    com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert;

	@Autowired
    com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsOperationsFinancieres InterfaceRepositoryInformationsOperationsFinancieres;
	@PutMapping("/MiseAjourInformationsOperationsFinancieres")
	public ResponseEntity<String> updateInformationsOperationsFinancieres(@RequestBody InformationsOperationsFinancieresBD updatedInformationsOperationsFinancieres,HttpSession session) {
	
		Long iddeclaration =(Long) session.getAttribute("Déclarationid");
		DéclarationPrixDeTransfert DéclarationPrixDeTransfert =InterfaceRepositoryDéclarationPrixDeTransfert.findDéclarationPrixDeTransfertById(iddeclaration);
		InformationsOperationsBD InformationsOperations=DéclarationPrixDeTransfert.getInformationsOperations();
		MontantTransactionsMethodeDeterminationPrixTransfertBD MontantTransactionsMethodeDeterminationPrixTransfert=InformationsOperations.getMontantTransactionsMethodeDeterminationPrixTransfert();
		
	InformationsOperationsFinancieresBD InformationsOperationsFinancieres=MontantTransactionsMethodeDeterminationPrixTransfert.getInformationsOperationsFinancieres();
	
	InformationsOperationsFinancieres.setTotalAchatsDepensesOperationsFinancieres(updatedInformationsOperationsFinancieres.getTotalAchatsDepensesOperationsFinancieres());
	InformationsOperationsFinancieres.setTotalVentesRevenusOperationsFinancieres(updatedInformationsOperationsFinancieres.getTotalVentesRevenusOperationsFinancieres());
	session.setAttribute("idInformationsOperationsFinancieres", InformationsOperationsFinancieres.getId());
	InterfaceRepositoryInformationsOperationsFinancieres.save(InformationsOperationsFinancieres);
	return ResponseEntity.ok(" mise à jour avec succès");
	










	}

}
