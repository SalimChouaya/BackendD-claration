package com.PrixDeTransfert.Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsRemunerationsBiensCorporelsIncorporelsBD;
import com.PrixDeTransfert.Backend.models.InformationsServicesBD;
import com.PrixDeTransfert.Backend.models.LigneRemunerationBiensBD;
import com.PrixDeTransfert.Backend.models.LigneServiceBD;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsRemunerationsBiens;
import com.PrixDeTransfert.Backend.services.ServiceLigneService;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerLigneService {
	@Autowired
	private ServiceLigneService LigneService ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsServices/LigneService")
	public LigneServiceBD  save(@RequestBody LigneServiceBD  a,HttpSession session) {
		Long idInformationsService=ControllerInformationsServices.idInformationsServices;
		return LigneService.save(a, idInformationsService);}


	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsServices InterfaceRepositoryInformationsServices;
	@PutMapping("/MiseAjourLigneService")
	public ResponseEntity<String> updateLigneService(@RequestBody List<LigneServiceBD> updatedLigneService,HttpSession session) {

	 Long idInformations=(Long)session.getAttribute("idInformationsServices");
	 

	 InformationsServicesBD InformationsService=InterfaceRepositoryInformationsServices.findInformationsServicesBDById(idInformations);
	 
	 InformationsService.setLigneService(updatedLigneService);
	 
	 InterfaceRepositoryInformationsServices.save(InformationsService);
	 return ResponseEntity.ok(" mise à jour avec succès");
	}
















}
