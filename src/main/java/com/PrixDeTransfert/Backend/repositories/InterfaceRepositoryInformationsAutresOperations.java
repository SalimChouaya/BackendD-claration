package com.PrixDeTransfert.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PrixDeTransfert.Backend.models.InformationsAutresOperationsBD;



public interface InterfaceRepositoryInformationsAutresOperations extends JpaRepository<InformationsAutresOperationsBD,Long> {
	InformationsAutresOperationsBD findInformationsAutresOperationsBDById(Long idInformationsAutresOperations);

}
