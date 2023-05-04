package com.ty.workSpace_Management.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.workSpace_Management.entity.EmployeeDutyAssignEntity;
import com.ty.workSpace_Management.repo.EmployeeDutyAssignRepo;

@Repository
public class EmployeeDutyAssignDao {

	@Autowired
	private EmployeeDutyAssignRepo repo;

	public EmployeeDutyAssignEntity saveEmployeeDuttyAssign(EmployeeDutyAssignEntity employeeDutyAssignEntity) {
		return repo.save(employeeDutyAssignEntity);
	}

	public EmployeeDutyAssignEntity updateEmployeeDutyAssignEntity(String employeeDutyAssignId,
			EmployeeDutyAssignEntity employee) {
		EmployeeDutyAssignEntity employee1 = repo.findById(employeeDutyAssignId).get();
		if (employee1 != null) {
			employee.setEmployeeDutyAssignId(employeeDutyAssignId);
			return repo.save(employee);
		}

		return null;

	}

	public EmployeeDutyAssignEntity deleteDutyAssignEntity(String employDutyAssignId) {
		EmployeeDutyAssignEntity employee = repo.findById(employDutyAssignId).get();
		if (employee != null) {

			repo.delete(employee);
			return employee;

		}
		return null;

	}

	public EmployeeDutyAssignEntity findDutyAssign(String employDutyAssignId) {
		EmployeeDutyAssignEntity employee = repo.findById(employDutyAssignId).get();

		return employee;

	}

}
