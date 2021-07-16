/**
 * 
 */
package com.platzi.ereservation.sight.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.ereservation.business.services.ClientService;
import com.platzi.ereservation.model.Client;
import com.platzi.ereservation.sightresources.vo.ClientVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Class representing the client service web.
 * 
 * @author Nelson
 *
 */

@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientResource {

	private final ClientService clientService;

	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping
	@ApiOperation(value = "Create client", notes = "Service  to created new client")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successful created client"),
			@ApiResponse(code = 400, message = "request invalid") })
	public ResponseEntity<Client> createClient(@RequestBody ClientVo clientVo) {
		Client client = new Client();
		client.setIdentification(clientVo.getIdentification());
		client.setName(clientVo.getName());
		client.setSurName(clientVo.getSurName());
		client.setDirection(clientVo.getDirection());
		client.setNumberPhone(clientVo.getNumberPhone());
		client.setEmail(client.getEmail());
		return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
	}

	@PutMapping("/{identification}")
	@ApiOperation(value = "Update client", notes = "Service to update a client")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successful update client"),
			@ApiResponse(code = 404, message = "Client not found") })
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

	@DeleteMapping("/{identification}")
	@ApiOperation(value = "Delete Client", notes = "Service to delete a client")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successful delete client"),
			@ApiResponse(code = 404, message = "Client not found") })
	public void removeClient(@PathVariable("identification") String identification) {
		Client client = this.clientService.finByIdentification(identification);
		if (client != null) {
			this.clientService.delete(client);
		}
	}

	@GetMapping
	@ApiOperation(value = "List Clients", notes = "Service to li a client")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clients founds"),
			@ApiResponse(code = 404, message = "Clients not found") })
	public ResponseEntity<List<Client>> findAll() {
		return ResponseEntity.ok(this.clientService.findAll());

	}
}
