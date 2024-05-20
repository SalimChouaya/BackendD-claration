package com.PrixDeTransfert.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PrixDeTransfert.Backend.models.LigneAutreOperationBD;



public interface InterfaceRepositoryLigneAutreOperation extends JpaRepository<LigneAutreOperationBD,Long> {
	

}
