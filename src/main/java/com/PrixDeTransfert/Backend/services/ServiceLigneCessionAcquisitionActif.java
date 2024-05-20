package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsCessionsAcquisitionsActifsBD;
import com.PrixDeTransfert.Backend.models.LigneCessionAcquisitionActifBD;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsCessionsAcquisitionsActifs;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryLigneCessionAcquisitionActif;

@Service
public class ServiceLigneCessionAcquisitionActif {
	@Autowired
	InterfaceRepositoryLigneCessionAcquisitionActif LigneCessionAcquisitionActif;
   
    @Autowired
    InterfaceRepositoryInformationsCessionsAcquisitionsActifs b;
	public LigneCessionAcquisitionActifBD save(LigneCessionAcquisitionActifBD a, Long IdInformationsCessionsAcquisitionsActifs) {
		InformationsCessionsAcquisitionsActifsBD InformationsCessionsAcquisitionsActifs=b.findInformationsCessionsAcquisitionsActifsBDById(IdInformationsCessionsAcquisitionsActifs);
		a.setInformationsCessionsAcquisitionsActifs(InformationsCessionsAcquisitionsActifs);
		return LigneCessionAcquisitionActif.save(a);
}
}