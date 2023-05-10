package com.ty.workSpace_Management.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.workSpace_Management.dao.ClientDao;
import com.ty.workSpace_Management.dao.EmployeeDao;
import com.ty.workSpace_Management.dao.EmployeeDutyAssignDao;
import com.ty.workSpace_Management.dao.ManagerDao;
import com.ty.workSpace_Management.entity.ClientEntity;
import com.ty.workSpace_Management.entity.EmployeeDutyAssignEntity;
import com.ty.workSpace_Management.entity.EmployeeEntity;
import com.ty.workSpace_Management.entity.ManagerEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.exception.ClientNotFound;
import com.ty.workSpace_Management.exception.EmployeeNotFound;
import com.ty.workSpace_Management.exception.IdNotFoundByDutyAssign;
import com.ty.workSpace_Management.exception.IdNotFoundByManager;
@Service
public class EmployeeDutyAssignService {

	@Autowired
	private EmployeeDutyAssignDao dao;

	@Autowired
	private ManagerDao managerDao;
     
	@Autowired
	private ClientDao clientDao;
	
	
	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private EmployeeDutyAssignEntity employeeDutyAssignEntity;

	public ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>> saveEmployeeDuttyAssign(String managerId, String clientId,String empID
			) {

		ManagerEntity manager = managerDao.getManagerByID(managerId);
		if (manager != null) {
			
			ClientEntity client=clientDao.findClientEntity(clientId);{
				
			}
			if(client!=null) {
				
				EmployeeEntity employeeEntity=employeeDao.findEmployee(empID);
				if(employeeEntity!=null) {
					
					
					

					java.util.Date date2 = new java.util.Date();
					Date date = new Date(date2.getTime());
					employeeDutyAssignEntity.setStartDate(date);
					employeeDutyAssignEntity.setEmployee(employeeEntity);
					EmployeeDutyAssignEntity duty = dao.saveEmployeeDuttyAssign(employeeDutyAssignEntity);
					
					List<EmployeeDutyAssignEntity>assign=new ArrayList<>();
					assign.add(duty);
					assign.addAll(client.getEmployeeDuty());
					client.setEmployeeDuty(assign);
					clientDao.updateClientEntity(client, clientId);
					
					
					

					ResponseStructure<EmployeeDutyAssignEntity> responseStructure = new ResponseStructure<>();
					responseStructure.setData(duty);
					responseStructure.setStatus(HttpStatus.CREATED.value());
					responseStructure.setMessage("successfully inserted");
					return new ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>>(responseStructure,
							HttpStatus.CREATED);
					
					
				}
				
				throw new EmployeeNotFound("employee not found "+empID);
			}
             throw new ClientNotFound("client is not found with"+clientId);
		}
         throw new IdNotFoundByManager("manager is not found with  "+managerId);
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
		throw new IdNotFoundByDutyAssign("duty assign object is not found for"+dutyAssignId);
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