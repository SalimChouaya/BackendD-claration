package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryCreerCompte;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;
import com.PrixDeTransfert.Backend.models.Entreprise;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryDéclarationPrixDeTransfert;
@Service
public class ServiceDéclarationPrixDeTransfert  {
    @Autowired
	private InterfaceRepositoryDéclarationPrixDeTransfert InterfaceRepositoryDéclarationPrixDeTransfert;
    @Autowired
    private InterfaceRepositoryCreerCompte InterfaceRepositoryCreerCompte;
	public DéclarationPrixDeTransfert save(DéclarationPrixDeTransfert a,Long entrepriseid) {
		
		Entreprise Entreprise=InterfaceRepositoryCreerCompte.findEntrepriseById(entrepriseid);
		 
		a.setEntreprise(Entreprise);
		return InterfaceRepositoryDéclarationPrixDeTransfert.save(a);
	}
	
	
 
}
