package com.ty.workSpace_Management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.workSpace_Management.entity.EmployeeDutyAssignEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.service.EmployeeDutyAssignService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeeDutyAssignController {

	@Autowired
	private EmployeeDutyAssignService duty;

	@PostMapping
	@ApiOperation(value = "save  employeeDutyAssign", notes = "Api is used to save employeeDutyAssign ")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully  employeeDutyAssign is saved") })
	public ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>> saveEmployeeDutyAssign(
			@Valid @RequestBody String managerId, List<String> id) {
		return duty.saveEmployeeDuttyAssign(managerId, id);
	}

	@PutMapping
	@ApiOperation(value = "update  employeeDutyAssign", notes = "Api is used to update employeeDutyAssign ")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully  employeeDutyAssign is updated"),
			@ApiResponse(code = 404, message = "  floor id is not found to update") })
	public ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>> updateEmployeeDutyAssign(
			@RequestParam String dutyAssignId, @RequestParam List<String> id) {
		return duty.updateEmployeeDuttyAssign(dutyAssignId, id);
	}

	@GetMapping
	@ApiOperation(value = "get employeeDutyAssign", notes = "Api is used to fetch employeeDutyAssign ")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully  employeeDutyAssign is fetched") })
	public ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>> getEmployeeDutyAssign(
			@Valid @RequestParam String employeeDutyAssignId) {
		return duty.getEmployeeDuty(employeeDutyAssignId);
	}

}
