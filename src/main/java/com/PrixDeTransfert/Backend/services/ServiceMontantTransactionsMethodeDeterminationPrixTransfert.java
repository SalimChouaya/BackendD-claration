package com.PrixDeTransfert.Backend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsOperationsBD;
import com.PrixDeTransfert.Backend.models.MontantTransactionsMethodeDeterminationPrixTransfertBD;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryMontantTransactionsMethodeDeterminationPrixTransfert;

@Service
public class ServiceMontantTransactionsMethodeDeterminationPrixTransfert {
  @Autowired
  ServiceInformationsOperations Service;
	
	
	@Autowired
	 InterfaceRepositoryMontantTransactionsMethodeDeterminationPrixTransfert b ;
	
	public MontantTransactionsMethodeDeterminationPrixTransfertBD save(MontantTransactionsMethodeDeterminationPrixTransfertBD a,Long IdDeclaration) {
		InformationsOperationsBD c =new InformationsOperationsBD();
		
		
			
		Service.save(c, IdDeclaration);
		
		
		a.setInformationsOperations(c);
		
		return b.save(a);
		
	}

}
