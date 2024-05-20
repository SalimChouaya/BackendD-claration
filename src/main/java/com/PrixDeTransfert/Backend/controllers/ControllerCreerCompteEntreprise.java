package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.PrixDeTransfert.Backend.models.*;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryCreerCompte;

import jakarta.servlet.http.HttpSession;


@RestController
public class ControllerCreerCompteEntreprise {
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceCreerCompte ServiceCreerCompte;
	@Autowired
	private com.PrixDeTransfert.Backend.repositories.userRepository InterfaceRepositoryUser ;
	@Autowired
	InterfaceRepositoryCreerCompte InterfaceRepositoryCreerCompte;
	
	@GetMapping("/getDéclaration")
	public Entreprise GetDéclarationComplete(HttpSession session) {
		Long iduser=(Long)session.getAttribute("iduser");
		
		User user = InterfaceRepositoryUser.findUserById(iduser);
		
	    Entreprise existingEntreprise = InterfaceRepositoryCreerCompte.findEntrepriseById(user.getEntreprise().getId());
	    return existingEntreprise ;
		
	}
	@PostMapping("/Entreprise")// le controlleur pour faire la declaration 
	public Object save(@RequestBody com.PrixDeTransfert.Backend.models.Entreprise a, HttpSession session) {
		Long iduser =(Long) session.getAttribute("iduser");
		User user =InterfaceRepositoryUser.findUserById(iduser);
		if(user.getEntreprise()!=null) {
			return "vous avez déja une déclaration";
		}
		Entreprise savedEntreprise = ServiceCreerCompte.save(a,iduser);
        session.setAttribute("entrepriseId", savedEntreprise.getId());
		return savedEntreprise;
		
	}
	@DeleteMapping("/suppressionDeclaration")
	public ResponseEntity<String> deleteEntreprise( HttpSession session) {
	    
	    Long idUser = (Long) session.getAttribute("iduser");
	    

	 
	    User user = InterfaceRepositoryUser.findUserById(idUser);
	    
	    if(user.getEntreprise() == null ) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("vous n'avez pas une déclaration");
	    }
	    
	    Entreprise Entreprise=user.getEntreprise();
	   
	    InterfaceRepositoryCreerCompte.delete(Entreprise);

	    return ResponseEntity.ok("L'entreprise a été supprimée avec succès");
	}
	@PutMapping("/miseAJourEntreprise")
	public ResponseEntity<String> updateEntreprise(@RequestBody Entreprise updatedEntreprise,HttpSession session) {
	    // Récupérer l'entreprise à mettre à jour en fonction de son identifiant 
		Long iduser=(Long) session.getAttribute("iduser");
		User user = InterfaceRepositoryUser.findUserById(iduser);
		 if(user.getEntreprise()==null) {
	    		
	    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("vous n'avez pas une déclaration");
	    		
	    	}
	    Entreprise existingEntreprise = InterfaceRepositoryCreerCompte.findEntrepriseById(user.getEntreprise().getId());
	    
	    
        Long identreprise=user.getEntreprise().getId();
        session.setAttribute("identreprise", identreprise);
        if(updatedEntreprise.getActivitePrincipale()!=null) {
	   existingEntreprise.setActivitePrincipale(updatedEntreprise.getActivitePrincipale());}
        if(updatedEntreprise.getActiviteSecondaire()!=null) {
	   existingEntreprise.setActiviteSecondaire(updatedEntreprise.getActiviteSecondaire());}
        if(updatedEntreprise.getAdresseSiegeSocialEtablissementTunisie()!=null) {
	   existingEntreprise.setAdresseSiegeSocialEtablissementTunisie(updatedEntreprise.getAdresseSiegeSocialEtablissementTunisie());}
        if(updatedEntreprise.getChiffreAffaireAnnuel()!=null) {
	   existingEntreprise.setChiffreAffaireAnnuel(updatedEntreprise.getChiffreAffaireAnnuel());}
        if(updatedEntreprise.getCodePostal() != null) {
	   existingEntreprise.setCodePostal(updatedEntreprise.getCodePostal());}
        if(updatedEntreprise.getFormeJuridique()!=null) {
	   existingEntreprise.setFormeJuridique(updatedEntreprise.getFormeJuridique());}
        if(updatedEntreprise.getNationalite()!=null) {
	   existingEntreprise.setNationalite(updatedEntreprise.getNationalite());}
        if(updatedEntreprise.getNationalite()!=null) {
	   existingEntreprise.setRaisonSocial(updatedEntreprise.getRaisonSocial());}
	   
	   
	   InterfaceRepositoryCreerCompte.save(existingEntreprise);
	    return ResponseEntity.ok("Entreprise mise à jour avec succès");
	}
	
}
