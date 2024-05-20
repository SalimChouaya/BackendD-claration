package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsEntrepriseDeclaranteBD;
import com.PrixDeTransfert.Backend.models.LigneParticipationLieeBD;
@Service
public class ServiceParticipationLiee {
    @Autowired 
    com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryParticipationLiee InterfaceRepositoryParticipationLiee;
    @Autowired
    com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsEntrepriseDeclarante InterfaceRepositoryInformationsEntrepriseDeclarante;


	
	public LigneParticipationLieeBD save(LigneParticipationLieeBD a, Long idInformationsEntrepriseDeclarante) {
		
		InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclarante=InterfaceRepositoryInformationsEntrepriseDeclarante.findInformationsEntrepriseDeclaranteBDById(idInformationsEntrepriseDeclarante);
		a.setInformationsEntrepriseDeclarante(InformationsEntrepriseDeclarante);
		return InterfaceRepositoryParticipationLiee.save(a);
		
	}}
