package com.platzi.ereservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.ereservation.model.Client;

/**
 * Interfece to define client related BD operations.
 * 
 * @author Nelson
 *
 */

public interface clientRepository extends JpaRepository<Client, String> {

	public List<Client> findByIdC(String idC);

	public Client findByIdentification(String identification);
	
	
}
