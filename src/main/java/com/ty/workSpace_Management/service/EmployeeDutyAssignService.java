package com.ty.workSpace_Management.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.workSpace_Management.dao.EmployeeDao;
import com.ty.workSpace_Management.dao.EmployeeDutyAssignDao;
import com.ty.workSpace_Management.dao.ManagerDao;
import com.ty.workSpace_Management.entity.EmployeeDutyAssignEntity;
import com.ty.workSpace_Management.entity.EmployeeEntity;
import com.ty.workSpace_Management.entity.ManagerEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
@Service
public class EmployeeDutyAssignService {

	@Autowired
	private EmployeeDutyAssignDao dao;

	@Autowired
	private ManagerDao managerDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private EmployeeDutyAssignEntity employeeDutyAssignEntity;

	public ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>> saveEmployeeDuttyAssign(String managerId,
			List<String> id) {

		ManagerEntity manager = managerDao.getManagerByID(managerId);
		if (manager != null) {
			List<EmployeeEntity> employees = new ArrayList<>();
			for (String string : id) {
				employees.add(employeeDao.findEmployee(string));
			}

			java.util.Date date2 = new java.util.Date();
			Date date = new Date(date2.getTime());
			employeeDutyAssignEntity.setStartDate(date);
			employeeDutyAssignEntity.setEmployee(employees);
			EmployeeDutyAssignEntity duty = dao.saveEmployeeDuttyAssign(employeeDutyAssignEntity);

			ResponseStructure<EmployeeDutyAssignEntity> responseStructure = new ResponseStructure<>();
			responseStructure.setData(duty);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("successfully inserted");
			return new ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>>(responseStructure,
					HttpStatus.CREATED);
		}
		return null;

	}

	public ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>> updateEmployeeDuttyAssign(String dutyAssignId,
			List<String> id) {
		EmployeeDutyAssignEntity assign = dao.findDutyAssign(dutyAssignId);
		if (assign != null) {
			List<EmployeeEntity> employees = new ArrayList<>();
			for (String string : id) {
				employees.add(employeeDao.findEmployee(string));
			}
			employees.addAll(assign.getEmployee());

			assign.setEmployee(employees);
			EmployeeDutyAssignEntity duty = dao.updateEmployeeDutyAssignEntity(dutyAssignId, assign);

			ResponseStructure<EmployeeDutyAssignEntity> responseStructure = new ResponseStructure<>();
			responseStructure.setData(duty);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successfully updated");
			return new ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>>(responseStructure, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>> endWork(String dutyAssignId) {
		EmployeeDutyAssignEntity assign = dao.findDutyAssign(dutyAssignId);
		if (assign != null) {
			java.util.Date date2 = new java.util.Date();
			Date date = new Date(date2.getTime());
			assign.setEndDate(date);
			EmployeeDutyAssignEntity duty = dao.updateEmployeeDutyAssignEntity(dutyAssignId, assign);

			ResponseStructure<EmployeeDutyAssignEntity> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully work completed");
			responseStructure.setData(duty);
			return new ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>>(responseStructure, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>> getEmployeeDuty(String dutyAssignId) {

		EmployeeDutyAssignEntity assign = dao.findDutyAssign(dutyAssignId);
		ResponseStructure<EmployeeDutyAssignEntity> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully fetched");
		responseStructure.setData(assign);
		return new ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>>(responseStructure, HttpStatus.OK);

	}

}
