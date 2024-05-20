package com.PrixDeTransfert.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PrixDeTransfert.Backend.models.InformationsOperationsBD;



public interface InterfaceRepositoryInformationsOperations extends JpaRepository<InformationsOperationsBD,Long>{
	
	InformationsOperationsBD findInformationsOperationsBDById(Long idInformationsOperations);
}
