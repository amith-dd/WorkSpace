package com.ty.workSpace_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.workSpace_Management.entity.ServiceEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.service.ServiceService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/service")
public class ServiceController {
	
	@Autowired
	private ServiceService service;
	
	@PostMapping
	@ApiOperation(value = "save  service", notes = "Api is used to save service ")
	@ApiResponses({@ApiResponse(code=201,message="Sucessfully  service is saved"),
		@ApiResponse(code=404,message="  building id is not found to add service")})
	public ResponseEntity<ResponseStructure<ServiceEntity>> saveService(@RequestBody ServiceEntity service1,@RequestParam  String buildingId) {
		return service.saveService(service1, buildingId);
	}
	
	@GetMapping
	@ApiOperation(value = "list of  service based on name", notes = "Api is used to display the list of services ")
	@ApiResponses({@ApiResponse(code=302,message="Sucessfully  service is found to display"),
		@ApiResponse(code=404,message="service name  is not found to display ")})
	public ResponseEntity<ResponseStructure<List<ServiceEntity>>> listOfServicesBasedONServiceName(@RequestParam  String name) {
		return service.listOfServicesBasedONServiceName(name);
	}
	
	@GetMapping("/building")
	@ApiOperation(value = "list of  service based on building id", notes = "Api is used to display the list of services ")
	@ApiResponses({@ApiResponse(code=302,message="Sucessfully  building  is found to display"),
		@ApiResponse(code=404,message="building  is not found to display list of services")})
	public ResponseEntity<ResponseStructure<List<ServiceEntity>>> listOfServicesBasedONBuildingService(@RequestParam  String buildingID) {
		return service.listOfServicesBasedONBuildingService(buildingID);
	}
	
	

}
