package com.PrixDeTransfert.Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.PrixDeTransfert.Backend.models.InformationsGroupeEntreprisesBD;
import com.PrixDeTransfert.Backend.models.LigneActifInCorporelBD;

import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsGroupeEntreprises;

import jakarta.servlet.http.HttpSession;

public class ControlleurLigneActifInCorporel {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceLigneActifInCorporel ServiceLigneActifInCorporel ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsGroupesEntreprises/ActifInCorporel")
	public LigneActifInCorporelBD save(@RequestBody LigneActifInCorporelBD  a,HttpSession session) {
		Long idInformationsGroupeEntreprises=(Long) session.getAttribute("idInformationsGroupeEntreprises");
		return ServiceLigneActifInCorporel.save(a, idInformationsGroupeEntreprises);

}
	

@Autowired
	InterfaceRepositoryInformationsGroupeEntreprises InterfaceRepositoryGroupeEntreprises;

	@PutMapping("/MiseAjourLigneActifInCorporel")
	public ResponseEntity<String> updateLigneActifInCorporel(@RequestBody List<LigneActifInCorporelBD> updatedLigneActifInCorporel,HttpSession session) {
	Long idinformationsGroupeEntreprise=(Long) session.getAttribute("idinformationsGroupeEntreprise");
	InformationsGroupeEntreprisesBD InformationsGroupeEntreprises=InterfaceRepositoryGroupeEntreprises.findInformationsGroupeEntreprisesBDById(idinformationsGroupeEntreprise);
InformationsGroupeEntreprises.setLigneActifInCorporel(updatedLigneActifInCorporel);


InterfaceRepositoryGroupeEntreprises.save(InformationsGroupeEntreprises);

return ResponseEntity.ok(" mise à jour avec succès");




	}
}
