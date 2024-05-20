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
import com.PrixDeTransfert.Backend.models.InformationsAutresOperationsBD;
import com.PrixDeTransfert.Backend.models.InformationsOperationsBD;
import com.PrixDeTransfert.Backend.models.InformationsPretsEmpruntsBD;
import com.PrixDeTransfert.Backend.models.LignePretAccordeBD;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerLignePretAccorde {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceLignePretAccorde ServiceLignePretAccorde;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsOperations/InformationsPretsEmprunts/LignePretAccorde")// lid nekhdhouh waktli nasn3o awel mara InformationsOperations f valeur Exploitation 
	public LignePretAccordeBD save(@RequestBody LignePretAccordeBD  a,HttpSession session) {
		Long idInformationsOperations=(Long) session.getAttribute("idInformationsOperations");
		LignePretAccordeBD LignePretAccordeBD=ServiceLignePretAccorde.save(a, idInformationsOperations);
		session.setAttribute("idInformationsPretsEmprunts",LignePretAccordeBD.getInformationsPretsEmprunts().getId());
		return LignePretAccordeBD ;}
@Autowired
com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsPretsEmprunts InterfaceRepositoryInformationsPretsEmprunts ;
@Autowired
com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert;
	@PutMapping("/MiseAjourLignePretAccorde")
	public ResponseEntity<String> updateLignePretAccorde(@RequestBody List<LignePretAccordeBD> updatedLignePretAccorde,HttpSession session) {
	
		Long iddeclaration =(Long) session.getAttribute("Déclarationid");
		DéclarationPrixDeTransfert DéclarationPrixDeTransfert =InterfaceRepositoryDéclarationPrixDeTransfert.findDéclarationPrixDeTransfertById(iddeclaration);
		InformationsOperationsBD InformationsOperations=DéclarationPrixDeTransfert.getInformationsOperations();
		InformationsPretsEmpruntsBD InformationsPretsEmpruntsBD=InformationsOperations.getInformationsPretsEmprunts();
		InformationsPretsEmpruntsBD.setLignePretAccorde(updatedLignePretAccorde);
		InterfaceRepositoryInformationsPretsEmprunts.save(InformationsPretsEmpruntsBD);
		
		return ResponseEntity.ok(" mise à jour avec succès");
		
		

}}
