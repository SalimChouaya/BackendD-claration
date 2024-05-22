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
import com.PrixDeTransfert.Backend.models.LigneParticipationDeclaranteBD;
import com.PrixDeTransfert.Backend.models.RestructurationsGroupeEntreprisesBD;

import jakarta.servlet.http.HttpSession;
@RestController
public class ControlleurInformationsGroupeEntreprises {
public static Long idInformationsGroupeEntreprises;
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceInformationsGroupeEntreprises ServiceInformationsGroupeEntreprises;
	
	@PostMapping("/DéclarationPrixDeTransfert/InformationsGroupeEntreprises")
	public InformationsGroupeEntreprisesBD save(@RequestBody InformationsGroupeEntreprisesBD a,HttpSession session) {
		Long declarationid =ControlleurDéclarationPrixDeTransfert.Déclarationid;
	    InformationsGroupeEntreprisesBD InformationsGroupeEntrepriseBD=ServiceInformationsGroupeEntreprises.save(a, declarationid);
		idInformationsGroupeEntreprises=InformationsGroupeEntrepriseBD.getId() ;
		return InformationsGroupeEntrepriseBD;
		
	}
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsGroupeEntreprises InterfaceRepositoryInformationsGroupeEntreprises ;
	@PutMapping("/MiseAjourInformationsGroupeEntreprises")
	public ResponseEntity<String> updateInformationsGroupeEntreprises(@RequestBody InformationsGroupeEntreprisesBD updatedInformationsGroupeEntreprise,HttpSession session) {
    Long idDéclaration =(Long) session.getAttribute("Déclarationid");
    InformationsGroupeEntreprisesBD existingInformationsGroupeEntreprises=InterfaceRepositoryInformationsGroupeEntreprises.findInformationsGroupeEntreprisesBDById(idDéclaration);
    existingInformationsGroupeEntreprises.setDescriptionGeneralePolitiquePrixTransfert(updatedInformationsGroupeEntreprise.getDescriptionGeneralePolitiquePrixTransfert());
    existingInformationsGroupeEntreprises.setDescriptionPrincipalesActivites(updatedInformationsGroupeEntreprise.getDescriptionPrincipalesActivites());
    session.setAttribute("idinformationsGroupeEntreprise", existingInformationsGroupeEntreprises.getId());
    
    return ResponseEntity.ok(" mise à jour avec succès");
    		
	}
	@Autowired
	com.PrixDeTransfert.Backend.services.ServiceRestructurationsGroupeEntreprises ServiceRestructurationsGroupeEntreprises;
	@PostMapping("/DéclarationPrixDeTransfert/InformationsGroupeEntreprises/RestructurationsGroupeEntreprises")
	public RestructurationsGroupeEntreprisesBD save(@RequestBody RestructurationsGroupeEntreprisesBD a,HttpSession session) {
		
		return ServiceRestructurationsGroupeEntreprises.save(a, idInformationsGroupeEntreprises);
		
	}
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsGroupeEntreprises InterfaceRepositoryGroupeEntreprises;
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryRestructurationsGroupeEntreprises InterfaceRepositoryRestructurationsGroupeEntreprises;
	@PutMapping("/MiseAjourRestructurationsGroupeEntreprises")
	public ResponseEntity<String> updateRestructurationsGroupeEntreprises(@RequestBody RestructurationsGroupeEntreprisesBD updatedRestructurationsGroupeEntreprises,HttpSession session) {
	
	Long idinformationsGroupeEntreprise=(Long) session.getAttribute("idinformationsGroupeEntreprise");
	InformationsGroupeEntreprisesBD InformationsGroupeEntreprises=InterfaceRepositoryGroupeEntreprises.findInformationsGroupeEntreprisesBDById(idinformationsGroupeEntreprise);
	RestructurationsGroupeEntreprisesBD exsitingRestructurationsGroupeEntreprisesBD=InformationsGroupeEntreprises.getRestructurationsGroupeEntreprises();
	
	
	exsitingRestructurationsGroupeEntreprisesBD.setAffirmation(exsitingRestructurationsGroupeEntreprisesBD.getAffirmation());
	exsitingRestructurationsGroupeEntreprisesBD.setDescription(exsitingRestructurationsGroupeEntreprisesBD.getDescription());
	
	
	
	
	
	return ResponseEntity.ok(" mise à jour avec succès");
	
	
	
	
	
	}
}
