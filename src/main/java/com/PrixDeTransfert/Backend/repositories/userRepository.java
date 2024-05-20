package com.PrixDeTransfert.Backend.repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PrixDeTransfert.Backend.models.User;




@Repository
public interface userRepository extends JpaRepository<com.PrixDeTransfert.Backend.models.User,Long> {

	
	 User findUserById(Long iduser);

	Optional<com.PrixDeTransfert.Backend.models.User> findByLogin(String login);
	
}
