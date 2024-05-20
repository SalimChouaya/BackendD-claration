package com.PrixDeTransfert.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PrixDeTransfert.Backend.models.LigneParticipationDeclaranteBD;



public interface InterfaceRepositoryParticipationDeclarante extends JpaRepository<LigneParticipationDeclaranteBD,Long> {
	

}
