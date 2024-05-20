package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsGroupeEntreprisesBD;
import com.PrixDeTransfert.Backend.models.InformationsMereEntiteUltimeBD;

@Service
public class ServiceInformationsMereEntiteUltime {
  @Autowired
  com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsMereEntiteUltime InterfaceRepositoryInformationsMereEntiteUltime;
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsGroupeEntreprises InterfaceRepositoryInformationsGroupeEntreprises ;
	public InformationsMereEntiteUltimeBD save(InformationsMereEntiteUltimeBD a, Long idInformationsGroupeEntreprises) {
		
		InformationsGroupeEntreprisesBD InformationsGroupeEntreprises=InterfaceRepositoryInformationsGroupeEntreprises.findInformationsGroupeEntreprisesBDById(idInformationsGroupeEntreprises);
		a.setInformationsGroupeEntreprises(InformationsGroupeEntreprises);
		return InterfaceRepositoryInformationsMereEntiteUltime.save(a);
	}

}
