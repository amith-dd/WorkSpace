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
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  admin is saved")})
	public ResponseEntity<ResponseStructure<AdminDto>> signupAdmin(@Valid @RequestBody AdminEntity admin) {
		return service.saveAdmin(admin);
	}
	
	@PutMapping
	@ApiOperation(value = "update  Admin", notes = "Api is used to update Admin ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  admimn is updated"),
		@ApiResponse(code=404,message="  admimn id is not found to update")})
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(@RequestBody AdminEntity admin,@RequestParam  String adminId) {
		return service.updateAdmin(admin, adminId);
	}
	
	
	@GetMapping
	@ApiOperation(value = "display  Admin", notes = "Api is used to display Admin ")
	@ApiResponses({@ApiResponse(code=302,message="Sucessfully  admim is found"),
		@ApiResponse(code=404,message="  admim id is not found to display")})
	public ResponseEntity<ResponseStructure<AdminDto>> getAdminById(@RequestParam String adminId) {
		return service.getAdminByID(adminId);
	}

	@GetMapping("/email")
	@ApiOperation(value = "display  Admin by email", notes = "Api is used to display Admin ")
	@ApiResponses({@ApiResponse(code=302,message="Sucessfully  admin is found"),
		@ApiResponse(code=404,message="  admin email is not found to display")})
	public ResponseEntity<ResponseStructure<AdminDto>> getAdminByemail(@RequestParam String email) {
		return service.getAdminByEmail(email);
	}
	

	@GetMapping("/pwd")
	@ApiOperation(value = "display  Admin with password", notes = "Api is used to display Admin ")
	@ApiResponses({@ApiResponse(code=302,message="Sucessfully  admin is found"),
		@ApiResponse(code=404,message="  admin email is not found to display")})
	public ResponseEntity<ResponseStructure<AdminEntity>> getAdminPwdByEmail(@RequestParam String email) {
		return service.getAdminPwdByEmail(email);
	}
	
	@GetMapping("/login")
	@ApiOperation(value = "login  Admin with password and email", notes = "Api is used to login Admin ")
	@ApiResponses({@ApiResponse(code=302,message="Sucessfully  admin is found to login "),
		@ApiResponse(code=404,message=" unable to login pls provide proper credeentials")})
	public ResponseEntity<ResponseStructure<AdminDto>> getAdminPwdByEmail(@RequestParam String email, @RequestParam String pwd) {
		return service.login(email, pwd);
	}
	
	
	
	
	
	
	
	

}
