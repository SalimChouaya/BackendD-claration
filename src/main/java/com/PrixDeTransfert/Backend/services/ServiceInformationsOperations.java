package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;
import com.PrixDeTransfert.Backend.models.InformationsOperationsBD;

@Service
public class ServiceInformationsOperations  {
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsOperations InterfaceRepositoryInformationsOperations;
	
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert;
	public InformationsOperationsBD save(InformationsOperationsBD a, Long idDeclaratinPrixDeTransfert) {
		DéclarationPrixDeTransfert DéclarationPrixDeTransfert=InterfaceRepositoryDéclarationPrixDeTransfert.findDéclarationPrixDeTransfertById(idDeclaratinPrixDeTransfert);
		a.setDéclarationPrixDeTransfert(DéclarationPrixDeTransfert);
		
		return InterfaceRepositoryInformationsOperations.save(a);
		
	}
	

}
