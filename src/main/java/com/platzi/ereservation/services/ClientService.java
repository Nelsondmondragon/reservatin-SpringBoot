package com.platzi.ereservation.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.ereservation.model.Client;
import com.platzi.ereservation.repository.clientRepository;

/**
 * Class to define client services.
 * 
 * @author Nelson
 *
 */

@Service
@Transactional(readOnly = true)
public class ClientService {

	private final clientRepository clientRepository;

	public ClientService(clientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	/**
	 * Method to perform the operation of saving client
	 * 
	 * @param client
	 * @return
	 */

	@Transactional
	public Client create(Client client) {
		return this.clientRepository.save(client);
	}

	/**
	 * Method to perform the operation of update client.
	 * 
	 * @param client
	 * @return
	 */
	@Transactional
	public Client update(Client client) {
		return this.clientRepository.save(client);
	}

	/**
	 * Method to perform the operation of delete client.
	 * 
	 * @param client
	 */
	@Transactional
	public void delete(Client client) {
		this.clientRepository.delete(client);

	}

	/**
	 * Method to consult a client by identification.
	 * 
	 * @param identification
	 * @return
	 */

	public Client finByIdentification(String identification) {
		return this.clientRepository.findByIdentification(identification);
	}

}
