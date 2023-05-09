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

import com.ty.workSpace_Management.entity.EmployeeDutyAssignEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.service.EmployeeDutyAssignService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/duty")
public class EmployeeDutyAssignController {

	@Autowired
	private EmployeeDutyAssignService duty;

	@PostMapping
	@ApiOperation(value = "save  employeeDutyAssign", notes = "Api is used to save employeeDutyAssign ")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully  employeeDutyAssign is saved") })
	public ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>> saveEmployeeDutyAssign(
			 @RequestParam String managerId, @RequestParam String clientID,  @RequestParam String employeeId ) {
		return duty.saveEmployeeDuttyAssign(managerId,clientID,employeeId);
	}

	@PutMapping
	@ApiOperation(value = "end  employeeDutyAssign", notes = "Api is used to end employeeDutyAssign ")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully  employeeDutyAssign is ended"),
			@ApiResponse(code = 404, message = "  employeeDutyAssign id is not found to update") })
	public ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>> endWork(
			@RequestParam String dutyAssignId ) {
		return duty.endWork(dutyAssignId);
	}

	@GetMapping
	@ApiOperation(value = "get employeeDutyAssign", notes = "Api is used to fetch employeeDutyAssign ")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully  employeeDutyAssign is fetched"),
		@ApiResponse(code = 404, message = "  employeeDutyAssign id is not found to update")})
	public ResponseEntity<ResponseStructure<EmployeeDutyAssignEntity>> getEmployeeDutyAssign(
			 @RequestParam String employeeDutyAssignId) {
		return duty.getEmployeeDuty(employeeDutyAssignId);
	}

}
