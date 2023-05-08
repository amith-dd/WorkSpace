package com.ty.workSpace_Management.controller;

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

import com.ty.workSpace_Management.dto.ManagerDto;
import com.ty.workSpace_Management.entity.ManagerEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.service.ManagerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired  
	private ManagerService service;

	@PostMapping
	@ApiOperation(value = "save  manager", notes = "Api is used to save manager ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  manager is saved")})
	public ResponseEntity<ResponseStructure<ManagerDto>> signupManager(@Valid @RequestBody ManagerEntity manager) {
		return service.saveManager(manager);
	}
	
	@PutMapping
	@ApiOperation(value = "update  manager", notes = "Api is used to update manager ")
	@ApiResponses({@ApiResponse(code=200,message="Sucessfully  manager is updated"),
		@ApiResponse(code=404,message="  manager id is not found to update")})
	public ResponseEntity<ResponseStructure<ManagerDto>> updateManager(@RequestBody ManagerEntity manager, @RequestParam String managerId) {
		return service.updateManager(manager, managerId);
	}
	
	
	@GetMapping
	@ApiOperation(value = "display  manager", notes = "Api is used to display manager ")
	@ApiResponses({@ApiResponse(code=302,message="Sucessfully  manager is found"),
		@ApiResponse(code=404,message="  manager id is not found to display")})
	public ResponseEntity<ResponseStructure<ManagerDto>> getmanagerById(@RequestParam String managerId) {
		return service.getManagerByID(managerId);
	}

	@GetMapping("/email")
	@ApiOperation(value = "display  manager by email", notes = "Api is used to display manager ")
	@ApiResponses({@ApiResponse(code=302,message="Sucessfully  manager is found"),
		@ApiResponse(code=404,message="  manager email is not found to display")})
	public ResponseEntity<ResponseStructure<ManagerDto>> getmanagerByemail(@RequestParam String email) {
		return service.getManagerByEmail(email);
	}
	

	@GetMapping("/pwd")
	@ApiOperation(value = "display  manager with password", notes = "Api is used to display manager ")
	@ApiResponses({@ApiResponse(code=302,message="Sucessfully  manager is found"),
		@ApiResponse(code=404,message="  manager email is not found to display")})
	public ResponseEntity<ResponseStructure<ManagerEntity>> getmanagerPwdByEmail(@RequestParam String email) {
		return service.getManagerPwdByEmail(email);
	}
	
	@GetMapping("/login")
	@ApiOperation(value = "login  manager with password and email", notes = "Api is used to login manager ")
	@ApiResponses({@ApiResponse(code=302,message="Sucessfully  manager is found to login "),
		@ApiResponse(code=404,message=" unable to login pls provide proper credeentials")})
	public ResponseEntity<ResponseStructure<ManagerDto>> getManagerPwdByEmail(@RequestParam String email, @RequestParam String pwd) {
		return service.loginManager(email, pwd);
	}
	
	
	
}
