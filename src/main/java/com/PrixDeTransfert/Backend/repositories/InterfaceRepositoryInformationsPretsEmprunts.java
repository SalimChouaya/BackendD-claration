package com.PrixDeTransfert.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PrixDeTransfert.Backend.models.InformationsPretsEmpruntsBD;



public interface InterfaceRepositoryInformationsPretsEmprunts extends JpaRepository<InformationsPretsEmpruntsBD,Long> {
	InformationsPretsEmpruntsBD findInformationsPretsEmpruntsBDById(Long idInformationsPretsEmprunts);

}
