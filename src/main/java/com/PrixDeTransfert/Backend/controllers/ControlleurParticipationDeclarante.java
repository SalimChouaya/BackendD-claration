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
import com.PrixDeTransfert.Backend.models.LigneParticipationDeclaranteBD;
import com.PrixDeTransfert.Backend.models.LigneParticipationLieeBD;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControlleurParticipationDeclarante {

	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceParticipationDeclarante ServiceParticipationDeclarante ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsEntrepriseDeclarante/LigneParticipationDeclarante")
	public LigneParticipationDeclaranteBD save(@RequestBody LigneParticipationDeclaranteBD  a) {
		Long InformationsEntrepriseDeclaranteid=ControlleurInformationsEntrepriseDeclarante.InformationsEntrepriseDeclaranteid;
		return ServiceParticipationDeclarante.save(a, InformationsEntrepriseDeclaranteid);
		

}
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsEntrepriseDeclarante InterfaceRepositoryInformationsEntrepriseDeclarante;
	@PutMapping("/MiseAjourLigneParticipationDeclarante")
	public ResponseEntity<String> updateLigneParticipationDeclarante(@RequestBody List<LigneParticipationDeclaranteBD> updatedLigneParticipationDeclarante,HttpSession session) {

		Long idInformationsEntrepriseDeclarante =(Long) session.getAttribute("idInformationsEntrepriseDeclarante");
		InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclarante=InterfaceRepositoryInformationsEntrepriseDeclarante.findInformationsEntrepriseDeclaranteBDById(idInformationsEntrepriseDeclarante);


	 InformationsEntrepriseDeclarante.setLigneParticipationDeclarante(updatedLigneParticipationDeclarante);
	 InterfaceRepositoryInformationsEntrepriseDeclarante.save(InformationsEntrepriseDeclarante);

	 return ResponseEntity.ok(" mise à jour avec succès");
	}
}