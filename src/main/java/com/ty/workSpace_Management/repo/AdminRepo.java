package com.ty.workSpace_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.workSpace_Management.entity.AdminEntity;

public interface AdminRepo extends JpaRepository<AdminEntity, String>{

	@Query("select a from AdminEntity a where a.adminEmail=?1")
	public AdminEntity findAdminByEmail(String email);
	
}
