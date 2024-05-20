package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsEntrepriseDeclaranteBD;
import com.PrixDeTransfert.Backend.models.LigneParticipationDeclaranteBD;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryParticipationDeclarante;
@Service
public class ServiceParticipationDeclarante  {

	 @Autowired 
		InterfaceRepositoryParticipationDeclarante InterfaceRepositoryParticipationDéclarante;
	    @Autowired
	    com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsEntrepriseDeclarante InterfaceRepositoryInformationsEntrepriseDeclarante;


		



		
		public LigneParticipationDeclaranteBD save(LigneParticipationDeclaranteBD a, Long idInformationsEntrepriseDeclarante) {
			InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclarante=InterfaceRepositoryInformationsEntrepriseDeclarante.findInformationsEntrepriseDeclaranteBDById(idInformationsEntrepriseDeclarante);
			a.setInformationsEntrepriseDeclarante(InformationsEntrepriseDeclarante);
			return InterfaceRepositoryParticipationDéclarante.save(a);
			
		}}
