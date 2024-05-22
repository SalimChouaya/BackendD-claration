package com.PrixDeTransfert.Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsEntrepriseDeclaranteBD;
import com.PrixDeTransfert.Backend.models.LigneParticipationLieeBD;
import com.PrixDeTransfert.Backend.models.ModificationLiensCapitalAuCoursExerciceBD;

import jakarta.servlet.http.HttpSession;
@RestController
public class ControlleurParticipationLiee {

	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceParticipationLiee ServiceParticipationLiee ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsEntrepriseDeclarante/LigneParticipationLiee")
	
	public LigneParticipationLieeBD save(@RequestBody LigneParticipationLieeBD a) {
		Long InformationsEntrepriseDeclaranteid=ControlleurInformationsEntrepriseDeclarante.InformationsEntrepriseDeclaranteid;
		return ServiceParticipationLiee.save(a, InformationsEntrepriseDeclaranteid);
		
	}
@Autowired
com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsEntrepriseDeclarante InterfaceRepositoryInformationsEntrepriseDeclarante;
@PutMapping("/MiseAjourLigneParticipationLiee")
public ResponseEntity<String> updateLigneParticipationLiee(@RequestBody List<LigneParticipationLieeBD> updatedLigneParticipationLiee,HttpSession session) {

	Long idInformationsEntrepriseDeclarante =(Long) session.getAttribute("idInformationsEntrepriseDeclarante");
	InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclarante=InterfaceRepositoryInformationsEntrepriseDeclarante.findInformationsEntrepriseDeclaranteBDById(idInformationsEntrepriseDeclarante);


 InformationsEntrepriseDeclarante.setLigneParticipationLiee(updatedLigneParticipationLiee);
 InterfaceRepositoryInformationsEntrepriseDeclarante.save(InformationsEntrepriseDeclarante);

 return ResponseEntity.ok(" mise à jour avec succès");
}
}




