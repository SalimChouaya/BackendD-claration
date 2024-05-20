package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsGroupeEntreprisesBD;
import com.PrixDeTransfert.Backend.models.LigneActifInCorporelBD;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryLigneActifInCorporel;
@Service
public class ServiceLigneActifInCorporel {
	@Autowired
	InterfaceRepositoryLigneActifInCorporel  InterfaceRepositoryLigneActifInCorporel ;
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsGroupeEntreprises InterfaceRepositoryInformationsGroupeEntreprises ;
	
	public LigneActifInCorporelBD save(LigneActifInCorporelBD a, Long idInformationsGroupeEntreprises) {
		InformationsGroupeEntreprisesBD InformationsGroupeEntreprises=InterfaceRepositoryInformationsGroupeEntreprises.findInformationsGroupeEntreprisesBDById(idInformationsGroupeEntreprises);
		a.setInformationsGroupeEntreprises(InformationsGroupeEntreprises);
		return InterfaceRepositoryLigneActifInCorporel.save(a);

}}
