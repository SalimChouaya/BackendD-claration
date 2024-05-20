package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;
import com.PrixDeTransfert.Backend.models.InformationsGroupeEntreprisesBD;
@Service
public class ServiceInformationsGroupeEntreprises {
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsGroupeEntreprises InterfaceRepositoryInformationsGroupeEntreprises;
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert;
	
	public InformationsGroupeEntreprisesBD save(InformationsGroupeEntreprisesBD a, Long idDeclaratinPrixDeTransfert) {
		
		DéclarationPrixDeTransfert DéclarationPrixDeTransfert  =InterfaceRepositoryDéclarationPrixDeTransfert.findDéclarationPrixDeTransfertById(idDeclaratinPrixDeTransfert);
		a.setDéclarationPrixDeTransfert(DéclarationPrixDeTransfert);
		
		return InterfaceRepositoryInformationsGroupeEntreprises.save(a) ;

}
}