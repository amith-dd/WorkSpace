package com.ty.workSpace_Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.workSpace_Management.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, String> {
	
	
	@Query(" select e from EmployeeEntity e where e.employeeRole=?1 ")
	public List<EmployeeEntity> employeesBasedOnRole(String role);
	
	@Query(" select e from EmployeeEntity e where e.employeeEmail=?1 ")
	public EmployeeEntity getEmployeeByEmail(String email);
	
}
