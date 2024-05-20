package com.PrixDeTransfert.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PrixDeTransfert.Backend.models.InformationsServicesBD;



public interface InterfaceRepositoryInformationsServices extends JpaRepository<InformationsServicesBD,Long>{
	InformationsServicesBD findInformationsServicesBDById(Long idInformationsServices);

}
