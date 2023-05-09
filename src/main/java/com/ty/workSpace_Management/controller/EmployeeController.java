package com.ty.workSpace_Management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.workSpace_Management.dto.EmployeeDto;
import com.ty.workSpace_Management.entity.EmployeeEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@ApiOperation(value = "Save employee", notes = "API is used to save employee")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 400, message = "Id not found for the given employee ID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<EmployeeDto>> saveEmployee(@Valid @RequestBody EmployeeEntity employee){
		return service.saveEmployee(employee);
	}
	@ApiOperation(value = "employee login", notes = "API is used to login employee")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "employee logged in"),
			@ApiResponse(code = 400, message = "Id not found for the given employee email and password") })
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<EmployeeDto>> logInEmployee(@RequestParam String email,@RequestParam String pwd){
		return service.logIn(email, pwd);
	}
	@ApiOperation(value = "Update employee", notes = "API is used to update employee for given employee Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "succesfully updated"),
			@ApiResponse(code = 400, message = "Id not found for the given client ID") })
	@PutMapping
	public ResponseEntity<ResponseStructure<EmployeeDto>> updateEmployee( @RequestBody EmployeeEntity employee,@RequestParam String employeeId){
		return service.updateEmployee(employee, employeeId);
	}
	@ApiOperation(value = "get employee", notes = "API is used to get employee for employee mail")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "employee is fetched"),
			@ApiResponse(code = 400, message = "Id not found for the given employee email") })
	@GetMapping("/getbymail")
	public ResponseEntity<ResponseStructure<EmployeeDto>> getEmployeeByEmail(@RequestParam String email){
		return service.getEmployeeByEmail(email);
	}
	@ApiOperation(value = "get employee", notes = "API is used to get employee for employee Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "employee is fetched"),
			@ApiResponse(code = 400, message = "Id not found for the given employee ID") })
	@GetMapping("getbyid")
	public ResponseEntity<ResponseStructure<EmployeeDto>> findEmployeeById(@RequestParam String id){
		return service.findEmployeeById(id);
	}
	@ApiOperation(value = "get employee", notes = "API is used to get employees based on role")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "employees are fetched"),
			@ApiResponse(code = 400, message = "employees not found for the given role") })
	@GetMapping("getbyrole")
	public ResponseEntity<ResponseStructure<List<EmployeeDto>>> findEmployeesByRole(@RequestParam String role){
		return service.findEmployeesByRole(role);
	}
	
	@ApiOperation(value = "get employee password by email", notes = "API is used to get employee password using email")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "employee details are fetched"),
			@ApiResponse(code = 400, message = "employees not found for the given email") })
	@GetMapping("getpwd")
	public ResponseEntity<ResponseStructure<EmployeeEntity>> findEmployeePasswordByemail(@RequestParam String email){
		return service.getEmployeePasswordByEmail(email);
	}
	
	
	
	
}
