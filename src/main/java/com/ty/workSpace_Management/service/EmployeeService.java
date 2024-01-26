package com.ty.workSpace_Management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.workSpace_Management.dao.EmployeeDao;
import com.ty.workSpace_Management.dto.DtoConfig;
import com.ty.workSpace_Management.dto.EmployeeDto;
import com.ty.workSpace_Management.entity.EmployeeEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.exception.EmployeeNotFound;
import com.ty.workSpace_Management.exception.EmployeePasswordWrong;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;
	@Autowired
	private DtoConfig dto;

	public ResponseEntity<ResponseStructure<EmployeeDto>> saveEmployee(EmployeeEntity employee) {
//		if(employee.getAddress()!=null) {
		ResponseStructure<EmployeeDto> structure = new ResponseStructure<>();
		structure.setData(dto.employeeEntityToDto(dao.saveEmployee(employee)));
		structure.setMessage("employee saved success");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<EmployeeDto>>(structure, HttpStatus.CREATED);
//		}
//		throw new AddressEmpty("address cannot be empty for employee");
	}

	public ResponseEntity<ResponseStructure<EmployeeDto>> logIn(String email, String pwd) {
		EmployeeEntity employee = dao.getEmployeeByEmail(email);
		if (employee != null) {
			if (employee.getEmployeePassword().equals(pwd)) {
				ResponseStructure<EmployeeDto> structure = new ResponseStructure<>();
				structure.setData(dto.employeeEntityToDto(employee));
				structure.setMessage("employee found success");
				structure.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<ResponseStructure<EmployeeDto>>(structure, HttpStatus.FOUND);
			} else {
				throw new EmployeePasswordWrong("password wrong, enter correct password");
			}
		} else {
			throw new EmployeeNotFound("employee not found for given email");
		}
	}

	public ResponseEntity<ResponseStructure<EmployeeDto>> updateEmployee(EmployeeEntity employee, String employeeId) {
		EmployeeEntity employee2 = dao.findEmployee(employeeId);
		if (employee2 != null) {
			ResponseStructure<EmployeeDto> structure = new ResponseStructure<>();
			structure.setData(dto.employeeEntityToDto(dao.updateEmployee(employee2, employeeId)));
			structure.setMessage("employee update success");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<EmployeeDto>>(structure, HttpStatus.OK);
		}
		throw new EmployeeNotFound("employee not found with given id");
	}

	public ResponseEntity<ResponseStructure<EmployeeDto>> getEmployeeByEmail(String email) {
		EmployeeEntity employee = dao.getEmployeeByEmail(email);
		if (employee != null) {
			ResponseStructure<EmployeeDto> structure = new ResponseStructure<>();
			structure.setData(dto.employeeEntityToDto(employee));
			structure.setMessage("employee saved success");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<EmployeeDto>>(structure, HttpStatus.FOUND);
		}
		throw new EmployeeNotFound("employee not found for given email");
	}

	public ResponseEntity<ResponseStructure<EmployeeDto>> findEmployeeById(String id) {
		EmployeeEntity employee = dao.findEmployee(id);

		if (employee != null) {
			ResponseStructure<EmployeeDto> structure = new ResponseStructure<>();
			structure.setData(dto.employeeEntityToDto(employee));
			structure.setMessage("employee found success");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<EmployeeDto>>(structure, HttpStatus.FOUND);
		}
		throw new EmployeeNotFound("employee not found for given id");
	}

	public ResponseEntity<ResponseStructure<List<EmployeeDto>>> findEmployeesByRole(String role) {
		List<EmployeeEntity> dbemployees = dao.employeesBasedOnRole(role);
		if (dbemployees != null) {

			List<EmployeeDto> dtoemployees = new ArrayList<>();
			for (EmployeeEntity e : dbemployees) {
				dtoemployees.add(dto.employeeEntityToDto(e));
			}

			ResponseStructure<List<EmployeeDto>> structure = new ResponseStructure<>();
			structure.setData(dtoemployees);
			structure.setMessage("employee found success");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<EmployeeDto>>>(structure, HttpStatus.FOUND);
		}
		throw new EmployeeNotFound("employee not found for given role "+role);
	}
	
	public ResponseEntity<ResponseStructure<EmployeeEntity>> getEmployeePasswordByEmail(String email) {
		EmployeeEntity employee = dao.getEmployeeByEmail(email);
		if (employee != null) {
			ResponseStructure<EmployeeEntity> structure = new ResponseStructure<>();
			structure.setData(employee);
			structure.setMessage("employee found success");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<EmployeeEntity>>(structure, HttpStatus.FOUND);
		}
		throw new EmployeeNotFound("employee not found for given email");
	}
	

}
