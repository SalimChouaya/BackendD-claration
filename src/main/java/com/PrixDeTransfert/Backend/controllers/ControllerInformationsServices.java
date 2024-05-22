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
import com.PrixDeTransfert.Backend.models.InformationsRemunerationsBiensCorporelsIncorporelsBD;
import com.PrixDeTransfert.Backend.models.InformationsServicesBD;
import com.PrixDeTransfert.Backend.models.MontantTransactionsMethodeDeterminationPrixTransfertBD;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsRemunerationsBiens;

import jakarta.servlet.http.HttpSession;
@RestController
public class ControllerInformationsServices {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceInformationsServices ServiceInformationsServices  ;
	public static Long idInformationsServices;
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsServices")// lid nekhdho m return mta InformationsValeursExploitation.save(a, idDéclaration)(khatr montantTransaction o informationsOperations yetsan3o mara kahw
	public InformationsServicesBD save(@RequestBody InformationsServicesBD  a) {
		Long idMontantTransaction=ControlleurInformationsValeursExploitation.idMontantTransactions;
		InformationsServicesBD informationsServicesBD=ServiceInformationsServices.save(a, idMontantTransaction);
		idInformationsServices=informationsServicesBD.getId();
		return informationsServicesBD;}
@Autowired
com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert;
	@Autowired
    com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsServices InterfaceRepositoryInformationsServices;
	@PutMapping("/MiseAjourInformationsServices")
	public ResponseEntity<String> updateInformationsServices(@RequestBody InformationsServicesBD updatedInformationsServices,HttpSession session) {
	
		Long iddeclaration =(Long) session.getAttribute("Déclarationid");
		DéclarationPrixDeTransfert DéclarationPrixDeTransfert =InterfaceRepositoryDéclarationPrixDeTransfert.findDéclarationPrixDeTransfertById(iddeclaration);
		InformationsOperationsBD InformationsOperations=DéclarationPrixDeTransfert.getInformationsOperations();
		MontantTransactionsMethodeDeterminationPrixTransfertBD MontantTransactionsMethodeDeterminationPrixTransfert=InformationsOperations.getMontantTransactionsMethodeDeterminationPrixTransfert();
		
	InformationsServicesBD InformationsServices=MontantTransactionsMethodeDeterminationPrixTransfert.getInformationsServices();
	
	InformationsServices.setTotalAchatsDepensesServices(updatedInformationsServices.getTotalAchatsDepensesServices());
	InformationsServices.setTotalVentesServices(updatedInformationsServices.getTotalVentesServices());
	session.setAttribute("idInformationsServices", InformationsServices.getId());
	InterfaceRepositoryInformationsServices.save(InformationsServices);
	return ResponseEntity.ok(" mise à jour avec succès");
	
	
}














}
