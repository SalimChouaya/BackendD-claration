package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsGroupeEntreprisesBD;
import com.PrixDeTransfert.Backend.models.InformationsMereEntiteUltimeBD;
import com.PrixDeTransfert.Backend.models.RestructurationsGroupeEntreprisesBD;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsGroupeEntreprises;

import jakarta.servlet.http.HttpSession;

@RestController 
public class ControlleurInformationsMereEntiteUltime {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceInformationsMereEntiteUltime ServiceInformationsMereEntiteUltime ;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsGroupesEntreprises/InformationsMereEntiteUltime")
	public InformationsMereEntiteUltimeBD save(@RequestBody InformationsMereEntiteUltimeBD  a,HttpSession session) {
		Long idInformationsGroupeEntreprises=(Long) session.getAttribute("idInformationsGroupeEntreprises");
		
		return ServiceInformationsMereEntiteUltime.save(a, idInformationsGroupeEntreprises);
		

}
	@Autowired
	InterfaceRepositoryInformationsGroupeEntreprises InterfaceRepositoryGroupeEntreprises;
	@PutMapping("/MiseAjourInformationsEntiteMereUltime")
	public ResponseEntity<String> updateInformationsEntiteMereUltime(@RequestBody InformationsMereEntiteUltimeBD updatedInformationsMereEntiteUltime,HttpSession session) {
		Long idinformationsGroupeEntreprise=(Long) session.getAttribute("idinformationsGroupeEntreprise");
		InformationsGroupeEntreprisesBD InformationsGroupeEntreprises=InterfaceRepositoryGroupeEntreprises.findInformationsGroupeEntreprisesBDById(idinformationsGroupeEntreprise);
		InformationsMereEntiteUltimeBD existingInformationsMereEntiteUltime=InformationsGroupeEntreprises.getInformationsMereEntiteUltime();
		
		existingInformationsMereEntiteUltime.setAdresseSiegeSocial(updatedInformationsMereEntiteUltime.getAdresseSiegeSocial());
		existingInformationsMereEntiteUltime.setEtatTerritoire(updatedInformationsMereEntiteUltime.getEtatTerritoire());
		existingInformationsMereEntiteUltime.setIdentifiant(updatedInformationsMereEntiteUltime.getIdentifiant());
		existingInformationsMereEntiteUltime.setMatriculeFiscal(updatedInformationsMereEntiteUltime.getMatriculeFiscal());
		existingInformationsMereEntiteUltime.setRaisonSociale(updatedInformationsMereEntiteUltime.getRaisonSociale());
		
		return ResponseEntity.ok(" mise à jour avec succès");}
	
	
	
	
	
	
	
}