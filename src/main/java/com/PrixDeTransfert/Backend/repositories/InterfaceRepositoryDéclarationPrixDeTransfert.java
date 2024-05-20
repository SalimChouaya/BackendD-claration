package com.PrixDeTransfert.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PrixDeTransfert.Backend.models.DéclarationPrixDeTransfert;



public interface InterfaceRepositoryDéclarationPrixDeTransfert  extends JpaRepository<DéclarationPrixDeTransfert,Long > {
	
	DéclarationPrixDeTransfert findDéclarationPrixDeTransfertById(Long a);
	
}
