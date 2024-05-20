package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsServicesBD;
import com.PrixDeTransfert.Backend.models.MontantTransactionsMethodeDeterminationPrixTransfertBD;
@Service

public class ServiceInformationsServices  {

	@Autowired
	ServiceMontantTransactionsMethodeDeterminationPrixTransfert service;
    @Autowired
    com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryMontantTransactionsMethodeDeterminationPrixTransfert b;
    @Autowired
    com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsServices InterfaceRepositoryInformationsServices;
	public InformationsServicesBD save(InformationsServicesBD a, Long idMontantTransactions) {
		MontantTransactionsMethodeDeterminationPrixTransfertBD MontantTransactionsMethodeDeterminationPrixTransfert=b.findMontantTransactionsMethodeDeterminationPrixTransfertBDById(idMontantTransactions);
		a.setMontantTransactionsMethodeDeterminationPrixTransfert(MontantTransactionsMethodeDeterminationPrixTransfert);
		return  InterfaceRepositoryInformationsServices.save(a);
	}

}
