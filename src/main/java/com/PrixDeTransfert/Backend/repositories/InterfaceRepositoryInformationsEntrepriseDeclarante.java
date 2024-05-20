package com.PrixDeTransfert.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PrixDeTransfert.Backend.models.InformationsEntrepriseDeclaranteBD;



public interface InterfaceRepositoryInformationsEntrepriseDeclarante extends JpaRepository<InformationsEntrepriseDeclaranteBD,Long> {
	InformationsEntrepriseDeclaranteBD findInformationsEntrepriseDeclaranteBDById(Long a);

}
