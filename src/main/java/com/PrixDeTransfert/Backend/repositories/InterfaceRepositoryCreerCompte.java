package com.PrixDeTransfert.Backend.repositories;




import org.springframework.data.jpa.repository.JpaRepository;

import com.PrixDeTransfert.Backend.models.Entreprise;




public interface InterfaceRepositoryCreerCompte extends JpaRepository<Entreprise, Long> {
    
    Entreprise findEntrepriseById( Long id);
}