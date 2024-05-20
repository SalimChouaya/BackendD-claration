package com.PrixDeTransfert.Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsCessionsAcquisitionsActifsBD;
import com.PrixDeTransfert.Backend.models.InformationsServicesBD;
import com.PrixDeTransfert.Backend.models.LigneCessionAcquisitionActifBD;
import com.PrixDeTransfert.Backend.models.LigneServiceBD;
import com.PrixDeTransfert.Backend.services.ServiceLigneCessionAcquisitionActif;

import jakarta.servlet.http.HttpSession;
@RestController
public class ControllerLigneCessionAcquisitionActif {
	@Autowired
	private ServiceLigneCessionAcquisitionActif LigneCessionAcquisitionActif ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsCessionsAcquisitionsActifs/LigneCessionAcquisitionActif")
	public LigneCessionAcquisitionActifBD save(@RequestBody LigneCessionAcquisitionActifBD a,HttpSession session) {
		Long idInformationsCessionsAcquisitionsActifs=(Long) session.getAttribute("idInformationsCessionsAcquisitionsActifs");
		
		return LigneCessionAcquisitionActif.save(a, idInformationsCessionsAcquisitionsActifs);}

	
	
	
	
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsCessionsAcquisitionsActifs InterfaceRepositoryInformationsCessionsAcquisitionsActifs;
	@PutMapping("/MiseAjourLigneCessionAcquisitionActif")
	public ResponseEntity<String> updateLigneCessionAcquisitionActif(@RequestBody List<LigneCessionAcquisitionActifBD> updatedLigneCessionAcquisitionActif,HttpSession session) {

	 Long idInformations=(Long)session.getAttribute("idInformationsCessionsAcquisitionsActifs");
	 

	 InformationsCessionsAcquisitionsActifsBD InformationsCessionsAcquisitionsActifs=InterfaceRepositoryInformationsCessionsAcquisitionsActifs.findInformationsCessionsAcquisitionsActifsBDById(idInformations);
	 
	 InformationsCessionsAcquisitionsActifs.setLigneCessionAcquisitionActif(updatedLigneCessionAcquisitionActif);
	 
	 InterfaceRepositoryInformationsCessionsAcquisitionsActifs.save(InformationsCessionsAcquisitionsActifs);
	 return ResponseEntity.ok(" mise à jour avec succès");
	}



	
	
	
	
	
	
	
	
	
	
	
	
}
