package com.ty.workSpace_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.workSpace_Management.entity.AddressEntity;

public interface AddressRepo extends JpaRepository<AddressEntity,String> {
	
	
	
}
