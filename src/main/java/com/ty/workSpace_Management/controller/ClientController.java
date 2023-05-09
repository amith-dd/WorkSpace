package com.ty.workSpace_Management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.workSpace_Management.dto.ClientDto;
import com.ty.workSpace_Management.entity.ClientEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.service.ClientService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientService service;
	@ApiOperation(value = "Save client", notes = "API is used to save client")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 400, message = "Id not found for the given client ID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<ClientDto>> saveClient(@Valid @RequestBody ClientEntity client){
		return service.saveClient(client);
	}
	
	
	@ApiOperation(value = "Update client", notes = "API is used to update client for given client Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "succesfully updated"),
			@ApiResponse(code = 400, message = "Id not found for the given client ID") })
	@PutMapping
	public ResponseEntity<ResponseStructure<ClientDto>> updateClient(@Valid @RequestBody ClientEntity client,@RequestParam String clientId){
		return service.updateClient(client, clientId);
	}
	
	
	@ApiOperation(value = "get client", notes = "API is used to get client for client Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "client is fetched"),
			@ApiResponse(code = 400, message = "Id not found for the given client ID") })
	@GetMapping
	public ResponseEntity<ResponseStructure<ClientDto>> findClientById(@RequestParam String clientId){
		return service.findClientById(clientId);
	}
	
	
	@ApiOperation(value = "get client by email", notes = "API is used to get client for client mail")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "client is fetched"),
			@ApiResponse(code = 400, message = "Id not found for the given admin ID") })
	@GetMapping("/getbyemail")
	public ResponseEntity<ResponseStructure<ClientDto>> getClientByEmail(@RequestParam String email){
		return service.getClientByEmail(email);
	}
	
	
	@ApiOperation(value = "client login", notes = "API is used to login client")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "client logged in"),
			@ApiResponse(code = 400, message = "Id not found for the given client email and password") })
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<ClientDto>> clientLogin(@RequestParam String email, @RequestParam String pwd){
		return service.login(email, pwd);
	}
	
	@ApiOperation(value = "get client password", notes = "API is used to get client password using email")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "client found and password retrieved"),
			@ApiResponse(code = 400, message = "Id not found for the given client email") })
	@GetMapping("/pwd")
	public ResponseEntity<ResponseStructure<ClientEntity>> getClientPasswordByEmail(@RequestParam String email){
		return service.getClientPasswordByEmail(email);
	}
	
}
