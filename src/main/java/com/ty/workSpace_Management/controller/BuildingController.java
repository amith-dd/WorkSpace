package com.ty.workSpace_Management.controller;

import java.util.List;

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
import com.ty.workSpace_Management.dto.BuildingDto;
import com.ty.workSpace_Management.entity.AdminEntity;
import com.ty.workSpace_Management.entity.BuildingEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.service.BuildingService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/building")
public class BuildingController {

	@Autowired
	private BuildingService service;
	@Autowired
	private BuildingDto dto;

	@PostMapping
	@ApiOperation(value = "save  building", notes = "Api is used to save building ")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully  building is saved"),
			@ApiResponse(code = 404, message = "  admin id is not found to save building") })
	public ResponseEntity<ResponseStructure<BuildingDto>> saveBuilding(@RequestBody BuildingEntity building,
			@RequestParam String adminId) {
		return service.saveBuilding(building, adminId);
	}

	@PutMapping
	@ApiOperation(value = "assign  manager", notes = "Api is used to assign manager ")
	@ApiResponses({ @ApiResponse(code = 200, message = "Sucessfully  assign manager to building"),
			@ApiResponse(code = 404, message = " id is  not found for assin the manager") })
	public ResponseEntity<ResponseStructure<BuildingDto>> assignManagerToBuilding(@RequestParam String adminId,
			@RequestParam String buildingId, @RequestParam String managerId) {
		return service.AssignBuildingtoManager(adminId, buildingId, managerId);
	}

	@GetMapping
	@ApiOperation(value = "dispaly  building", notes = "Api is used to dispaly  building ")
	@ApiResponses({ @ApiResponse(code = 302, message = "Sucessfully   building is found to display"),
			@ApiResponse(code = 404, message = "  building id is  not found to display") })
	public ResponseEntity<ResponseStructure<BuildingDto>> getBuildingByID(@RequestParam String buildingId) {
		return service.getBuildingByID(buildingId);
	}

	@GetMapping("/name")
	@ApiOperation(value = "dispaly  building based on name", notes = "Api is used to dispaly  building based on name ")
	@ApiResponses({ @ApiResponse(code = 302, message = "Sucessfully   building is found to display"),
			@ApiResponse(code = 404, message = "  building name is  not found to display") })
	public ResponseEntity<ResponseStructure<List<BuildingDto>>> getBuildingByName(@RequestParam String name) {
		return service.getBuildingByName(name);
	}

	@GetMapping("/pincode")
	@ApiOperation(value = "dispaly  building based on pincode", notes = "Api is used to dispaly  building based on pincode ")
	@ApiResponses({ @ApiResponse(code = 302, message = "Sucessfully   building is found to display"),
			@ApiResponse(code = 404, message = "  pincode  is  not found to display") })
	public ResponseEntity<ResponseStructure<List<BuildingDto>>> getListOfBuildingByLocation(@RequestParam int pincode) {
		return service.getListOfBuildingByLocation(pincode);
	}

	@GetMapping("/rating")
	@ApiOperation(value = "dispaly  building based on rating", notes = "Api is used to dispaly  building based on rating ")
	@ApiResponses({ @ApiResponse(code = 302, message = "Sucessfully   building is found to display"),
			@ApiResponse(code = 404, message = "  rating  is  not found to display building list") })
	public ResponseEntity<ResponseStructure<List<BuildingDto>>> getListOfBuildingBasedonRating() {
		return service.getListOfBuildingBasedonRating();
	}

	@GetMapping("/list")
	@ApiOperation(value = "dispaly  building list", notes = "Api is used to dispaly list of buildings ")
	@ApiResponses({ @ApiResponse(code = 302, message = "Sucessfully   building list is found to display"),
			@ApiResponse(code = 404, message = "no building is exist to display") })
	public ResponseEntity<ResponseStructure<List<BuildingDto>>> getListOfBuilding() {
		return service.getListOfBuilding();
	}

}
