package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsOperationsBD;
import com.PrixDeTransfert.Backend.models.InformationsPretsEmpruntsBD;

@Service
public class ServiceInformationsPretsEmprunts {
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsPretsEmprunts InterfaceRepositoryInformationsPretsEmprunts;
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsOperations InterfaceRepositoryInformationsOperations;
	
	InformationsPretsEmpruntsBD save(InformationsPretsEmpruntsBD a ,Long idInformationsOperations)  {
		InformationsOperationsBD InformationsOperations=InterfaceRepositoryInformationsOperations.findInformationsOperationsBDById(idInformationsOperations);
		a.setInformationsOperations(InformationsOperations);
		return InterfaceRepositoryInformationsPretsEmprunts.save(a);
		
		
		
		
		
	}

}
