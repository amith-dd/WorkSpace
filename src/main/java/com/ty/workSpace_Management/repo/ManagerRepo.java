package com.ty.workSpace_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.workSpace_Management.entity.ManagerEntity;
public interface ManagerRepo  extends JpaRepository<ManagerEntity, String>{
	
	@Query("select a from ManagerEntity a where a.managerEmail=?1")
	public ManagerEntity findManagerByEmail(String managerEmail);

}
