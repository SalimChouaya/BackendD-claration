package com.PrixDeTransfert.Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PrixDeTransfert.Backend.models.InformationsRemunerationsBiensCorporelsIncorporelsBD;
import com.PrixDeTransfert.Backend.models.LigneRemunerationBiensBD;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsRemunerationsBiens;
import com.PrixDeTransfert.Backend.services.ServiceLigneRemunerationBiens;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerLigneRemunerationBiens {
	@Autowired
	private ServiceLigneRemunerationBiens LigneRemunerationBiens ;
	
	@PostMapping("/DéclarationPrixDeTransfert/MontantTransaction/InformationsRemunerationsBiensCorporelsIncorporels/LigneRemunerationBiens")
	public LigneRemunerationBiensBD save(@RequestBody LigneRemunerationBiensBD  a) {
		Long idInformationsRemunerationsBiensCorporelsIncorporels=ControllerInformationsRemunerationsBiensCorporelsIncorporels.idInformationsRemunerationsBiensCorporelsIncorporels;
		return LigneRemunerationBiens.save(a, idInformationsRemunerationsBiensCorporelsIncorporels);}

@Autowired
InterfaceRepositoryInformationsRemunerationsBiens InterfaceRepositoryInformationsRemunerationsBiensCorporelsIncorporels;
@PutMapping("/MiseAjourLigneRemunerationsBiens")
public ResponseEntity<String> updateLigneRemunerationsBiens(@RequestBody List<LigneRemunerationBiensBD> updatedLigneRemunerationsBiens,HttpSession session) {

 Long idInformations=(Long)session.getAttribute("idInformationsRemunerations");
 

 InformationsRemunerationsBiensCorporelsIncorporelsBD InformationsRemunerationsBiensCorporelsIncorporels=InterfaceRepositoryInformationsRemunerationsBiensCorporelsIncorporels.findInformationsRemunerationsBiensCorporelsIncorporelsBDById(idInformations);
 
 InformationsRemunerationsBiensCorporelsIncorporels.setLigneRemunerationBiens(updatedLigneRemunerationsBiens);
 
 InterfaceRepositoryInformationsRemunerationsBiensCorporelsIncorporels.save(InformationsRemunerationsBiensCorporelsIncorporels);
 return ResponseEntity.ok(" mise à jour avec succès");
}}




























