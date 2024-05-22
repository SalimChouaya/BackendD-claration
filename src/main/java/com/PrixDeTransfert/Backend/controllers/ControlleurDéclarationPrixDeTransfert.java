package com.PrixDeTransfert.Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;
import com.PrixDeTransfert.Backend.models.Entreprise;

import jakarta.servlet.http.HttpSession;


@RestController
public class ControlleurDéclarationPrixDeTransfert {
	public static Long Déclarationid ;
	@Autowired
	private com.PrixDeTransfert.Backend.services.ServiceDéclarationPrixDeTransfert ServiceDéclarationPrixDeTransfert;
	@Autowired 
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryCreerCompte InterfaceRepositoryCreerCompte ;
	
	@PostMapping("/DéclarationPrixDeTransfert")
	public DéclarationPrixDeTransfert save(@RequestBody DéclarationPrixDeTransfert a) {
		Long entrepriseid=ControllerCreerCompteEntreprise.entrepriseId;
		DéclarationPrixDeTransfert Declaration =ServiceDéclarationPrixDeTransfert.save(a,entrepriseid);
		Déclarationid =Declaration.getId();
		return Declaration;
		
	}
	
	@PutMapping("/miseAJourDéclaration")
	public ResponseEntity<String> updateDéclaration(@RequestBody DéclarationPrixDeTransfert updatedDéclaration,HttpSession session) {
		Long identreprise =(Long) session.getAttribute("identreprise");
		Entreprise Entreprise=InterfaceRepositoryCreerCompte.findEntrepriseById(identreprise);
		DéclarationPrixDeTransfert existingDeclaration =Entreprise.getDéclarationPrixDeTransfert();
		 if (existingDeclaration == null) {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("vous n'avez pas une déclaration");
		    }
		session.setAttribute("idDéclaration", existingDeclaration.getId());
		if(updatedDéclaration.getCodeActe()!=null) {
		existingDeclaration.setCodeActe(updatedDéclaration.getCodeActe());}
		if(updatedDéclaration.getCodeCatégorie()!=null) {
		existingDeclaration.setCodeCatégorie(updatedDéclaration.getCodeCatégorie());}
		if(updatedDéclaration.getCodeTva()!=null) {
		existingDeclaration.setCodeTva(updatedDéclaration.getCodeTva());}
		if(updatedDéclaration.getDateDébutExercice()!=null) {
		existingDeclaration.setDateDébutExercice(updatedDéclaration.getDateDébutExercice());}
		if(updatedDéclaration.getDateFinExercice()!=null) {
		existingDeclaration.setDateFinExercice(updatedDéclaration.getDateFinExercice());}
		if(updatedDéclaration.getExercice()!=null) {
		existingDeclaration.setExercice(updatedDéclaration.getExercice());}
		if(updatedDéclaration.getMatriculeFiscalDeclarant()!=null) {
		existingDeclaration.setMatriculeFiscalDeclarant(updatedDéclaration.getMatriculeFiscalDeclarant());}
		if(updatedDéclaration.getTypeDéclaration()!=null) {
		existingDeclaration.setTypeDéclaration(updatedDéclaration.getTypeDéclaration());}
		
		return ResponseEntity.ok("Entreprise mise à jour avec succès");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}