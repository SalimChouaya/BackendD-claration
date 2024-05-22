package com.PrixDeTransfert.Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsGroupeEntreprisesBD;
import com.PrixDeTransfert.Backend.models.LigneActifCorporelBD;
import com.PrixDeTransfert.Backend.models.LigneActifInCorporelBD;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsGroupeEntreprises;

import jakarta.servlet.http.HttpSession;
@RestController
public class ControlleurLigneActifCorporel {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceLigneActifCorporel ServiceLigneActifCorporel ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsGroupesEntreprises/ActifCorporel")
	public LigneActifCorporelBD save(@RequestBody LigneActifCorporelBD  a) {
		Long idInformationsGroupeEntreprises=ControlleurInformationsGroupeEntreprises.idInformationsGroupeEntreprises;
		return ServiceLigneActifCorporel.save(a, idInformationsGroupeEntreprises);
}
	


	@Autowired
	InterfaceRepositoryInformationsGroupeEntreprises InterfaceRepositoryGroupeEntreprises;

	@PutMapping("/MiseAjourLigneActifCorporel")
	public ResponseEntity<String> updateLigneActifCorporel(@RequestBody List<LigneActifCorporelBD> updatedLigneActifCorporel,HttpSession session) {
	Long idinformationsGroupeEntreprise=(Long) session.getAttribute("idinformationsGroupeEntreprise");
	InformationsGroupeEntreprisesBD InformationsGroupeEntreprises=InterfaceRepositoryGroupeEntreprises.findInformationsGroupeEntreprisesBDById(idinformationsGroupeEntreprise);
InformationsGroupeEntreprises.setLigneActifCorporel(updatedLigneActifCorporel);


InterfaceRepositoryGroupeEntreprises.save(InformationsGroupeEntreprises);

return ResponseEntity.ok(" mise à jour avec succès");




	}















}
