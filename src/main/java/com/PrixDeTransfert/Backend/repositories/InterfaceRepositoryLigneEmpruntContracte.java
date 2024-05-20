package com.PrixDeTransfert.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PrixDeTransfert.Backend.models.LigneEmpruntContracteBD;



public interface InterfaceRepositoryLigneEmpruntContracte extends JpaRepository<LigneEmpruntContracteBD,Long> {
	

}
