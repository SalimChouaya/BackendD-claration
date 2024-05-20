package com.PrixDeTransfert.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PrixDeTransfert.Backend.models.LigneServiceBD;



public interface InterfaceRepositoryLigneService extends JpaRepository<LigneServiceBD,Long>{
	

}
