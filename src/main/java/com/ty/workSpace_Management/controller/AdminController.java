package com.ty.workSpace_Management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.workSpace_Management.dto.AdminDto;
import com.ty.workSpace_Management.entity.AdminEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.service.AdminService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	
	@PostMapping
	@ApiOperation(value = "save  Admin", notes = "Api is used to save Admin ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  Vendor is saved")})
	public ResponseEntity<ResponseStructure<AdminDto>> signupAdmin(@Valid @RequestBody AdminEntity admin) {
		return service.saveAdmin(admin);
	}
	
	@PutMapping
	@ApiOperation(value = "update  Admin", notes = "Api is used to update Admin ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  admimn is updated"),
		@ApiResponse(code=404,message="  admimn id is not found to update")})
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(@RequestBody AdminEntity admin, String adminId) {
		return service.updateAdmin(admin, adminId);
	}
	
	
	

}
