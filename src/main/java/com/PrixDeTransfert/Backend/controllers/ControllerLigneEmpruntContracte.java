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
import com.PrixDeTransfert.Backend.models.InformationsPretsEmpruntsBD;
import com.PrixDeTransfert.Backend.models.LigneEmpruntContracteBD;
import com.PrixDeTransfert.Backend.models.LignePretAccordeBD;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerLigneEmpruntContracte
{
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceLigneEmpruntContracte ServiceLigneEmpruntContracte ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsOperations/InformationsPretsEmprunts/LigneEmpruntContracte")// lid nekhdhouh mn lignePretAccorde baad mancreew InormationsEmprunts
	public LigneEmpruntContracteBD save(@RequestBody LigneEmpruntContracteBD  a) {
		Long idInformationsPretsEmprunts =ControllerLignePretAccorde.idInformationsPretsEmprunts;
		return ServiceLigneEmpruntContracte.save(a, idInformationsPretsEmprunts);}

	
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsPretsEmprunts InterfaceRepositoryInformationsPretsEmprunts ;
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert;
		@PutMapping("/MiseAjourLigneEmpruntContracte")
		public ResponseEntity<String> updateLigneEmpruntContracte(@RequestBody List<LigneEmpruntContracteBD> updatedLigneEmpruntContracte,HttpSession session) {
		
			Long iddeclaration =(Long) session.getAttribute("Déclarationid");
			DéclarationPrixDeTransfert DéclarationPrixDeTransfert =InterfaceRepositoryDéclarationPrixDeTransfert.findDéclarationPrixDeTransfertById(iddeclaration);
			InformationsOperationsBD InformationsOperations=DéclarationPrixDeTransfert.getInformationsOperations();
			InformationsPretsEmpruntsBD InformationsPretsEmpruntsBD=InformationsOperations.getInformationsPretsEmprunts();
			InformationsPretsEmpruntsBD.setLigneEmpruntContracte(updatedLigneEmpruntContracte);
			InterfaceRepositoryInformationsPretsEmprunts.save(InformationsPretsEmpruntsBD);
			
			return ResponseEntity.ok(" mise à jour avec succès");
}
}