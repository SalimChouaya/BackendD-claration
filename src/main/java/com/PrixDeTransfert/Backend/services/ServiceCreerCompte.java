package com.PrixDeTransfert.Backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrixDeTransfert.Backend.models.Entreprise;
import com.PrixDeTransfert.Backend.models.User;
import com.PrixDeTransfert.Backend.repositories.InterfaceRepositoryCreerCompte;
@Service
public class ServiceCreerCompte {
  @Autowired
	private InterfaceRepositoryCreerCompte InterfaceRepositoryCreerCompte;
  @Autowired
  private com.PrixDeTransfert.Backend.repositories.userRepository InterfaceRepositoryUser ;
  
	public Entreprise save(Entreprise a , Long idUser) {
		User user=InterfaceRepositoryUser.findUserById(idUser);
		a.setUser(user);
		return InterfaceRepositoryCreerCompte.save(a);
		
	}

	public Entreprise findEntrepriseById(Long a) {
	
	 return InterfaceRepositoryCreerCompte.findEntrepriseById(a);
	}


	


	


	

}
