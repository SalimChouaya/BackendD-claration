package com.PrixDeTransfert.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PrixDeTransfert.Backend.models.LigneParticipationLieeBD;


public interface InterfaceRepositoryParticipationLiee extends JpaRepository<LigneParticipationLieeBD, Long>{
 
}
