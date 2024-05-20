package com.PrixDeTransfert.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PrixDeTransfert.Backend.models.InformationsGroupeEntreprisesBD;



public interface InterfaceRepositoryInformationsGroupeEntreprises extends JpaRepository<InformationsGroupeEntreprisesBD,Long>{
	InformationsGroupeEntreprisesBD findInformationsGroupeEntreprisesBDById(Long a);

}
