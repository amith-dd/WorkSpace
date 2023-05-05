package com.ty.workSpace_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.workSpace_Management.entity.ClientEntity;

public interface ClientRepo extends JpaRepository<ClientEntity,String> {
	
	@Query("select c from ClientEntity c where c.clientEmail = ?1 and c.clientPassword = ?2 ")
	public ClientEntity clientLogin(String email, String password); 
	
}
