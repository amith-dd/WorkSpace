package com.ty.workSpace_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.workSpace_Management.entity.EmployeeEntity;
import com.ty.workSpace_Management.repo.EmployeeRepo;
@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo repo;
	
	public EmployeeEntity saveEmployee(EmployeeEntity employee) {
		return repo.save(employee);
	}
	
	public EmployeeEntity findEmployee(String employeeId) {
		Optional<EmployeeEntity> employee = repo.findById(employeeId);
		if(employee.isPresent()) {
			return employee.get();
		}else {
			return null;
		}
	}
	
	public EmployeeEntity updateEmployee(EmployeeEntity employee, String employeeId) {
		Optional<EmployeeEntity> employee2 = repo.findById(employeeId);
		if(employee2.isPresent()) {
			employee.setEmployeeId(employeeId);
			if(employee.getAddress()==null) {
				employee.setAddress(employee2.get().getAddress());
			}
			if(employee.getEmployeeEmail()==null) {
				employee.setEmployeeEmail(employee2.get().getEmployeeEmail());
			}
			if(employee.getEmployeeName()==null) {
				employee.setEmployeeName(employee2.get().getEmployeeName());
			}
			if(employee.getEmployeePassword()==null) {
				employee.setEmployeePassword(employee2.get().getEmployeePassword());
			}
			return repo.save(employee);
		}else {
			return null;
		}

	}
	
	public EmployeeEntity employeeLogin(String EmployeeEmail, String EmployeePassword) {
		return repo.login(EmployeeEmail, EmployeePassword);
	}
	
	public List<EmployeeEntity> employeesBasedOnRole(String role){
		return repo.employeesBasedOnRole(role);
	}
	public EmployeeEntity getEmployeeByEmail(String email) {
		return repo.getEmployeeByEmail(email);
	}
	
}
