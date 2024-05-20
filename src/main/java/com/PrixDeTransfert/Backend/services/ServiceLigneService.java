package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsServicesBD;
import com.PrixDeTransfert.Backend.models.LigneServiceBD;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsServices;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryLigneService;
@Service
public class ServiceLigneService  {
	@Autowired
    InterfaceRepositoryLigneService LigneService;
	   
	    @Autowired
	    InterfaceRepositoryInformationsServices b;
	
	public LigneServiceBD save(LigneServiceBD a, Long IdInformationsServices) {
	
		InformationsServicesBD InformationsServices=b.findInformationsServicesBDById(IdInformationsServices);
		a.setInformationsServices(InformationsServices);
		return LigneService.save(a);
	}

}
