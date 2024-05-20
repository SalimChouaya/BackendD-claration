package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsGroupeEntreprisesBD;
import com.PrixDeTransfert.Backend.models.LigneActifCorporelBD;

@Service
public class ServiceLigneActifCorporel {

	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryLigneActifCorporel  InterfaceRepositoryLigneActifCorporel ;
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsGroupeEntreprises InterfaceRepositoryInformationsGroupeEntreprises ;
	
	public LigneActifCorporelBD save(LigneActifCorporelBD a, Long idInformationsGroupeEntreprises) {
		InformationsGroupeEntreprisesBD InformationsGroupeEntreprises=InterfaceRepositoryInformationsGroupeEntreprises.findInformationsGroupeEntreprisesBDById(idInformationsGroupeEntreprises);
		a.setInformationsGroupeEntreprises(InformationsGroupeEntreprises);
		return InterfaceRepositoryLigneActifCorporel.save(a);
	}

}
