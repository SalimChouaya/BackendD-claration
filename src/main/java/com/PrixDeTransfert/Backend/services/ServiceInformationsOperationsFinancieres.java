package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsOperationsFinancieresBD;
import com.PrixDeTransfert.Backend.models.MontantTransactionsMethodeDeterminationPrixTransfertBD;

@Service
public class ServiceInformationsOperationsFinancieres  {
	@Autowired
	ServiceMontantTransactionsMethodeDeterminationPrixTransfert service;
    @Autowired
    com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryMontantTransactionsMethodeDeterminationPrixTransfert b;
    @Autowired
    com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsOperationsFinancieres InterfaceRepositoryInformationsOperationsFinancieres;
	
	public InformationsOperationsFinancieresBD save(InformationsOperationsFinancieresBD a, Long IdMontantTransactions) {
		MontantTransactionsMethodeDeterminationPrixTransfertBD MontantTransactionsMethodeDeterminationPrixTransfert=b.findMontantTransactionsMethodeDeterminationPrixTransfertBDById(IdMontantTransactions);
		a.setMontantTransactionsMethodeDeterminationPrixTransfert(MontantTransactionsMethodeDeterminationPrixTransfert);
		return InterfaceRepositoryInformationsOperationsFinancieres.save(a);
	}

}
