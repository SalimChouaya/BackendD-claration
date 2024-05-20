package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsEntrepriseDeclaranteBD;
import com.PrixDeTransfert.Backend.models.Qualité;

@Service
public class ServiceQualité {
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryQualité InterfaceRepositoryQualité ;
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsEntrepriseDeclarante InterfaceRepositoryInformationsEntrepriseDeclarante;
	public Qualité save(Qualité a,Long idInformationsEntrepriseDeclarante) {
		InformationsEntrepriseDeclaranteBD InformationsEntrepriseDeclarante=InterfaceRepositoryInformationsEntrepriseDeclarante.findInformationsEntrepriseDeclaranteBDById(idInformationsEntrepriseDeclarante);
	
	a.setInformationsEntrepriseDeclarante(InformationsEntrepriseDeclarante);
	return InterfaceRepositoryQualité.save(a);
	
	
	
	
	}

}
