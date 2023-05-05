package com.ty.workSpace_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.workSpace_Management.entity.ClientBookingEntity;

public interface ClientBookingRepo extends JpaRepository<ClientBookingEntity, String> {
	
	
	
}
