package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsAutresOperationsBD;
import com.PrixDeTransfert.Backend.models.LigneAutreOperationBD;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsAutresOperations;

@Service
public class ServiceLigneAutreOperation  {

	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryLigneAutreOperation InterfaceRepositoryLigneAutreOperation;
   
    @Autowired
    InterfaceRepositoryInformationsAutresOperations b;
	public LigneAutreOperationBD save(LigneAutreOperationBD a, Long idInformationsAutresOperations) {
		InformationsAutresOperationsBD InformationsAutresOperations=b.findInformationsAutresOperationsBDById(idInformationsAutresOperations);
		a.setInformationsAutresOperations(InformationsAutresOperations);
		return InterfaceRepositoryLigneAutreOperation.save(a);
		
	}

}
