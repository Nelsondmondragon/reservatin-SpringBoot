/**
 * 
 */
package com.platzi.ereservation.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.platzi.ereservation.model.Client;
import com.platzi.ereservation.resources.vo.ClientVo;
import com.platzi.ereservation.services.ClientService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

/**
 * Class representing the client service web.
 * 
 * @author Nelson
 *
 */

@RestController
@RequestMapping("/api/Client")
public class ClientResource {

	private final ClientService clientService;

	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody ClientVo clientVo) {
		Client client = new Client();
		client.setName(clientVo.getName());
		client.setSurName(clientVo.getSurName());
		client.setDirection(clientVo.getDirection());
		client.setNumberPhone(clientVo.getNumberPhone());
		client.setEmail(client.getEmail());
		return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
	}

	@PutMapping("/{identification}")
	public ResponseEntity<Client> updateClietn(@PathVariable("identification") String identification,
			ClientVo clientVo) {

		Client client = this.clientService.finByIdentification(identification);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		} else {
			client.setName(clientVo.getName());
			client.setSurName(clientVo.getSurName());
			client.setDirection(clientVo.getDirection());
			client.setNumberPhone(clientVo.getNumberPhone());
			client.setEmail(client.getEmail());
		}
		return new ResponseEntity<>(this.clientService.update(client), HttpStatus.OK);
	}

}
