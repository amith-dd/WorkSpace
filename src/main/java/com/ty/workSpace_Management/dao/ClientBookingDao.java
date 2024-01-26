package com.ty.workSpace_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.workSpace_Management.entity.ClientBookingEntity;
import com.ty.workSpace_Management.repo.ClientBookingRepo;

@Repository
public class ClientBookingDao {
	@Autowired
	private ClientBookingRepo repo;
	
	public ClientBookingEntity saveClientBooking(ClientBookingEntity clientBooking ) {
		return repo.save(clientBooking);
	}
	
	public ClientBookingEntity updateClientBooking(ClientBookingEntity clientBooking, String clientBookingID) {
		Optional<ClientBookingEntity> clientBooking2 = repo.findById(clientBookingID);
		if(clientBooking2.isPresent()) {
			clientBooking.setId(clientBookingID);
			
			return repo.save(clientBooking);
		}else {
			return null;
		}
	}
	
	public ClientBookingEntity findClientBooking(String clientBookingId) {
		Optional<ClientBookingEntity> clientBooking = repo.findById(clientBookingId);
		if(clientBooking.isPresent()) {
			return clientBooking.get();
		}else {
			return null;
		}
	}
	
	
	public List<ClientBookingEntity> listofClientBookings(){
		List<ClientBookingEntity> list	=repo.findAll();
		if(list.isEmpty()) {
			return null;
		}
		else
			return list;
		
	}
}
