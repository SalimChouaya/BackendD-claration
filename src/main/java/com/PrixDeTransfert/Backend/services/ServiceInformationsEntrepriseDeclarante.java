package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;
import com.PrixDeTransfert.Backend.models.InformationsEntrepriseDeclaranteBD;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsEntrepriseDeclarante;
@Service

public class ServiceInformationsEntrepriseDeclarante {
	@Autowired
	InterfaceRepositoryInformationsEntrepriseDeclarante InterfaceRepositoryInformationsEntrepriseDeclarante;
	@Autowired
	InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert;
	
	public InformationsEntrepriseDeclaranteBD save(InformationsEntrepriseDeclaranteBD a, Long idDeclaratinPrixDeTransfert) {
		
		DéclarationPrixDeTransfert DéclarationPrixDeTransfert=InterfaceRepositoryDéclarationPrixDeTransfert.findDéclarationPrixDeTransfertById(idDeclaratinPrixDeTransfert);
		a.setDéclarationPrixDeTransfert(DéclarationPrixDeTransfert);
		
		return InterfaceRepositoryInformationsEntrepriseDeclarante.save(a);
		
	}

}
