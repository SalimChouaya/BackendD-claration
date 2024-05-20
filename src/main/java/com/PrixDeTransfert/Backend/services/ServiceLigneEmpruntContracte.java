package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsPretsEmpruntsBD;
import com.PrixDeTransfert.Backend.models.LigneEmpruntContracteBD;

@Service
public class ServiceLigneEmpruntContracte {
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryLigneEmpruntContracte InterfaceRepositoryLigneEmpruntContracte ; 
	@Autowired
	com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsPretsEmprunts InterfaceRepositoryInformationsPretsEmprunts ;
	
	public LigneEmpruntContracteBD save(LigneEmpruntContracteBD a ,Long idInformationsPretsEmprunts) {
		InformationsPretsEmpruntsBD InformationsPretsEmprunts=InterfaceRepositoryInformationsPretsEmprunts.findInformationsPretsEmpruntsBDById(idInformationsPretsEmprunts);
		a.setInformationsPretsEmprunts(InformationsPretsEmprunts);
		
		return InterfaceRepositoryLigneEmpruntContracte.save(a);
	}

}
