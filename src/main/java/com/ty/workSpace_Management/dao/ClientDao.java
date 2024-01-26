package com.ty.workSpace_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.workSpace_Management.entity.ClientEntity;
import com.ty.workSpace_Management.repo.ClientRepo;
@Repository
public class ClientDao {
	@Autowired
	private ClientRepo repo;
	
	public ClientEntity saveClient(ClientEntity client) {
		return repo.save(client);
	}
	
	public ClientEntity updateClientEntity(ClientEntity client, String clientId) {
		Optional<ClientEntity> client2 = repo.findById(clientId);
		if(client2.isPresent()) {
			client.setClientId(clientId);
			if(client.getAddress()==null) {
				client.setAddress(client2.get().getAddress());
			}
			if(client.getClientEmail()==null) {
				client.setClientEmail(client2.get().getClientEmail());
			}
			if(client.getClientName()==null) {
				client.setClientName(client2.get().getClientName());
			}
			if(client.getClientPassword()==null) {
				client.setClientPassword(client2.get().getClientPassword());
			}
			
			return repo.save(client);
		}else {
			return null;
		}
	}
	
	public ClientEntity findClientEntity(String clientId) {
		Optional<ClientEntity> client = repo.findById(clientId);
		if(client.isPresent()) {
			return client.get();
		}else {
			return null;
		}
	}
	

	public ClientEntity findClientByEmail(String mail) {
		ClientEntity client = repo.findClientByEmail(mail);
		if(client!=null) {
			return client;
		}
		else {
			return null;
		}
	}
	
}
