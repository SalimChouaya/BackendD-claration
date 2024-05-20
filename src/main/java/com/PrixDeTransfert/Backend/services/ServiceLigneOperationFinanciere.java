package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsOperationsFinancieresBD;
import com.PrixDeTransfert.Backend.models.LigneOperationFinanciereBD;

@Service
public class ServiceLigneOperationFinanciere {
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryLigneOperationFinanciere LigneOperationFinanciere;
   
    @Autowired
    com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsOperationsFinancieres b;
	public LigneOperationFinanciereBD save(LigneOperationFinanciereBD a, Long IdinformationsOperationsFinancieres) {
		InformationsOperationsFinancieresBD InformationsOperationsFinancieres=b.findInformationsOperationsFinancieresBDById(IdinformationsOperationsFinancieres);
		a.setInformationsOperationsFinancieres(InformationsOperationsFinancieres);
		return LigneOperationFinanciere.save(a);
		
}
}