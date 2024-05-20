package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsPretsEmpruntsBD;
import com.PrixDeTransfert.Backend.models.LignePretAccordeBD;

@Service
public class ServiceLignePretAccorde {
@Autowired
ServiceInformationsPretsEmprunts ServiceInformationsPretsEmprunts ; 
@Autowired
com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryLignePretAccorde InterfaceRepositoryLignePretAccorde ;

	public LignePretAccordeBD save(LignePretAccordeBD a , Long idInformationsOperations) {
		InformationsPretsEmpruntsBD InformationsPretsEmprunts =new InformationsPretsEmpruntsBD();
		ServiceInformationsPretsEmprunts.save(InformationsPretsEmprunts, idInformationsOperations);
		a.setInformationsPretsEmprunts(InformationsPretsEmprunts);
		return InterfaceRepositoryLignePretAccorde.save(a);
	}
}
