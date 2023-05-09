package com.ty.workSpace_Management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.workSpace_Management.dao.ClientDao;
import com.ty.workSpace_Management.dto.ClientDto;
import com.ty.workSpace_Management.dto.DtoConfig;
import com.ty.workSpace_Management.entity.ClientBookingEntity;
import com.ty.workSpace_Management.entity.ClientEntity;
import com.ty.workSpace_Management.entity.EmployeeDutyAssignEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.exception.ClientNotFound;
import com.ty.workSpace_Management.exception.ClientNotFoundByEmail;
import com.ty.workSpace_Management.exception.ClientPasswordIncorrect;

@Service
public class ClientService {
	@Autowired
	private DtoConfig dto;
	@Autowired
	private ClientDao dao;

	public ResponseEntity<ResponseStructure<ClientDto>> saveClient(ClientEntity client) {
		ResponseStructure<ClientDto> structure = new ResponseStructure<>();
		structure.setData(dto.clientEntityToDto(dao.saveClient(client)));
		structure.setMessage("client has been saved");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<ClientDto>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<ClientDto>> updateClient(ClientEntity client, String clientId) {
		ClientEntity client2 = dao.findClientEntity(clientId);
		if (client2 != null) {
			List<ClientBookingEntity> bookings = new ArrayList<>();
			bookings.addAll(client2.getBookings());
			bookings.addAll(client.getBookings());
			client.setBookings(bookings);

			List<EmployeeDutyAssignEntity> empduties = new ArrayList<>();
			empduties.addAll(client2.getEmployeeDuty());
			empduties.addAll(client.getEmployeeDuty());
			client.setEmployeeDuty(empduties);

			ResponseStructure<ClientDto> structure = new ResponseStructure<>();
			structure.setData(dto.clientEntityToDto(dao.updateClientEntity(client, clientId)));
			structure.setMessage("client updated success");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<ClientDto>>(structure, HttpStatus.OK);

		}

		throw new ClientNotFound("client not found by given id");
	}

	public ResponseEntity<ResponseStructure<ClientDto>> findClientById(String clientId) {
		if (dao.findClientEntity(clientId) != null) {
			ResponseStructure<ClientDto> structure = new ResponseStructure<>();
			structure.setData(dto.clientEntityToDto(dao.findClientEntity(clientId)));
			structure.setMessage("client found");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<ClientDto>>(structure, HttpStatus.FOUND);

		}
		throw new ClientNotFound("client not found");
	}

	public ResponseEntity<ResponseStructure<ClientDto>> getClientByEmail(String email) {
		ClientEntity client = dao.findClientByEmail(email);
		if (client != null) {
			ResponseStructure<ClientDto> structure = new ResponseStructure<>();

			structure.setData(dto.clientEntityToDto(client));
			structure.setMessage("client found successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<ClientDto>>(structure, HttpStatus.OK);
		}
		throw new ClientNotFoundByEmail("client not found for " + email);
	}

	public ResponseEntity<ResponseStructure<ClientDto>> login(String email, String pwd) {
		ClientEntity client = dao.findClientByEmail(email);
		if (client != null) {

			if (client.getClientPassword().equals(pwd)) {
				ResponseStructure<ClientDto> structure = new ResponseStructure<>();
				structure.setData(dto.clientEntityToDto(client));
				structure.setMessage("client found successfully");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<ClientDto>>(structure, HttpStatus.OK);

			}
			throw new ClientPasswordIncorrect("client password wrong, provide correct password");

		}
		throw new ClientNotFound("no client found for given email");
	}
	
	public ResponseEntity<ResponseStructure<ClientEntity>> getClientPasswordByEmail(String email) {
		ClientEntity client = dao.findClientByEmail(email);
		if (client != null) {
			ResponseStructure<ClientEntity> structure = new ResponseStructure<>();

			structure.setData(client);
			structure.setMessage("client found successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<ClientEntity>>(structure, HttpStatus.OK);
		}
		throw new ClientNotFoundByEmail("client not found for " + email);
	}

}
