package com.PrixDeTransfert.Backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.InformationsRemunerationsBiensCorporelsIncorporelsBD;
import com.PrixDeTransfert.Backend.models.LigneRemunerationBiensBD;

@Service

public class ServiceLigneRemunerationBiens  {
    @Autowired
    com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryLigneRemunerationBiens LigneRemunerationBiens;
   
    @Autowired
    com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryInformationsRemunerationsBiens b;
	public LigneRemunerationBiensBD save(LigneRemunerationBiensBD a, Long IdinformationsRemunerations) {
		InformationsRemunerationsBiensCorporelsIncorporelsBD InformationsRemunerationsBiensCorporelsIncorporels=b.findInformationsRemunerationsBiensCorporelsIncorporelsBDById(IdinformationsRemunerations);
		a.setInformationsRemunerationsBiensCorporelsIncorporels(InformationsRemunerationsBiensCorporelsIncorporels);
		return LigneRemunerationBiens.save(a);
		
	}}